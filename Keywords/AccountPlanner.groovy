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
}
