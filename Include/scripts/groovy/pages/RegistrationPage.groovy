package pages

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement
import java.util.Random
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

class RegistrationPage {
	static void fillForm(String email, String phone, String password) {
		WebUI.setText(findTestObject('Object Repository/Registration/RegistrationPage/form_screen/input_Correo electrnico_email'), email)
		WebUI.setText(findTestObject('Object Repository/Registration/RegistrationPage/form_screen/input_Telfono_tel'), phone)
		WebUI.setEncryptedText(findTestObject('Object Repository/Registration/RegistrationPage/form_screen/input_Contrasea_password'), password)
		WebUI.click(findTestObject('Object Repository/Registration/RegistrationPage/form_screen/img'))
	}

	static void clickNextStep() {
		WebUI.click(findTestObject('Object Repository/Registration/RegistrationPage/form_screen/button_Empieza tu prueba gratuita'))
	}

	static void selectCategory(String sectorId) {
		if (sectorId == null) {
			WebUI.comment("El valor de sectorId es null, no se puede seleccionar la categoría.")
			return
		}


		String sectorLocator = "//*[@id='sectorContainer_${sectorId}']"
		TestObject sectorObject = new TestObject()
		sectorObject.addProperty("xpath", ConditionType.EQUALS, sectorLocator)


		WebUI.waitForElementVisible(sectorObject, 30)


		WebUI.click(sectorObject)
	}

	static void clickNext() {
		WebUI.click(findTestObject('Object Repository/Registration/RegistrationPage/step1_screen/button_Siguiente'))
	}

	static int selectManagementOption() {

		String optionLocator = "//div[@class='item-sector']"


		TestObject dynamicObject = new TestObject()
		dynamicObject.addProperty("xpath", ConditionType.EQUALS, optionLocator)


		List<WebElement> options = WebUiCommonHelper.findWebElements(dynamicObject, 30)


		Random random = new Random()
		int randomIndex = random.nextInt(options.size())


		WebElement selectedOption = options.get(randomIndex)
		selectedOption.click()


		return randomIndex
	}

	static void clickStart() {
		WebUI.click(findTestObject('Object Repository/Registration/RegistrationPage/step2_screen/button_Empezar'))
	}

	static void verifyCountry(String expectedCountry) {
		String inputValue = WebUI.getAttribute(findTestObject('Object Repository/Registration/RegistrationPage/form_screen/country_check'), 'value')
		if (inputValue.equals(expectedCountry)) {
			WebUI.comment('El campo se completó correctamente con el país: ' + inputValue)
		} else {
			WebUI.comment('El campo no se completó correctamente. Valor actual: ' + inputValue + ', País esperado: ' + expectedCountry)
		}
	}

	static void validatePageAfterSelection(int optionIndex) {
		// Validar los elementos web en la pantalla de selección de opciones
		switch (optionIndex) {
			case 0:
				WebUI.verifyElementPresent(findTestObject('Object Repository/Registration/RegistrationPage/step2_screen/time_tracking_feature'), 30)
				break
			case 1:
				WebUI.verifyElementPresent(findTestObject('Object Repository/Registration/RegistrationPage/step2_screen/Invoices_feature'), 30)
				break
			case 2:
				WebUI.verifyElementPresent(findTestObject('Object Repository/Registration/RegistrationPage/step2_screen/jobs_feature'), 30)
				break
			case 3:
				WebUI.verifyElementPresent(findTestObject('Object Repository/Registration/RegistrationPage/step2_screen/sales_feature'), 30)
				break
			case 4:
				WebUI.verifyElementPresent(findTestObject('Object Repository/Registration/RegistrationPage/step2_screen/task_feature'), 30)
				break
			case 5:
				WebUI.verifyElementPresent(findTestObject('Object Repository/Registration/RegistrationPage/step2_screen/expenses_feature'), 30)
				break
			default:
				throw new IllegalStateException("Opción no válida: " + optionIndex)
		}
	}

	static void validateUrlAfterRegistration(int optionIndex) {
		// Definir un tiempo máximo de espera
		int timeout = 30
		int interval = 2
		int elapsedTime = 0

		// URL esperada para cada opción
		String expectedUrlPattern = ''
		switch (optionIndex) {
			case 0:
				expectedUrlPattern = '.*clock-hours.*'
				break
			case 1:
				expectedUrlPattern = '.*budgets\\?type=BILL.*'
				break
			case 2:
				expectedUrlPattern = '.*admin/deals.*'
				break
			case 3:
				expectedUrlPattern = '.*sales\\?type=BDG.*'
				break
			case 4:
				expectedUrlPattern = '.*activities.*'
				break
			case 5:
				expectedUrlPattern = '.*expenses.*'
				break
			default:
				throw new IllegalStateException("Opción no válida: " + optionIndex)
		}

		// Esperar hasta que la URL coincida con el patrón esperado
		while (elapsedTime < timeout) {
			String currentUrl = WebUI.getUrl()
			if (currentUrl ==~ expectedUrlPattern) {
				WebUI.comment("URL validada correctamente: " + currentUrl)
				return
			}
			WebUI.delay(interval)
			elapsedTime += interval
		}

		// Si se sale del bucle sin haber encontrado la URL, lanzar un error
		String currentUrl = WebUI.getUrl()
		throw new AssertionError("URL actual no coincide con el patrón esperado. URL actual: " + currentUrl + ", Patrón esperado: " + expectedUrlPattern)
	}
	
	static void enableAllFeature() {
		
		WebUI.click(findTestObject('Object Repository/Registration/RegistrationPage/a_Funcionalidades'))
		
		
		WebUI.check(findTestObject('Object Repository/Registration/RegistrationPage/span_Gastos_slider-large round'))
		WebUI.check(findTestObject('Object Repository/Registration/RegistrationPage/span_Ventas_slider-large round'))
		WebUI.check(findTestObject('Object Repository/Registration/RegistrationPage/span_Gestion interna_slider-large round'))
		
	}
}
