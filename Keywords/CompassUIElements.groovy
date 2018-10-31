import static com.kms.katalon.core.checkpoint.CheckpointFactory.*
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.ss.usermodel.Chart
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.server.handler.WebDriverHandler

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
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
				"//kendo-list[@class='ng-star-inserted']//ul[@role='listbox']/li[contains(.,'"+data+"')]",true)
		WebUI.waitForElementVisible(tox, GlobalVariable.waitforelement, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementClickable(tox, GlobalVariable.waitforelement, FailureHandling.STOP_ON_FAILURE)
		WebUI.click(tox)
	}
	@Keyword
	public static void waitCompassLoad(){
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/Compass/Generic/Spinner'), GlobalVariable.pageloadwait, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/Compass/Generic/PageLoad'), GlobalVariable.pageloadwait, FailureHandling.STOP_ON_FAILURE)
		WebUI.waitForElementNotVisible(findTestObject('Object Repository/Compass/Generic/PageLoadingText'), GlobalVariable.pageloadwait, FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(2)
	}
	@Keyword
	public static void clickButton(TestObject to){
		waitCompassLoad()
		WebUI.click(to)
	}
	@Keyword
	public static void selectMultiList(){
	}
	@Keyword
	public static void clickButtonItem(TestObject to, String buttonItem){
	}
	@Keyword
	public static void kendoMultiSelectList(TestObject to, String item){
		String[] allItems = item.split(GlobalVariable.multivalueseperator)
		for(String data:allItems){
			waitCompassLoad()
			//check if its already exist
			TestObject itemObj = General.createObject("//div[@class='k-multiselect-wrap k-floatwrap']//li/span[contains(.,'"+data+"')]")
			boolean isSelected = true
			try{

				isSelected = WebUI.waitForElementVisible(itemObj,1)

			}
			catch(Exception e){
				isSelected = false
			}
			if(!isSelected)
			{
				WebUI.waitForElementVisible(to, GlobalVariable.waitforelement, FailureHandling.STOP_ON_FAILURE)
				WebUI.waitForElementClickable(to, GlobalVariable.waitforelement, FailureHandling.STOP_ON_FAILURE)
				WebUI.click(to)
				itemObj = General.createObject("//kendo-list[@class='ng-star-inserted']//ul[@role='listbox']/li[contains(.,'"+data+"')]")
				WebUI.waitForElementVisible(itemObj, GlobalVariable.waitforelement, FailureHandling.STOP_ON_FAILURE)
				WebUI.waitForElementClickable(itemObj, GlobalVariable.waitforelement, FailureHandling.STOP_ON_FAILURE)
				WebUI.click(itemObj)
			}
		}
	}
	@Keyword
	public static void kendoDeleteMultiSelectItem(String item){
		String[] allItems = item.split(GlobalVariable.multivalueseperator)
		for(String data:allItems){
			waitCompassLoad()
			TestObject itemObj = General.createObject("//div[@class='k-multiselect-wrap k-floatwrap']//span[contains(.,'"+data+"')]/following-sibling::span/span[@class='k-icon k-i-close']")
			WebUI.click(itemObj)
		}

	}
	@Keyword
	public static void kendoChartWidgetClose(String chartDisplayName){
		String[] allItems = chartDisplayName.split(GlobalVariable.multivalueseperator)
		TestObject obj,itemObj;
		for(String data:allItems){
			waitCompassLoad()
			if((!data.equalsIgnoreCase("events")))
				obj= General.createObject("//*[contains(.,'"+data+"') and ancestor::*[name()='kendo-chart']]//ancestor::*[name()='kendo-chart']/preceding-sibling::span")
			else if(data.equalsIgnoreCase("events"))
				obj = General.createObject("//th[contains(.,'Event ID')]//ancestor::*[name()='kendo-grid']/preceding-sibling::span")
			if(checkElementVisible(obj, 1)){
				WebUI.click(obj)
				waitCompassLoad()
				itemObj = General.createObject("//div[@class='k-multiselect-wrap k-floatwrap']//li/span[contains(.,'"+data+"')]")
				if(checkElementVisible(itemObj, 1)){
					KeywordUtil.markFailed("Though the widget "+data+" is remove, it is still showing up in the add sections list")
				}
			}
		}
	}
	@Keyword
	public static void kendoVerifyChartVisible(String chartName){
		String[] allCharts = chartName.split(GlobalVariable.multivalueseperator)
		for(String data:allCharts){
			waitCompassLoad()
			//check if its already exist
			TestObject itemObj = General.createObject("//*[contains(.,'"+data+"') and ancestor::*[name()='kendo-chart']]//ancestor::*[name()='kendo-chart']")
			boolean isVisible = true
			try{

				isVisible = WebUI.waitForElementVisible(itemObj,1)

			}
			catch(Exception e){
				isVisible = false
			}
			if(!isVisible)
			{
				KeywordUtil.markFailed("The chart with name "+data+" is not visible")
			}
		}
	}
	@Keyword
	public static void verifyElementData(TestObject to,String value){
		waitCompassLoad()
		String[] allData = value.split(GlobalVariable.multivalueseperator)
		for(String data:allData){
			WebUI.verifyElementVisible(to)
			WebUI.verifyElementText(to, data, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}
	@Keyword
	public static boolean checkElementVisible(TestObject to,int timeOut){
		boolean isVisible = false
		try{
			isVisible = WebUI.waitForElementVisible(to, timeOut)
		}
		catch(Exception e){
			isVisible = false
		}
		return isVisible
	}
}
