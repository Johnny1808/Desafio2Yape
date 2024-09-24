@FlujoPrincipal
Feature: Reserva de una habitación en la aplicación Booking

  @HappyPath-1
  Scenario: Flujo principal
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
    And El usuario ingresa numero de tarjeta "4555788765443333"
    And El usuario ingresa fecha de vencimiento de tarjeta "02/25"
    And El usuario valida el precio final
    And El usuario hace clic en reservar
    Then Muestra mensaje


  @HappyPath-2
  Scenario: Flujo completo seleccionando 2 habitaciones con 3 adultos y 2 niños
    Given El usuario está en la página principal de la aplicación
    When El usuario busca un destino y selecciona "Cusco J"
    And El usuario selecciona fechas para reserva de "14 February 2025" a "28 February 2025"
    And El usuario selecciona habitaciones e invitados con niños
    And El usuario selecciona hotel encontrado
    And El usuario selecciona habitacion
    And El usuario ingresa en el formuario el nombre "Johnny" y apellido "Mallqui Moreno"
    And El usuario ingresa en el formulario el correo "jmallqui18@gmail.com" y region "Peru"
    And El usuario ingresa en el formulario el número "986783762" y opción "Leisure"
    And El usuario valida el precio final
    And El usuario hace clic en next step
    And El usuario valida los datos de la reserva noches "14" habitaciones "3" adultos "3" niños "2"
    And El usuario valida el precio final
    And El usuario hace clic en next
    And El usuario ingresa numero de tarjeta "4555788765443333"
    And El usuario ingresa fecha de vencimiento de tarjeta "02/25"
    And El usuario valida el precio final
    And El usuario hace clic en reservar
    Then Muestra mensaje