import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.stringtemplate.v4.compiler.STParser.compoundElement_return
import java.lang.String.CaseInsensitiveComparator
import org.openqa.selenium.WebDriver
import com.gargoylesoftware.htmlunit.javascript.host.media.webkitMediaStream
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
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.interactions.Action

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
	public static void selectPPG(String ProductSelection){
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/AccountPlaner/ddb_product_selection'),ProductSelection)
	}
	@Keyword
	public static void selectUnits(String units){
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/AccountPlaner/ddb_units'),units)
	}
	@Keyword
	public static void exportToExecel(){
		WebUI.click(findTestObject('Object Repository/Compass/AccountPlaner/btn_export_to_excel'))
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
			selectPPG(dataObj.get('PRODUCT_SELECTION'))
			selectUnits(dataObj.get('UNITS'))
		}
	}
	@Keyword
	public static void getDataFromProductCostingTable(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/btn_add_new'))
			CompassUIElements.GetValueInTablecell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),dataObj.get('rowNo'),'EDLP Rate/Case')
		}
	}
	@Keyword
	public static void productCostingTable(TestData td,String rowNo){
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
			CompassUIElements.EnterValueInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),
					dataObj.get('Row_No'), 'Unit Cost Net Allow',dataObj.get('Unit_Cost_Net_Allow'))

			CompassUIElements.EnterValueInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),
					dataObj.get('Row_No'), 'Non Promo SRP',dataObj.get('Non_Promo_SRP'))

			CompassUIElements.EnterValueInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),
					dataObj.get('Row_No'), 'Ret Margin (Base %)',dataObj.get('Retailer_Margin_(Base %)'))
			WebUI.delay(2)
			CompassUIElements.SelectValueInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),
					dataObj.get('Row_No'), 'Spend Method',dataObj.get('Spend_Method'))
			WebUI.delay(2)

			//CompassUIElements.kendoDialogBoxHandler('true','One of the following conditions are not met','OK')
		}
	}
	@Keyword
	public static void AccountPlannerKendoDialogBox1(){
		CompassUIElements.kendoDialogBoxHandler("true","Do you want to save your Account Planner changes for UB5 36z Velveeta Loaf 12 15.30?","","","Yes")
	}
	@Keyword
	public static void AccountPlannerKendoDialogBox2(){

		CompassUIElements.kendoDialogBoxHandler("true","One of the following conditions are not met","","","OK")
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
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/btn_apply_edlp'))
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
	public static void DataInPlanYearList(String PlanYearList){
		CompassUIElements.kendoGetText(findTestObject("//compass-plan-selection-header-component//div[2]//span[1]/kendo-dropdownlist/span[@role='listbox']/span[@class='k-input'and text()='2018']"),PlanYearList)
	}
	@Keyword
	public static void DataInCustomerPlanList(String CustomerPlanList ){
		CompassUIElements.kendoGetText(findTestObject("//compass-plan-selection-header-component//div[2]//span[2]/kendo-dropdownlist/span[@role='listbox']/span[@class='k-input'and text()='2018 ALBERTSONS / Recipe Grated n Cul']"),CustomerPlanList)
	}
	@Keyword
	public static void DataInCategoryList(String CategoryList){
		CompassUIElements.kendoGetText(("//compass-plan-selection-header-component//div[2]//span[3]/kendo-dropdownlist/span[@role='listbox']/span[@class='k-input'and text()='Recipe Cheese']"), CategoryList)
	}
	@Keyword
	public static void clickProductCost(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/btn_product_costing'))
	}
	@Keyword
	public static void DataInProductList(String ProductList){
		CompassUIElements.kendoGetText(findTestObject("//kendo-combobox/span/kendo-searchbar/input[@class='k-input']"),ProductList)
	}
	@Keyword
	public static void DataInUnits(String Units){
		//TestObject to=General.createObject
		CompassUIElements.kendoGetText(findTestObject("//kendo-dropdownlist/span//span[@class='k-input' and text()='Units']"),Units)

	}
	@Keyword
	public static void VerifyListItemsData(TestData td,String rowNo)  {
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			DataInProductList(dataObj.get('PRODUCT_SELECTION'))
			DataInUnits(dataObj.get('UNITS'))
		}
	}
	@Keyword
	public static void verifyHeaderListItemsData(TestData td, String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			DataInPlanYearList(dataObj.get('PLAN_YEAR'))
			DataInCustomerPlanList(dataObj.get('CUSTOMER_PLAN'))
			DataInCategoryList(dataObj.get('CATEGORY'))
		}
	}
	@Keyword
	public static void accountPlannerHeaderListData(TestData td, String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			DataInPlanYearList(dataObj.get('PLAN_YEAR'))
			DataInCustomerPlanList(dataObj.get('CUSTOMER_PLAN'))
			DataInCategoryList(dataObj.get('CATEGORY'))
		}
	}
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
		TestObject to=General.createObject("//accounts-planner//div[@class='col-md-12 form-group']/div/kendo-dropdownlist/following-sibling::button[contains(text(),'Create View')]")
		//call CustomUI button click method
		CompassUIElements.clickButton(to);
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
		WebDriver driver = DriverFactory.getWebDriver()
		//call CustomUIElements setText menthod
		TestObject to=General.createObject("//div/label[text()='View Name:']/following-sibling::input[contains(@class,'k-textbox')]")
		WebUI.delay(5)
		//WebUI.mouseOver(to)

		CompassUIElements.setText(to, "viewname1")

	}


	//click on save button
	@Keyword
	public static void clickSavebtn(){

		TestObject to=General.createObject("//accounts-planner[@class='ng-star-inserted']/div[2]/div[1]/div/button[text()='Save']")

		//call CustomUIElements button enable
		boolean elementclickable=CompassUIElements.checkButtonEnable(to)
		if(elementclickable==true)
		{
			//call CustomUIElements button click
			CompassUIElements.clickButton(to)

			//CompassUIElements.waitCompassLoad()
			//boolean result=CompassUIElements.checkElementVisible(findTestObject("Object Repository/Compass/AccountPlaner/txt_saved"), 5)
			//boolean result=CompassUIElements.checkElementVisible(findTestObject("//div[text()='Info Account Planner has been Saved']"), 5)


			//def exp=WebUI.getText(findTestObject("Object Repository/Compass/AccountPlaner/txt_saved"))

			/*boolean result=WebUI.verifyElementText(findTestObject("Object Repository/Compass/AccountPlaner/txt_saved"), popupmessage)
			 println "saved : "+result
			 if(result==true){
			 println "saved : "+result
			 CompassUIElements.waitCompassLoad()
			 }
			 else
			 {
			 println "saved "+result}*/


		}
	}

	//handle message popup
	@Keyword
	public static void messagePopupHandle(String popupmessage)
	{
		WebUI.delay(2)

		TestObject to1=General.createObject("//div[text()='"+popupmessage+"']")
		WebUI.waitForElementVisible(to1, 0, FailureHandling.STOP_ON_FAILURE)
		def exp=WebUI.getText(to1)
		println "exp"+exp
		//CompassUIElements.waitCompassLoad()

		WebUI.verifyMatch(exp,popupmessage, false)
		//CompassUIElements.waitCompassLoad()
	}
	//click close view
	@Keyword
	public static void closeView() {
		CompassUIElements.waitCompassLoad()
		TestObject to=General.createObject("//button[contains(text(),'Close View')]")
		WebUI.click(to)
	}
	//select view from list box
	@Keyword
	public static void selectView(String view)
	{
		CompassUIElements.selectListBox(findTestObject("Object Repository/Compass/AccountPlaner/ddb_viewlist"), view)

	}

	//click version button
	@Keyword
	public static void clickVersion(){
		CompassUIElements.clickButton(findTestObject("Object Repository/Compass/AccountPlaner/btn_versions"))
	}
	@Keyword
	public static void selectButtonList(String data)
	{
		CompassUIElements.selectKendoButtonList(data)
	}
	//select created version
	@Keyword
	public static void selectVersion(String version)
	{
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/AccountPlaner/ddb_versionlist'), version)
	}

	//verify selected version from list

	@Keyword
	public static void verifySelectedVersion(String version)
	{
		TestObject to=General.createObject("//span[contains(text(),'"+version+"')]")
		WebUI.verifyElementVisible(to)
	}

}

