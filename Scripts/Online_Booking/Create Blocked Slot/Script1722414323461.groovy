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

WebUI.click(findTestObject('Object Repository/OnlineBooking/Create blocked slot/button_Horarios'))

WebUI.click(findTestObject('Object Repository/OnlineBooking/Create blocked slot/span_Aadir bloqueo'))

WebUI.click(findTestObject('Object Repository/OnlineBooking/Create blocked slot/span_Guardar'))

WebUI.setText(findTestObject('Object Repository/OnlineBooking/Create blocked slot/input_Razn_reason'), reason)

WebUI.click(findTestObject('Object Repository/OnlineBooking/Create blocked slot/input_Fecha_datepicker-2'))


TestObject dayElementsObject = new TestObject('DayElements')

dayElementsObject.addProperty('xpath', ConditionType.EQUALS, '//*[contains(@class, \'w-9\') and contains(@class, \'h-9\') and contains(@class, \'text-xs\') and contains(@class, \'text-center\') and contains(@class, \'font-regular\') and contains(@class, \'rounded-full\') and contains(@class, \'flex\') and contains(@class, \'items-center\') and contains(@class, \'justify-center\') and contains(@class, \'hover:bg-primary-100\')]')

List<WebElement> elements = WebUI.findWebElements(dayElementsObject, 10)

int indexOfElementWithTextWhite = -1

for (int i = 0; i < elements.size(); i++) {
    WebElement element = elements.get(i)

    if (element.getAttribute('class').contains('text-white')) {
        indexOfElementWithTextWhite = i
    }
}

indexOfElementWithTextWhite = (indexOfElementWithTextWhite + 2)

TestObject dayObject = new TestObject().addProperty('xpath', ConditionType.EQUALS, ('//*[@id="block-schedule-modal"]/div/div/div[2]/form/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/button[' + 
    indexOfElementWithTextWhite) + ']')

WebUI.click(dayObject)


WebUI.setText(findTestObject('Object Repository/OnlineBooking/Create blocked slot/input_Desde_hour-input'), '08:00')

WebUI.setText(findTestObject('Object Repository/OnlineBooking/Create blocked slot/input_Hasta_hour-input'), '11:00')

WebUI.click(findTestObject('Object Repository/OnlineBooking/Create blocked slot/span_Guardar'))


WebUI.closeBrowser()

