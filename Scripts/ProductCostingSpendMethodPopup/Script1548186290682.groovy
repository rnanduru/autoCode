import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/*35.Able to choose an appropriate spend method, and (for WW / Case) have the WW Data button + popup page appear for WW Volume input
*/
CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.menu_accounts_planner)

CustomKeywords.'AccountPlanner.clickProductCost'()

CustomKeywords.'AccountPlanner.productCostingTable'(findTestData('AccountPlanner1'), '1')

not_run: CustomKeywords.'CompassUIElements.kendoDialogBoxHandler'('true', '', 'OK')

CustomKeywords.'AccountPlanner.clickWWDataButton'()

CustomKeywords.'CompassUIElements.WherehouseWithdrawlSetText'(General.getRandomnum(5, 99))

CustomKeywords.'CompassUIElements.kendoDialogBoxHandler'('true', '', 'OK')

