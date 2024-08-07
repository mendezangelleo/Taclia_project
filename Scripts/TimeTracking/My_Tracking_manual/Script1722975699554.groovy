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
import pages.Tracking as Tracking
import pages.GeneralUse as GeneralUse

WebUI.callTestCase(findTestCase('Registration'), [('variable') : ''], FailureHandling.STOP_ON_FAILURE)

try {
    Tracking.navigateToTimeTracking()

    Tracking.navigateToMyTracking()

    Tracking.startManualTracking()

    Tracking.validateDate()

    Tracking.setStartandEndDate()

    Tracking.saveManualTracking()

}
catch (Exception e) {
    e.printStackTrace()

    throw new AssertionError('Se produjo un error durante la ejecución del test: ' + e.getMessage())
} 
finally { 
    GeneralUse.close()
}

