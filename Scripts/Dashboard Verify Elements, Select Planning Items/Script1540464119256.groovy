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
import java.lang.String as String

CustomKeywords.'HamburgMenu.clickHamburgMenu'(GlobalVariable.menu_dashboard)

CustomKeywords.'Dashboard.selectHeaderItem'(findTestData('Dashboard'), '1')

CustomKeywords.'Dashboard.btnClickDashboardHeader'()

CustomKeywords.'Dashboard.btnClickAddSections'()

CustomKeywords.'Dashboard.selectAddSectionsItem'(findTestData('Dashboard'), '1')

CustomKeywords.'Dashboard.btnClickAddSections'()

CustomKeywords.'Dashboard.btnClickAddSections'()

CustomKeywords.'Dashboard.deleteAddSectionsItem'(findTestData('Dashboard'), '1')

CustomKeywords.'Dashboard.btnClickAddSections'()

CustomKeywords.'Dashboard.closeSelectionChart'('Trade Rate by Month;GSV LE vs')

CustomKeywords.'Dashboard.verifyChartsExist'(findTestData('Dashboard'), '1')

