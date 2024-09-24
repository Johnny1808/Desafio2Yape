package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import drivers.DriverManager;

public class BookingSteps {

    private AppiumDriver<MobileElement> driver;
    private WebDriverWait wait;
    private DriverManager driverManager;

    private String precioHabitacion; // Variable para almacenar el precio

    private SearchPage searchPage;
    private DateSelectionPage dateSelectionPage;
    private RoomSelectionPage roomSelectionPage;
    private ReservationPage reservationPage;
    private DataFormPage dataFormPage;
    private ReservaDetailsPage reservaDetailsPage;
    private FinishPage finishPage;

    @Before
    public void setUp() throws Exception {
        // Inicializamos el Driver Manager
        driverManager = new DriverManager();
        driver = driverManager.getDriver();
        wait = driverManager.getWait();

        // Inicializar la página de búsqueda
        searchPage = new SearchPage(driver, wait);
        dateSelectionPage = new DateSelectionPage(driver, wait);
        roomSelectionPage = new RoomSelectionPage(driver, wait);
        reservationPage = new ReservationPage(driver, wait);
        dataFormPage = new DataFormPage(driver, wait);
        reservaDetailsPage = new ReservaDetailsPage(driver, wait);
        finishPage = new FinishPage(driver, wait);
    }


    @Given("^El usuario está en la página principal de la aplicación$")
    public void usuarioEnPaginaPrincipal() {
        // Aquí podrías hacer alguna validación de que la app esté en la pantalla correcta si es necesario
        System.out.println("El usuario está en la página principal de la app.");
    }

    @When("^El usuario busca un destino y selecciona \"([^\"]*)\"$")
    public void buscarDestino(String destino) {
        searchPage.searchDestination(destino);
    }

    @And("El usuario selecciona fechas para reserva de \"([^\"]*)\" a \"([^\"]*)\"$")
    public void elUsuarioSeleccionaFechasParaReservaDeA(String fechaInicio, String fechaFin) throws InterruptedException {
        dateSelectionPage.selectDate(fechaInicio, fechaFin);
    }

    @And("^El usuario selecciona habitaciones e invitados$")
    public void elUsuarioSeleccionaUnaOpcionDeHabitacion() throws InterruptedException {
        roomSelectionPage.selectRoomOptions();
    }

    @And("El usuario selecciona habitaciones e invitados con niños")
    public void elUsuarioSeleccionaHabitacionesEInvitadosParaAdultosYNiños() throws InterruptedException {
        roomSelectionPage.selectRoomOptions2();
    }

    @And("El usuario selecciona hotel encontrado")
    public void elUsuarioSeleccionaHotelEncontrado() {
        reservationPage.seleccionarHotel();
    }

    @And("El usuario selecciona habitacion")
    public void elUsuarioSeleccionaHabitacion() {
        precioHabitacion = reservationPage.selectHabitacion();
    }

    @And("El usuario ingresa en el formuario el nombre {string} y apellido {string}")
    public void elUsuarioIngresaEnElFormuarioElNombreYApellido(String nombre, String apellido) {
        dataFormPage.nomYape(nombre, apellido);
    }

    @And("El usuario ingresa en el formulario el correo {string} y region {string}")
    public void elUsuarioIngresaEnElFormularioElCorreoYRegion(String correo, String region) {
        dataFormPage.correoYregion(correo, region);
    }

    @And("El usuario ingresa en el formulario el número {string} y opción {string}")
    public void elUsuarioIngresaEnElFormularioElNúmeroYOpción(String numero, String opcion) {
        dataFormPage.numYopc(numero, opcion);
    }

    @And("El usuario valida el precio final")
    public void elUsuarioValidaElPrecioFinal() {
        ValidarPrecioPage validarPrecioPage = new ValidarPrecioPage(driver, wait, precioHabitacion);
        validarPrecioPage.validarPrecioFinal(precioHabitacion);
    }

    @And("El usuario hace clic en next step")
    public void elUsuarioHaceClicEnNextStep() {
        dataFormPage.clickNextStep();
    }

    @And("El usuario valida los datos de la reserva noches {string} habitaciones {string} adultos {string} niños {string}")
    public void elUsuarioValidaLosDatosDeLaReservaNochesHabitacionesAdultosNiños(String noches, String hab, String adultos, String ninos) {
        reservaDetailsPage.validarReservaDetalles(noches, hab, adultos, ninos);
    }

    @And("El usuario hace clic en next")
    public void elUsuarioHaceClicEnNext() {
        reservaDetailsPage.clicSiguienteReserva();
    }

    @And("El usuario ingresa numero de tarjeta {string}")
    public void elUsuarioIngresaNumeroDeTarjeta(String numTarj) {
        finishPage.ingresarNumTarjeta(numTarj);
    }

    @And("El usuario ingresa fecha de vencimiento de tarjeta {string}")
    public void elUsuarioIngresaFechaDeVencimientoDeTarjeta(String fechaVenc) {
        finishPage.ingresarFechaVenci(fechaVenc);
    }

    @And("El usuario hace clic en reservar")
    public void elUsuarioHaceClicEnReservar() {
        finishPage.clicReservar();
    }

    @Then("Muestra mensaje")
    public void muestraMensaje() {
        System.out.println("PRUEBA FINALIZADA... GRACIAS!!");
    }

    //UnHappysPath:
    @And("El usuario selecciona fechas para reserva de {string} a {string} incorrectos")
    public void elUsuarioSeleccionaFechasParaReservaDeAIncorrectos(String fechaInicio, String fechaFin) {
        dateSelectionPage.selectDateIncorrec(fechaInicio, fechaFin);
    }

    @Then("El usuario valida campos requeridos")
    public void elUsuarioValidaCamposRequeridos() {
        dataFormPage.validarCamposRequeridos();
    }

    @Then("El usuario valida campos finales")
    public void elUsuarioValidaCamposFinales() {
        finishPage.validarCamposFin();
    }

    @After
    public void tearDown() {
        // Finalizamos el driver
        if (driver != null) {
            driverManager.quitDriver();
        }
    }


}
