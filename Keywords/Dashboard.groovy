import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.geom.GeneralPath

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

public class Dashboard {
	@Keyword
	def verifyDashboardElements(TestObject to){
	}
	@Keyword
	def selectPlanYear(String plan_year){
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/Dashboard/ddb_plan_year'), plan_year)
	}
	@Keyword
	def selectCustomerPlan(String plan){
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/Dashboard/ddb_customer_plan'), plan)
	}
	@Keyword
	def selectCategory(String category){
		CompassUIElements.selectListBox(findTestObject('Object Repository/Compass/Dashboard/ddb_category'), category)
	}
	@Keyword
	def selectHeaderItem(TestData td,String rowNo){
		Map dataMap = General.loadData(td, rowNo)
		for(Map dataObj:dataMap){
			selectPlanYear(dataObj.get('PLAN_YEAR'))
			selectCustomerPlan(dataObj.get('CUSTOMER_PLAN'))
			selectCategory(dataObj.get(''))
		}
	}
	@Keyword
	public static void verifyDashboardHeaderElement(){
		WebUI.verifyElementVisible(findTestObject('Object Repository/Compass/Dashboard/ddb_plan_year'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Compass/Dashboard/ddb_customer_plan'), FailureHandling.STOP_ON_FAILURE)
		WebUI.verifyElementVisible(findTestObject('Object Repository/Compass/Dashboard/ddb_category'), FailureHandling.STOP_ON_FAILURE)
	}
}
