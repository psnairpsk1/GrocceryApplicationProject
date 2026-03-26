package constant;

public class Constants {

	//Path declaration starts here
	public static final String TESTDATAFILE = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
	public static final String CONFIGFILE = System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
	
	//Messages declaration starts here
	public static final String VALIDCREDENTIALERROR = "User Was unable to login with valid credentials";
	public static final String HOMETITLECOMPARISONERROR = "User was able to login with invalid password";
	public static final String DASHBOARDDISPLAYEDERROR = "ERROR: Dashboard was displayed! User logged in with invalid credentials.";
	public static final String LOGOUTCHECKERROR = "User is in home page";
	public static final String ADDNEWUSERERROR = "Error : The user is in Admin Users Creation Page";
	public static final String SEARCHUSERERROR = "Error : The user is in Admin Users List Page";
	public static final String RESETUSERLISTERROR = "Error : The user is in home page";
	public static final String PAGETITLESTATUSERROR ="Error : User is in news creation Page";
	public static final String PAGETITLESEARCHMANAGENEWSSTATUSERROR ="Error : User is in news list Page";
}
