import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.stringtemplate.v4.compiler.STParser.ifstat_return
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.By
import com.kms.katalon.core.webui.driver.DriverFactory
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
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable

public class EventManagement {

	@Keyword
	public static void clickExportToExcel(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/EventManagement/btn_export_to_excel'))
	}

	@Keyword
	public static void clickEventsTab(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/EventManagement/btn_Events'))
	}

	@Keyword
	public static void clickProductsTab(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/EventManagement/btn_products'))
	}
	@Keyword
	public static void kendoGridFilterCell(TestObject tb,String column,String filterBy,String apply){

		WebUI.click(General.createObject("//kendo-tabstrip[@class='ng-tns-c11-3 k-widget k-tabstrip k-floatwrap k-tabstrip-top k-header']/div[1]//div[@class='k-grid-header-wrap']//tr[2]/td[1]//span[2]"))
		WebUI.delay(2)
		WebUI.click(General.createObject("//kendo-list[@class='ng-star-inserted']//ul[@role='listbox']/li[contains(.,'Is equal to')]"))
	}

	@Keyword
	public static void deleteAnyEvent(int rowNumber){
		TestObject to=General.createObject("//kendo-tabstrip/div[1]/kendo-grid//kendo-grid-list[@role='presentation']//table[@role='presentation']/tbody[@role='presentation']/tr["+rowNumber+"]/td[1]//div[@class='col-sm-2']")
		WebUI.click(to)
	}


	@Keyword
	public static void hideAndShowColumns(){
		for(int rownumber=13;rownumber<21;rownumber++){
			TestObject to=General.createObject("//event-management-component[@class='ng-star-inserted']/kendo-dialog/div[2]/div/span["+rownumber+"]/label[@class='k-checkbox-label']")
			WebUI.click(to)
		}
		WebUI.click(General.createObject("//event-management-component[@class='ng-star-inserted']/kendo-dialog//kendo-dialog-actions/button[@class='k-button ng-star-inserted']"))
		WebUI.delay(2)
	}

	@Keyword
	public static void verifyTotalNumOfHeaders(int row,int col){
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> ele=driver.findElements(By.xpath("//kendo-tabstrip/div["+row+"]/kendo-grid/div/div[@role='presentation']/div[@role='presentation']/table[@role='presentation']/thead[@role='presentation']/tr[1]/th"))
		int totalColumns=ele.size()
		if(col==totalColumns){
			KeywordUtil.markPassed("Total number of columns"+totalColumns)
		}else{
			KeywordUtil.markFailed("Mismatch in Total number"+totalColumns+" of Headers")
		}
	}
	@Keyword
	public static void clickColumnsButton(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/EventManagement/btn_Columns'))
	}
	@Keyword
	public static void sortAndFilterColumns(){
		TestObject obj;
		TestObject obj1;
		TestObject sel;
		for(int i=1;i<=22;i++) {
			if(i!=3 || i!=4){
				//filter to click
				obj=General.createObject("//kendo-tabstrip[@class='ng-tns-c11-3 k-widget k-tabstrip k-floatwrap k-tabstrip-top k-header']/div[1]//div[@class='k-grid-header-wrap']//tr[2]/td["+i+"]//span[2]")
				WebUI.click(obj)
				//Dropdown Selection equal to
				sel=General.createObject("//kendo-tabstrip[@class='ng-tns-c11-3 k-widget k-tabstrip k-floatwrap k-tabstrip-top k-header']/div[1]//div[@class='k-grid-header-wrap']//tr[2]/td["+i+"]//span[@class='k-input' and text()='Is equal to']")
				WebUI.delay(2)
				WebUI.click(sel)
				//input to enter
				//	obj1=General.createObject("//kendo-tabstrip[@class='ng-tns-c11-3 k-widget k-tabstrip k-floatwrap k-tabstrip-top k-header']/div[1]//div[@class='k-grid-header-wrap']//tr[2]/td["+i+"]//input")
			}
		}
	}


	@Keyword
	public static void filterColumns(TestObject to){
	}
	@Keyword
	public static void clickCreateEventButton(int row){
		TestObject obj;
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/EventManagement/btn_CreateEvent'))
		WebUI.delay(2)
		obj=General.createObject("//app-root/kendo-popup//kendo-button-list[@class='ng-star-inserted']/ul/li["+row+"]")
		WebUI.delay(2)
		WebUI.click(obj)
	}

	@Keyword
	public static void editByEventID(String event,String row){
		TestObject filterIcon=General.createObject("//kendo-tabstrip/div["+row+"]//kendo-grid//div[@role='presentation']/table[@role='presentation']/thead[@role='presentation']/tr[2]/td[1]//kendo-dropdownlist/span[@role='listbox']//span[@class='k-i-filter k-icon']")
		WebUI.click(filterIcon)
		WebUI.delay(2)
		//Select Equal to Filter
		WebUI.click(General.createObject("//kendo-list[@class='ng-star-inserted']//ul[@role='listbox']/li[1]"))
		//Input textbox
		//TestObject inpt=General.createObject("//kendo-tabstrip/div[1]//kendo-grid/div[@role='grid']//div[@role='presentation']/table[@role='presentation']//tr[2]/td[1]//kendo-grid-filter-wrapper-cell[@class='k-filtercell-wrapper']/input")
		TestObject inpt=General.createObject("//kendo-tabstrip/div["+row+"]/kendo-grid//div[@role='presentation']/table[@role='presentation']//tr[2]/td[1]//kendo-grid-filter-wrapper-cell[@class='k-filtercell-wrapper']/input")
		CompassUIElements.setText(inpt, event)
		TestObject rowData=General.createObject("//kendo-tabstrip/div["+row+"]//kendo-grid//kendo-grid-list[@role='presentation']/div[@role='presentation']//table[@role='presentation']/tbody[@role='presentation']/tr[1]/td[1]//a")
		WebUI.click(rowData)
		CompassUIElements.waitCompassLoad()
	}
	/*
	 * Verify's the corresponding PPGs eventsIDs
	 */
	@Keyword
	public static void verifyPPGsEventID(){
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> element=driver.findElements(By.xpath("//kendo-tabstrip/div[1]//kendo-grid//kendo-grid-list[@role='presentation']/div[@role='presentation']//table[@role='presentation']/tbody[@role='presentation']/tr"))
		if(element.size>0){
			println "PPGs corresponding Event ID Exists"
		}else{
		    KeywordUtil.markFailed("PPGs corresponding Event ID Exists");
		}
	}

	@Keyword
	public static void clickEventNameBtn(String str){
		WebUI.click(findTestObject('Object Repository/Compass/EventManagement/btn_eventname'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/Compass/EventManagement/txt_eventname'), str)
	}

	@Keyword
	public static void clickSaveBtn(){
		WebUI.click(findTestObject('Object Repository/Compass/EventManagement/btn_save'))
		WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/Compass/EventManagement/btn_saveinfo_ok'))
	}

	@Keyword
	public static void verifyEditEvent(String str,String eventName){
		//event row Data
		TestObject rowData=General.createObject("//kendo-tabstrip/div["+str+"]/kendo-grid//kendo-grid-list[@role='presentation']//table[@role='presentation']/tbody[@role='presentation']/tr[1]/td[2]")
		CompassUIElements.kendoVerifyText(rowData, eventName, "true")
	}
	/*
	 * Selects the PPGs above the event tab.
	 */
	@Keyword
	public static void selectPPG(String ProductSelection){
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/EventManagement/ddb_product_selection'),ProductSelection)
	}
}
