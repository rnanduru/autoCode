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
import common.*
import internal.GlobalVariable

public class AccountPlanner {
	@Keyword
	public static void selectPlanYear(String plan_year){
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/AccountPlaner/ddb_plan_year'), plan_year)
	}
	@Keyword
	public static void selectCustomerPlan(String plan){
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/AccountPlaner/ddb_customer_plan'), plan)
	}
	@Keyword
	public static void selectCategory(String category){
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/AccountPlaner/ddb_category'), category)
	}
	@Keyword
	public static void selectPPG(String ppg){
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/AccountPlaner/ddb_product_selection'), ppg)
	}
	@Keyword
	public static void selectUnits(String unit){
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/AccountPlaner/ddb_units'), unit)
	}
	@Keyword
	public static void selectHeaderItem(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			selectPlanYear(dataObj.get('PLAN_YEAR'))r
			selectCustomerPlan(dataObj.get('CUSTOMER_PLAN'))
			selectCategory(dataObj.get('CATEGORY'))
		}
	}
	public static void selectPPGs(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			CompassUIElements.checkItemInMultiSelectBox(findTestObject('Object Repository/Compass/AccountPlaner/ddb_product_selection'),dataObj.get("PRODUCT_SELECTION"))
		}
	}
	@Keyword
	public static void enterProductCostingData(){
	}
	@Keyword
	public static void clickAddNewBtn(){
	}
	@Keyword
	public static void clickApplyEDLPBtn(){
	}
	@Keyword
	public static void clickColumnBtn(){
	}
	@Keyword
	public static void enterAccountPlannerHeader(TestData td, String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			enterAccountPlannerHeader(dataObj.get('PLAN_YEAR'), dataObj.get('CUSTOMER PLAN'), dataObj.get('CATEGORY'))
		}
	}
	@Keyword
	public static void enterAccountPlannerSubHeader(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			enterAccountPlannerSubHeader(dataObj.get('PRODUCT_SELECTION'))
		}
	}
	@Keyword
	public static void enterAccountPlannerHeader(String planYear,String custPlan,String category, String newString){
		selectPlanYear("")
		selectCustomerPlan("")
		selectCategory("")
	}
	@Keyword
	public static void verifyDataInPlanYearList(String expValue){
		TestObject to = General.createObject("//compass-plan-selection-header-component//div[2]//span[1]/kendo-dropdownlist/span[@role='listbox']/span[@class='k-input']")
		CompassUIElements.verifyElementData(to, expValue)
	}
	@Keyword
	public static void verifyDataInCustomerPlanList(String expValue){
		TestObject to = General.createObject("//compass-plan-selection-header-component//div[2]//span[2]/kendo-dropdownlist/span[@role='listbox']/span[@class='k-input']")
		CompassUIElements.verifyElementData(to, expValue)
	}
	@Keyword
	public static void verifyDataInCategoryList(String expValue){
		TestObject to = General.createObject("//compass-plan-selection-header-component//div[2]//span[3]/kendo-dropdownlist/span[@role='listbox']/span[@class='k-input']")
		CompassUIElements.verifyElementData(to, expValue)
	}
	@Keyword
	public static void VerifyDataInProductList(String expValue){
		TestObject to=General.createObject("//kendo-combobox[@placeholder='Select PPG...']/span/kendo-searchbar/input[@class='k-input']")
		CompassUIElements.verifyElementData(to, expValue)
	}
	@Keyword
	public static void verifyHeaderListItemsData(TestData td, String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			verifyDataInPlanYearList(dataObj.get('PLAN_YEAR'))
			verifyDataInCustomerPlanList(dataObj.get('CUSTOMER_PLAN'))
			verifyDataInCategoryList(dataObj.get('CATEGORY'))
		}
	}

	//jk
	@Keyword
	public static void getAllCheckboxes() {
		String xpathcount="//div[@id='k-tabstrip-tabpanel-0']//kendo-grid-list//tbody/tr[.]/td[1]"

		int size=CompassUIElements.countAllCheckboxes(xpathcount)
		println "size :"+size
		CompassUIElements.checkAllCheckboxes(size)
	}

	//click on create view button
	@Keyword
	public static void clickCreateViewbtn(){
		//call CustomUI button click method
		CompassUIElements.clickButton('Object Repository/Compass/AccountPlaner/btn_create_view');
	}

	@Keyword
	public static void clickClosebtn()
	{
		//call CustomUI button click method
		CompassUIElements.clickButton('Object Repository/Compass/AccountPlaner/btn_close_view')
	}
	
	//Enter view name in the text input field
	@Keyword
	public static void setViewName(){
		//call CustomUIElements setText menthod
		CompassUIElements.setText('Object Repository/Compass/AccountPlaner/input_view_name', "viewname")
	}
	
	//click on save button
	@Keyword
	public static void clickSavebtn(){
		//call CustomUIElements button enable
		boolean elementclickable=CompassUIElements.checkButtonEnable('Object Repository/Compass/AccountPlaner/btn_view_save')
		if(elementclickable==true)
		{
			//call CustomUIElements button click
			CompassUIElements.clickButton('Object Repository/Compass/AccountPlaner/btn_view_save')
			
		}
	}
	
}

