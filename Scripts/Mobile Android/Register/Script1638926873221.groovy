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

//variable
String strName = 'Dinda Kasa'
String strEmail = 'dinda@mail.com'
String strPassword = '123456'

Mobile.startApplication('App/Sample Android App Login Test_v4.0_apkpure.com.apk', true)

Mobile.tap(findTestObject('MobileAndroid/LoginPage/btn_CreateAccount'), 0)

//=== negative flow
//name case
Mobile.setText(findTestObject('MobileAndroid/RegisterPage/txt_RegisName'), "", 0)
Mobile.tap(findTestObject('MobileAndroid/RegisterPage/btn_RegisSubmit'), 0)
if (Mobile.waitForElementPresent(findTestObject('MobileAndroid/RegisterPage/lbl_ErrorName'), 1)) {
	Mobile.comment("error message is exist")
} else {
	Mobile.comment("error message is not exist")
}
Mobile.takeScreenshot()
Mobile.setText(findTestObject('MobileAndroid/RegisterPage/txt_RegisName'), strName, 0)

//email case
Mobile.setText(findTestObject('MobileAndroid/RegisterPage/txt_RegisEmail'), "", 0)
Mobile.tap(findTestObject('MobileAndroid/RegisterPage/btn_RegisSubmit'), 0)
if (Mobile.waitForElementPresent(findTestObject('MobileAndroid/RegisterPage/lbl_ErrorEmail'), 1)) {
	Mobile.comment("error message is exist")
} else {
	Mobile.comment("error message is not exist")
}
Mobile.takeScreenshot()

Mobile.setText(findTestObject('MobileAndroid/RegisterPage/txt_RegisEmail'), "test", 0)
Mobile.tap(findTestObject('MobileAndroid/RegisterPage/btn_RegisSubmit'), 0)
if (Mobile.waitForElementPresent(findTestObject('MobileAndroid/RegisterPage/lbl_ErrorEmail'), 1)) {
	Mobile.comment("error message is exist")
} else {
	Mobile.comment("error message is not exist")
}
Mobile.takeScreenshot()
Mobile.setText(findTestObject('MobileAndroid/RegisterPage/txt_RegisEmail'), strEmail, 0)

//password case
Mobile.setText(findTestObject('MobileAndroid/RegisterPage/txt_RegisPassword'), "", 0)
Mobile.tap(findTestObject('MobileAndroid/RegisterPage/btn_RegisSubmit'), 0)
if (Mobile.waitForElementPresent(findTestObject('MobileAndroid/RegisterPage/lbl_ErrorPassword'), 1)) {
	Mobile.comment("error message is exist")
} else {
	Mobile.comment("error message is not exist")
}
Mobile.takeScreenshot()
Mobile.setText(findTestObject('MobileAndroid/RegisterPage/txt_RegisPassword'), strPassword, 0)

//confirm password case
Mobile.setText(findTestObject('MobileAndroid/RegisterPage/txt_RegisConfirmPassword'), "", 0)
Mobile.tap(findTestObject('MobileAndroid/RegisterPage/btn_RegisSubmit'), 0)
if (Mobile.waitForElementPresent(findTestObject('MobileAndroid/RegisterPage/lbl_ErrorConfirmPassword'), 1)) {
	Mobile.comment("error message is exist")
} else {
	Mobile.comment("error message is not exist")
}
Mobile.takeScreenshot()

Mobile.setText(findTestObject('MobileAndroid/RegisterPage/txt_RegisConfirmPassword'), strPassword+"fail", 0)
Mobile.tap(findTestObject('MobileAndroid/RegisterPage/btn_RegisSubmit'), 0)
if (Mobile.waitForElementPresent(findTestObject('MobileAndroid/RegisterPage/lbl_ErrorConfirmPassword'), 1)) {
	Mobile.comment("error message is exist")
} else {
	Mobile.comment("error message is not exist")
}
Mobile.takeScreenshot()
Mobile.setText(findTestObject('MobileAndroid/RegisterPage/txt_RegisConfirmPassword'), strPassword, 0)

//submit account
Mobile.takeScreenshot()
Mobile.tap(findTestObject('MobileAndroid/RegisterPage/btn_RegisSubmit'), 0)
if (Mobile.waitForElementPresent(findTestObject('MobileAndroid/RegisterPage/lbl_RegisSuccess'), 1)) {
	Mobile.comment("message is exist")
} else {
	Mobile.comment("message is not exist")
}

//validate email exist
Mobile.setText(findTestObject('MobileAndroid/RegisterPage/txt_RegisName'), strName, 0)
Mobile.setText(findTestObject('MobileAndroid/RegisterPage/txt_RegisEmail'), strEmail, 0)
Mobile.setText(findTestObject('MobileAndroid/RegisterPage/txt_RegisPassword'), strPassword, 0)
Mobile.setText(findTestObject('MobileAndroid/RegisterPage/txt_RegisConfirmPassword'), strPassword, 0)
//submit account
Mobile.takeScreenshot()
Mobile.tap(findTestObject('MobileAndroid/RegisterPage/btn_RegisSubmit'), 0)
if (Mobile.waitForElementPresent(findTestObject('MobileAndroid/RegisterPage/lbl_RegisExist'), 1)) {
	Mobile.comment("message is exist")
} else {
	Mobile.comment("message is not exist")
}