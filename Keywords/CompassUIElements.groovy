import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class CompassUIElements {
	@Keyword
	public static void selectListBox(TestObject to,String data){
		if(data.equalsIgnoreCase(""))
			return
		waitCompassLoad()
		WebUI.waitForElementClickable(to, GlobalVariable.waitforelement, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(to)
		TestObject tox = new TestObject().addProperty('xpath', ConditionType.EQUALS,
				"//app-root/kendo-popup//kendo-list[@class='ng-star-inserted']//ul[@role='listbox']/li[contains(.,'"+data+"')]",true)
		WebUI.waitForElementClickable(tox, GlobalVariable.waitforelement, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(tox)
	}
	@Keyword
	public static void waitCompassLoad(){
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/Compass/Generic/Spinner'), GlobalVariable.pageloadwait, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/Compass/Generic/PageLoad'), GlobalVariable.pageloadwait, FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(2)
	}
	@Keyword
	public static void clickButton(TestObject to){
	}
	@Keyword
	public static void selectMultiList(){
	}
	@Keyword
	public static void clickButtonItem(TestObject to, String buttonItem){
	}
}
