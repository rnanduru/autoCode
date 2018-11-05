
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testdata.TestData

import com.kms.katalon.core.testobject.TestObject


def static "CompassUIElements.countAllCheckboxes"(
    	String to	) {
    (new CompassUIElements()).countAllCheckboxes(
        	to)
}

def static "CompassUIElements.checkAllCheckboxes"(
    	int size	) {
    (new CompassUIElements()).checkAllCheckboxes(
        	size)
}

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

def static "AccountPlanner.selectHeaderItem"(
    	TestData td	
     , 	String rowNo	) {
    (new AccountPlanner()).selectHeaderItem(
        	td
         , 	rowNo)
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
    	TestData td	
     , 	String rowNo	) {
    (new AccountPlanner()).enterAccountPlannerHeader(
        	td
         , 	rowNo)
}

def static "AccountPlanner.enterAccountPlannerSubHeader"(
    	TestData td	
     , 	String rowNo	) {
    (new AccountPlanner()).enterAccountPlannerSubHeader(
        	td
         , 	rowNo)
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

def static "AccountPlanner.verifyDataInPlanYearList"(
    	String expValue	) {
    (new AccountPlanner()).verifyDataInPlanYearList(
        	expValue)
}

def static "AccountPlanner.verifyDataInCustomerPlanList"(
    	String expValue	) {
    (new AccountPlanner()).verifyDataInCustomerPlanList(
        	expValue)
}

def static "AccountPlanner.verifyDataInCategoryList"(
    	String expValue	) {
    (new AccountPlanner()).verifyDataInCategoryList(
        	expValue)
}

def static "AccountPlanner.VerifyDataInProductList"(
    	String expValue	) {
    (new AccountPlanner()).VerifyDataInProductList(
        	expValue)
}

def static "AccountPlanner.verifyHeaderListItemsData"(
    	TestData td	
     , 	String rowNo	) {
    (new AccountPlanner()).verifyHeaderListItemsData(
        	td
         , 	rowNo)
}

def static "AccountPlanner.getAllCheckboxes"() {
    (new AccountPlanner()).getAllCheckboxes()

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

def static "CompassUIElements.kendoMultiSelectList"(
    	TestObject to	
     , 	String item	) {
    (new CompassUIElements()).kendoMultiSelectList(
        	to
         , 	item)
}

def static "CompassUIElements.kendoDeleteMultiSelectItem"(
    	String item	) {
    (new CompassUIElements()).kendoDeleteMultiSelectItem(
        	item)
}

def static "CompassUIElements.kendoChartWidgetClose"(
    	String chartDisplayName	) {
    (new CompassUIElements()).kendoChartWidgetClose(
        	chartDisplayName)
}

def static "CompassUIElements.kendoVerifyChartVisible"(
    	String chartName	) {
    (new CompassUIElements()).kendoVerifyChartVisible(
        	chartName)
}

def static "CompassUIElements.verifyElementData"(
    	TestObject to	
     , 	String value	) {
    (new CompassUIElements()).verifyElementData(
        	to
         , 	value)
}

def static "CompassUIElements.checkElementVisible"(
    	TestObject to	
     , 	int timeOut	) {
    (new CompassUIElements()).checkElementVisible(
        	to
         , 	timeOut)
}

def static "CompassUIElements.kendoGridSelectCheckBox"(
    	TestObject tblObj	
     , 	String rowNo	
     , 	int column	) {
    (new CompassUIElements()).kendoGridSelectCheckBox(
        	tblObj
         , 	rowNo
         , 	column)
}

def static "CompassUIElements.kendoGridEnterTextInCell"(
    	String rowNo	
     , 	int column	
     , 	String data	) {
    (new CompassUIElements()).kendoGridEnterTextInCell(
        	rowNo
         , 	column
         , 	data)
}

def static "CompassUIElements.kendoGridGetTextInCell"(
    	String rowNo	
     , 	int column	) {
    (new CompassUIElements()).kendoGridGetTextInCell(
        	rowNo
         , 	column)
}

def static "CompassUIElements.kendoDialogBoxHandler"(
    	String idDisplayed	
     , 	String verifyText	
     , 	String buttonToClick	) {
    (new CompassUIElements()).kendoDialogBoxHandler(
        	idDisplayed
         , 	verifyText
         , 	buttonToClick)
}

def static "HamburgMenu.clickHamburgMenu"(
    	String menuItem	) {
    (new HamburgMenu()).clickHamburgMenu(
        	menuItem)
}

def static "General.openAppURLRobo"(
    	String url	) {
    (new General()).openAppURLRobo(
        	url)
}

def static "AccountPlanner.clickCreateViewbtn"() {
    (new AccountPlanner()).clickCreateViewbtn()
}

def static "AccountPlanner.clickClosebtn"() {
    (new AccountPlanner()).clickClosebtn()
}

def static "AccountPlanner.setViewName"() {
    (new AccountPlanner()).setViewName()
}

def static "AccountPlanner.clickSavebtn"() {
    (new AccountPlanner()).clickSavebtn()
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

def static "Dashboard.btnClickAddSections"() {
    (new Dashboard()).btnClickAddSections()
}

def static "Dashboard.ddbClickAddSections"(
    	String AddSections	) {
    (new Dashboard()).ddbClickAddSections(
        	AddSections)
}

def static "Dashboard.btnClickDashboardHeader"() {
    (new Dashboard()).btnClickDashboardHeader()
}

def static "Dashboard.toggleAddSelections"(
    	boolean display	) {
    (new Dashboard()).toggleAddSelections(
        	display)
}

def static "Dashboard.selectHeaderItem"(
    	TestData td	
     , 	String rowNo	) {
    (new Dashboard()).selectHeaderItem(
        	td
         , 	rowNo)
}

def static "Dashboard.selectAddSectionsItem"(
    	TestData td	
     , 	String rowNo	) {
    (new Dashboard()).selectAddSectionsItem(
        	td
         , 	rowNo)
}

def static "Dashboard.selectAddSectionsItem"(
    	String item	) {
    (new Dashboard()).selectAddSectionsItem(
        	item)
}

def static "Dashboard.deleteAddSectionsItem"(
    	TestData td	
     , 	String rowNo	) {
    (new Dashboard()).deleteAddSectionsItem(
        	td
         , 	rowNo)
}

def static "Dashboard.deleteAddSectionsItem"(
    	Object item	) {
    (new Dashboard()).deleteAddSectionsItem(
        	item)
}

def static "Dashboard.verifyChartsExist"(
    	TestData td	
     , 	String rowNo	) {
    (new Dashboard()).verifyChartsExist(
        	td
         , 	rowNo)
}

def static "Dashboard.verifyChartsEventExist"(
    	TestData td	
     , 	String rowNo	) {
    (new Dashboard()).verifyChartsEventExist(
        	td
         , 	rowNo)
}

def static "Dashboard.verifyDashboardHeaderElement"() {
    (new Dashboard()).verifyDashboardHeaderElement()
}

def static "Dashboard.closeSelectionChart"(
    	String chartName	) {
    (new Dashboard()).closeSelectionChart(
        	chartName)
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

<<<<<<< HEAD
def static "CustomerSettings.clickDeleteBtn"() {
    (new CustomerSettings()).clickDeleteBtn()
}

def static "CustomerSettings.clickAddPPGBtn"() {
    (new CustomerSettings()).clickAddPPGBtn()
}

def static "CustomerSettings.clickGroupBtn"() {
    (new CustomerSettings()).clickGroupBtn()
}

def static "CustomerSettings.saveBtn"() {
    (new CustomerSettings()).saveBtn()
}

def static "CustomerSettings.selectItem"(
    	int i	) {
    (new CustomerSettings()).selectItem(
        	i)
}

def static "CustomerSettings.selectPPG"() {
    (new CustomerSettings()).selectPPG()
}

def static "CustomerSettings.selectItemsFromList"(
    	String data	) {
    (new CustomerSettings()).selectItemsFromList(
        	data)
}

def static "CustomerSettings.selectItemsfromExcel"(
    	TestData td	
     , 	String rowNo	) {
    (new CustomerSettings()).selectItemsfromExcel(

def static "CustomerSettings.removeAllPPGAndGroups"() {
    (new CustomerSettings()).removeAllPPGAndGroups()
}

def static "CustomerSettings.selectPPGs"(
    	TestData td	
     , 	String rowNo	) {
    (new CustomerSettings()).selectPPGs(

        	td
         , 	rowNo)
}


def static "CustomerSettings.clickOnPopUp"(
    	String titlename	) {
    (new CustomerSettings()).clickOnPopUp(
        	titlename)
}

def static "CustomerSettings.selectPopUpDelete"(
    	TestData td	
     , 	String rowNo	) {
    (new CustomerSettings()).selectPopUpDelete(
        	td
         , 	rowNo)
}

def static "CustomerSettings.selectPopUpOk"(
    	TestData td	
     , 	String rowNo	) {
    (new CustomerSettings()).selectPopUpOk(
        	td
         , 	rowNo)

def static "CustomerSettings.selectPPGs"(
    	String item	) {
    (new CustomerSettings()).selectPPGs(
        	item)
}

def static "CustomerSettings.clickAddPPGButton"(
    	String item	) {
    (new CustomerSettings()).clickAddPPGButton(
        	item)

}
