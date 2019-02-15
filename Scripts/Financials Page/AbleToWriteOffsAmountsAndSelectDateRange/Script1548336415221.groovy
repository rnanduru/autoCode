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
 * Able to enter write-off amounts and select a date range it applies to via the Write-Off column popup window, 
 * and apply those changes to the grid and save them
 *
 *1) Login And Click Financials Tab
 *2) Click Week Button and Click Write Off Columns edit button
 *3) Enter Values of Write Off Manual,Write Off Auto,Write Off Tolerance,Select Date Range,Select Dates and Click Apply
 *4) Click Save Button
 *5) Verify the total values of column's Write Off Manual,Write Off Auto,Write Off Tolerance
 */



CustomKeywords.'General.openAppURLRobo'(GlobalVariable.url)

CustomKeywords.'Login.loginCompass'(GlobalVariable.username, GlobalVariable.password)

CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.Financials)

CustomKeywords.'Financials.clickTabsInFinancials'("Financials")

CustomKeywords.'CompassUIElements.clickButton'(findTestObject('Object Repository/Compass/Financials/btn_quarter'))

CustomKeywords.'CompassUIElements.clickButton'(findTestObject('Object Repository/Compass/Financials/btn_week'))

//Scroll To Element i.e Write Off Column

CustomKeywords.'Financials.scrollToElement'(findTestObject('Object Repository/Compass/Financials/btn_writeoff'))

//Click Write Off column edit button.

CustomKeywords.'Financials.clickEditWriteBtn'(findTestObject('Object Repository/Compass/Financials/btn_writeoff'))

//Enter Values of Write Off Manual,Write Off Auto,Write Off Tolerance,Select Date Range,Select Dates and Click Apply

CustomKeywords.'Financials.modifyFianacialsWriteOffAmount'(1) 

//Click Save Button

CustomKeywords.'Financials.clickSaveBtn'(findTestObject('Object Repository/Compass/Financials/btn_save'))

// 10 & 14 are Column indexes of Write Off Column

CustomKeywords.'Financials.verifyEditColumnsDataInWeekTab'(findTestObject('Object Repository/Compass/Financials/tbl_header_financialsTab'),10,14)
