import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable


/*
 * This Method verifies the Months order.
 * @mon
 * months string to validate
 */
@Keyword
public static void verifyMonthOrder(String mon){

	String[] month=mon.split(GlobalVariable.multivalueseperator)
	TestObject to;
	String monthName="";
	for(int i=1;i<=12;i++){
		to=General.createObject("//app-merch-calendar/div[@class='relative']//div[@class='data-grid float-left']/div/div[1]/div["+i+"]/div[contains(.,'"+month[i-1]+"')][1]")
		monthName= WebUI.getText(to)
		if (monthName.equals(month[i-1])) {
			KeywordUtil.markPassed("Text is equal  "+month[i-1])
		}else{
			KeywordUtil.markFailed("Text is not equal  "+month[i-1])
		}
	}
}

@Keyword
public static void verifyWeekOrder(String mon){
	String[] month=mon.split(GlobalVariable.multivalueseperator)
	TestObject to;
	String weekNo="";
	int k;
	int wk=0;
	for(int i=0;i<=month.size()-1;i++){
		if (month[i].equalsIgnoreCase("jan") || month[i].equalsIgnoreCase("apr")|| month[i].equalsIgnoreCase("jul")|| month[i].equalsIgnoreCase("oct")|| month[i].equalsIgnoreCase("dec")) {
			k=5;
		}else{
			k=4;
		}
		for (int j =1;j<=k;j++) {
			wk++;
			to=General.createObject("//app-merch-calendar/div[@class='relative']//div[@class='data-grid float-left']/div/div[1]/div["+getMonthNumber(month[i])+"]/div[2]/div["+j+"]/div[@class='h-column']")
			weekNo=WebUI.getText(to)
			if (weekNo.equals("Week "+wk)) {
				KeywordUtil.markPassed("Weeks are equal in order"+weekNo)
			}else{
				KeywordUtil.markFailed("Weeks are unequal in order"+weekNo)
			}
		}
	}
}


@Keyword
public static String getMonthNumber(String month){
	String num="";
	if(month.toUpperCase().equals("JAN")){
		num="1"
	}else if(month.toUpperCase().equals("FEB")){
		num="2"
	}else if(month.toUpperCase().equals("MAR")){
		num="3"
	}else if(month.toUpperCase().equals("APR")){
		num="4"
	}else if(month.toUpperCase().equals("MAY")){
		num="5"
	}else if(month.toUpperCase().equals("JUN")){
		num="6"
	}else if(month.toUpperCase().equals("JUL")){
		num="7"
	}else if(month.toUpperCase().equals("AUG")){
		num="8"
	}else if(month.toUpperCase().equals("SEPT")){
		num="9"
	}else if(month.toUpperCase().equals("OCT")){
		num="10"
	}else if(month.toUpperCase().equals("NOV")){
		num="11"
	}else if(month.toUpperCase().equals("DEC")){
		num="12"
	}
	return num;
}

@Keyword
public static void clickProductBtn(TestObject to){
	CompassUIElements.clickButton(to)
	WebUI.delay(2)
}

/*
 * @to
 * search for text
 */
@Keyword
public static void searchAndSelectPPGs(TestObject to,String ppg){
	CompassUIElements.setText(to, ppg)
	WebUI.delay(5)
	TestObject tppg=General.createObject("//app-merch-calendar/div[@class='relative']//div[@class='product-items-content']/div/label[@class='k-checkbox-label']")
	CompassUIElements.clickButton(tppg)
}
/*
 * @Year
 * years tab i.e current year and prior year (2018;2019
 * @ppg 
 * ppgs validation exists or not(0IX 5.5-6z Mac&Cheese MWO 12)
 */
@Keyword
public static void verifyPPGsAndYears(TestObject eoc,String year,String ppg){
	String[] years=year.split(GlobalVariable.multivalueseperator)

	CompassUIElements.clickButton(eoc)

	for(int i=0;i<years.size();i++){
		TestObject to=General.createObject("//app-merch-calendar/div[@class='relative']/div[2]/div[@class='float-left']/div[2]//div[.='"+years[i]+"']")
		CompassUIElements.checkElementVisible(to, 20)
	}
	CompassUIElements.checkElementVisible(General.createObject("//app-merch-calendar/div[@class='relative']//div[2]/div[1]/div[contains(.,'"+ppg+"')]"), 20)
}

@Keyword
public static void clickCurrentWeekTab(int month,int week){
	
	TestObject to=General.createObject("//app-merch-calendar/div[@class='relative']//div[@class='data-grid float-left']/div/div[2]/div["+month+"]/div["+week+"]/div[@title='Click to Add Event']")
	CompassUIElements.clickButton(to)
}


