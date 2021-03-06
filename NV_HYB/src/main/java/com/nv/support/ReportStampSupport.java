package com.nv.support;  

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReportStampSupport extends HtmlReportSupport{
//	return date
	public static String dateStamp(){
		DateFormat dateFormat = new SimpleDateFormat();
		Date date = new Date();
		return dateFormat.format(date).substring(0,7);
	}
	
	//
	public static String dateTime()
	{
		Date todaysDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss a");
		String formattedDate = formatter.format(todaysDate);
		return formattedDate;

	}
	
	public static String stepExecTime()
	{
		Date todaysDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy_HHmmss");
		String formattedDate = formatter.format(todaysDate);
		return formattedDate;

	}
	public static String getTime()
	{
		Date todaysDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss a");
		String formattedDate = formatter.format(todaysDate);
		return formattedDate;

	}
	//return time
	
	//return time and date
	public static String timeStamp(){
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime()).toString();
	}
	// return environmental details
	public static String osEnvironment(){

		return "Current suit exicuted on : "+System.getProperty("os.name")
				+"/version : "+System.getProperty("os.version")
				+"/Architecture : "+System.getProperty("os.arch");
	}
	public String getHostName() throws UnknownHostException{
		InetAddress addr = InetAddress.getLocalHost();
		String hostname = addr.getHostName();

		return hostname;
	}
	public void calculateTestCaseStartTime(){			
		iStartTime = System.currentTimeMillis();
	}

	
	/***
	 * 		This method is supposed to be used in the @AfterMethod to calculate the total test case execution time 
	 * to show in Reports by taking the start time from the calculateTestCaseStartTime method.
	 */
	public void calculateTestCaseExecutionTime(){	
		iEndTime = System.currentTimeMillis();
		iExecutionTime=(iEndTime-iStartTime);
		TimeUnit.MILLISECONDS.toSeconds(iExecutionTime);
		HtmlReportSupport.executionTime.put(tc_name,String.valueOf(TimeUnit.MILLISECONDS.toSeconds(iExecutionTime)));
		System.out.println(tc_name+";Time :"+String.valueOf(TimeUnit.MILLISECONDS.toSeconds(iExecutionTime)));
	}
	
	
	/***
	 * 		This method is supposed to be used in the @BeforeSuite in-order trigger the Suite Start Time
	 * which inturn used to calculate the Total Suite execution time to show in Reports.
	 */
	public static void calculateSuiteStartTime(){
		
		iSuiteStartTime = System.currentTimeMillis(); //Newly added
	}
	
	
	/***
	 * 		This method is supposed to be used in the @AfterMethod to calculate the total suite execution time
	 * to show in Reports by taking the suite start time from the calculateSuiteStartTime method.
	 */
	public static void calculateSuiteExecutionTime(){
		
		iSuiteEndTime = System.currentTimeMillis(); //Newly added
		/*iSuiteExecutionTime = TimeUnit.MILLISECONDS.toMinutes(iSuiteEndTime-iSuiteStartTime);//Newly added
		if(iSuiteExecutionTime==0)
			iSuiteExecutionTime=1;*/
		
		iSuiteExecutionTime=String.format("%dMin %dSec", 
			    TimeUnit.MILLISECONDS.toMinutes(iSuiteEndTime-iSuiteStartTime),
			    TimeUnit.MILLISECONDS.toSeconds(iSuiteEndTime-iSuiteStartTime) - 
			    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(iSuiteEndTime-iSuiteStartTime))
			);
	}
}
