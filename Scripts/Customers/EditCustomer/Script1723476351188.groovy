import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Customers/CreateCustomer'), [('calledByTest') : true], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Customers/EditCustomer/customer_row'))

WebUI.setText(findTestObject('Object Repository/Customers/EditCustomer/input__form-control md-input ng-untouched n_6bafb9'), 
    'Edit customer test')

WebUI.setText(findTestObject('Object Repository/Customers/EditCustomer/input_NOMBRE FISCAL_form-control md-input n_8ae886'), 
    'fiscal name edit')

WebUI.setText(findTestObject('Object Repository/Customers/EditCustomer/input_NMERO FISCAL_form-control md-input ng_40ba76'), 
    '12341234A edit')

WebUI.setText(findTestObject('Object Repository/Customers/EditCustomer/input_CORREO ELECTRNICO_form-control md-inp_296ed0'), 
    'testedit@email.com')

WebUI.setText(findTestObject('Object Repository/Customers/EditCustomer/input_TELFONO_tel'), '610101010')

WebUI.click(findTestObject('Object Repository/Customers/EditCustomer/button_Guardar'))

WebUI.closeBrowser()