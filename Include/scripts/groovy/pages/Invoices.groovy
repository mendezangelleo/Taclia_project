package pages

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import java.util.Arrays
import com.kms.katalon.core.testobject.TestObject
import config.TestConfig

class Invoices {
	static void openInvoices() {
		WebUI.click(findTestObject('Object Repository/Sales/Invoices/invoices_sidebar'))
	}

	static void openModalCreate() {
		WebUI.click(findTestObject('Object Repository/Sales/Invoices/create_invoice'))
	}

	static void createCustomer() {
		WebUI.click(findTestObject('Object Repository/Sales/Invoices/dropdown_Customers'))
		WebUI.click(findTestObject('Object Repository/Sales/Invoices/modal_createCustomer'))
		WebUI.setText(findTestObject('Object Repository/Sales/Invoices/name_modalCustomer'), TestConfig.name)
		WebUI.click(findTestObject('Object Repository/Sales/Invoices/Save_modalCustomer'))
	}

	static void saveInvoice() {
		WebUI.click(findTestObject('Object Repository/Sales/Invoices/Save_invoice'))
	}
	
	static void editInvoice() {
		WebUI.click(findTestObject('Object Repository/Sales/Invoices/edit_button'))
	}
	
	static void addConcepts() {
    // Hacer clic en el dropdown de conceptos
    WebUI.click(findTestObject('Object Repository/Sales/Invoices/dropdown_Concepts'))

    // Ingresar el nombre en el campo correspondiente
    WebUI.setText(findTestObject('Object Repository/Sales/Invoices/input_name'), TestConfig.name)

    // Encuentra el objeto al que deseas hacer scroll
    TestObject conceptObject = findTestObject('Object Repository/Sales/Invoices/select_concept')

    // Ejecutar JavaScript para hacer scroll hasta el objeto
    WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(WebUI.findWebElement(conceptObject)))

    // Hacer clic en el concepto seleccionado
    WebUI.click(conceptObject)
}
	
	static void selectSerialNumberExisting() {
		WebUI.click(findTestObject('Object Repository/Sales/Invoices/dropdown_SerialNumber'))
		WebUI.click(findTestObject('Object Repository/Sales/Invoices/select_SerialNumber'))
	}

	static void createSerialNumber() {
		WebUI.click(findTestObject('Object Repository/Sales/Invoices/dropdown_SerialNumber'))
		WebUI.click(findTestObject('Object Repository/Sales/Invoices/modal_createSerialNumber'))
		WebUI.setText(findTestObject('Object Repository/Sales/Invoices/name_modalSerialNumber'), TestConfig.SerialNumberName)
		WebUI.setText(findTestObject('Object Repository/Sales/Invoices/prefix_modalSerialNumber'), TestConfig.Prefix)
		WebUI.click(findTestObject('Object Repository/Sales/Invoices/Save_modalSerialNumber'))
		WebUI.click(findTestObject('Object Repository/Sales/Invoices/dropdown_SerialNumber'))
		WebUI.click(findTestObject('Object Repository/Sales/Invoices/select_SerialNumber'))
	}

	static void validatePreview() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Sales/Invoices/check_preview'), 30)
	}

}
