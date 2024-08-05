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
import pages.LoginPage as LoginPage
import pages.OnlineBooking as OnlineBooking
import config.TestConfig as TestConfig

WebUI.callTestCase(findTestCase('Registration'), [('variable') : ''], FailureHandling.STOP_ON_FAILURE)

try {
    OnlineBooking.navigateToOnlineBooking()

    OnlineBooking.createBookingPage(TestConfig.businessName)

    OnlineBooking.createProductOrService(TestConfig.serviceName)

    OnlineBooking.saveAndPublishPage()
}
catch (Exception e) {
    e.printStackTrace()

    WebUI.markFailed('Se produjo un error durante la ejecución del Test Case: ' + e.message)
} 
// Manejo de la excepción
// Falla el Test Case en caso de excepción
finally { 
    // Cerrar la aplicación o realizar acciones de limpieza
    LoginPage.close()
}

