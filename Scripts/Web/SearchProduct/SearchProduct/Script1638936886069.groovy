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

String strSearch = "iphone 11"

//search product
WebUI.setText(findTestObject('Web/Cart/txt_Search'), strSearch)
WebUI.click(findTestObject('Web/Cart/btn_SubmitSearch'))

//all product
for (int i in 2..10) {
	TestObject to = new TestObject("newObjectWeb")
	to.addProperty('XPath', ConditionType.EQUALS, "//section[@id='product-explorer-container']/div/div/div[2]/div/div[2]/div[4]/div/div["+i+"]")
	String textobject = WebUI.getText(to)
	WebUI.comment(textobject)
	boolean isProductValid = textobject.toLowerCase().contains(strSearch.toLowerCase())
	WebUI.verifyMatch(isProductValid.toString(), "true", false) 
}
WebUI.delay(1)
WebUI.closeBrowser()