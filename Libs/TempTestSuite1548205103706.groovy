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


suiteProperties.put('id', 'Test Suites/RegressionSuit')

suiteProperties.put('name', 'RegressionSuit')

suiteProperties.put('description', 'view,version,save,export')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\DELL\\Katalon Studio\\Kraft_Working\\Reports\\RegressionSuit\\20190123_062823\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/RegressionSuit', suiteProperties, [new TestCaseBinding('Test Cases/Login Test', 'Test Cases/Login Test',  null), new TestCaseBinding('Test Cases/Dashboard Verify Elements, Select Planning Items', 'Test Cases/Dashboard Verify Elements, Select Planning Items',  null), new TestCaseBinding('Test Cases/AccountPlanner_GlobalNav', 'Test Cases/AccountPlanner_GlobalNav',  null), new TestCaseBinding('Test Cases/CreateViewButton', 'Test Cases/CreateViewButton',  null), new TestCaseBinding('Test Cases/VesionsButton', 'Test Cases/VesionsButton',  null), new TestCaseBinding('Test Cases/BasePlanningValidations', 'Test Cases/BasePlanningValidations',  null), new TestCaseBinding('Test Cases/ProductCostingSpendMethodPopup', 'Test Cases/ProductCostingSpendMethodPopup',  null), new TestCaseBinding('Test Cases/SaveButtonWorksCorrectly', 'Test Cases/SaveButtonWorksCorrectly',  null), new TestCaseBinding('Test Cases/CheckPPGsAndAddIntoGroups', 'Test Cases/CheckPPGsAndAddIntoGroups',  null), new TestCaseBinding('Test Cases/AbleToEnterAllPPGActivationFields', 'Test Cases/AbleToEnterAllPPGActivationFields',  null), new TestCaseBinding('Test Cases/AbleToDeleteRowInPPGActivation', 'Test Cases/AbleToDeleteRowInPPGActivation',  null), new TestCaseBinding('Test Cases/SortContentAscOrDescInPPGActivation', 'Test Cases/SortContentAscOrDescInPPGActivation',  null), new TestCaseBinding('Test Cases/EditAllEditableFieldsInUPCActivation', 'Test Cases/EditAllEditableFieldsInUPCActivation',  null), new TestCaseBinding('Test Cases/SortDataAscOrDescInUPCActivation', 'Test Cases/SortDataAscOrDescInUPCActivation',  null), new TestCaseBinding('Test Cases/ProductCostingErrormsg', 'Test Cases/ProductCostingErrormsg',  null)])
