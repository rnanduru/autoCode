import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import common.*
import internal.GlobalVariable

public class CustomerSettings {

	@Keyword
	public static void clickDeleteBtn() {
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomSettings/btn_delete'))
	}

	@Keyword
	public static void clickAddPPGBtn() {
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomerSettings/btn_add_ppg'))
	}
	@Keyword
	public static void clickGroupBtn() {
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomSettings/btn_group'))
	}
	@Keyword
	public static void saveBtn() {
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomSettings/btn_save'))
	}

	@Keyword
	public static void saveUPCBtn() {
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomerSettings/btn_upc_save'))
	}

	@Keyword
	public static void groupBtn(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomerSettings/btn_group'))
	}
	@Keyword
	public static void selectItem(int i){
		CompassUIElements.clickButton(findTestObject("//div/button[position()='"+i+"']"))
	}
	@Keyword
	public static void clickUPCActivationBtn(){
		CompassUIElements.clickButton(findTestObject('Compass/CustomerSettings/btn_upc_activation'))
	}
	@Keyword
	public static void addToGroup(String isNew,String grpName){
		CompassUIElements.waitCompassLoad();
		WebUI.click(findTestObject('Object Repository/Compass/CustomerSettings/btn_group'));
		if(isNew.equalsIgnoreCase("new"))
			WebUI.setText(findTestObject('Compass/CustomerSettings/txb_add_to_group_createNewGroup'), grpName)
		else
			CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/CustomerSettings/ddb_add_to_existing_grp'));

		WebUI.click(findTestObject('Object Repository/Compass/CustomerSettings/btn_save_add_to_group'))
		//TestObject to=General.createObject('Object Repository/Compass/CustomerSettings/Txt_createNewGroup')
		//WebUI.delay(2)
		//CompassUIElements.setText(to,"Kiwi")
	}
	@Keyword
	public static void createNewGroupname(){
		CustomKeywords.'General.createGroupName'('GroupName')
	}
	@Keyword
	public static void clickBtnOfselectPPG(){
		WebUI.click(findTestObject('Object Repository/Compass/CustomerSettings/btn1selectppg'))
		//CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomerSettings/btn1selectppg'))
	}
	@Keyword
	public static void clickBtnOfUPCSelectPPg(){
		WebUI.click(findTestObject('Object Repository/Compass/CustomerSettings/btn_upc_selectppgs'))
	}
	@Keyword
	public static void clickGroupWindow(){
		CompassUIElements.clickButton(findTestObject('Compass/CustomerSettings/txt_add_to_group_existing_group_header'))
		RobotX.RoboKeyPress('<tab>')
		RobotX.RoboKeyPress('<tab>')
	}
	@Keyword
	public static void selectItemsFromList(String data){
		TestObject to=General.createObject("Object Repository/Compass/CustomerSettings/input_select_ppg'")
		WebUI.click(to)
	}
	@Keyword
	public static void clickPPGActivationCheckboxes(){
		CompassUIElements.kendoGridSelectCheckBox(findTestObject('Object Repository/Compass/CustomerSettings/tbl_ppg_activation'),"all",1)
	}
	@Keyword
	public static void selectItemsfromExcel(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			selectItemsFromList(dataObj.get('PPG_NAME'))
		}
	}
	//handling popup
	@Keyword
	public static void clickOnPopUp(String titlename){
		General.createObject("//div/kendo-dialog-titlebar/div[text()='"+titlename+"']")

		println "obj :"+titlename
		if(titlename.equalsIgnoreCase("Please confirm"))
		{
			TestObject to=General.createObject("//div[text()='Are you sure?']/following-sibling::kendo-dialog-actions//button[contains(text(),'Yes')]")
			WebUI.click(to)
		}
		else if(titlename.equalsIgnoreCase("Info"))
		{
			TestObject to=General.createObject("//kendo-dialog-actions/button[contains(text(),'Ok')]")
			WebUI.click(to)
		}
	}
	@Keyword
	public static void ClickPPgBtn(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomerSettings/input_select_ppg'))
	}
	@Keyword
	public static void selectPopUpDelete(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			clickOnPopUp(dataObj.get("POPUP_DELETE"))
		}
	}

	@Keyword
	public static void selectPopUpOk(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			clickOnPopUp(dataObj.get("POPUP_INFO"))
		}
	}

	@Keyword
	public static void removeAllPPGAndGroups(){
		CompassUIElements.kendoGridSelectCheckBox(findTestObject('Object Repository/Compass/CustomerSettings/tbl_ppg_activation'), "all",'');
		CompassUIElements.clickButton(findTestObject("Object Repository/Compass/CustomerSettings/btn_delete"));
		CompassUIElements.kendoDialogBoxHandler("true","Are you Sure","","","OK");
	}
	@Keyword
	public static void removeOnePPGAndGroup(){
		CompassUIElements.kendoGridSelectCheckBox(findTestObject('Object Repository/Compass/CustomerSettings/tbl_ppg_activation'), "all", 1)
		CompassUIElements.clickButton(findTestObject("Object Repository/Compass/CustomerSettings/btn_delete"));
		CompassUIElements.kendoDialogBoxHandler("true","Are you Sure","OK");
	}
	@Keyword
	public static void setValuesInPPGActivationTable(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			CompassUIElements.kendoGridEnterTextBox(findTestObject('Object Repository/Compass/CustomerSettings/tbl_ppg_activation'),dataObj.get('GRID_ROW'), '5',dataObj.get('CUSTOMER_SEGMENT'))
			CompassUIElements.kendoGridSelectListBox(findTestObject('Object Repository/Compass/CustomerSettings/tbl_ppg_activation'),dataObj.get('GRID_ROW'),'10',dataObj.get('EDLP_SPEND_METHOD'))
			CompassUIElements.kendoGridEnterTextBox(findTestObject('Object Repository/Compass/CustomerSettings/tbl_ppg_activation'),dataObj.get('GRID_ROW'),'11',dataObj.get('Shp_Lead_WK'))
			CompassUIElements.kendoGridEnterTextBox(findTestObject('Object Repository/Compass/CustomerSettings/tbl_ppg_activation'),dataObj.get('GRID_ROW'), '15',dataObj.get('COMMENTS'))
		}
	}
	@Keyword
	public static void setValuesInUPCActivationTable(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			CompassUIElements.kendoGridEnterTextBox(findTestObject('Object Repository/Compass/CustomerSettings/tbl_upc_Activation'), dataObj.get('GRID_ROW'),'6',dataObj.get('Customer_Item_Desc'))
			CompassUIElements.kendoGridEnterTextBox(findTestObject('Object Repository/Compass/CustomerSettings/tbl_upc_Activation'), dataObj.get('GRID_ROW'),'7',dataObj.get('Customer_Item'))
			CompassUIElements.kendoGridEnterTextBox(findTestObject('Object Repository/Compass/CustomerSettings/tbl_upc_Activation'), dataObj.get('GRID_ROW'),'11',dataObj.get('COMMENTS'))
		}
	}
	@Keyword
	public static void clickUPCBtn(){
		CompassUIElements.clickButton(findTestObject("Object Repository/Compass/CustomerSettings/btn_upc_activation"))
	}
	@Keyword
	public static void clickAddUPCBtn(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomerSettings/btn_add_upc'))
	}
	@Keyword
	public static Map<String,String> getAllTableValuesInPPGActivationTable(TestObject to,String inColumn){

		WebDriver driver=DriverFactory.getWebDriver()
		//WebElement element=driver.findElements(By.xpath("//app-root//authorization-list//kendo-tabstrip/div[1]//kendo-grid//kendo-grid-list[@role='presentation']/div[@role='presentation']//table[@role='presentation']/tbody[@role='presentation']/tr[1]/td[2]"));
		def headers = to.findPropertyValue("xpath")+"//thead[@role='presentation']/tr[1]/th"
		to.addProperty("xpath", ConditionType.EQUALS, headers)
		List<WebElement> tableHeaders=WebUiCommonHelper.findWebElements(to, 0)
		Map<String,String> dataMap=new HashMap<String,String>();
		WebElement element;
		WebElement element1;
		WebElement rowData1;
		JavascriptExecutor executor;
		def column = ""
		def row=""
		TestObject to1;
		TestObject to2;
		boolean iFound = false;
		int iColHeader = 2;
		while(!iFound)
		{
			def headXpath=to.findPropertyValue("xpath")+"//thead[@role='presentation']/tr[1]/th["+iColHeader+"]/a[@href='#']";
			to1=to.addProperty("xpath", ConditionType.EQUALS, headXpath)
			element = WebUiCommonHelper.findWebElement(to1, 0)
			executor = ((driver) as JavascriptExecutor)
			column = executor.executeScript('return arguments[0].innerText;', element).toString()
			println "column data is......"+column
			if(column.trim().equalsIgnoreCase(inColumn))
				iFound = true;
			else
				iColHeader++;
		}

		def rows=to.findPropertyValue("xpath")+"//table[@role='presentation']/tbody[@role='presentation']/tr"
		to.addProperty("xpath", ConditionType.EQUALS, rows)
		List<WebElement> rowCount=WebUiCommonHelper.findWebElements(to, 30)
		def rowValue=""

		for(int j=1;j<=rowCount.size();j++){
			def rowData=to.findPropertyValue("xpath")+"//table[@role='presentation']/tbody[@role='presentation']/tr["+j+"]/td["+iColHeader+"]";
			to2=to.addProperty("xpath", ConditionType.EQUALS, rowData)
			element1 = WebUiCommonHelper.findWebElement(to2, 10)
			row=executor.executeScript('return arguments[0].innerText;', element1).toString()
			if(j==1)
				rowValue=row
			if(!rowValue.equalsIgnoreCase("")){
				rowValue=rowValue+GlobalVariable.multivalueseperator+row
			}

			println "row data is...."+ row
			println "column is.."+column+":   "+row
			dataMap.put(column.trim(), rowValue)
		}

		return dataMap;
		/*	WebUI.click(findTestObject('Object Repository/Compass/CustomerSettings/btn_KHCPPG_desending'))
		 ArrayList<String> sortedList = new ArrayList<>();
		 for(String s:obtainedList){
		 sortedList.add(s);
		 }
		 Collections.sort(sortedList);
		 Assert.assertTrue((sortedList.equals(obtainedList)))*/

		//CompassUIElements.KendoGridSortTableData(findTestObject('Object Repository/Compass/CustomerSettings/tbl_ppg_activation'),'2','Get','')
	}

	@Keyword
	public static void verifySorting(TestObject to){

		def headers = to.findPropertyValue("xpath")+"//thead[@role='presentation']/tr[1]/th"
		to.addProperty("xpath", ConditionType.EQUALS, headers)
		List<WebElement> tableHeaders=WebUiCommonHelper.findWebElements(to, 0)
		for(int i=0;i<tableHeaders.size();i++){

			Map<String, String> unSortedMap=getAllTableValuesInPPGActivationTable(to)

			tableHeaders.get(i).click()
			System.out.println("Unsorted Map : " + unSortedMap);

			//LinkedHashMap preserve the ordering of elements in which they are inserted
			/*LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
			 unSortedMap.entrySet(){
			 .stream()
			 .sorted(Map.Entry.comparingByValue())
			 .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
			 */
			//tableHeaders.get(i).click()
		}




	}

	@Keyword
	public static void clickOnPPGActivationTableColumn(String colName){

		WebUI.click(General.createObject("//app-root//authorization-list//kendo-tabstrip/div[1]//kendo-grid/div[@role='grid']/div/div[@role='presentation']//table[@role='presentation']//thead[@role='presentation']/tr[1]/th/a[@href='#' and text()='"+colName+"']"))

	}
	@Keyword
	public static void clickOnUPCActivationTableColumn1(String colName){
		WebUI.click(General.createObject("//app-root//authorization-list//kendo-tabstrip/div[2]//kendo-grid/div[@role='grid']/div/div[@role='presentation']//table[@role='presentation']//thead[@role='presentation']/tr[1]/th/a[@href='#' and text()='"+colName+"']"))

	}


	@Keyword
	public static void verifyValuesOrder(String columnName,String concString ,String strSeperator, String order){
		ArrayList<String> inString=new ArrayList<String>()
		inString=concString.split(strSeperator)
		ArrayList<String> inString2=new ArrayList<String>()
		inString2=inString
		if(order.equalsIgnoreCase("asc")){
			Collections.sort(inString2)
		}
		else{
			Collections.sort(inString2, Collections.reverseOrder());
		}
		if(!inString.equals(inString2)){
			KeywordUtil.markFailed("Column is not sorted "+columnName)
		}

	}
	@Keyword
	public static void selectPPgs(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			CompassUIElements.checkItemInMultiSelectBox(findTestObject('Object Repository/Compass/CustomerSettings/input_select_ppg'), dataObj.get("ADD_PPG"))
		}
	}

	@Keyword
	public static void selectUPCs(TestData td,String rowNo){

		Map<Integer,Map<String,String>> dataMap = General.loadData(td,rowNo)
		for(Map dataObj :dataMap.values()){
			CompassUIElements.checkItemInMultiSelectBox(findTestObject('Object Repository/Compass/CustomerSettings/input_select_upc'), dataObj.get("ADD_PPG"))
		}
	}
	@Keyword
	public static void whitespace(){
		WebUI.click(findTestObject('Object Repository/Compass/CustomerSettings/whitspace'))
	}
	@Keyword
	public static void selectPPG(String item){
		CompassUIElements.checkItemInMultiSelectBox(findTestObject('Object Repository/Compass/CustomerSettings/input_select_ppg'), item)
	}
	@Keyword
	public boolean clickSelectPPGTextBox(){
		//WebUI.click(findTestObject('Object Repository/Compass/CustomerSettings/input_select_ppg'))
		WebUI.clearText(findTestObject('Object Repository/Compass/CustomerSettings/input_select_ppg'),FailureHandling.CONTINUE_ON_FAILURE)
	}
	@Keyword
	public static void clearTextPPg(){
		WebUI.clearText(findTestObject('Object Repository/Compass/CustomerSettings/txb_selectPPg'))
	}
	@Keyword
	public static void clickAddPPGButton(String item){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomerSettings/btn_add_ppg'))
		//CompassUIElements.kendoDialogBoxHandler("true","1 PPG(s) has been added to the activation list","","","Ok");
	}

	@Keyword
	public static void clickAddUPCButton(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/CustomerSettings/btn_add_upc'))
	}

}

