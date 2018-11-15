import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.stringtemplate.v4.compiler.STParser.compoundElement_return

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
import com.kms.katalon.core.webui.keyword.internal.WebUIKeywordMain

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
	public static void selectPPG( String PRODUCT_SELECTION){
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/AccountPlaner/ddb_product_selection'),PRODUCT_SELECTION)
	}
	@Keyword
	public static void selectUnits(String UNITS){
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/AccountPlaner/ddb_units'),UNITS)
	}
	@Keyword
	public static void whiteSpaceClick(){
		WebUI.click(findTestObject('Object Repository/Compass/AccountPlaner/white_space'))
	}
	@Keyword
	public static void clickSavebutton(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/btn_save'))
	}
	@Keyword
	public static void selectMiddleHeader(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			selectUnits(dataObj.get('UNITS'))
		}
	}
	@Keyword
	public static void prod(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/btn_add_new'))
			/*CompassUIElements.EnterValueInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),
					dataObj.get('Row_No'), 'PPG/Group', dataObj.get('PPG_Group'))*/
			CompassUIElements.EnterDateInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),
					dataObj.get('Row_No'), 'Start Date', dataObj.get('Start_Date'))

			CompassUIElements.EnterDateInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),
					dataObj.get('Row_No'), 'End Date', dataObj.get('End_Date'))

			CompassUIElements.EnterValueInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),
					dataObj.get('Row_No'), 'EDLP Rate/Case', dataObj.get('EDLP_Rate_Case'))
			println dataObj.get('EDLP_Rate_Case')
			CompassUIElements.EnterValueInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),
					dataObj.get('Row_No'), 'EDLP Rate/Unit',dataObj.get('EDLP_Rate_Unit'))

			CompassUIElements.EnterValueInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),
					dataObj.get('Row_No'), 'Spend Rate EDLP %',dataObj.get('Spend_Rate EDLP %'))

			CompassUIElements.EnterValueInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),
					dataObj.get('Row_No'), 'Unit Cost Net EDLP', dataObj.get('UnitCostNet_EDLP'))

			CompassUIElements.kendoDialogBoxHandler('true', 'Invalid plan data. Unit Cost Net Allowances cannot be 0 or greater than list price/unit','OK')

			CompassUIElements.EnterValueInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),
					dataObj.get('Row_No'), 'Unit Cost Net Allow',dataObj.get('Unit_Cost_Net_Allow'))
			WebUI.delay(1)
			CompassUIElements.kendoDialogBoxHandler('true','Invalid plan data. Unit Cost Net Allowances cannot be 0 or greater than list price/unit','OK')
			WebUI.delay(2)
			CompassUIElements.kendoDialogBoxHandler('true','Invalid plan data. Unit Cost Net Allowances cannot be 0 or greater than list price/unit','OK')
			WebUI.delay(5)
			CompassUIElements.kendoDialogBoxHandler('true','Invalid plan data. Unit Cost Net Allowances cannot be 0 or greater than list price/unit','OK')
			WebUI.delay(5)
			CompassUIElements.EnterValueInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),
					dataObj.get('Row_No'), 'Non Promo SRP',dataObj.get('Non_Promo_SRP'))

			CompassUIElements.EnterValueInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),
					dataObj.get('Row_No'), 'Ret Margin (Base %)',dataObj.get('Retailer_Margin_(Base %)'))

			CompassUIElements.SelectValueInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),
					dataObj.get('Row_No'), 'Spend Method',dataObj.get('Spend_Method'))

			CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/btn_apply_edlp'))


		}
	}
	@Keyword
	public static void AccountPlannerKendoDialogBox1(){
		CompassUIElements.kendoDialogBoxHandler("True","Do you want to save your Account Planner changes for .09z FS Crystal Light On the Go ", "Yes")
	}
	@Keyword
	public static void AccountPlannerKendoDialogBox2(){

		CompassUIElements.kendoDialogBoxHandler("True", "One of the following conditions are not met", "OK")
	}
	@Keyword
	public static void selectHeaderItem(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			selectPlanYear(dataObj.get('PLAN_YEAR'))
			selectCustomerPlan(dataObj.get('CUSTOMER_PLAN'))
			selectCategory(dataObj.get('CATEGORY'))
		}
	}

	/*@Keyword
	 public static void clearPPGFromProductSelection(){
	 TestObject to=General.createObject(findTestObject('Object Repository/Compass/AccountPlaner/ddb_product_selection'))
	 TestObject to1=General.createObject(findTestObject('Object Repository/Compass/AccountPlaner/product_section_searchbar'))
	 }*/
	@Keyword
	public static void enterProductCostingData(){
	}
	@Keyword
	public static void clickAddNewBtn(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/btn_add_new'))
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
	public static void clickProductCost(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/btn_product_costing'))
	}
	@Keyword
	public static void VerifyDataInProductList(String expValue){
		TestObject to=General.createObject("//kendo-combobox/span/kendo-searchbar/input[@class='k-input']")
		CompassUIElements.verifyElementData(to, expValue)
	}
	@Keyword
	public static void VerifyDataInUnits(String expValue){
		//TestObject to=General.createObject
		String s=WebUI.getText(findTestObject("//kendo-dropdownlist/span//span[@class='k-input' and text()='Units']"))
		CompassUIElements.verifyElementData(s, expValue)
	}
	@Keyword
	public static void VerifyListItemsData(TestData td,String rowNo)  {
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			VerifyDataInProductList(dataObj.get('PRODUCT_SELECTION'))
			VerifyDataInUnits(dataObj.get('UNITS'))
		}
	}
	@Keyword
	public static void ProductCostingTable(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			CompassUIElements.BuildTableColumns(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'))
			CompassUIElements.EnterDateInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/DatePicker'),'1','Start_Date','Oct/29/2018')
		}
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
}
