package pages

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.Random

class OnlineBooking {

	static void navigateToOnlineBooking() {
		WebUI.click(findTestObject('Object Repository/OnlineBooking/span_Reservas Online'))
	}

	static void createBookingPage(String businessName) {
		WebUI.click(findTestObject('Object Repository/OnlineBooking/span_Crear pgina de reservas'))
		WebUI.setText(findTestObject('Object Repository/OnlineBooking/Step_1/input_Nombre de tu negocio_name'), businessName)
		String randomUrl = generateRandomUrl(8) // Genera una URL aleatoria con 8 caracteres
		WebUI.setText(findTestObject('Object Repository/OnlineBooking/Step_1/input_booking.taclia.com_url'), randomUrl)
		WebUI.waitForElementVisible(findTestObject('Object Repository/OnlineBooking/Step_2/span_Siguiente'), 10)
		WebUI.click(findTestObject('Object Repository/OnlineBooking/Step_2/span_Siguiente'))

		WebUI.waitForElementVisible(findTestObject('Object Repository/OnlineBooking/Step_2/span_Siguiente'), 10)
		WebUI.click(findTestObject('Object Repository/OnlineBooking/Step_2/span_Siguiente'))
	}

	static void createProductOrService(String serviceName) {
		WebUI.click(findTestObject('Object Repository/OnlineBooking/Step_3/div_Crear productoservicio'))
		WebUI.setText(findTestObject('Object Repository/OnlineBooking/Step_3/service_name'), serviceName)
		WebUI.click(findTestObject('Object Repository/OnlineBooking/Step_3/button_Guardar'))
	}

	static void saveAndPublishPage() {
		WebUI.click(findTestObject('Object Repository/OnlineBooking/Step_3/span_Guardar'))
		WebUI.click(findTestObject('Object Repository/OnlineBooking/span_Publicar pgina'))
		WebUI.click(findTestObject('Object Repository/OnlineBooking/Step_3/span_Personalizacin_icon icon-xmark align-m_63c011'))
	}

	static void saveAndNoPublishPage() {
		WebUI.click(findTestObject('Object Repository/OnlineBooking/Step_3/span_Guardar'))
		WebUI.click(findTestObject('Object Repository/OnlineBooking/span_No publicar pagina'))
	}

	private static String generateRandomUrl(int length) {
		String chars = "abcdefghijklmnopqrstuvwxyz0123456789"
		Random random = new Random()
		StringBuilder sb = new StringBuilder()
		for (int i = 0; i < length; i++) {
			sb.append(chars.charAt(random.nextInt(chars.length())))
		}
		return sb.toString()
	}
}
