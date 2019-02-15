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
 * Able to enter post audit amounts and select a date range it applies to via the Post Audit column popup window, 
 * and apply those changes to the grid and save them
 *
 */


CustomKeywords.'General.openAppURLRobo'(GlobalVariable.url)

CustomKeywords.'Login.loginCompass'(GlobalVariable.username, GlobalVariable.password)

CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.Financials)

CustomKeywords.'Financials.clickTabsInFinancials'("Financials")

CustomKeywords.'CompassUIElements.clickButton'(findTestObject('Object Repository/Compass/Financials/btn_quarter'))

CustomKeywords.'CompassUIElements.clickButton'(findTestObject('Object Repository/Compass/Financials/btn_week'))

CustomKeywords.'Financials.clickEditWriteBtn'(findTestObject('Object Repository/Compass/Financials/btn_edit_post_audit'))

CustomKeywords.'Financials.modifyFinancialsPostAuditAmt'(1)

CustomKeywords.'Financials.clickSaveBtn'(findTestObject('Object Repository/Compass/Financials/btn_save'))

CustomKeywords.'Financials.verifyEditPostAduitAmt'(findTestObject('Object Repository/Compass/Financials/tbl_header_financialsTab'))

