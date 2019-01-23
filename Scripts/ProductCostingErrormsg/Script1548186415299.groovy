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

/*36.Able to apply EDLP changes, or see appropriate popup message telling you to do one of 5 updates to your line item if EDLP has not been applied yet
*/
CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.menu_accounts_planner)

CustomKeywords.'AccountPlanner.clickProductCost'()

CustomKeywords.'AccountPlanner.clickAddNewBtn'()

CustomKeywords.'AccountPlanner.clickSavebutton'()

CustomKeywords.'CompassUIElements.kendoDialogBoxHandler'('true', 'One of the following conditions are not met', 'OK')

CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.menu_customer_settings)

CustomKeywords.'CompassUIElements.kendoDialogBoxHandler'('true', 'Do you want to save your Account Planner changes for 003 32z Velveeta Loaf 12 $96.12 ?', 
    'No')

CustomKeywords.'CompassUIElements.kendoDialogBoxHandler'('true', 'One of the following conditions are not met', 'ok')

