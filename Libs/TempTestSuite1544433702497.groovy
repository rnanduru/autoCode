import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import groovy.lang.MissingPropertyException
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/Suit')

suiteProperties.put('name', 'Suit')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\DELL\\Katalon Studio\\Kraft_Working\\Reports\\Suit\\20181210_145142\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/Suit', suiteProperties, [new TestCaseBinding('Test Cases/Login Test', 'Test Cases/Login Test',  null), new TestCaseBinding('Test Cases/Dashboard Verify Elements, Select Planning Items', 'Test Cases/Dashboard Verify Elements, Select Planning Items',  null), new TestCaseBinding('Test Cases/CustomerSettings', 'Test Cases/CustomerSettings',  null), new TestCaseBinding('Test Cases/Go to Account Planner, the data is loading correctly according global header selection', 'Test Cases/Go to Account Planner, the data is loading correctly according global header selection',  null), new TestCaseBinding('Test Cases/Account Planner Create a Product Plan', 'Test Cases/Account Planner Create a Product Plan',  null), new TestCaseBinding('Test Cases/Select different PPG or PPG Group by using drop down of Product Selection, can load correct data depends on the selection', 'Test Cases/Select different PPG or PPG Group by using drop down of Product Selection, can load correct data depends on the selection',  null), new TestCaseBinding('Test Cases/Swich version between Units and Cases get correct data', 'Test Cases/Swich version between Units and Cases get correct data',  null), new TestCaseBinding('Test Cases/On Product Costing tab, Error message should be prompted when user navigates away from the account planner page without entering one of the mandatory fields', 'Test Cases/On Product Costing tab, Error message should be prompted when user navigates away from the account planner page without entering one of the mandatory fields',  null), new TestCaseBinding('Test Cases/On Product Costing tab, Error message should be promted when user navigates away from the Prodcut Costing tab without Apply EDLP or entering one of the mandatory fields', 'Test Cases/On Product Costing tab, Error message should be promted when user navigates away from the Prodcut Costing tab without Apply EDLP or entering one of the mandatory fields',  null), new TestCaseBinding('Test Cases/the user does not enter the start date and the end date and the EDLP Rate per Case or ELDP Rate per Unit or Spend Rate EDLP mandatory field error message should be prompted', 'Test Cases/the user does not enter the start date and the end date and the EDLP Rate per Case or ELDP Rate per Unit or Spend Rate EDLP mandatory field error message should be prompted',  null), new TestCaseBinding('Test Cases/On Product Costing tab, Delete button works correctly', 'Test Cases/On Product Costing tab, Delete button works correctly',  null), new TestCaseBinding('Test Cases/Create View button is working correctly', 'Test Cases/Create View button is working correctly',  null), new TestCaseBinding('Test Cases/Creating  a plan by using button Save as under Versions correctlly', 'Test Cases/Creating  a plan by using button Save as under Versions correctlly',  null), new TestCaseBinding('Test Cases/Save button works correctly The info message box should be promted after saving data', 'Test Cases/Save button works correctly The info message box should be promted after saving data',  null), new TestCaseBinding('Test Cases/Export to Excel button works correctly', 'Test Cases/Export to Excel button works correctly',  null)])
