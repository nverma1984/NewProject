import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

	
public class Timesheet {
	private static ThreadLocal<WebDriver> localthread = new ThreadLocal<WebDriver>();

@BeforeClass	
public void beforthemethod(){
	System.out.println("This will launch the ie browser");
}
	     @Test
		 public void firsttest(){	    	 
	    	 Timesheet t1 = new Timesheet();
	    	 t1.createinstanceofbrowser("Mozilla", "true");
	    	 t1.login("VBS1226", "Password1", "https://empower.intsof.com");
	    	 t1.filltimesheet();
	    	 //System.setProperty("webdriver.gecko.driver", "C:\\Users\\nverma\\Desktop\\Stuff not backed up\\Stuff not backed up\\Softwares\\Drivers\\latest\\geckodriver.exe");
			 //WebDriver driver=new FirefoxDriver();			 
			System.out.println("This is method");        
		}
	     
	     @AfterClass
//	     public void aftermehtod(){
//	    	 System.out.println("This is going to close the ie browser");
//	     }
	     
	     public static WebDriver getDriver(){
	 		return (WebDriver)localthread.get();		
	 		}
	     
	     
	     public void createinstanceofbrowser(String Browser, String GridMachine){

	 		WebDriver driver=null;
	 		if (Browser.equalsIgnoreCase("Mozilla"))
	 		
	 		{
	 			
	 		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Resources\\Driver\\geckodriver.exe");
	 		 driver=new FirefoxDriver();
	 		 this.localthread.set(driver);	
	 		}
	 		
	 		else if(Browser.equalsIgnoreCase("Chrome")){
	 			System.setProperty("webdriver.chrome.driver", "C:\\Users\\nverma\\Desktop\\Drivers\\chromedriver.exe");
	 			
	 			ChromeOptions chrome = new ChromeOptions();
	 			chrome.addArguments("start-maximized");				
	 			DesiredCapabilities dcpchrome = new DesiredCapabilities().chrome();
	 			dcpchrome.setCapability(ChromeOptions.CAPABILITY, chrome);
	 							
	 			 driver =new ChromeDriver(dcpchrome);
	 			//driver.manage().window().maximize();//This can be used directly instead of using the chrome options class.
	 			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	 			this.localthread.set(driver);
	 			
	 		}
	 		else if(Browser.equalsIgnoreCase("IE")){
	 			System.setProperty("webdriver.ie.driver", "C:\\Users\\nverma\\Desktop\\Stuff not backed up\\Stuff not backed up\\Softwares\\Drivers\\IEDriverServer.exe");
	 			 driver =new InternetExplorerDriver();
	 			this.localthread.set(driver);
	 			
	 		}
	 	    driver=localthread.get();
	 		//Capabilities cap=((RemoteWebDriver)getDriver()).getCapabilities();
	 		//log.debug("The name of the browser is-- "+cap.getBrowserName());
	 		//log.debug("The version of the browser is-- "+cap.getVersion());
	 		//log.debug("The platform of the browser is-- "+cap.getPlatform());
	 	
	 	}
	     
	     public void login(String username,String password,String url){
			 
	 	    // log.debug("Login Starts");
	 		getDriver().get(url);
	 		getDriver().manage().window().maximize();
	 		//takescreenshot();
	 		getDriver().manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	 		if(getDriver().findElement(By.id("txtUserID")).isDisplayed())
	 		{System.out.println("Yes the element is displayed");};
	 		System.out.println(username);
	 		System.out.println(password);
	 		System.out.println(url);
	 		getDriver().findElement(By.id("txtUserID")).sendKeys(username);
	 		getDriver().findElement(By.id("txtPassword")).sendKeys(password);	
	 		getDriver().findElement(By.id("btnUserLogin")).click();
	 }
		
	     public void filltimesheet(){
	 		
	 		//log.debug("Number of rows is"+ getrownumfromexcel());			
	 		for(int i=1;i<getrownumfromexcel();i++)
	 			
	 		{
	 		System.out.println("The number of rows fetched is " + getrownumfromexcel());
	 			String Date = getdatafromexcel(i, 2);
	 			System.out.println("Date is " + Date);
	 			
	 			 if(null==Date){
	 				// log.debug("The value of the Date is null in row-"+i);
	 					continue;
	 				}
	 			String Project=getdatafromexcel(i, 0);
	 			if(null==Project){
	 				
	 				//log.debug("The value of the project is null in row-"+i +"  so Timesheet is not added for the date  " + Date);
	 				continue;
	 			}
		 		System.out.println("The value of project is " + Project);

	 			String Task = getdatafromexcel(i, 1);
	             if(null==Task){
	             	//log.debug("The value of the Task is null in row-"+i +"  so Timesheet is not added for the date  " + Date);
	             	//log.debug("The value of the Task is "+ Task);
	 				continue;
	 			}
			 		System.out.println("The value of task is " + Task);

	 			String Remarks= getdatafromexcel(i, 3);
	 			
	 			if(null==Remarks){
	 				//log.debug("The value of the Remarks is null in row-"+i +"and date "+ Date);
	 				
	 			}
		 		System.out.println("The value of Remarks is " + Remarks);

	 			//log.debug("Adding Timesheet for Date"+Date);
	 			System.out.println("Date fetched from filltimesheet method is" + Date);
	 			addtimesheet(Project, Task, Date, Remarks);
	 				
	 			//log.debug("Added Timesheet for the date " + Date);
	 		}
	 		
	 		
	 		
	 	}
	 	
