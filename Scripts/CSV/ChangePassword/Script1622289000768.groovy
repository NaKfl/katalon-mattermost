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

// Login
String USERNAME='lem'
String PASSWROD='aAbB12@'

WebUI.callTestCase(findTestCase('CommonTestCase/TC-Common-Login'), [('username') : USERNAME, ('password'): PASSWROD], FailureHandling.STOP_ON_FAILURE)


for (def rowNum = 1; rowNum <= findTestData('Data Files/CSV/password').getRowNumbers(); rowNum++) {
	String oldPassword=''
	
	if(rowNum==1)
		oldPassword=PASSWROD
	else
		oldPassword = findTestData('Data Files/CSV/password').getValue(1, rowNum - 1)

	String newPassword = findTestData('Data Files/CSV/password').getValue(1, rowNum)

	WebUI.click(findTestObject('Page_Town Square - AnhEm1Nha Mattermost/button_More Menus'))
	
	WebUI.click(findTestObject('Object Repository/Page_Town Square - AnhEm1Nha Mattermost/button_Account Settings'))
	
	WebUI.click(findTestObject('Object Repository/Page_Town Square - AnhEm1Nha Mattermost/button_Security'))
	
	WebUI.click(findTestObject('Object Repository/Page_Town Square - AnhEm1Nha Mattermost/span_Edit'))
	
	WebUI.setText(findTestObject('Object Repository/Page_Town Square - AnhEm1Nha Mattermost/input_Current Password_currentPassword'),
		oldPassword)
	
	WebUI.setText(findTestObject('Object Repository/Page_Town Square - AnhEm1Nha Mattermost/input_New Password_newPassword'),
		newPassword)
	
	WebUI.setText(findTestObject('Object Repository/Page_Town Square - AnhEm1Nha Mattermost/input_Retype New Password_confirmPassword'),
		newPassword)
	
	WebUI.click(findTestObject('Object Repository/Page_Town Square - AnhEm1Nha Mattermost/button_Save'))
	
	WebUI.click(findTestObject('Object Repository/Page_Town Square - AnhEm1Nha Mattermost/button_Close'))
	
	WebUI.click(findTestObject('Page_Town Square - AnhEm1Nha Mattermost/button_More Menus'))
	
	WebUI.click(findTestObject('Object Repository/Page_Town Square - AnhEm1Nha Mattermost/button_Log Out'))
	
	WebUI.waitForPageLoad(3)
	
	WebUI.callTestCase(findTestCase('CommonTestCase/TC-Common-Login'), [('username') : USERNAME, ('password'): newPassword], FailureHandling.STOP_ON_FAILURE)
}

WebUI.closeBrowser()
