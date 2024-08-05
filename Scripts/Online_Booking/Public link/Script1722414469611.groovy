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

String email = 'test@yopmail.com'
String name = 'Test'
String lastName = 'OB'
String prefix = '+34'
String phoneNumber = '610101010'

WebUI.openBrowser('')

WebUI.navigateToUrl('https://booking.taclia.com/testob54')

//main page
if (WebUI.verifyElementPresent(findTestObject('Object Repository/Online booking/Public link/span_0_custom-radio'), 5, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Online booking/Public link/span_0_custom-radio'))
} else {
	WebUI.comment('Radio input not found')
}
WebUI.click(findTestObject('Object Repository/Online booking/Public link/button_Reservar Ahora'))

//1st step
WebUI.click(findTestObject('Object Repository/Online booking/Public link/button_Continuar'))

//2n step
WebUI.verifyElementNotClickable(findTestObject('Object Repository/Online booking/Public link/button_Continuar'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Online booking/Public link/button_0200'))
WebUI.verifyElementClickable(findTestObject('Object Repository/Online booking/Public link/button_Continuar'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Online booking/Public link/button_Continuar'))

//3rd step
WebUI.click(findTestObject('Object Repository/Online booking/Public link/input_Name_name'))
WebUI.verifyElementNotClickable(findTestObject('Object Repository/Online booking/Public link/button_Continuar'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Online booking/Public link/input_Name_name'))
WebUI.setText(findTestObject('Object Repository/Online booking/Public link/input_Name_name'), name)
WebUI.setText(findTestObject('Object Repository/Online booking/Public link/input_Last Name_lastName'), lastName)
WebUI.setText(findTestObject('Object Repository/Online booking/Public link/input_Email_email'), '')
WebUI.click(findTestObject('Object Repository/Online booking/Public link/p_Campo obligatorio'))
WebUI.setText(findTestObject('Object Repository/Online booking/Public link/input_Email_email'), email)
WebUI.setText(findTestObject('Object Repository/Online booking/Public link/input_text'), prefix)
WebUI.setText(findTestObject('Object Repository/Online booking/Public link/input_Phone_phone'), phoneNumber)
WebUI.setText(findTestObject('Object Repository/Online booking/Public link/input_Direccin (slo para servicios a domici_bb55a9'), '')
WebUI.click(findTestObject('Object Repository/Online booking/Public link/div_NombreApellidoCorreo ElectrnicoTelfonoD_6eda97'))
WebUI.verifyElementClickable(findTestObject('Object Repository/Online booking/Public link/button_Continuar'), FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Online booking/Public link/button_Continuar'))

//4th step
WebUI.click(findTestObject('Object Repository/Online booking/Public link/button_Confirma reserva'))

//5th step
WebUI.verifyElementPresent(findTestObject('Object Repository/Online booking/Public link/h2_Reserva confirmada'), 0)
WebUI.delay(8)

WebUI.closeBrowser()

