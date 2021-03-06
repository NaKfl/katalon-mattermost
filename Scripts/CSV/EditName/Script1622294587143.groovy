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

WebUI.callTestCase(findTestCase('CommonTestCase/TC-Common-Login'), [('username') : findTestData('InternalData/Login').getValue(
	1, 4), ('password') : findTestData('InternalData/Login').getValue(2, 4)], FailureHandling.STOP_ON_FAILURE)

for (def rowNum = 1; rowNum <= findTestData('Data Files/CSV/name').getRowNumbers(); rowNum++) {
	String name = findTestData('Data Files/CSV/name').getValue(1, rowNum)
	String firstname = name.split(' ')[0]
	String lastname = name.split(' ')[1]
	
	WebUI.click(findTestObject('Page_Town Square/Edit/div_path'))
	
	WebUI.click(findTestObject('Page_Town Square/Edit/button_Account Settings'))
	
	WebUI.click(findTestObject('Page_Town Square/Edit/span_EditFullName'))
	
	WebUI.setText(findTestObject('Page_Town Square/Edit/input_First Name_firstName'), firstname)
	
	WebUI.setText(findTestObject('Page_Town Square/Edit/input_Last Name_lastName'), lastname)
	
	WebUI.click(findTestObject('Page_Town Square/Edit/span_SaveFullname'))
	
	String fullName = WebUI.getText(findTestObject('Page_Town Square/Edit/div_fullname'))
	
	WebUI.verifyMatch(fullName, firstname+ ' '+ lastname,false)
	
	WebUI.click(findTestObject('Object Repository/Page_Town Square - AnhEm1Nha Mattermost/button_Close'))
}

WebUI.closeBrowser()