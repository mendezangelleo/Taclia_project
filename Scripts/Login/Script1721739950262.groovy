import pages.LoginPage as LoginPage
import config.TestConfig as TestConfig
import pages.GeneralUse as GeneralUse
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

try {
	// Abrir la aplicación y aceptar cookies
	LoginPage.open()
	LoginPage.acceptCookies()
	LoginPage.fillForm()
	LoginPage.clickLogin()
	LoginPage.validateUrlAfterLogin()
} catch (Exception e) {
	// Manejo de la excepción
	e.printStackTrace()
	WebUI.markFailed('Se produjo un error durante la ejecución del Test Case: ' + e.message)
} finally {
	// Cierre de la aplicación
	// GeneralUse.close()
}
