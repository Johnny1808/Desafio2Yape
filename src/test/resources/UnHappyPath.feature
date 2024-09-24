@FlujosAlternos
Feature: Reserva de una habitación en la aplicación Booking

  @UnHappyPath-1
  Scenario: Seleccionar fechas anteriores al día presente
    Given El usuario está en la página principal de la aplicación
    When El usuario busca un destino y selecciona "Cusco J"
    And El usuario selecciona fechas para reserva de "12 September 2024" a "15 September 2024" incorrectos
    Then Muestra mensaje

  @UnHappyPath-2
  Scenario Outline: Validar la informacion obligatoria del formulario
    Given El usuario está en la página principal de la aplicación
    When El usuario busca un destino y selecciona "Cusco J"
    And El usuario selecciona fechas para reserva de "14 February 2025" a "28 February 2025"
    And El usuario selecciona habitaciones e invitados
    And El usuario selecciona hotel encontrado
    And El usuario selecciona habitacion
    And El usuario ingresa en el formuario el nombre "<nombre>" y apellido "<apellido>"
    And El usuario ingresa en el formulario el correo "<correo>" y region "<region>"
    And El usuario ingresa en el formulario el número "<numero>" y opción "<opcion>"
    And El usuario valida el precio final
    And El usuario hace clic en next step
    Then El usuario valida campos requeridos
    Examples:
      | nombre | apellido       | correo               | region | numero    | opcion   |
      |        | Mallqui Moreno | jmallqui18@gmail.com | Peru   | 986783762 | Leisure  |
      | Johnny |                | jmallqui18@gmail.com | Peru   | 986783762 | Business |
      | Johnny | Mallqui Moreno |                      | Peru   | 986783762 | Leisure  |
      | Johnny | Mallqui Moreno | jmallqui18@gmail.com |        | 986783762 | Business |
      | Johnny | Mallqui Moreno | jmallqui18@gmail.com | Peru   |           | Leisure  |

  @UnHappyPath-3
  Scenario: Validar el campo numero de tarjeta sea obligatorio
    Given El usuario está en la página principal de la aplicación
    When El usuario busca un destino y selecciona "Cusco J"
    And El usuario selecciona fechas para reserva de "14 February 2025" a "28 February 2025"
    And El usuario selecciona habitaciones e invitados
    And El usuario selecciona hotel encontrado
    And El usuario selecciona habitacion
    And El usuario ingresa en el formuario el nombre "Johnny" y apellido "Mallqui Moreno"
    And El usuario ingresa en el formulario el correo "jmallqui18@gmail.com" y region "Peru"
    And El usuario ingresa en el formulario el número "986783762" y opción "Leisure"
    And El usuario valida el precio final
    And El usuario hace clic en next step
    And El usuario valida los datos de la reserva noches "14" habitaciones "2" adultos "2" niños "1"
    And El usuario valida el precio final
    And El usuario hace clic en next
    And El usuario ingresa numero de tarjeta ""
    And El usuario ingresa fecha de vencimiento de tarjeta "02/25"
    And El usuario valida el precio final
    And El usuario hace clic en reservar
    Then El usuario valida campos finales