import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.lang.invoke.SwitchPoint

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
import internal.GlobalVariable

import org.eclipse.jdt.internal.compiler.ast.SwitchStatement
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('CommonTestCase/TC-Common-Login'), [('username') : findTestData('InternalData/Login').getValue(
            1, 4), ('password') : findTestData('InternalData/Login').getValue(2, 4)], FailureHandling.STOP_ON_FAILURE)

String type = '12h';
WebUI.click(findTestObject('Page_Town Square/Edit/div_path'))

WebUI.click(findTestObject('Page_Town Square/Edit/button_Account Settings'))

WebUI.click(findTestObject('Object Repository/Page_Town Square/Edit/button_option_display'))

WebUI.click(findTestObject('Object Repository/Page_Town Square/Edit/div_Clock DisplayEdit24-hour clock (example 1600)'))
switch (type) {
    case '12h':
        WebUI.click(findTestObject('Object Repository/Page_Town Square/Edit/label_12-hour clock (example 400 PM)'))
		WebUI.click(findTestObject('Object Repository/Page_Town Square/Edit/button_save_type_clock'))
		String typeClock = WebUI.getText(findTestObject('Object Repository/Page_Town Square/Edit/span_display_clock_type'))
		
		WebUI.verifyMatch(typeClock, '12-hour clock (example: 4:00 PM)',false)
		break;
	case '24h':
		WebUI.click(findTestObject('Object Repository/Page_Town Square/Edit/label_24-hour clock (example 1600)'))
		WebUI.click(findTestObject('Object Repository/Page_Town Square/Edit/button_save_type_clock'))
		String typeClock = WebUI.getText(findTestObject('Object Repository/Page_Town Square/Edit/span_display_clock_type'))
		WebUI.verifyMatch(typeClock, '24-hour clock (example: 16:00)',false)
		break;
    default:
        break
}



WebUI.closeBrowser()