	 	public void addtimesheet(String Project,String Task,String Date,String Remarks){
	 		System.out.println("Code has entered addtimesheet");
	 		try {
	 		Thread.sleep(5000);
	 	} catch (InterruptedException e) {
	 		System.out.println("There is an exception in method addtimesheet");
	 		e.printStackTrace();
	 		
	 	}
	 		getDriver().navigate().to("https://empower.intsof.com/addnewtimesheetentry.aspx");
	 		getDriver().findElement(By.id("cphMaster_btnAddNewTimeSheetEntry")).click();
	 			List<WebElement> li = getDriver().findElements(By.linkText("Edit"));
	 	int pindex= li.size();
	     String xpath1 = "//*[@id='cphMaster_MyDataGrid_ddlProjects" + "_" + pindex + "']";
	    
	     WebElement Web = getDriver().findElement(By.xpath(xpath1));
	      Select s = new Select(Web);
	      s.selectByVisibleText(Project);
	      String xpath2="//*[@id='cphMaster_MyDataGrid_ddlTaskPhase" + "_" + pindex + "']";
	    //*[@id="cphMaster_MyDataGrid_ddlTaskPhase_0"]/option[2]
	      try {
	  		Thread.sleep(1000);
	  	} catch (InterruptedException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  	}
	      Select s1 =new Select(getDriver().findElement(By.xpath(xpath2)));
	      s1.selectByVisibleText(Task);          
	 	 String id = "cphMaster_MyDataGrid_txtDate_"+pindex;
	 	 System.out.println("The id is "+ id);
	 	 System.out.println("the date is "+Date);
	 	  try {
	 	  		Thread.sleep(2000);
	 	  	} catch (InterruptedException e) {
	 	  		// TODO Auto-generated catch block
	 	  		e.printStackTrace();
	 	  	}
	      getDriver().findElement(By.id(id)).clear();
	      getDriver().findElement(By.id(id)).sendKeys(Date);
	      try {
	   		Thread.sleep(5000);
	   	} catch (InterruptedException e) {
	   		// TODO Auto-generated catch block
	   		e.printStackTrace();
	   	}
	      getDriver().findElement(By.id("cphMaster_MyDataGrid_txtStartTime_"+ pindex)).clear();;
	      getDriver().findElement(By.id("cphMaster_MyDataGrid_txtStartTime_"+ pindex)).sendKeys("08:30");
	      getDriver().findElement(By.id("cphMaster_MyDataGrid_txtHours_"+pindex)).clear();
	      getDriver().findElement(By.id("cphMaster_MyDataGrid_txtHours_"+pindex)).sendKeys("8");
	      getDriver().findElement(By.id("cphMaster_MyDataGrid_txtRemarks_"+pindex)).sendKeys(Remarks);
	      getDriver().findElement(By.linkText("Update")).click();
	     
	 }
	 	
	 	public String getdatafromexcel(int i,int k){
			
			String cellvalue=null;
			File f = new File(System.getProperty("user.dir")+ "\\Resources\\Files\\Timesheet.xlsx");
			try {
				FileInputStream fi = new FileInputStream(f);
				Workbook wb = new XSSFWorkbook(fi);
				Row row= wb.getSheetAt(0).getRow(i);
				Cell cell=null;
				
				if(null!=row){
				cell = row.getCell(k);
				if (null!=cell){
				switch(cell.getCellType()){			
				case Cell.CELL_TYPE_STRING:
					cellvalue=cell.getStringCellValue();}
				}
				else{
					cellvalue=null;
				}
				}
				
				
				else {
				cellvalue=null;
				}
				
			wb.close();
			fi.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			return cellvalue;

		}
		public int getrownumfromexcel(){
			int rownum=0;
			File f = new File(System.getProperty("user.dir")+"\\Resources\\Files\\Timesheet.xlsx");
			try {
				FileInputStream fi = new FileInputStream(f);
				Workbook wb = new XSSFWorkbook(fi);
				
				rownum = wb.getSheetAt(0).getLastRowNum()+1;
				wb.close();
				fi.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rownum;
		}
	}

	


