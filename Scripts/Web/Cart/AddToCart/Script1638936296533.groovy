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
import com.kms.katalon.core.testobject.ConditionType

WebUI.openBrowser('')
WebUI.navigateToUrl('https://www.bukalapak.com/')
WebUI.maximizeWindow()

//search product
WebUI.setText(findTestObject('Web/Cart/txt_Search'), 'televisi')
WebUI.takeScreenshot()
WebUI.click(findTestObject('Web/Cart/btn_SubmitSearch'))

//choose product
WebUI.click(findTestObject('Web/Cart/btn_Product2'))
WebUI.takeScreenshot()
//WebUI.click(findTestObject('Web/Cart/btn_ChooseMemory'))
//WebUI.click(findTestObject('Web/Cart/lst_Memory128'))
//WebUI.click(findTestObject('Object Repository/Web/Cart/span_Hitam'))
//WebUI.click(findTestObject('Object Repository/Web/Cart/span_Merah'))
//WebUI.takeScreenshot()
if (WebUI.waitForElementPresent(findTestObject('Web/Cart/btn_MasukkanKeranjang'), 1)) {
	WebUI.click(findTestObject('Web/Cart/btn_MasukkanKeranjang'))
} else {
	WebUI.click(findTestObject('Web/Cart/btn_MasukkanKeranjang2'))
}


WebUI.delay(2)
WebUI.closeBrowser()