import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import pages.GeneralUse as GeneralUse
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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import java.text.SimpleDateFormat as SimpleDateFormat
import internal.GlobalVariable as GlobalVariable
import pages.LoginPage as LoginPage
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement

int randomNumber = Math.random() * 100000

String reason = 'test automation' + randomNumber


WebUI.callTestCase(findTestCase('Online_Booking/Onboarding_OBP_published'), [ :], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/OnlineBooking/Create blocked slot/button_horarios'))

WebUI.click(findTestObject('Object Repository/OnlineBooking/Create blocked slot/span_Aadir bloqueo'))

WebUI.click(findTestObject('Object Repository/OnlineBooking/Create blocked slot/span_Guardar'))

WebUI.setText(findTestObject('Object Repository/OnlineBooking/Create blocked slot/input_Razn_reason'), reason)

WebUI.click(findTestObject('Object Repository/OnlineBooking/Create blocked slot/input_Fecha_datepicker-2'))


GeneralUse.clickOnDayElementWithTextWhite()


WebUI.setText(findTestObject('Object Repository/OnlineBooking/Create blocked slot/input_Desde_hour-input'), '08:00')

WebUI.setText(findTestObject('Object Repository/OnlineBooking/Create blocked slot/input_Hasta_hour-input'), '11:00')

WebUI.click(findTestObject('Object Repository/OnlineBooking/Create blocked slot/span_Guardar'))


WebUI.closeBrowser()

