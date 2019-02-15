import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.stringtemplate.v4.compiler.STParser.compoundElement_return
import java.lang.String.CaseInsensitiveComparator
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.Color;
import org.openqa.selenium.WebElement
import com.gargoylesoftware.htmlunit.javascript.host.media.webkitMediaStream
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIKeywordMain
import internal.GlobalVariable
import org.openqa.selenium.By
import java.util.List;
import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import org.testng.Assert
import org.testng.annotations.*;
public class AccountPlanner {
	public static HashMap consumptionAllCols,distriAllCols,velAllCols;
	public static HashMap consumptionDataCols,distriDataCols,velDataCols;
	public static String baseDiv;
	public static String baseDataDiv;
	public static String baseTotalsDiv;
	public static iTable;
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
	public static void eventHeaderWhitespaceClick(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/btn_Eventheader_whitespaceclick'))
	}
	@Keyword
	public static void clickEvents(){
		TestObject to=General.createObject("//accounts-planner[@class='ng-star-inserted']/div[2]/div[1]/div/kendo-dropdownbutton[2]/button[contains(text(),'Events')]")
		//call CustomUIElements button enable
		boolean elementclickable=CompassUIElements.checkButtonEnable(to)
		if(elementclickable==true)
		{
			//call CustomUIElements button click
			CompassUIElements.clickButton(to)
		}
	}
	@Keyword
	public static void enterStartAndEndDate(TestObject tb,String str,String date){

		TestObject tbd = new General().createObject(tb.findPropertyValue('xpath')+"//kendo-datepicker[@placeholder='"+str+"']//span[@role='button']/span")
		WebUI.click(tbd)
		WebUI.delay(2)
		CompassUIElements.selectDatePicker(date)
	}
	public static void checkCheckBoxes(String str){
		TestObject to=General.createObject("//accounts-planner[@class='accounts-planner ng-star-inserted']//div[6]/div["+str+"]/div/label[@class='k-checkbox-label']")
		WebUI.click(to)
		WebUI.delay(2)
	}
	@Keyword
	public static void enterCaseUnitText(String str,String text){
		WebUI.delay(2)
		TestObject to=General.createObject("//accounts-planner[@class='accounts-planner ng-star-inserted']//div[6]/div["+str+"]//kendo-numerictextbox//input[@role='spinbutton']")
		CompassUIElements.setText(to, text)
		WebUI.delay(2)
	}
	/*
	 * Clicks the Start and end date calendar icon
	 */
	@Keyword
	public static void clickOIBBCaseStartAndEndDateBtn(String str,String row){
		TestObject to=General.createObject("//accounts-planner[@class='accounts-planner ng-star-inserted']//div[@class='padding-section']/div[6]/div["+str+"]/span/kendo-datepicker["+row+"]//span[@role='button']/span")
		WebUI.click(to)
		WebUI.delay(2)

	}

