package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject
import java.text.SimpleDateFormat
import java.util.Date
import com.kms.katalon.core.testobject.ConditionType
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import java.util.Random
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement

class Tracking {

	static void navigateToTimeTracking() {
		WebUI.click(findTestObject('Object Repository/ControlHorario/MyTracking/svg'))
	}

	static void navigateToMyTracking() {
		WebUI.click(findTestObject('Object Repository/ControlHorario/MyTracking/a_Mis fichajes'))
	}

	static void navigateToTeamTracking() {
		WebUI.click(findTestObject('Object Repository/ControlHorario/TeamTracking/TeamTraking'))
	}

	static void addTeamTracking() {
		WebUI.click(findTestObject('Object Repository/ControlHorario/TeamTracking/Add_TeamTracking'))
	}

	static void selectUser() {
		WebUI.click(findTestObject('Object Repository/ControlHorario/TeamTracking/User_Dropdown'))
		WebUI.click(findTestObject('Object Repository/ControlHorario/TeamTracking/Select_user'))
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

	static void saveTeamTracking() {
		WebUI.click(findTestObject('Object Repository/ControlHorario/TeamTracking/SaveTeamTracking'))
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

	static void selectCalendar() {
        try {
            // Generar una fecha aleatoria desde hoy hasta una fecha pasada
            String randomDate = generateRandomDate()

            // Definir el objeto TestObject para el campo de fecha
            TestObject dateField = findTestObject('Object Repository/ControlHorario/TeamTracking/Select_calendar')

            // Hacer clic en el campo de calendario para enfocarlo
            WebUI.click(dateField)

            // Ingresar la fecha aleatoria en el campo
            WebUI.setText(dateField, randomDate)
        } catch (Exception e) {
            WebUI.comment('Error al seleccionar la fecha en el calendario: ' + e.message)
            throw e
        }
    }

    private static String generateRandomDate() {
        // Formato de fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy")

        // Fecha actual
        Date now = new Date()

        // Generar un número aleatorio de días entre 0 y 365
        Random random = new Random()
        int randomDays = random.nextInt(366)

        // Calcular la fecha aleatoria
        Date randomDate = new Date(now.time - (randomDays * 24 * 60 * 60 * 1000L))

        // Devolver la fecha en el formato especificado
        return sdf.format(randomDate)
    }
}
