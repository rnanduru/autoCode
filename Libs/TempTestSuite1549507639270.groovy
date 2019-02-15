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


suiteProperties.put('id', 'Test Suites/RegressionSuite')

suiteProperties.put('name', 'RegressionSuite')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\COMPASS\\autoCode\\Reports\\RegressionSuite\\20190207_081719\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/RegressionSuite', suiteProperties, [new TestCaseBinding('Test Cases/ComparePlansPage/CompareAndDisplayDataInGridForm', 'Test Cases/ComparePlansPage/CompareAndDisplayDataInGridForm',  null), new TestCaseBinding('Test Cases/CustomerAuthorization/ExportDataBasedOnWeekSelection', 'Test Cases/CustomerAuthorization/ExportDataBasedOnWeekSelection',  null), new TestCaseBinding('Test Cases/CustomerAuthorization/KHCWeekAllShowsUPCsShippedFiscalYear', 'Test Cases/CustomerAuthorization/KHCWeekAllShowsUPCsShippedFiscalYear',  null), new TestCaseBinding('Test Cases/CustomerAuthorization/SeeDefaultUPCsToActivePPGsForCurrentWeek', 'Test Cases/CustomerAuthorization/SeeDefaultUPCsToActivePPGsForCurrentWeek',  null), new TestCaseBinding('Test Cases/CustomerAuthorization/SortAndFilterColumnsOnTabs', 'Test Cases/CustomerAuthorization/SortAndFilterColumnsOnTabs',  null), new TestCaseBinding('Test Cases/EventManagement/CreateAllEventTypes', 'Test Cases/EventManagement/CreateAllEventTypes',  null), new TestCaseBinding('Test Cases/EventManagement/CreateEventTypesViaCreateEventBtn', 'Test Cases/EventManagement/CreateEventTypesViaCreateEventBtn',  null), new TestCaseBinding('Test Cases/EventManagement/CreatePPGEventWithWithEventCreateButton', 'Test Cases/EventManagement/CreatePPGEventWithWithEventCreateButton',  null), new TestCaseBinding('Test Cases/EventManagement/DeleteAnyEventOnTabs', 'Test Cases/EventManagement/DeleteAnyEventOnTabs',  null), new TestCaseBinding('Test Cases/EventManagement/EditAnyEventByEventIDColumn', 'Test Cases/EventManagement/EditAnyEventByEventIDColumn',  null), new TestCaseBinding('Test Cases/EventManagement/Export To Excel for Tabs-Events and Products', 'Test Cases/EventManagement/Export To Excel for Tabs-Events and Products',  null), new TestCaseBinding('Test Cases/EventManagement/HideAndDisplayColumnsViaColumnsButton', 'Test Cases/EventManagement/HideAndDisplayColumnsViaColumnsButton',  null), new TestCaseBinding('Test Cases/EventManagement/PPGAndItsRelatedEvents', 'Test Cases/EventManagement/PPGAndItsRelatedEvents',  null), new TestCaseBinding('Test Cases/EventManagement/SortAndFilterResultsFromEventsAndproductsTab', 'Test Cases/EventManagement/SortAndFilterResultsFromEventsAndproductsTab',  null), new TestCaseBinding('Test Cases/EventManagement/VerifyCYVolumeShipmentOnEventCreation', 'Test Cases/EventManagement/VerifyCYVolumeShipmentOnEventCreation',  null), new TestCaseBinding('Test Cases/EventManagement/VerifyEventCreationLayoutSections', 'Test Cases/EventManagement/VerifyEventCreationLayoutSections',  null), new TestCaseBinding('Test Cases/EventManagement/VerifyLookUpForAddPPGBtn', 'Test Cases/EventManagement/VerifyLookUpForAddPPGBtn',  null), new TestCaseBinding('Test Cases/Financials Page/AbleToWriteOffsAmountsAndSelectDateRange', 'Test Cases/Financials Page/AbleToWriteOffsAmountsAndSelectDateRange',  null), new TestCaseBinding('Test Cases/Financials Page/ModifyPostAuditAmtAndSelectDateAndSave', 'Test Cases/Financials Page/ModifyPostAuditAmtAndSelectDateAndSave',  null), new TestCaseBinding('Test Cases/Financials Page/ViewFinancialDataOnWeeklyMonthlyAndQuarterly', 'Test Cases/Financials Page/ViewFinancialDataOnWeeklyMonthlyAndQuarterly',  null), new TestCaseBinding('Test Cases/MerchCalendar/CreateEventOnWeekNumber', 'Test Cases/MerchCalendar/CreateEventOnWeekNumber',  null), new TestCaseBinding('Test Cases/MerchCalendar/VerifyCalendarInGridForm', 'Test Cases/MerchCalendar/VerifyCalendarInGridForm',  null), new TestCaseBinding('Test Cases/MerchCalendar/VerifyEventPromoSRPRedBox', 'Test Cases/MerchCalendar/VerifyEventPromoSRPRedBox',  null), new TestCaseBinding('Test Cases/ShipperModPage/CreateEventAgainstMODAndPrePopulate', 'Test Cases/ShipperModPage/CreateEventAgainstMODAndPrePopulate',  null), new TestCaseBinding('Test Cases/ShipperModPage/VerifyModProductAsTwoTabs', 'Test Cases/ShipperModPage/VerifyModProductAsTwoTabs',  null)])