	@Keyword
	public static void clickCreationEventSaveBtn(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/btn_eventcreation_save'))
		CompassUIElements.waitCompassLoad()
	}
	@Keyword
	public static void verifyEventPPGCreationInfo(TestObject to,String str){
		String txt=WebUI.getText(to)
		if(txt.contains(str)){
			println "text is equal"
		}else{
			KeywordUtil.markFailed("Text do not match; expected is "+txt);
		}

	}
	/*@login into Account planner
	 * Click BasePlanning 
	 * verify All tab colors
	 * get the CSS value
	 * convert RGB value to Hex value
	 * Verify the Actual value and expected value
	 */
	@Keyword
	public static void verifyColorInColumn(String Expected,String row,String row1){
		WebDriver driver = DriverFactory.getWebDriver()
		String value = driver.findElement(By.xpath("//div[@id='k-tabstrip-tabpanel-"+row1+"']/div/div[1]/div[2]/div/div["+row+"]/div[1]")).getCssValue("background-color");
		println "button color of RGB " + value;
		String hex = Color.fromString(value).asHex().toUpperCase();
		println "Converted color is "+ hex ;
		String actual=hex;
		println "Expected color is equal to actual colors "+Expected + "=" + actual
		Assert.assertEquals(Expected,actual);

	}
	@Keyword
	public static void verifyWeeksColorInColumn(String quarter,String month,String row,String column){
		WebDriver driver=DriverFactory.getWebDriver()
		String to=driver.findElement(By.xpath("//div[@id='k-tabstrip-tabpanel-1']/div/div[2]/div[1]"))
		//WebElement tbl=driver.findElement(By.xpath(to +"//div["+quarter+"]/div["+month+"]/div["+row+"]"));
		//List<WebElement> rows=tbl.findElements(By.xpath(tbl));
		List<WebElement> rows=driver.findElements(By.xpath(to+"//div["+quarter+"]/div["+month+"]//div["+row+"]"))
		String Count=rows.size();
		println"count is +++++++"+Count
		for(int i=1;i<=rows.size();i++) {
			List<WebElement> columns=driver.findElements(By.xpath(rows+"//div["+column+"]"));
			System.out.println("Number of columns:"+columns.size());
			for(int j=1;j<=columns.size();j++){
				System.out.println(columns.get(j).getText());
			}
		}
	}
	/*@verify the 4 color columns at a time by using the GlobalVariable
	 *
	 */
	@Keyword
	public static void verifyTabBackgroundColorOfBasePlanning(){
		accountPlannerPBISFTabs(GlobalVariable.accountPlanner_BasePlanning,"2")
		verifyColorInColumn(GlobalVariable.baseplanning_consumption_purple,"1","1")
		println "*****consumption Purple color is Verified sucessfully*****"
		verifyColorInColumn(GlobalVariable.baseplanning_pricing_blue,"3","1")
		println "*****Pricing Blue color is Verified sucessfully*****"
		verifyColorInColumn(GlobalVariable.baseplanning_distribution_green,"2","1")
		println "****Distribution Green color is Verified sucessfully****"
		verifyColorInColumn(GlobalVariable.baseplanning_velocity_red,"4","1")
		println "*****Velocity Red color is Verified sucessfully******"
	}
	@Keyword
	public static void verifyTabBackgroundColorOfIncPlanning(){
		accountPlannerPBISFTabs(GlobalVariable.accountPlanner_IncPlanning,"3")
		println "IncPlanning Tab is Clicked sucessfully " ;
		verifyColorInColumn(GlobalVariable.incplanning_consumption_purple,"1","2")
		println "consumption Purple color is Verified sucessfully" ;
		verifyColorInColumn(GlobalVariable.incplanning_merch_orange,"2","2")
		println "Merch orange  color is Verified sucessfully" ;
		verifyColorInColumn(GlobalVariable.incplanning_hilo_green,"3","2")
		println "Hilo green color is Verified sucessfully";
		verifyColorInColumn(GlobalVariable.incplanning_pricing_blue,"4","2")
		println " Pricing blue color is Verified sucessfully ";
	}
	@Keyword
	public static void verifyTabBackgroundColorOfShipment(){
		accountPlannerPBISFTabs(GlobalVariable.accountPlanner_Shipment,"4")
		println" Shipment Tab is clicked sucessfully " ;
		verifyColorInColumn(GlobalVariable.shipment_consumption_purple,"1","3")
		println "consumption Purple color is Verified sucessfully" ;
		verifyColorInColumn(GlobalVariable.shipment_shipment_brown,"2","3")
		println " Shipment Brown color is Verified sucessfully " ;
	}
	@Keyword
	public static void verifyTabBackgroundColorOfFinancials(){
		accountPlannerPBISFTabs(GlobalVariable.accountPlanner_Financials,"5")
		println "Financials Tab is Clicked Sucessfully " ;
		verifyColorInColumn(GlobalVariable.financials_khcfinancials_ink,"1","4")
		println "KHc Financials ink color is verified successfully " ;
		verifyColorInColumn(GlobalVariable.financials_customerfinancials_red,"2","4")
		println "Customer Financials Red color is verified sucessfully" ;
	}
	@Keyword
	public static void clickSavebutton(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/btn_save'))
	}
	@Keyword
	public static void btnclickEvents(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/ddb_events'))
	}
	@Keyword
	public static void clickEventsCreteButton(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/btn_events_create'))
	}
	@Keyword
	public static void clickCreateAndViewEventBtn(String str){
		TestObject to=General.createObject("//kendo-button-list[@class='ng-star-inserted']/ul/li["+str+"]")
		CompassUIElements.clickButton(to)
		CompassUIElements.waitCompassLoad()
	}


