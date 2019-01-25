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

/*
 * Able to view the financials data on the page in weekly, monthly or quarterly form (via the left nav links); 
 * with amounts summed up to each relevant level
 */



CustomKeywords.'General.openAppURLRobo'(GlobalVariable.url)

CustomKeywords.'Login.loginCompass'(GlobalVariable.username, GlobalVariable.password)

CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.Financials)

CustomKeywords.'Financials.clickTabsInFinancials'("Financials")

CustomKeywords.'CompassUIElements.clickButton'(findTestObject('Object Repository/Compass/Financials/btn_quarter'))

CustomKeywords.'Financials.verifyFinancialQuarterAmt'(findTestObject('Object Repository/Compass/Financials/tbl_header_financialsTab'))

CustomKeywords.'CompassUIElements.clickButton'(findTestObject('Object Repository/Compass/Financials/btn_month'))

CustomKeywords.'Financials.verifyFinancialMonthAmt'(findTestObject('Object Repository/Compass/Financials/tbl_header_financialsTab'))

CustomKeywords.'CompassUIElements.clickButton'(findTestObject('Object Repository/Compass/Financials/btn_week'))

CustomKeywords.'Financials.verifyFinancialWeekAmt'(findTestObject('Object Repository/Compass/Financials/tbl_header_financialsTab'))





