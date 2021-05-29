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
WebUI.openBrowser('')

WebUI.navigateToUrl('http://192.168.46.108:8065/')

WebUI.setText(findTestObject('Object Repository/Page_Mattermost/input_username'), 'sysadmin')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Mattermost/input_password'), '2SwE/drL9BoSDSAWnt1s8EiQe9rbSfQc')

WebUI.click(findTestObject('Object Repository/Page_Mattermost/button_Sign in'))

String TEST_HEADER = 'test-header-'

for (int i = 1; i <= 3; i++) {
	String expectedHeader=TEST_HEADER+i
	
	// Set header
	WebUI.click(findTestObject('Page_Mattermost/span_Set a Header'))
	WebUI.setText(findTestObject('Page_Mattermost/textarea_Input header'), expectedHeader)
	WebUI.click(findTestObject('Page_Mattermost/span_Save Header'))
	
	// Check
	String resultHeader = WebUI.getText(findTestObject('Page_Mattermost/p_Header value'))
	WebUI.verifyMatch(resultHeader, expectedHeader, false)
}

WebUI.closeBrowser()