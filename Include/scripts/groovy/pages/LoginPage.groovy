package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class LoginPage {
	static void open() {
		WebUI.openBrowser('')
		WebUI.navigateToUrl('https://app.taclia.com/auth/login')
	}

	static void acceptCookies() {
		WebUI.click(findTestObject('Object Repository/Registration/LoginPage/button_Aceptar todo'))
	}

	static void clickStartNow() {
		WebUI.click(findTestObject('Object Repository/Registration/LoginPage/a_Empieza ahora'))
	}

	static void close() {
		WebUI.closeBrowser()
	}
}
