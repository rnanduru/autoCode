
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.DayOfWeek as DayOfWeek
import java.time.LocalDate as LocalDate
import java.time.format.DateTimeFormatter as DateTimeFormatter
import java.util.regex.Matcher
import java.util.regex.Pattern

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class General {
	@Keyword
	public static void openAppURLRobo(String url){
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		robotEnterString("<f6>")
		robotEnterString("<f6>")
		robotEnterString(url)
		robotEnterString("<enter>")
		WebUI.delay(20)
	}
	@Keyword
	public static void openAppURL(String url){
		WebUI.openBrowser('')
		WebUI.openBrowser(url,FailureHandling.STOP_ON_FAILURE)
	}
	@Keyword
	public static void robotEnterString(String data){
		RobotX.RoboKeyPress(data)
	}
	@Keyword
	public static TestObject createObject(xPath){
		return new TestObject().addProperty('xpath', ConditionType.EQUALS,xPath,true)
	}
	@Keyword
	public static Map loadData(TestData td, String dataId){
		Map mp = [:]
		Map<String,String> mp1 = new HashMap<String, String>()
		def arl1 = new ArrayList<String>()
		def tableID = ""
		def indexI = 0
		def rowNumbers = td.getRowNumbers()
		def didValue = dataId.toString()
		def val1 = new ArrayList<String>()
		def theValue = ""
		for(int i=1;i<=rowNumbers;i++){
			if(td.getValue("ID", i) != ""){
				tableID = td.getValue("ID", i)
				theValue = ""
				indexI++
				mp1 = [:]
			}
			if(tableID.equalsIgnoreCase(didValue.toString())){
				String[] cols = td.getColumnNames()

				for(int col=1;col<cols.length;col++) {
					//if(td.getValue(cols[col], i).toString() != "") {

					if(mp1.containsKey(cols[col])){
						if(!td.getValue(cols[col], i).toString().equalsIgnoreCase(""))
							theValue = mp1.get(cols[col])+GlobalVariable.multivalueseperator+td.getValue(cols[col], i).toString()
						else
							theValue = mp1.get(cols[col])
					}
					else{
						theValue =  td.getValue(cols[col], i).toString()
					}
					println "theValue :"+theValue
					theValue = evalString(theValue)
					mp1.put(cols[col],theValue)
					//}
				}
				mp.put(indexI, mp1)
			}
		}
		return mp
	}
	public static String evalString(String data){
		if(data.contains("{")){
			if(data.contains("{store.")){
				String[] data1 = data.split("\\.")
				def varname = data1[1].substring(0, (data1[1].length()-1))
				data = varname
			}
			if(data.contains("{var.")){
				String[] data1 = data.split("\\.")
				def varname = data1[1].substring(0, (data1[1].length()-1))
				println "varname :"+varname
				data = GetValue(varname)
			}
			if(data.contains("{date.")){
				String regString = "\\{(\\s*?.*?)*?\\}";
				Pattern pattern = Pattern.compile(regString)
				Matcher matcher = pattern.matcher(data)
				def data1 = data
				while (matcher.find()){
					def theString = matcher.group(0).substring(1, (matcher.group(0).length()-1)).split("\\.")
					def format
					if(theString.length > 2){
						format = theString[2]
					}
					else if(theString.length == 2){
						format = GlobalVariable.defaultdateformat
					}
					data1 = data1.replace(matcher.group(0), DateFormater(theString[1],format))
				}
				data = data1
			}
			if(data.contains("{uid}")){
				Random rand = new Random();
				int value =	rand.nextInt((99 - 11) + 1) + 11;
				def data1 = data.replace("{uid}", value);
				data = data1;
			}
			if(data.equalsIgnoreCase(""))
				data = "<null>"
		}
		return data
	}
	public static String evalInt(String data){
		if(data.startsWith("{toInt(")){
			data = data.replace("{toInt(","");
			data = data.replace("(","");
			data = data.replace(")","");
			data = data.replace("}","");
			data = data.replace("\$","");
			data = data.replace(",","");
			data = data.replace("%","");
		}
		return data
	}
	public static String DateFormater(String days,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format)
		Calendar c = Calendar.getInstance()
		//Number of Days to add
		c.add(Calendar.DAY_OF_MONTH, Integer.valueOf(days));
		//Date after adding the days to the given date
		String newDate = sdf.format(c.getTime());
		//Displaying the new Date after addition of Days
		return newDate
	}
	public static String FormatDate(String date,String actualFormat,String expFormat){
		DateFormat originalFormat = new SimpleDateFormat(actualFormat, Locale.ENGLISH);
		DateFormat targetFormat = new SimpleDateFormat(expFormat);
		Date date1 = originalFormat.parse(date);
		String formattedDate = targetFormat.format(date1);
		return formattedDate
	}
	@Keyword
	public static int getCurrentweekNum(){
		Calendar now=Calendar.getInstance();
		return now.get(Calendar.WEEK_OF_YEAR);
	}

	@Keyword
	public static int getCurrentMonth(){

		Calendar now=Calendar.getInstance();
		int m=now.get(Calendar.MONTH);
		return m+1
	}
	@Keyword
	public static String GetValue(String data1){
		//check for the text file with data
		//if exists read the content and
		//return the contents
		//data files location /TestData/

		String outputDir = System.getProperty("user.dir")+"\\Data Files\\Outputs"
		if(!new File(outputDir+"\\"+data1+".txt").exists()){
			return data1
		}
		FileReader fileReader =	new FileReader(outputDir+"\\"+data1+".txt")
		//FileReader fileReader =	new FileReader() //"C:\\Users\\DELL\\Katalon Studio\\Kraft_Sample\\Data Files\\Outputs\data1.txt")
		BufferedReader bufferedReader =
				new BufferedReader(fileReader);
		def str = bufferedReader.readLine()
		println "str :"+str
		return str
	}
	@Keyword
	public static void SetValue(String variable,String value){
		BufferedWriter out = new BufferedWriter(new FileWriter(System.getProperty("user.dir")+"\\Data Files\\Outputs\\" + variable +".txt"));
		out.write(value);
		out.close();
	}

	@Keyword
	public static String getRandomnum(int min,int max){
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}

	@Keyword
	public static String getCurrentWeekEndDate(){
		DateTimeFormatter df = DateTimeFormatter.ofPattern('MMM/dd/yyyy')
		LocalDate today = LocalDate.now()
		// Go forward to get saturday
		LocalDate saturday = today
		while (saturday.getDayOfWeek() != DayOfWeek.SATURDAY) {
			saturday = saturday.plusDays(1)
		}
		def date=df.format(saturday)
		return date
	}


}
