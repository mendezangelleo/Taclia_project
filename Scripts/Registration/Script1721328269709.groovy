import pages.LoginPage as LoginPage
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import pages.RegistrationPage as RegistrationPage
import emailGenerator.groovy.EmailGenerator as EmailGenerator
import geolocation.Geolocation as Geolocation
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import keywords.SectorKeywords as SectorKeywords
import config.TestConfig as TestConfig
import pages.GeneralUse as GeneralUse

try {
    // Abrir la aplicación y aceptar cookies
    LoginPage.open()

    LoginPage.acceptCookies()

    LoginPage.clickStartNow()

    WebUI.comment('Navegación inicial completada.')

    // Generar correo electrónico
    String generatedEmail = EmailGenerator.getNextEmail()

    // Obtener el país a través de la IP
    String expectedCountry = Geolocation.getCountryByIP()

    // Completar el formulario de registro
    RegistrationPage.fillForm(generatedEmail, TestConfig.phone, TestConfig.password)


    RegistrationPage.clickNextStep()
	

    WebUI.comment('Formulario de registro completado y siguiente paso clicado.')


    // Obtener el sector aleatorio
    String sectorId = SectorKeywords.getRandomSectorId()

    RegistrationPage.selectCategory(sectorId)

    RegistrationPage.clickNext()

    WebUI.comment('Categoría seleccionada y siguiente clicado.')

    int selectedOptionIndex = RegistrationPage.selectManagementOption()

    RegistrationPage.validatePageAfterSelection(selectedOptionIndex)

    RegistrationPage.clickStart()

    WebUI.comment('Opción de gestión seleccionada y clic en empezar.')

    // Validar la página y la URL después del registro
    RegistrationPage.validateUrlAfterRegistration(selectedOptionIndex)

    WebUI.comment('URL validada después del registro.')
	
	
	RegistrationPage.enableAllFeature()
	
	
	
	return generatedEmail
}
catch (Exception e) {
    WebUI.comment('Error: ' + e.getMessage())

    throw e
} 
// Lanzar la excepción para que el test falle
finally { 
    // Cerrar la aplicación
    //GeneralUse.close()
}
