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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class HamburgMenu {
	@Keyword
	public static void clickHamburgMenu(String menuItem){
		CompassUIElements.waitCompassLoad()
		WebUI.waitForElementVisible(findTestObject("Object Repository/Compass/HamburgMenu/btn_hamburg"),
				GlobalVariable.waitforelement, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementClickable(findTestObject("Object Repository/Compass/HamburgMenu/btn_hamburg"),
				GlobalVariable.waitforelement, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(findTestObject("Object Repository/Compass/HamburgMenu/btn_hamburg"))
		TestObject TestObj  = General.createObject("//div[@id='sidebar-wrapper']/ul[@class='sidebar-nav']//a[contains(., '"+menuItem+"')]")
		CompassUIElements.waitCompassLoad()
		WebUI.waitForElementVisible(TestObj, GlobalVariable.waitforelement, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(TestObj)
	}
}
