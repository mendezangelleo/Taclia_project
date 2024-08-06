package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class MyTracking {

	static void navigateToTimeTracking() {
		WebUI.click(findTestObject('Object Repository/ControlHorario/MyTracking/svg'))
	}

	static void navigateToMyTracking() {
		WebUI.click(findTestObject('Object Repository/ControlHorario/MyTracking/a_Mis fichajes'))
	}

	static void startAutomaticTracking() {
		WebUI.click(findTestObject('Object Repository/ControlHorario/MyTracking/img_Entrada_ng-star-inserted'))
	}

	static void waitForOneMinute() {
		WebUI.delay(60)
	}

	static void stopAutomaticTracking() {
		WebUI.click(findTestObject('Object Repository/ControlHorario/MyTracking/div_Detener'))
	}

	static void toastVisible() {
		WebUI.verifyElementVisible(findTestObject('Object Repository/ControlHorario/MyTracking/Toast_Traking_ok'))
	}
}
