package pages

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement
import java.util.Random
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.configuration.RunConfiguration
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import config.TestConfig

class RegistrationPage {

	// Método para llenar el formulario de registro
	static void fillForm(email) {
		WebUI.setText(findTestObject('Object Repository/Registration/RegistrationPage/form_screen/input_Correo electrnico_email'), email)
		WebUI.setText(findTestObject('Object Repository/Registration/RegistrationPage/form_screen/input_Telfono_tel'), TestConfig.phone)
		WebUI.setEncryptedText(findTestObject('Object Repository/Registration/RegistrationPage/form_screen/input_Contrasea_password'), TestConfig.password)
		WebUI.click(findTestObject('Object Repository/Registration/RegistrationPage/form_screen/img'))
	}

	// Método para hacer clic en el botón "Empieza tu prueba gratuita"
	static void clickNextStep() {
		WebUI.click(findTestObject('Object Repository/Registration/RegistrationPage/form_screen/button_Empieza tu prueba gratuita'))
	}

	// Método para seleccionar la categoría según sectorId
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

	// Método para hacer clic en el botón "Siguiente"
	static void clickNext() {
		WebUI.click(findTestObject('Object Repository/Registration/RegistrationPage/step1_screen/button_Siguiente'))
	}

	// Método para seleccionar una opción de gestión de manera aleatoria
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

	// Método para hacer clic en el botón "Empezar"
	static void clickStart() {
		WebUI.click(findTestObject('Object Repository/Registration/RegistrationPage/step2_screen/button_Empezar'))
	}

	// Método para verificar el país seleccionado en el formulario
	static void verifyCountry(String expectedCountry) {
		String inputValue = WebUI.getAttribute(findTestObject('Object Repository/Registration/RegistrationPage/form_screen/country_check'), 'value')
		if (inputValue.equals(expectedCountry)) {
			WebUI.comment('El campo se completó correctamente con el país: ' + inputValue)
		} else {
			WebUI.comment('El campo no se completó correctamente. Valor actual: ' + inputValue + ', País esperado: ' + expectedCountry)
		}
	}

	// Método para validar la página después de seleccionar una opción
	static void validatePageAfterSelection(int optionIndex) {
		switch (optionIndex) {
			case 0:
				WebUI.verifyElementPresent(findTestObject('Object Repository/Registration/RegistrationPage/step2_screen/time_tracking_feature'), 30)
				break
			case 1:
				WebUI.verifyElementPresent(findTestObject('Object Repository/Registration/RegistrationPage/step2_screen/Invoices_feature'), 30)
				break
			case 2:
				WebUI.verifyElementPresent(findTestObject('Object Repository/Registration/RegistrationPage/step2_screen/OB_feature'), 30)
				break
			case 3:
				WebUI.verifyElementPresent(findTestObject('Object Repository/Registration/RegistrationPage/step2_screen/jobs_feature'), 30)
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

	// Método para validar la URL después de registrar la opción seleccionada
	static void validateUrlAfterRegistration(int optionIndex) {
		int timeout = 30
		int interval = 2
		int elapsedTime = 0

		String expectedUrlPattern = ''
		switch (optionIndex) {
			case 0:
				expectedUrlPattern = '.*clock-hours.*'
				break
			case 1:
				expectedUrlPattern = '.*budgets\\?type=BILL.*'
				break
			case 2:
				expectedUrlPattern = '.*/admin/online-booking.*'
				break
			case 3:
				expectedUrlPattern = '.*admin/deals.*'
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

		while (elapsedTime < timeout) {
			String currentUrl = WebUI.getUrl()
			if (currentUrl ==~ expectedUrlPattern) {
				WebUI.comment("URL validada correctamente: " + currentUrl)
				return
			}
			WebUI.delay(interval)
			elapsedTime += interval
		}

		String currentUrl = WebUI.getUrl()
		throw new AssertionError("URL actual no coincide con el patrón esperado. URL actual: " + currentUrl + ", Patrón esperado: " + expectedUrlPattern)
	}

	// Método para habilitar todas las funcionalidades
	static void enableAllFeature() {
		WebUI.click(findTestObject('Object Repository/Registration/RegistrationPage/a_Funcionalidades'))

		List<TestObject> sliders = [
			findTestObject('Object Repository/Registration/RegistrationPage/span_Gastos_slider-large round'),
			findTestObject('Object Repository/Registration/RegistrationPage/span_Gestion interna_slider-large round'),
			findTestObject('Object Repository/Registration/RegistrationPage/span_Ventas_slider-large round'),
			findTestObject('Object Repository/Registration/RegistrationPage/span_controlHorario')
		]

		for (TestObject slider : sliders) {
			if (isValidXpath(slider) && !isSliderGreen(slider)) {
				try {
					scrollIntoView(slider)
					WebUI.click(slider)
				} catch (Exception e) {
					WebUI.comment("Error al habilitar el slider: " + e.getMessage())
				}
			} else {
				WebUI.comment("El slider ya está en verde, no se realiza el clic.")
			}
		}
	}

	// Método para verificar si un slider está en color verde
	static boolean isSliderGreen(TestObject testObject) {
		try {
			WebDriver driver = DriverFactory.getWebDriver()
			WebElement element = driver.findElement(By.xpath(testObject.findPropertyValue('xpath').toString()))
			String color = WebUI.executeJavaScript('return window.getComputedStyle(arguments[0]).backgroundColor;', Arrays.asList(element))
			return color.equals('rgb(54, 191, 106)') // Color verde en formato RGB
		} catch (Exception e) {
			WebUI.comment("Error al verificar el color del slider: " + e.getMessage())
			return false
		}
	}

	// Método para desplazar un elemento al viewport
	static void scrollIntoView(TestObject testObject) {
		try {
			WebDriver driver = DriverFactory.getWebDriver()
			WebElement element = driver.findElement(By.xpath(testObject.findPropertyValue('xpath').toString()))
			JavascriptExecutor js = (JavascriptExecutor) driver
			js.executeScript('arguments[0].scrollIntoView(true);', element)
		} catch (Exception e) {
			WebUI.comment("Error al desplazar el elemento al viewport: " + e.getMessage())
		}
	}

	// Método para verificar si un XPath es válido
	static boolean isValidXpath(TestObject testObject) {
		String xpath = testObject.findPropertyValue('xpath').toString()
		if (xpath == null || xpath.isEmpty()) {
			WebUI.comment("XPath no es válido: " + xpath)
			return false
		}
		return true
	}

	// Método para obtener el token de reCAPTCHA
	static void getReCaptchaToken() {
		String recaptchaUrl = "https://www.google.com/recaptcha/api2/demo"
		String token = null
		try {
			URL url = new URL(recaptchaUrl)
			HttpURLConnection connection = (HttpURLConnection) url.openConnection()
			connection.setRequestMethod("GET")
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))
			String line
			while ((line = reader.readLine()) != null) {
				if (line.contains("recaptcha-token")) {
					token = line.split("value=\"")[1].split("\"")[0]
					break
				}
			}
			reader.close()
		} catch (Exception e) {
			WebUI.comment("Error al obtener el token de reCAPTCHA: " + e.getMessage())
		}
		WebUI.comment("Token de reCAPTCHA: " + token)
	}
}
