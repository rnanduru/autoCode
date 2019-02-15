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

/*5.Able to select a PPG(s) not yet added to a PPG Group, via the checkbox column (far left), click on PPG Group and add that PPG(s) to either a current group (drop down) or to a new group (provide a name)
*/
CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.menu_customer_settings)

CustomKeywords.'CustomerSettings.clickPPGActivationCheckboxes'()

CustomKeywords.'CustomerSettings.addToGroup'('new', 'Test_' + General.getRandomnum(5, 150))

CustomKeywords.'CompassUIElements.kendoDialogBoxHandler'('true', 'Trade events exist for this PPG / Group. PPG additions or deletions are no longer possible', 
    'ok')

