package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object url
     
    /**
     * <p></p>
     */
    public static Object username
     
    /**
     * <p></p>
     */
    public static Object password
     
    /**
     * <p></p>
     */
    public static Object pageloadwait
     
    /**
     * <p></p>
     */
    public static Object waitforelement
     
    /**
     * <p></p>
     */
    public static Object menu_accounts_planner
     
    /**
     * <p></p>
     */
    public static Object menu_dashboard
     
    /**
     * <p></p>
     */
    public static Object multivalueseperator
     
    /**
     * <p></p>
     */
    public static Object defaultdateformat
     
    /**
     * <p></p>
     */
    public static Object menu_customer_settings
     
    /**
     * <p></p>
     */
    public static Object GroupName
     
    /**
     * <p></p>
     */
    public static Object Event_Management
     
    /**
     * <p></p>
     */
    public static Object Customer_Authorization
     
    /**
     * <p></p>
     */
    public static Object Financials
     
    /**
     * <p></p>
     */
    public static Object Merch_Calendar
     
    /**
     * <p></p>
     */
    public static Object baseplanning_consumption_purple
     
    /**
     * <p></p>
     */
    public static Object baseplanning_pricing_blue
     
    /**
     * <p></p>
     */
    public static Object baseplanning_distribution_green
     
    /**
     * <p></p>
     */
    public static Object baseplanning_velocity_red
     
    /**
     * <p></p>
     */
    public static Object incplanning_merch_orange
     
    /**
     * <p></p>
     */
    public static Object incplanning_hilo_green
     
    /**
     * <p></p>
     */
    public static Object incplanning_consumption_purple
     
    /**
     * <p></p>
     */
    public static Object incplanning_pricing_blue
     
    /**
     * <p></p>
     */
    public static Object shipment_consumption_purple
     
    /**
     * <p></p>
     */
    public static Object shipment_shipment_brown
     
    /**
     * <p></p>
     */
    public static Object financials_khcfinancials_ink
     
    /**
     * <p></p>
     */
    public static Object financials_customerfinancials_red
     
    /**
     * <p></p>
     */
    public static Object accountPlanner_ProductCosting
     
    /**
     * <p></p>
     */
    public static Object accountPlanner_BasePlanning
     
    /**
     * <p></p>
     */
    public static Object accountPlanner_IncPlanning
     
    /**
     * <p></p>
     */
    public static Object accountPlanner_Shipment
     
    /**
     * <p></p>
     */
    public static Object accountPlanner_Financials
     

    static {
        def allVariables = [:]        
        allVariables.put('default', ['url' : 'https://compassreg.myit.kraftheinz.com', 'username' : 'secregst376', 'password' : 'Kraft@2016', 'pageloadwait' : 100, 'waitforelement' : 100, 'menu_accounts_planner' : 'Accounts Planner', 'menu_dashboard' : 'Dashboard', 'multivalueseperator' : ';', 'defaultdateformat' : 'MM/dd/yyyy', 'menu_customer_settings' : 'Customer Settings', 'GroupName' : 'KIWI', 'Event_Management' : 'Event Management', 'Customer_Authorization' : 'Customer Authorization', 'Financials' : 'Financials', 'Merch_Calendar' : 'Merch Calendar', 'baseplanning_consumption_purple' : '#7030A0', 'baseplanning_pricing_blue' : '#00B0F0', 'baseplanning_distribution_green' : '#00DA82', 'baseplanning_velocity_red' : '#FC634E', 'incplanning_merch_orange' : '#FF9900', 'incplanning_hilo_green' : '#00B050', 'incplanning_consumption_purple' : '#7030A0', 'incplanning_pricing_blue' : '#00B0F0', 'shipment_consumption_purple' : '#7030A0', 'shipment_shipment_brown' : '#C56111', 'financials_khcfinancials_ink' : '#183D6E', 'financials_customerfinancials_red' : '#E32526', 'accountPlanner_ProductCosting' : 'Product Costing', 'accountPlanner_BasePlanning' : 'Base Planning', 'accountPlanner_IncPlanning' : 'Inc Planning', 'accountPlanner_Shipment' : 'Shipment', 'accountPlanner_Financials' : 'Financials'])
        
        String profileName = RunConfiguration.getExecutionProfile()
        
        def selectedVariables = allVariables[profileName]
        url = selectedVariables['url']
        username = selectedVariables['username']
        password = selectedVariables['password']
        pageloadwait = selectedVariables['pageloadwait']
        waitforelement = selectedVariables['waitforelement']
        menu_accounts_planner = selectedVariables['menu_accounts_planner']
        menu_dashboard = selectedVariables['menu_dashboard']
        multivalueseperator = selectedVariables['multivalueseperator']
        defaultdateformat = selectedVariables['defaultdateformat']
        menu_customer_settings = selectedVariables['menu_customer_settings']
        GroupName = selectedVariables['GroupName']
        Event_Management = selectedVariables['Event_Management']
        Customer_Authorization = selectedVariables['Customer_Authorization']
        Financials = selectedVariables['Financials']
        Merch_Calendar = selectedVariables['Merch_Calendar']
        baseplanning_consumption_purple = selectedVariables['baseplanning_consumption_purple']
        baseplanning_pricing_blue = selectedVariables['baseplanning_pricing_blue']
        baseplanning_distribution_green = selectedVariables['baseplanning_distribution_green']
        baseplanning_velocity_red = selectedVariables['baseplanning_velocity_red']
        incplanning_merch_orange = selectedVariables['incplanning_merch_orange']
        incplanning_hilo_green = selectedVariables['incplanning_hilo_green']
        incplanning_consumption_purple = selectedVariables['incplanning_consumption_purple']
        incplanning_pricing_blue = selectedVariables['incplanning_pricing_blue']
        shipment_consumption_purple = selectedVariables['shipment_consumption_purple']
        shipment_shipment_brown = selectedVariables['shipment_shipment_brown']
        financials_khcfinancials_ink = selectedVariables['financials_khcfinancials_ink']
        financials_customerfinancials_red = selectedVariables['financials_customerfinancials_red']
        accountPlanner_ProductCosting = selectedVariables['accountPlanner_ProductCosting']
        accountPlanner_BasePlanning = selectedVariables['accountPlanner_BasePlanning']
        accountPlanner_IncPlanning = selectedVariables['accountPlanner_IncPlanning']
        accountPlanner_Shipment = selectedVariables['accountPlanner_Shipment']
        accountPlanner_Financials = selectedVariables['accountPlanner_Financials']
        
    }
}
