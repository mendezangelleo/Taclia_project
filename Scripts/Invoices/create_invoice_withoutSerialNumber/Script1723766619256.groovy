import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import pages.RegistrationPage as RegistrationPage
import pages.Invoices as Invoices
import pages.GeneralUse as GeneralUse
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import keywords.SectorKeywords as SectorKeywords
import config.TestConfig as TestConfig
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('Registration'), [('variable') : ''], FailureHandling.STOP_ON_FAILURE)

try {
    GeneralUse.openSales()

    Invoices.openInvoices()

    Invoices.openModalCreate()

    Invoices.createCustomer()

    Invoices.saveInvoice()

    Invoices.validatePreview()
}
catch (Exception e) {
    e.printStackTrace()

    WebUI.markFailed('Se produjo un error durante la ejecución del Test Case: ' + e.message)
} 
finally { 
    //GeneralUse.close()
}

