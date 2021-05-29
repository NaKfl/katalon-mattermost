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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

WebUI.callTestCase(findTestCase('CommonTestCase/TC-Common-Login'), null);

WebDriver driver = DriverFactory.getWebDriver()
def eleCount = driver.findElements(By.className("team-container")).size()
def workSpaceCount = (eleCount - 1)/2

int numberWorkSpace = 1

switch(numberWorkSpace) {
	case 0:
		WebUI.sendKeys(null,  Keys.chord(Keys.CONTROL,Keys.ALT,'1'));
		String name = WebUI.getText(findTestObject('Object Repository/Page_Town Square/nameWorkspace'))
		
		TestObject object = findTestObject('Object Repository/Page_Town Square/workspaceActive')
		WebUI.verifyElementAttributeValue(object,'aria-label', name.toLowerCase()+' team', 1)
	break
	case 1:
		WebUI.sendKeys(null,  Keys.chord(Keys.CONTROL,Keys.ALT,'2'));
		String name = WebUI.getText(findTestObject('Object Repository/Page_Town Square/nameWorkspace'))
		
		TestObject object = findTestObject('Object Repository/Page_Town Square/workspaceActive')
		WebUI.verifyElementAttributeValue(object,'aria-label', name.toLowerCase()+' team', 1)
	break
	case 2:
		WebUI.sendKeys(null,  Keys.chord(Keys.CONTROL,Keys.ALT,'3'));
		String name = WebUI.getText(findTestObject('Object Repository/Page_Town Square/nameWorkspace'))
		
		TestObject object = findTestObject('Object Repository/Page_Town Square/workspaceActive')
		WebUI.verifyElementAttributeValue(object,'aria-label', name.toLowerCase()+' team', 1)
	default:
	break
}

WebUI.closeBrowser()