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

/*Versions button: should be able to conduct Save As function, Set to Active only when not on the Active Plan, Compare (taking you to Compare Plans page) and Manage remains inactive, for now
*/
CustomKeywords.'AccountPlanner.clickVersion'()

CustomKeywords.'AccountPlanner.selectButtonList'('Save As')

CustomKeywords.'CompassUIElements.kendoDialogBoxHandler'('true', '', 'Save')

String s = 'TestLoger_' + General.getRandomnum(11, 99)

CustomKeywords.'AccountPlanner.setVersionName'(s)

CustomKeywords.'CompassUIElements.kendoDialogBoxHandler'('true', 'Enter Account Planner Name', 'Save')

WebUI.delay(3)

CustomKeywords.'AccountPlanner.selectVersion'('VER_TESTLOGER_40')

CustomKeywords.'AccountPlanner.verifySelectedVersion'('VER_TESTLOGER_40')

CustomKeywords.'AccountPlanner.clickVersion'()

CustomKeywords.'AccountPlanner.selectButtonList'('Compare')