	@Keyword
	public static void eventsCreateAlert1(){
		WebDriver driver = DriverFactory.getWebDriver()
		if(driver.findElements(By.xpath("//kendo-dialog")).size()>=0){
			CompassUIElements.kendoDialogBoxHandler("True","Failed to load Kraft fiscal weeks !","Ok")
		}
	}
	/*@Keyword
	 public static void clickBaseplaningQMWbtn(TestData td,String rowNo){
	 Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
	 for(Map dataObj :dataMap.values()){
	 //CompassUIElements.clickButton(findTestObject("//div[@id='k-tabstrip-tabpanel-1']/div/div/div/div[@class='black v-column']/span[contains(text(),'"+data+"')]"))	
	 CompassUIElements.clickBasePlanningQMW(dataObj.get('TIME'))
	 }
	 }*/
	@Keyword
	public static void clickBaseplaningQuarter(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/btn_baseplanning_quarter'))
	}
	@Keyword
	public static void clickBaseplaningMonth(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/btn_baseplanning_month'))
	}
	@Keyword
	public static void clickBaseplaningWeek(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/btn_baseplanning_week'))
	}
	@Keyword
	public static void createEventName(String eventName){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/txt_events_create_eventname'))
		WebUI.delay(2)
		println 'createEventName is  '+eventName
		CompassUIElements.setText(findTestObject('Object Repository/Compass/AccountPlaner/txt_events_create_eventname'),eventName)
	}
	@Keyword
	public static void createEventID(String eventid){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/txt_event_id'))
		WebUI.delay(2)
		CompassUIElements.setText(findTestObject('Object Repository/Compass/AccountPlaner/txt_event_id'),eventid)
	}
	@Keyword
	public static void addContractorNumbers(String contractorNumbers){
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element= WebUiCommonHelper.findWebElement(findTestObject('Object Repository/Compass/AccountPlaner/txt_add_contractor_numbers'), 0)
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript(element);
		CompassUIElements.setText(findTestObject('Object Repository/Compass/AccountPlaner/txt_add_contractor_numbers'),contractorNumbers)
	}
	@Keyword
	public static void customer(String customer){
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/AccountPlaner/ddb_eventCrete_customer'),customer)
	}
	@Keyword
	public static void startAndEndDate(TestData td,String rowNo ){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			CompassUIElements.EnterDateInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/btn_start_datepicker'),
					dataObj.get('Row_No'), '', dataObj.get('Start_Date'))
			CompassUIElements.EnterDateInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/btn_event_end_datepicker'),
					dataObj.get('Row_No'), '', dataObj.get('End_Date'))

		}
	}
	@Keyword
	public static void Enddate(String endDate){
		WebUI.click(findTestObject('Object Repository/Compass/AccountPlaner/btn_event_end_datepicker'),endDate)
	}
	@Keyword
	public static void multiEventCreateDataInput(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			createEventName(dataObj.get('CREATE_EVENT_NAME'))
			WebUI.delay(2)
			customer(dataObj.get('CUSTOMER'))
			eventHeaderWhitespaceClick()
			//addContractorNumbers(dataObj.get('CONTRACTOR_NUMBERS'))
			//startdate(dataObj.get('START_DATE1'))
			//Enddate(dataObj.get('END_DATE1'))
		}
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
					dataObj.get('Row_No'), 'SRP',dataObj.get('Non_Promo_SRP'))

			CompassUIElements.EnterValueInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),
					dataObj.get('Row_No'), 'Ret Margin',dataObj.get('Retailer_Margin_(Base %)'))
			CompassUIElements.EnterValueInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),
					dataObj.get('Row_No'), 'NUC',dataObj.get('NUC'))
			WebUI.delay(2)
			CompassUIElements.SelectValueInTableCell(findTestObject('Object Repository/Compass/AccountPlaner/tbl_product_costing'),
					dataObj.get('Row_No'), 'Spend Method',dataObj.get('Spend_Method'))
			WebUI.delay(2)
			//CompassUIElements.clickButton('Object Repository/Compass/AccountPlaner/btn_prod_wwdata');

			//CompassUIElements.kendoDialogBoxHandler('true','One of the following conditions are not met','OK')
		}
	}
	@Keyword
	public static void AccountPlannerKendoDialogBox1(){
		CompassUIElements.kendoDialogBoxHandler("true","Do you want to save your Account Planner changes for UB5 36z Velveeta Loaf 12 15.30?","","","Yes")
	}
	@Keyword
	public static void AccountPlannerKendoDialogBox2(){

		CompassUIElements.kendoDialogBoxHandler("true","One of the following conditions are not","OK")
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
		//CompassUIElements.kendoGetText(findTestObject("//div[@class='row']/kendo-dropdownlist[1]/span[@role='listbox']/span[@class='k-input']"),PlanYearList)

		CompassUIElements.kendoGetText(findTestObject('Compass/AccountPlaner/txt_plan_year'), PlanYearList)
	}
	@Keyword
	public static void DataInCustomerPlanList(String CustomerPlanList ){
		/*CompassUIElements.kendoGetText(findTestObject("//compass-plan-selection-header-component//div[2]//span[2]/kendo-dropdownlist/span[@role='listbox']/span[@class='k-input'and text()='2019 ALBERTSONS / Recipe Grated n Cul']"),CustomerPlanList)*/
		CompassUIElements.kendoGetText(findTestObject('Object Repository/Compass/AccountPlaner/txt_customerplan'),CustomerPlanList)
	}
	@Keyword
	public static void DataInCategoryList(String CategoryList){
		/*CompassUIElements.kendoGetText(("//compass-plan-selection-header-component//div[2]//span[3]/kendo-dropdownlist/span[@role='listbox']/span[@class='k-input'and text()='Recipe Cheese']"), CategoryList)*/
		CompassUIElements.kendoGetText(findTestObject('Object Repository/Compass/AccountPlaner/txt_category'),CategoryList)
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
	public static void setViewName(String s){
		WebDriver driver = DriverFactory.getWebDriver()
		//call CustomUIElements setText menthod
		TestObject to=General.createObject("//input[@placeholder='View Name']")
		WebUI.delay(5)
		//WebUI.mouseOver(to)

		CompassUIElements.setText(to,s)

	}

	//click on save button
	@Keyword
	public static void clickSavebtn(){

		TestObject to=General.createObject("//div[@class='col-md-12 form-group']/div/div/button[contains(text(),'Save')]")

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
		TestObject to=General.createObject("//accounts-planner[@class='accounts-planner ng-star-inserted']//div[@class='col-md-12 form-group']/div/button[@type='button']")
		WebUI.click(to)
	}
	//select view from list box
	@Keyword
	public static void selectView(String view)
	{
		CompassUIElements.selectListBox(findTestObject("Object Repository/Compass/AccountPlaner/ddb_viewlist"),view)

	}
	@Keyword
	public static void clickWWDataButton(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/btn_prod_wwdata'))
	}

	//click version button
	@Keyword
	public static void clickVersion(){
		CompassUIElements.clickButton(findTestObject("Object Repository/Compass/AccountPlaner/btn_versions"))
	}
	@Keyword
	public static void setVersionName(String vName){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/AccountPlaner/txt_versionName'))
		WebUI.delay(2)
		CompassUIElements.setText(findTestObject('Object Repository/Compass/AccountPlaner/txt_versionName'),vName)
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
		CompassUIElements.kendoGetText(findTestObject('Object Repository/Compass/AccountPlaner/txt_verify_versionname'),version)
		/*	TestObject to=General.createObject("//accounts-planner[@class='accounts-planner ng-star-inserted']//div[@class='col-md-12 form-group']/div/kendo-dropdownlist[2]/span[@role='listbox']//span[@class='k-i-arrow-s k-icon'][contains(text(),'"+version+"')]")
		 WebUI.verifyElementVisible(to)*/
	}

	@Keyword
	public static void updateConsumptionCellValue(String colName,int row,String value){
		actionBasePlanCellValue("consumption",colName,row,"enter",value);
	}

	@Keyword
	public static void updateDistributionCellValue(String colName,int row,String value){
		actionBasePlanCellValue("distribution",colName,row,"enter",value);
	}

	@Keyword
	public static void updateVelocityCellValue(String colName,int row,String value){
		actionBasePlanCellValue("velocity",colName,row,"enter",value);
	}

	@Keyword
	public static String getConsumptionCellValue(String colName,int row){
		actionBasePlanCellValue("consumption",colName,row,"get","");
	}

	@Keyword
	public static String getDistributionCellValue(String colName,int row){
		actionBasePlanCellValue("distribution",colName,row,"get","");
	}

	@Keyword
	public static String getVelocityCellValue(String colName,int row){
		actionBasePlanCellValue("velocity",colName,row,"get","");
	}

	@Keyword
	public static String getConsumptionCellTotal(String colName){
		actionBasePlanCellValue("consumption",colName,0,"get","");
	}

	@Keyword
	public static String getDistributionCellTotal(String colName){
		actionBasePlanCellValue("distribution",colName,0,"get","");
	}

	@Keyword
	public static String getVelocityCellTotal(String colName){
		actionBasePlanCellValue("velocity",colName,0,"get","");
	}
	@Keyword
	public static void toggleQMW(String toggleBy){
		if(toggleBy.equalsIgnoreCase("M")){
			if(CompassUIElements.isElementPresent(findTestObject('Object Repository/Compass/AccountPlaner/btn_baseplanning_month'), 2))
				WebUI.click(findTestObject('Object Repository/Compass/AccountPlaner/btn_baseplanning_month'))
		}
		else if(toggleBy.equalsIgnoreCase("Q")){
			if(CompassUIElements.isElementPresent(findTestObject('Object Repository/Compass/AccountPlaner/btn_baseplanning_quarter'), 2))
				WebUI.click(findTestObject('Object Repository/Compass/AccountPlaner/btn_baseplanning_quarter'))
		}
		else if(toggleBy.equalsIgnoreCase("W")){
			if(CompassUIElements.isElementPresent(findTestObject('Object Repository/Compass/AccountPlaner/btn_baseplanning_week'), 2))
				WebUI.click(findTestObject('Object Repository/Compass/AccountPlaner/btn_baseplanning_week'))
		}
	}
	@Keyword
	public static void accountPlannerPBISFTabs(String Tabs,String Row){
		if(Tabs.equalsIgnoreCase("Product Costing")){
			TestObject itemObj = General.createObject("//kendo-tabstrip/ul[@role='tablist']/li["+Row+"]/span[@class='k-link']")
			CompassUIElements.clickButton(itemObj)
			/*if(CompassUIElements.isElementPresent(findTestObject('Object Repository/Compass/AccountPlaner/accountPlanner_PBISF_tabs'), 2))
			 WebUI.click(findTestObject('Object Repository/Compass/AccountPlaner/accountPlanner_PBISF_tabs'))*/
		}
		else if(Tabs.equalsIgnoreCase("Base Planning")){
			TestObject itemObj = General.createObject("//kendo-tabstrip/ul[@role='tablist']/li["+Row+"]/span[@class='k-link']")
			CompassUIElements.clickButton(itemObj)
		}
		else if(Tabs.equalsIgnoreCase("Inc Planning")){
			TestObject itemObj = General.createObject("//kendo-tabstrip/ul[@role='tablist']/li["+Row+"]/span[@class='k-link']")
			CompassUIElements.clickButton(itemObj)
		}
		else if(Tabs.equalsIgnoreCase("Shipment")){
			TestObject itemObj = General.createObject("//kendo-tabstrip/ul[@role='tablist']/li["+Row+"]/span[@class='k-link']")
			CompassUIElements.clickButton(itemObj)
		}
		else if(Tabs.equalsIgnoreCase("Financials")){
			TestObject itemObj = General.createObject("//kendo-tabstrip/ul[@role='tablist']/li["+Row+"]/span[@class='k-link']")
			CompassUIElements.clickButton(itemObj)
		}

	}
	@Keyword
	public static void verifyConsumptionCellValue(String colName,int row,String expValue){
		WebUI.verifyMatch(expValue, actionBasePlanCellValue("consumption",colName,row,"get",""), false, FailureHandling.STOP_ON_FAILURE);
	}

	@Keyword
	public static void verifyDistributionCellValue(String colName,int row,String expValue){
		WebUI.verifyMatch(expValue, actionBasePlanCellValue("consumption",colName,row,"get",""), false, FailureHandling.STOP_ON_FAILURE);
	}

	@Keyword
	public static void verifyVelocityCellValue(String colName,int row,String expValue){
		WebUI.verifyMatch(expValue, actionBasePlanCellValue("consumption",colName,row,"get",""), false, FailureHandling.STOP_ON_FAILURE);
	}
	public static String actionBasePlanCellValue(String tableName,String colName,int row,String action,String value){
		cookConsumptionTableObjects(tableName);
		int com = (int) Math.ceil(row / 13)
		int quo = (int) Math.floor(row % 13)
		int cell = 0;
		int row1;
		if(quo == 0){
			row1 = 3;
			cell = 4;
		}
		else if(quo <= 5){
			row1 = 1;
			cell = quo;
		}
		else if(quo <= 9){
			row1 = 2;
			cell = quo - 5;
		}
		else{
			row1 = 3;
			cell = quo - 9;
		}
		String cellDiv;
		if(tableName.toLowerCase().contains("consumption")){
			cellDiv = baseDataDiv + "/div["+com+"]/div["+row1+"]/div["+cell+"]/div["+consumptionDataCols.get(colName)+"]"
			baseTotalsDiv = baseDiv + "/div[3]/div["+consumptionAllCols.get(colName)+"]"
		}
		else if(tableName.toLowerCase().contains("distribution")){
			cellDiv = baseDataDiv + "/div["+com+"]/div["+row1+"]/div["+cell+"]/div["+distriDataCols.get(colName)+"]"
			baseTotalsDiv = baseDiv + "/div[3]/div["+distriAllCols.get(colName)+"]"
		}
		else if(tableName.toLowerCase().contains("velocity")){
			cellDiv = baseDataDiv + "/div["+com+"]/div["+row1+"]/div["+cell+"]/div["+velDataCols.get(colName)+"]"
			baseTotalsDiv = baseDiv + "/div[3]/div["+velAllCols.get(colName)+"]"
		}
		//String cellDiv = baseDataDiv + "/div["+com+"]/div["+row+"]/div["+cell+"]/div["+allCols.get(colName)+"]//input"
		println cellDiv

		if(action.equalsIgnoreCase("enter")){
			TestObject cellInputObj = General.createObject(cellDiv+"\\input");
			boolean isDisabled = CompassUIElements.isElementAttributeExists(cellInputObj, "disabled", 2);
			if(!isDisabled){
				WebUI.setText(cellInputObj, value);
			}
			return "true"
		}
		else if(action.equalsIgnoreCase("get")){
			if(row != 0)
				return CompassUIElements.executeJavaScript(General.createObject(cellDiv), 'return arguments[0].innerText;');
			else
				return CompassUIElements.executeJavaScript(General.createObject(baseTotalsDiv), 'return arguments[0].innerText;');
		}
	}

	public static void cookConsumptionTableObjects(String tableName){
		if(tableName.toLowerCase().contains("consumption"))
			iTable = 1;
		else if(tableName.toLowerCase().contains("distribution"))
			iTable = 2;
		else if(tableName.toLowerCase().contains("velocity"))
			iTable = 3;

		baseDiv = "//div[@id='k-tabstrip-tabpanel-1']/div/div[1]//div[@class='scrollable-bpl']/div["+iTable+"]";
		baseDataDiv = "//div[@id='k-tabstrip-tabpanel-1']/div/div[3]/div[@class='scrollable-bpl']/div["+iTable+"]";
		String headDiv = baseDiv + "/div[1]";
		String baseColDiv = baseDiv + "/div[2]";
		if((consumptionAllCols == null) && (tableName.toLowerCase().contains("consumption")))
			getConsumptionTableHeads(baseColDiv,"consumption");
		else if((distriAllCols == null) && (tableName.toLowerCase().contains("distribution")))
			getConsumptionTableHeads(baseColDiv,"distribution");
		else if((velAllCols == null) && (tableName.toLowerCase().contains("velocity")))
			getConsumptionTableHeads(baseColDiv,"velocity");
		println("End");
	}
	public static HashMap getConsumptionTableHeads(String colDiv,String strSection){
		//get all child div objects of the colDiv
		//get the span value and put in a hash map "col name","iterator"
		//TestObject colDivObj = General.
		HashMap colMap = new HashMap();
		HashMap colDataMap = new HashMap();
		TestObject colObj,colSpanObj;
		String colString = "Test";
		String colSpanObjString,textVal;
		int i=1,k=1,m=1;

		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element;
		JavascriptExecutor executor;
		executor = ((driver) as JavascriptExecutor)
		while(colString != ""){
			colString = colDiv + "/div["+i+"]";
			colObj = General.createObject(colString);
			println colString;
			boolean isPresent = CompassUIElements.isElementPresent(colObj,5)
			boolean isVisible = CompassUIElements.checkElementVisible(colObj,5)
			if(!isPresent)
				colString = "";
			else{
				colSpanObjString = colString + "/span";
				colSpanObj = General.createObject(colSpanObjString);
				textVal = executor.executeScript('return arguments[0].innerText;', WebUiCommonHelper.findWebElement(colSpanObj, 2)).toString()
				colMap.put(textVal, k)

				if(isVisible)
				{
					colDataMap.put(textVal,m);
					m++;
				}
				k++;
			}
			i++;
		}
		if(strSection.toLowerCase().contains("consumption")){
			consumptionAllCols = colMap;
			consumptionDataCols = colDataMap
		}
		else if(strSection.toLowerCase().contains("distribution")){
			distriAllCols = colMap;
			distriDataCols = colDataMap;
		}
		else if(strSection.toLowerCase().contains("velocity")){
			velAllCols = colMap;
			velDataCols = colDataMap;
		}
	}
}

