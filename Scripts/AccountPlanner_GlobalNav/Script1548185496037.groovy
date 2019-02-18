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

/*28.Global Nav: should preload with the current fiscal year (first drop down) and top selections (second and third drop downs); with only showing the 4th drop down if in Albertsons - and the selections should drive the content on the Account Planner page, all tabs.  It should also drive the PPG selections in the PPG drop down (next to Units/Cases drop down)
*/

CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.menu_accounts_planner)

CustomKeywords.'AccountPlanner.selectHeaderItem'(findTestData('AccountPlanner'), '1')

CustomKeywords.'AccountPlanner.verifyHeaderListItemsData'(findTestData('AccountPlanner'), '1')

CustomKeywords.'AccountPlanner.selectMiddleHeader'(findTestData('AccountPlanner'), '1')
