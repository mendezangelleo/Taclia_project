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

// Inicializar la variable calledByTest si no está definida
boolean calledByTest = (boolean) (this.binding.hasVariable('calledByTest') ? calledByTest : false)

// Llamada a otro caso de prueba
WebUI.callTestCase(findTestCase('Registration'), [('variable') : ''], FailureHandling.STOP_ON_FAILURE)

// Interacciones con la UI
WebUI.click(findTestObject('Object Repository/Customers/CreateCustomer/a_Clientes'))
WebUI.click(findTestObject('Object Repository/Customers/CreateCustomer/button_Aadir'))
WebUI.setText(findTestObject('Object Repository/Customers/CreateCustomer/input__form-control md-input ng-untouched n_bf7bea'), 
    'Create customer test')
WebUI.setText(findTestObject('Object Repository/Customers/CreateCustomer/input_NOMBRE FISCAL_form-control md-input n_8ae886'), 
    'fiscal name')
WebUI.setText(findTestObject('Object Repository/Customers/CreateCustomer/input_NMERO FISCAL_form-control md-input ng_40ba76'), 
    '12341234A')
WebUI.setText(findTestObject('Object Repository/Customers/CreateCustomer/input_CORREO ELECTRNICO_form-control md-inp_296ed0'), 
    'test@email.com')
WebUI.setText(findTestObject('Object Repository/Customers/CreateCustomer/input_Telfono_tel'), '123123123')
WebUI.click(findTestObject('Object Repository/Customers/CreateCustomer/button_Guardar'))

// Cerrar el navegador solo si el test no fue llamado por otro test
if (!calledByTest) {
    WebUI.closeBrowser()
}
