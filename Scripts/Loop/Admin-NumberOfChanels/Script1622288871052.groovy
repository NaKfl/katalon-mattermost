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

WebUI.waitForPageLoad(3)

// Get number of chanels before
WebUI.navigateToUrl('http://192.168.46.108:8065/admin_console/about/license')

WebUI.click(findTestObject('Object Repository/Page_System Console - Mattermost/a_Site Statistics'))

String numberOfTeamBefore = WebUI.getText(findTestObject('Page_System Console - Mattermost/div_NumberTeams'))

int ADDITIONAL_TEAMS = 2

// Create new chanels
WebUI.navigateToUrl('http://192.168.46.108:8065/')

for (int i = 1; i <= ADDITIONAL_TEAMS; i++) {
	String newTeam = 'new-team2-' + i
	WebUI.click(findTestObject('Page_Mattermost/div_Add Team Icon'))
	WebUI.click(findTestObject('Page_Mattermost/span_Create a team'))
	WebUI.setText(findTestObject('Page_Mattermost/input_Team Name_teamNameInput'), 
	    newTeam)
	WebUI.click(findTestObject('Page_Mattermost/button_Next'))
	WebUI.click(findTestObject('Page_Mattermost/button_Finish'))
}

// Get number of chanels after
WebUI.navigateToUrl('http://192.168.46.108:8065/admin_console/about/license')

WebUI.click(findTestObject('Object Repository/Page_System Console - Mattermost/a_Site Statistics'))

String numberOfTeamAfter = WebUI.getText(findTestObject('Page_System Console - Mattermost/div_NumberTeams'))

WebUI.verifyEqual(Integer.parseInt(numberOfTeamAfter), Integer.parseInt(numberOfTeamBefore) + ADDITIONAL_TEAMS)

WebUI.closeBrowser()
