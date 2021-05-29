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
WebUI.setEncryptedText(findTestObject('Object Repository/Page_Mattermost/input_password'),
	'2SwE/drL9BoSDSAWnt1s8EiQe9rbSfQc')
WebUI.click(findTestObject('Object Repository/Page_Mattermost/button_Sign in'))

WebUI.waitForPageLoad(3)

// Get number of chanels before
WebUI.navigateToUrl('http://192.168.46.108:8065/admin_console')
WebUI.click(findTestObject('Object Repository/Page_System Console - Mattermost/a_Site Statistics'))
String numberOfChanelBefore = WebUI.getText(findTestObject('Object Repository/Page_System Console - Mattermost/div_NumberChanels'))

int ADDITIONAL_CHANELS=3

// Create new chanels
WebUI.navigateToUrl('http://192.168.46.108:8065/')
for (int i = 1; i <= ADDITIONAL_CHANELS; i++) {
String newChanel='new-chanel3-'+i;
  WebUI.click(findTestObject('Object Repository/Page_Town Square/more_button'))
  WebUI.click(findTestObject('Object Repository/Page_Town Square/button_Create New Channel'))
  WebUI.setText(findTestObject('Object Repository/Page_Town Square/input_Name_newChannelName'),
	  newChanel)
  WebUI.click(findTestObject('Object Repository/Page_Town Square/button_Create Channel'))
}

// Get number of chanels after
WebUI.navigateToUrl('http://192.168.46.108:8065/admin_console/about/license')
WebUI.click(findTestObject('Object Repository/Page_System Console - Mattermost/a_Site Statistics'))
String numberOfChanelAfter = WebUI.getText(findTestObject('Object Repository/Page_System Console - Mattermost/div_NumberChanels'))

WebUI.verifyEqual(Integer.parseInt(numberOfChanelAfter), Integer.parseInt(numberOfChanelBefore)+ADDITIONAL_CHANELS)

WebUI.closeBrowser()