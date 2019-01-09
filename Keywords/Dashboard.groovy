import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.geom.GeneralPath

import org.apache.poi.ss.usermodel.Chart

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
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad

import internal.GlobalVariable
import common.*
public class Dashboard {
	@Keyword
	public static void verifyDashboardElements(TestObject to){
	}
	@Keyword
	public static void selectPlanYear(String plan_year){
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/Dashboard/ddb1_plan_year'), plan_year)
	}
	@Keyword
	public static void selectCustomerPlan(String plan){
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/Dashboard/ddb_customer_plan'), plan)
	}
	@Keyword
	public static void selectCategory(String category){
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/Dashboard/ddb_category'), category)
	}
	@Keyword
	public static void selectCustomer(String customer){
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/Dashboard/ddb_customer_area_name'), customer)
	}
	@Keyword
	public static void btnClickAddSections(){
		CompassUIElements.clickButton(findTestObject('Object Repository/Compass/Dashboard/btn_add_sections'))
	}
	@Keyword
	public static void ddbClickAddSections(String AddSections){
		CompassUIElements.clickButton(findTestObject('Compass/Dashboard/ddb_add_sections'),AddSections)
	}
	@Keyword
	public static void btnClickDashboardHeader(){
		CompassUIElements.clickButton(findTestObject('Compass/Dashboard/btn_dashboard_header'))
	}
	@Keyword
	public static void verifyPlanyear(String PlanYear){
		CompassUIElements.kendoGetText(findTestObject('Object Repository/Compass/Dashboard/ddb1_plan_year'),PlanYear)
	}
	@Keyword
	public static void verifyCustomerPlan(String CustomerPlan){
		CompassUIElements.kendoGetText(findTestObject('Object Repository/Compass/Dashboard/ddb_verify_customer_plan'), CustomerPlan)
	}
	@Keyword
	public static void verifyCategory(String Category){
		CompassUIElements.kendoGetText(findTestObject('Object Repository/Compass/Dashboard/ddb_verify_category'),Category)
	}
	@Keyword
	public static void toggleAddSelections(boolean display){
		if(display) {
			if(!CompassUIElements.checkElementVisible(findTestObject("Object Repository/Compass/Dashboard/ddb_add_sections"),display))
				btnClickAddSections()
		}
		else{
			if(CompassUIElements.checkElementVisible(findTestObject("Object Repository/Compass/Dashboard/ddb_add_sections"),display))
				btnClickAddSections()
		}
	}

	@Keyword
	/**
	 * 
	 * @param td
	 * @param rowNo
	 */
	public static void selectHeaderItem(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			selectPlanYear(dataObj.get('PLAN_YEAR'))
			selectCustomerPlan(dataObj.get('CUSTOMER_PLAN'))
			selectCategory(dataObj.get('CATEGORY'))
			//selectCustomer(dataObj.get('CUSTOMER'))
		}
	}
	@Keyword
	public static void selectAddSectionsItem(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			CompassUIElements.kendoMultiSelectList(findTestObject('Compass/Dashboard/ddb_add_sections'), dataObj.get('ADD_SECTIONS'))
			//selectAddSectionsItem(dataObj.get('ADD_SECTIONS'))
			
		}
	}
	@Keyword
	public static void selectAddSectionsItem(String item){
		CompassUIElements.kendoMultiSelectList(findTestObject('Compass/Dashboard/ddb_add_sections'),item)
	}
	@Keyword
	public static void deleteAddSectionsItem(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			CompassUIElements.kendoDeleteMultiSelectItem(dataObj.get('DELETE_SECTIONS'))
		}
	}
	@Keyword
	public static void deleteAddSectionsItem(item){
		CompassUIElements.kendoDeleteMultiSelectItem(item)
	}
	@Keyword
	public static void verifyChartsExist(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			CompassUIElements.kendoVerifyChartVisible(dataObj.get('CHART_LIST'))
		}
	}
	@Keyword
	public static void verifyDashboardHeaderElementData(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){
			verifyPlanyear(dataObj.get('Planyear'))
			verifyCustomerPlan(dataObj.get('CustomerPlan'))
			verifyCategory(dataObj.get('Category'))
		}
	}
	@Keyword
	public static void verifyChartsEventExist(TestData td,String rowNo){
		Map<Integer,Map<String,String>> dataMap = General.loadData(td, rowNo)
		for(Map dataObj :dataMap.values()){

			CompassUIElements.kendoVerifyChartVisible(dataObj.get('CHART_LIST'))
		}
	}


	@Keyword
	public static void verifyDashboardHeaderElement(){
		WebUI.verifyElementVisible(findTestObject('Object Repository/Compass/Dashboard/ddb_plan_year'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Compass/Dashboard/ddb_customer_plan'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Compass/Dashboard/ddb_category'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Compass/Dashboard/btn_dashboard_header'),FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Compass/Dashboard/btn_add_sections'),FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	public static void closeSelectionChart(String chartName){
		CompassUIElements.kendoChartWidgetClose(chartName)
		WebUI.refresh()
	}
}
