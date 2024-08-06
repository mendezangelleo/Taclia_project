package pages

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import config.TestConfig

class LoginPage {
	static void open() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl(TestConfig.url)
	}

	static void acceptCookies() {
		WebUI.click(findTestObject('Object Repository/Registration/LoginPage/button_Aceptar todo'))
	}

	static void clickStartNow() {
		WebUI.click(findTestObject('Object Repository/Registration/LoginPage/a_Empieza ahora'))
	}

	static void fillForm(String email, String password) {
		WebUI.setText(findTestObject('Object Repository/Registration/LoginPage/input_Correo electrnico_email'), email)
		WebUI.setEncryptedText(findTestObject('Object Repository/Registration/LoginPage/input_Contrasea_password'), password)
	}

	static void clickLogin() {
		WebUI.click(findTestObject('Object Repository/Registration/LoginPage/button_Iniciar sesin'))
	}
	
	static void validateUrlAfterLogin() {
		// Definir un tiempo máximo de espera
		int timeout = 30
		int interval = 2
		int elapsedTime = 0
		
		String expectedUrlPattern = ''
		expectedUrlPattern = '.*taclia.com.*'
	}

	
}
