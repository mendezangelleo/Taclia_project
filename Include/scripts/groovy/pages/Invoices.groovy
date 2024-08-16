package pages
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import config.TestConfig

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



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
	
	
	static void createSerialNumber() {
		WebUI.click(findTestObject('Object Repository/Sales/Invoices/dropdown_SerialNumber'))
		WebUI.click(findTestObject('Object Repository/Sales/Invoices/modal_createSerialNumber'))
		WebUI.setText(findTestObject('Object Repository/Sales/Invoices/name_modalSerialNumber'), TestConfig.SerialNumberName)
		WebUI.setText(findTestObject('Object Repository/Sales/Invoices/prefix_modalSerialNumber'), TestConfig.Prefix)
		WebUI.click(findTestObject('Object Repository/Sales/Invoices/Save_modalSerialNumber'))
	}

	static void validatePreview() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Sales/Invoices/check_preview'), 30)
	}
	
	
	static void validateUrlPreview() {
		// Definir un tiempo máximo de espera
		int timeout = 30
		int interval = 2
		int elapsedTime = 0

		String expectedUrlPattern = ''
		expectedUrlPattern = '.*budgets/show?type=BILL&budget*'
	
	}
}