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
     

    static {
        def allVariables = [:]        
        allVariables.put('default', ['url' : 'https://compassdev.myit.kraftheinz.com', 'username' : 'secregst376', 'password' : 'Kraft@2016', 'pageloadwait' : 100, 'waitforelement' : 60])
        
        String profileName = RunConfiguration.getExecutionProfile()
        
        def selectedVariables = allVariables[profileName]
        url = selectedVariables['url']
        username = selectedVariables['username']
        password = selectedVariables['password']
        pageloadwait = selectedVariables['pageloadwait']
        waitforelement = selectedVariables['waitforelement']
        
    }
}
