import pages.LoginPage as LoginPage
import pages.GeneralUse as GeneralUse
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import pages.RegistrationPage as RegistrationPage
import emailGenerator.groovy.EmailGenerator as EmailGenerator
import geolocation.Geolocation as Geolocation
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
import org.openqa.selenium.Keys as Keys

try {
	// Abrir la aplicación y aceptar cookies
	LoginPage.open()
	LoginPage.acceptCookies()
	LoginPage.fillForm( TestConfig.email, TestConfig.password)
	LoginPage.clickLogin()
	LoginPage.validateUrlAfterLogin()
} catch (Exception e) {
	// Manejo de la excepción
	e.printStackTrace()
} finally {
	//GeneralUse.close()
}

