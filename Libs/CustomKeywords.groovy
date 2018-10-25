
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject

import com.kms.katalon.core.testdata.TestData


def static "AccountPlanner.selectPlanYear"(
    	String plan_year	) {
    (new AccountPlanner()).selectPlanYear(
        	plan_year)
}

def static "AccountPlanner.selectCustomerPlan"(
    	String plan	) {
    (new AccountPlanner()).selectCustomerPlan(
        	plan)
}

def static "AccountPlanner.selectCategory"(
    	String category	) {
    (new AccountPlanner()).selectCategory(
        	category)
}

def static "AccountPlanner.selectPPG"(
    	String ppg	) {
    (new AccountPlanner()).selectPPG(
        	ppg)
}

def static "AccountPlanner.selectUnits"(
    	String unit	) {
    (new AccountPlanner()).selectUnits(
        	unit)
}

def static "AccountPlanner.enterProductCostingData"() {
    (new AccountPlanner()).enterProductCostingData()
}

def static "AccountPlanner.clickAddNewBtn"() {
    (new AccountPlanner()).clickAddNewBtn()
}

def static "AccountPlanner.clickApplyEDLPBtn"() {
    (new AccountPlanner()).clickApplyEDLPBtn()
}

def static "AccountPlanner.clickColumnBtn"() {
    (new AccountPlanner()).clickColumnBtn()
}

def static "AccountPlanner.enterAccountPlannerHeader"(
    	String planYear	
     , 	String custPlan	
     , 	String category	) {
    (new AccountPlanner()).enterAccountPlannerHeader(
        	planYear
         , 	custPlan
         , 	category)
}

def static "AccountPlanner.enterAccountPlannerHeader"(
    	String planYear	
     , 	String custPlan	
     , 	String category	
     , 	String newString	) {
    (new AccountPlanner()).enterAccountPlannerHeader(
        	planYear
         , 	custPlan
         , 	category
         , 	newString)
}

def static "CompassUIElements.selectListBox"(
    	TestObject to	
     , 	String data	) {
    (new CompassUIElements()).selectListBox(
        	to
         , 	data)
}

def static "CompassUIElements.waitCompassLoad"() {
    (new CompassUIElements()).waitCompassLoad()
}

def static "CompassUIElements.clickButton"(
    	TestObject to	) {
    (new CompassUIElements()).clickButton(
        	to)
}

def static "CompassUIElements.selectMultiList"() {
    (new CompassUIElements()).selectMultiList()
}

def static "CompassUIElements.clickButtonItem"(
    	TestObject to	
     , 	String buttonItem	) {
    (new CompassUIElements()).clickButtonItem(
        	to
         , 	buttonItem)
}

def static "HamburgMenu.clickHamburgMenu"(
    	String menuItem	) {
    (new HamburgMenu()).clickHamburgMenu(
        	menuItem)
}

def static "Dashboard.verifyDashboardElements"(
    	TestObject to	) {
    (new Dashboard()).verifyDashboardElements(
        	to)
}

def static "Dashboard.selectPlanYear"(
    	String plan_year	) {
    (new Dashboard()).selectPlanYear(
        	plan_year)
}

def static "Dashboard.selectCustomerPlan"(
    	String plan	) {
    (new Dashboard()).selectCustomerPlan(
        	plan)
}

def static "Dashboard.selectCategory"(
    	String category	) {
    (new Dashboard()).selectCategory(
        	category)
}

def static "Dashboard.selectHeaderItem"(
    	TestData td	
     , 	String rowNo	) {
    (new Dashboard()).selectHeaderItem(
        	td
         , 	rowNo)
}

def static "Dashboard.verifyDashboardHeaderElement"() {
    (new Dashboard()).verifyDashboardHeaderElement()
}

def static "General.openAppURLRobo"(
    	String url	) {
    (new General()).openAppURLRobo(
        	url)
}

def static "General.openAppURL"(
    	String url	) {
    (new General()).openAppURL(
        	url)
}

def static "General.robotEnterString"(
    	String data	) {
    (new General()).robotEnterString(
        	data)
}

def static "General.createObject"(
    	Object xPath	) {
    (new General()).createObject(
        	xPath)
}

def static "General.loadData"(
    	TestData td	
     , 	String dataId	) {
    (new General()).loadData(
        	td
         , 	dataId)
}

def static "General.GetValue"(
    	String data1	) {
    (new General()).GetValue(
        	data1)
}

def static "General.SetValue"(
    	String variable	
     , 	String value	) {
    (new General()).SetValue(
        	variable
         , 	value)
}

def static "RobotX.RoboKeyPress"(
    	String data	) {
    (new RobotX()).RoboKeyPress(
        	data)
}

def static "RobotX.RoboKeyPressSpecial"(
    	String data	) {
    (new RobotX()).RoboKeyPressSpecial(
        	data)
}

def static "Login.loginCompass"(
    	String username	
     , 	String password	) {
    (new Login()).loginCompass(
        	username
         , 	password)
}

def static "Login.verifyLoginCompassObjects"() {
    (new Login()).verifyLoginCompassObjects()
}

def static "Wait.waitCompassLoad"(
    	String data	) {
    (new Wait()).waitCompassLoad(
        	data)
}
