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

/*Able to select up to 4 plans to compare, based on the global nav / customer plan selected, 
 * and set / change the PPG, plans, fields to display (10 total) and time range for comparison analysis, 
 * and have the data points appear on the page in grid form (after clicking ‘Compare Plans’)
 */

CustomKeywords.'General.openAppURLRobo'(GlobalVariable.url)

CustomKeywords.'Login.loginCompass'(GlobalVariable.username, GlobalVariable.password)

CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.Compare_Plans)

CustomKeywords.'AccountPlanner.selectHeaderItem'(findTestData('AccountPlanner'), '2')

CustomKeywords.'ShipperMod.selectPPG'("0LL 10z Boca Burger 9ct \$22.68")

CustomKeywords.'ShipperMod.selectPlan'()

CustomKeywords.'ShipperMod.selectFields'()

CustomKeywords.'ShipperMod.selectRange'("Year")

CustomKeywords.'ShipperMod.clickComparePlan'()

CustomKeywords.'ShipperMod.verifyDataInGridLayout'()





