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

// Login with admin account
WebUI.openBrowser('')
WebUI.navigateToUrl('http://192.168.46.108:8065/')
WebUI.setText(findTestObject('Object Repository/Page_Mattermost/input_username'), 'sysadmin')
WebUI.setEncryptedText(findTestObject('Object Repository/Page_Mattermost/input_password'), 
    '2SwE/drL9BoSDSAWnt1s8EiQe9rbSfQc')
WebUI.click(findTestObject('Object Repository/Page_Mattermost/button_Sign in'))

for (int i = 1; i <= 3; i++) {
String chanelNameExpect='test-team-'+i;
// Create test-team-x
  WebUI.click(findTestObject('Object Repository/Page_Town Square/more_button'))
  WebUI.click(findTestObject('Object Repository/Page_Town Square/button_Create New Channel'))
  WebUI.setText(findTestObject('Object Repository/Page_Town Square/input_Name_newChannelName'),
	  chanelNameExpect)
  WebUI.click(findTestObject('Object Repository/Page_Town Square/button_Create Channel'))
  
// Search test-team-x
  WebUI.click(findTestObject('Object Repository/Page_Town Square/button_Find channelK'))
  WebUI.setText(findTestObject('Object Repository/Page_Town Square/input_ESC_quickSwitchInput'), chanelNameExpect)
  
// Join test-team-x
  WebUI.sendKeys(findTestObject('Object Repository/Page_Town Square/input_ESC_quickSwitchInput'), Keys.chord(Keys.ENTER))
  String chanelNameResult = WebUI.getText(findTestObject('Object Repository/Page_Town Square/span_Chanel-name'))
  WebUI.verifyMatch(chanelNameResult, chanelNameExpect, false)
}

WebUI.closeBrowser()