import static com.kms.katalon.core.checkpoint.CheckpointFactory.*
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.ss.usermodel.Chart
import org.omg.CORBA.OBJ_ADAPTER
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.server.handler.WebDriverHandler

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.webui.driver.DriverFactory

import org.openqa.selenium.By

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;


import internal.GlobalVariable
import common.*
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
	public static boolean checkButtonEnable(TestObject to){
		WebUI.verifyElementClickable(to)
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

	@Keyword
	public static int countAllCheckboxes(String to)
	{

		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> ele=driver.findElements(By.xpath(to))
		int rowcount=ele.size()
		return rowcount
	}

	@Keyword
	public static void checkAllCheckboxes(int size)
	{
		for(int rownumber=1;rownumber<=size;rownumber++){

			TestObject to=General.createObject("//div[@id='k-tabstrip-tabpanel-0']//kendo-grid-list//tbody/tr["+rownumber+"]/td[1]")
			WebUI.click(to)
		}
	}
	//click on create view button in account planner page
	@Keyword
	public static void clickCreateViewbtn(String data)
	{
		if(data.equalsIgnoreCase('create_view'))
			WebUI.verifyElementText(findTestObject("//button[contains(text(),'"+data+"')]"), data)
	}

	//set text in input field box
	@Keyword
	public static void setText(TestObject to,String text){
		WebUI.setText(to, text)
	}
	@Keyword
	public static void kendoGridSelectCheckBox(TestObject tblObj,String rowNo,int column){
		String tblXPath = tblObj.findPropertyValue("xpath")+"//table"
		WebDriver driver = DriverFactory.getWebDriver()
		waitCompassLoad()
		if(rowNo.equalsIgnoreCase("all")){
			List<WebElement> rows = driver.findElements(By.xpath(tblXPath+"//tr"))
			boolean isChecked;
			for(int i=1;i<rows.size();i++){
				if(checkElementVisible(General.createObject(tblXPath+"//tr["+i+"]/td["+column+"]/input"), 2)){
					isChecked = WebUI.getAttribute(General.createObject(tblXPath+"//tr["+i+"]/td["+column+"]/input"), "checked");// WebUI.verifyElementAttributeValue(, "value", "on", 5)
					if(!isChecked)
						WebUI.click(General.createObject(tblXPath+"//tr["+i+"]/td["+column+"]/input"))
				}
			}
			println "test"
		}
		else if(rowNo.contains(":")){
			List<WebElement> rows = driver.findElements(By.xpath(tblXPath+"//tr"))

			String[] rowFrom = rowNo.split(":")
			for(int i=Integer.valueOf(rowFrom[0]);i<=Integer.valueOf(rowFrom[(rowFrom.length)-1]);i++){
				WebUI.click(General.createObject(tblXPath+"//tr["+i+"]/td["+column+"]"))
			}
		}
		else if(rowNo.contains(GlobalVariable.multivalueseperator)){
			List<WebElement> rows = driver.findElements(By.xpath(tblXPath+"//tr"))

			String[] rowFrom = rowNo.split(GlobalVariable.multivalueseperator)
			for(int i=0;i<rowFrom.length;i++){
				WebUI.click(General.createObject(tblXPath+"//tr["+rowFrom[i]+"]/td["+column+"]"))
			}
		}
		else
			WebUI.click(General.createObject(tblXPath+"//tr["+Integer.valueOf(rowNo)+"]/td["+column+"]"))
	}
	@Keyword
	public static void kendoGridEnterTextInCell(String rowNo,int column,String data){

	}
	@Keyword
	public static String kendoGridGetTextInCell(String rowNo,int column){

	}
	@Keyword
	public static kendoDialogBoxHandler(String idDisplayed,String verifyText,String ppgname,String ppgtype,String buttonToClick) {
		TestObject tb = General.createObject("//kendo-dialog")

		String dialog_pls_confirm = tb.findPropertyValue("xpath")

		String tb1 = ""

		ArrayList<WebElement> wes = WebUiCommonHelper.findWebElements(tb, 20)

		println "For loop"

		int index = 1

		for(WebElement we:wes) {
			if(we.isDisplayed()){
				tb1 = "("+dialog_pls_confirm+")["+index+"]"
				break;
			}
			index++
		}

		if((tb1.equalsIgnoreCase("")) && (idDisplayed.equalsIgnoreCase("true")))
			KeywordUtil.markFailedAndStop("Dialog box is not displayed")
		else if((!tb1.equalsIgnoreCase("")) && (idDisplayed.equalsIgnoreCase("false")))
			KeywordUtil.markFailedAndStop("Dialog box is displayed")
		//verify the text message

		if(tb1.equalsIgnoreCase(""))
			return

		String messagePath = tb1+"//kendo-dialog-titlebar/following-sibling::div[@class='k-content k-window-content k-dialog-content']"

		TestObject messObj = new TestObject().addProperty("xpath",ConditionType.EQUALS,messagePath)

		if(!verifyText.equalsIgnoreCase("")){
			if(!WebUI.getText(messObj).toLowerCase().contains(verifyText.toLowerCase()))
				KeywordUtil.markFailed("Dialog box text is not matched")
			else if(verifyText.equalsIgnoreCase("Version Name:"))
			{
				WebUI.delay(8)
				println "delay"
				TestObject to=General.createObject("/html/body/app-root/div/div[1]/div/accounts-planner/kendo-dialog[5]/div[2]/div/div[1]/b")
				WebUI.click(to)
				TestObject to1=General.createObject("//div/input[@name='version' and @id='ppg']/following-sibling::label[contains(.,'"+ppgtype+"')]")
				WebUI.delay(5)
				/*RobotX.RoboKeyPressSpecial("<tab>")
				RobotX.RoboKeyPressSpecial("<tab>")*/
				
				WebUI.click(findTestObject("Object Repository/Compass/AccountPlaner/txt_version_save"))
				WebUI.setText(findTestObject("Object Repository/Compass/AccountPlaner/txt_version_save"), ppgname)
				
				WebUI.click(to1)
			}
		}
		String buttonPath = tb1+"//kendo-dialog-titlebar/following-sibling::kendo-dialog-actions//button[contains(.,"+buttonToClick+")]"

		TestObject buttonObj = new TestObject().addProperty("xpath",ConditionType.EQUALS,buttonPath)

		WebUI.click(buttonObj)
	}
	@Keyword
	public static void checkItemInMultiSelectBox(TestObject to,String item)
	{

		String toObject = to.findPropertyValue("xpath");
		String[] items = item.split(GlobalVariable.multivalueseperator);
		TestObject itemInList;

		for(String data:items){
			WebUI.setText(to, data)
			itemInList = General.createObject(toObject+"/ancestor::dropdown-filterable//label[text()='"+data+"']");
			//if(checkElementVisible(itemInList, 5)){
			WebUI.click(itemInList);
			//}
			//else
			//	KeywordUtil.markFailed("Item "+data+" does not exists in the list of values to check");
		}
	}
	//Kendo button list
	@Keyword
	public static void selectKendoButtonList(String data)
	{
		waitCompassLoad()
		TestObject to=General.createObject("//kendo-popup//kendo-button-list/ul//li[contains(.,'"+data+"')]")
		WebUI.click(to)
	}
}


