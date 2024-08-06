package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.text.SimpleDateFormat
import java.util.Date


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
	
	static void startManualTracking() {
		WebUI.click(findTestObject('Object Repository/ControlHorario/MyTracking/button_Fichado manual'))
	}
	
	static void setStartandEndDate() {
		WebUI.setText(findTestObject('Object Repository/ControlHorario/MyTracking/input_Aadir horas_startDate'), '10:00')
		
		WebUI.setText(findTestObject('Object Repository/ControlHorario/MyTracking/input_Aadir horas_endDate'), '20:00')
	}

	static void waitForOneMinute() {
		WebUI.delay(60)
	}

	static void stopAutomaticTracking() {
		WebUI.click(findTestObject('Object Repository/ControlHorario/MyTracking/div_Detener'))
	}
	
	static void saveManualTracking() {
		WebUI.click(findTestObject('Object Repository/ControlHorario/MyTracking/button_Guardar'))
	}

	static void toastVisible() {
		WebUI.verifyElementVisible(findTestObject('Object Repository/ControlHorario/MyTracking/Toast_Traking_ok'))
	}
	
	static void validateDate() {
		// Formato de la fecha esperada (ajustar según el formato que utilices en el objeto)
		String expectedDateFormat = "ddMMyy"
		
		// Obtener la fecha actual en el formato esperado
		Date now = new Date()
		SimpleDateFormat dateFormat = new SimpleDateFormat(expectedDateFormat)
		String currentDate = dateFormat.format(now)

		// Obtener el texto del objeto que contiene la fecha
		TestObject dateObject = findTestObject('Object Repository/ControlHorario/MyTracking/div_Fecha 060824')
		String dateText = WebUI.getText(dateObject)

		// Extraer la fecha del texto (ajustar según el formato del texto del objeto)
		String objectDate = dateText.replaceAll("\\D+", "")

		// Validar que la fecha del objeto coincida con la fecha actual
		if (objectDate.equals(currentDate)) {
			WebUI.comment('La fecha del objeto coincide con la fecha actual: ' + currentDate)
		} else {
			WebUI.comment('La fecha del objeto no coincide con la fecha actual. Fecha del objeto: ' + objectDate + ', Fecha actual: ' + currentDate)
			throw new AssertionError('La fecha del objeto no coincide con la fecha actual.')
		}
	}
}
