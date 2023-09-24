Step:1 PageObjects Package -- BagePage.java Class
========================================================================================================
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	 WebDriver driver;
	    
	   public BasePage(WebDriver driver)
	     {
		     this.driver=driver;
		     PageFactory.initElements(driver,this);
	     }
	   	   
}

Step:2 PageObjects Package -- HomePage.java Class
========================================================================================================
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement lnkMyaccount;

	@FindBy(linkText = "Register")
	WebElement lnkRegister;

	// Action Methods
	public void clickMyAccount() {
		lnkMyaccount.click();
	}

Step:3 PageObjects Package -- AccountRegistrationPage.java Class
========================================================================================================
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	// Elements
		@FindBy(name = "firstname")
		WebElement txtFirstname;

		@FindBy(name = "lastname")
		WebElement txtLasttname;

		@FindBy(name = "email")
		WebElement txtEmail;

		@FindBy(name = "telephone")
		WebElement txtTelephone;

		@FindBy(name = "password")
		WebElement txtPassword;

		@FindBy(name = "confirm")
		WebElement txtConfirmPassword;
		
		 //4) Radio btns or Gender
		@FindBy(xpath = "//label[normalize-space()='Yes']")
		WebElement radioYesbtn;
		
		@FindBy(xpath = "//input[@value='0']")
		WebElement radioNobtn;
		
		//@FindBy(linkText = "Register")
		//WebElement lnkRegister;
		


		@FindBy(name = "agree")
		WebElement chkdPolicy;

		@FindBy(xpath = "//input[@value='Continue']")
		WebElement btnContinue;

		@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
		WebElement msgConfirmation;

		public void setFirstName(String fname) {
			txtFirstname.sendKeys(fname);

		}

		public void setLastName(String lname) {
			txtLasttname.sendKeys(lname);

		}

		public void setEmail(String email) {
			txtEmail.sendKeys(email);

		}

		public void setTelephone(String tel) {
			txtTelephone.sendKeys(tel);

		}

		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);

		}

		public void setConfirmPassword(String pwd) {
			txtConfirmPassword.sendKeys(pwd);

		}
		
		//4.Select Radiobtns method
		public void clickRadiobtn() {
			radioYesbtn.click();
			System.out.println(radioYesbtn.isSelected());
		}

		public void setPrivacyPolicy() {
			chkdPolicy.click();

		}

		public void clickContinue() {
			//sol1 
			btnContinue.click();
			
			//sol2 
			//btnContinue.submit();
			
			//sol3
			//Actions act=new Actions(driver);
			//act.moveToElement(btnContinue).click().perform();
						
			//sol4
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("arguments[0].click();", btnContinue);
			
			//Sol 5
			//btnContinue.sendKeys(Keys.RETURN);
			
			//Sol6  
			//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
			
		}

		public String getConfirmationMsg() {
			try {
				return (msgConfirmation.getText());
			} catch (Exception e) {
				return (e.getMessage());

			}

		}
}

Step:4 testBase Package-- BaseClass.java Class
========================================================================================================
package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;

	@BeforeClass
	public void setup()
	{
		//ChromeOptions options=new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("http://localhost/opencart/upload/index.php");
	        driver.get("https://tutorialsninja.com/demo/");
		
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
}

Step:5 testCases Package-- TC_001_AccountRegistrationTest.java Class
========================================================================================================
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	@Test
	public void test_account_Registration() throws InterruptedException
	{
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		
		regpage.setLastName(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		
		regpage.clickRadiobtn();
		
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
}

Step:6 1.Adding log4j2.xml file under src/test/resoures
========================================================================================================
<?xml version="1.0" encoding="UTF-8"?>

<Configuration status="WARN"> 

<Properties>
	<Property name="basePath">./logs</Property>
</Properties>


  <Appenders>
    <Console name="Console" target="SYSTEM_OUT">
      <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
    </Console>
    
      <RollingFile name="File" fileName="${basePath}/automation.log" filePattern="${basePath}/automation-%d{yyyy-MM-dd}.log">
     <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
      <SizeBasedTriggeringPolicy size="50000" />
   </RollingFile>
    
    
  </Appenders>
  
  <Loggers>
    <Root level="Info"><!-- Here you can use multiple log levels All < Trace < Debug < Info < Warn < Error < Fatal < Off -->
      <AppenderRef ref="File"/>  <!-- <AppenderRef ref="Console"/> -->
    </Root>
  </Loggers>
  
</Configuration>

Step:7 Step:4(repeat) testBase Package-- BaseClass.java Class
========================================================================================================
package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager; // ~~~~~~~~~~~~~~~~~~~~logging
import org.apache.logging.log4j.Logger;  // ~~~~~~~~~~~~~~~~~~~~logging


public class BaseClass {

	public WebDriver driver;
	
	public Logger logger; // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~for logging

	@BeforeClass
	public void setup()
	{
		logger=LogManager.getLogger(this.getClass());  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~logging
		
		//ChromeOptions options=new ChromeOptions();
		//options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("http://localhost/opencart/upload/index.php");
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}
	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
}

Step:8 Step:3(repeat) PageObjects Package -- AccountRegistrationPage.java Class --- adding loggers
========================================================================================================
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	@Test
	public void test_account_Registration() throws InterruptedException
	{
		logger.debug("application logs......");
		logger.info("***  Starting TC_001_AccountRegistrationTest ***");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My account link");
		
		
		hp.clickRegister();
		logger.info("Clicked on register link");
		
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing customer data");
		
		regpage.setFirstName(randomeString().toUpperCase());
		
		regpage.setLastName(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		
		regpage.clickRadiobtn();
		
		regpage.clickContinue();
		logger.info("Clicked on continue");
		
		String confmsg=regpage.getConfirmationMsg();
		
		logger.info("Validating expected message");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!","Test failed");
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail();
		}
		logger.info("***  Finished TC_001_AccountRegistrationTest ***");	
	}
}

Step:9   Go to testCases package rightClick convent to TestNG xml file 
========================================================================================================
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="OpenCartSuite">
  <test thread-count="5" name="OpenCartTest">
	  <parameter name="browser" value="chrome" />    <!-- passing browser parameter to BaseClass ->Setup() -->
    <classes>
      <class name="testCases.TC_001_AccountRegistrationTest"/>
    </classes>
  </test> <!-- OpenCartTest -->
</suite> <!-- OpenCartSuite --> 

Step:10  Step:7(repeat)  testBase Package-- BaseClass.java Class  ---- passing Parameters
========================================================================================================
package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;  // logging


public class BaseClass {

	public WebDriver driver;
	
	public Logger logger; // for logging

	@BeforeClass
	@Parameters("browser")   // getting browser parameter from testng.xml
	public void setup(String br)
	{
		logger=LogManager.getLogger(this.getClass());  //logging
		
		/*ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(options);*/
		
		/*WebDriverManager.chromedriver().setup(); // Not required selenium 4.6.0 later versions
		  driver=new ChromeDriver();*/
		
		//launch right browser based on parameter
		if (br.equals("chrome")) 
		   {
			driver = new ChromeDriver();
		   } 
		else if (br.equals("edge"))
		   {
			driver = new EdgeDriver();
		   } 
		else 
		   {
			driver = new ChromeDriver();
		   }
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}
	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
}

Step:11   Create Another file in test-output or same project given name of file like multiplebrowsers.xml using parallel testing browsers
===========================================================================================================================================
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="Suite" parallel="tests">
 
 <test name="ChromeTest">
    <parameter name="browser" value="chrome" />    <!-- passing browser parameter to BaseClass ->Setup() -->
    <classes>
   	     <class name="testCases.TC_001_AccountRegistrationTest"/>
    </classes>
  </test> 
  
  <test name="EdgeTest">
    <parameter name="browser" value="edge" />    <!-- passing browser parameter to BaseClass ->Setup() -->
    <classes>
   	     <class name="testCases.TC_001_AccountRegistrationTest"/>
    </classes>
  </test>
</suite> 

Step:12   src/test/resources  under Create config.properties 
========================================================================================================
appURL=https://tutorialsninja.com/demo/
email=pavanoltraining@gmail.com
password=test@123

Step:13  Step:10(repeat)  testBase Package-- BaseClass.java Class  ---- passing config.properties
========================================================================================================
package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;  // logging

import java.util.ResourceBundle;


public class BaseClass {

	public WebDriver driver;
	
	public Logger logger; // for logging
	
	public ResourceBundle rb;// to read config.properties

	@BeforeClass
	@Parameters("browser")   // getting browser parameter from testng.xml
	public void setup(String br)
	{
		logger=LogManager.getLogger(this.getClass());  //logging
		
		rb = ResourceBundle.getBundle("config");// Load config.properties
		
		/*ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(options);*/
		
		/*WebDriverManager.chromedriver().setup(); // Not required selenium 4.6.0 later versions
		  driver=new ChromeDriver();*/
		
		//launch right browser based on parameter
		if (br.equals("chrome")) 
		   {
			driver = new ChromeDriver();
		   } 
		else if (br.equals("edge"))
		   {
			driver = new EdgeDriver();
		   } 
		else 
		   {
			driver = new ChromeDriver();
		   }
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(rb.getString("appURL")); // get url from config.properties file
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}
	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
}
Step:14  utilities folder under place it  ExtentReportManager.java and srceenshoot and Dynamic path with timestamp
==================================================================================================================
package utilities;

import java.io.IOException;
//import java.net.URL;


//Extent report 5.x...//version
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;
public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	String repName;

	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		repName = "Test-Report-" + timeStamp + ".html";

		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);// specify location of the report

		sparkReporter.config().setDocumentTitle("opencart Automation Report"); // Title of report
		sparkReporter.config().setReportName("opencart Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "opencart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt", "QA");
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());

		try 
		{
		   String imgPath = new BaseClass().captureScreen(result.getName()); ~~~~~~~~~~~~~~~~~~captureScreen
		   test.addScreenCaptureFromPath(imgPath);
		}
		catch (IOException e1) 
		{
		   e1.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();

		/*
		 * try { URL url = new
		 * URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
		 * 
		 * // Create the email message 
		 * ImageHtmlEmail email = new ImageHtmlEmail();
		 * email.setDataSourceResolver(new DataSourceUrlResolver(url));
		 * email.setHostName("smtp.googlemail.com"); 
		 * email.setSmtpPort(465);
		 * email.setAuthenticator(new DefaultAuthenticator("pavanoltraining@gmail.com","password")); 
		 * email.setSSLOnConnect(true);
		 * email.setFrom("pavanoltraining@gmail.com"); //Sender
		 * email.setSubject("Test Results");
		 * email.setMsg("Please find Attached Report....");
		 * email.addTo("pavankumar.busyqa@gmail.com"); //Receiver 
		 * email.attach(url, "extent report", "please check report..."); 
		 * email.send(); // send the email 
		 * }
		 * catch(Exception e) { e.printStackTrace(); }
		 */
	}

}

Step:15  Step:13(repeat)  testBase Package-- BaseClass.java Class  ---- Static web driver and passing config.properties and capturescreen method
==========================================================================================================================
package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;  // logging


public class BaseClass {

	public static WebDriver driver;
	
	public Logger logger; // for logging
	
	public ResourceBundle rb;// to read config.properties

	@BeforeClass
	@Parameters("browser")   // getting browser parameter from testng.xml
	public void setup(String br)
	{
		logger=LogManager.getLogger(this.getClass());  //logging
		
		rb = ResourceBundle.getBundle("config");// Load config.properties
		
		/*ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(options);*/
		
		/*WebDriverManager.chromedriver().setup(); // Not required selenium 4.6.0 later versions
		  driver=new ChromeDriver();*/
		
		//launch right browser based on parameter
		if (br.equals("chrome")) 
		   {
			driver = new ChromeDriver();
		   } 
		else if (br.equals("edge"))
		   {
			driver = new EdgeDriver();
		   } 
		else 
		   {
			driver = new ChromeDriver();
		   }
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(rb.getString("appURL")); // get url from config.properties file
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}
	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException 
	{
		/*SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		  Date dt= new Date();
		  String timestamp = df.format(dt);*/
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try 
		{
			FileUtils.copyFile(source, new File(destination));
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
		return destination;

	}
}

Step:16 Step:9(repeat)  Go to testCases package rightClick convent to TestNG xml file and adding listener
========================================================================================================
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="OpenCartSuite">
	
<listeners>
	<listener class-name="utilities.ExtentReportManager" />
</listeners>
	
  <test thread-count="5" name="OpenCartTest">
	  <parameter name="browser" value="chrome" />    <!-- passing browser parameter to BaseClass ->Setup() -->
    <classes>
      <class name="testCases.TC_001_AccountRegistrationTest"/>
    </classes>
  </test> <!-- OpenCartTest -->
</suite> <!-- OpenCartSuite -->


Step:17 Step:2(repeat) PageObjects Package -- HomePage.java Class
	HomePage – update by adding login Page link element
========================================================================================================
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement lnkMyaccount;

	@FindBy(linkText = "Register")
	WebElement lnkRegister;

	@FindBy(linkText = "Login")   // Login page Locator added 
	WebElement linkLogin;
	
	
	// Action Methods
	public void clickMyAccount() {
		lnkMyaccount.click();
	}

	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin()    // Login page method added 
	{
		linkLogin.click();
	}
	
}

Step:18 PageObjects Package -- LoginPage.java Class
========================================================================================================
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;


	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}
}


Step:19 PageObjects Package -- MyAccountPage.java
========================================================================================================
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[text()='My Account']") // MyAccount Page heading
	WebElement msgHeading;

	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
}


Step:20 testCases -- TC_002_LoginTest.java
========================================================================================================
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;


public class TC_002_LoginTest extends BaseClass
{
	@Test
	public void test_Login()
	{
		logger.info(" ***Starting TC_002_LoginTest***");
		
		try
		{				
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account");
			
			hp.clickLogin();
			logger.info("Clicked on Login Link");
			
			
			LoginPage lp=new LoginPage(driver);
			logger.info("Providing login details");
			lp.setEmail(rb.getString("email")); // valid email, get it from config.properties file put form BaseClass.java
			
			lp.setPassword(rb.getString("password")); // valid password, get it from config.properties file put form BaseClass.java
			
			lp.clickLogin();
			logger.info("Clicked on Login button");
			
			
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetpage=macc.isMyAccountPageExists();
						
			Assert.assertEquals(targetpage, true,"Invalid login data");
			
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***Finished TC_002_LoginTest***");
		
	}
}

Step:21 src/test/resources -- config.properties
========================================================================================================
appURL=https://tutorialsninja.com/demo/
email=pradeepkumar@gmail.com
password=pradeep@123

	
Step:22 testng.xml for 
========================================================================================================
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="OpenCartSuite">
	
	 <listeners>
		<listener class-name="utilities.ExtentReportManager" />
	</listeners>
	
  <test thread-count="5" name="OpenCartTest">
	  <parameter name="browser" value="chrome" />    <!-- passing browser parameter to BaseClass ->Setup() -->
    <classes>
     <!--  <class name="testCases.TC_001_AccountRegistrationTest"/> -->
       <class name="testCases.TC_002_LoginTest"/>
    </classes>
  </test> <!-- OpenCartTest -->
</suite> <!-- OpenCartSuite -->
	
Step:23 Create or prepared Excel data --- testData file under add excel file(Opencart_LoginData.xlsx)
	Prepare test data in Excel, place the excel file inside the testData folder.
========================================================================================================

Step:24 Utilities Package under add Excelutility file(ExcelUtility.java)
	Create ExcelUtility class under utilities package.
========================================================================================================

Step:25 Step:19(repeat) PageObjects Package -- MyAccountPage.java add logout link element
========================================================================================================
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[text()='My Account']") // MyAccount Page heading
	WebElement msgHeading;

	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']") 
	WebElement lnkLogout;  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~add logout link element

	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickLogout() {
		lnkLogout.click();
	}
}

Step:26 Create DataProviders class in utilities package to maintain data providers for data driven tests.
========================================================================================================
package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	@DataProvider(name="LoginData")
	
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	 return logindata;//returning two dimension array
				
	}
	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
}

Step:27 Step:22(repeat)  testng.xml for 
========================================================================================================
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="OpenCartSuite">
	
	 <listeners>
		<listener class-name="utilities.ExtentReportManager" />
	</listeners>
	
  <test thread-count="5" name="OpenCartTest">
	  <parameter name="browser" value="chrome" />    <!-- passing browser parameter to BaseClass ->Setup() -->
    <classes>
     <!--  <class name="testCases.TC_001_AccountRegistrationTest"/> -->
     <!--   <class name="testCases.TC_002_LoginTest"/>-->
       <class name="testCases.TC_003_LoginDataDrivenTest"/>
       
    </classes>
  </test> <!-- OpenCartTest -->
</suite> <!-- OpenCartSuite -->


Step:28 Step:8 Step:3(repeat) PageObjects Package -- AccountRegistrationPage.java Class --- adding loggers
	(groups= {"Regression","Master"}) //Step8 groups added
========================================================================================================
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;


public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups= {"Regression","Master"}) //Step8 groups added
	public void test_account_Registration() throws InterruptedException
	{
		logger.debug("application logs......");
		logger.info("***  Starting TC_001_AccountRegistrationTest ***");
		
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My account link");
		
		
		hp.clickRegister();
		logger.info("Clicked on register link");
		
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing customer data");
		
		regpage.setFirstName(randomeString().toUpperCase());
		
		regpage.setLastName(randomeString().toUpperCase());
		
		//regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		
		regpage.setTelephone(randomeNumber());
		
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		
		regpage.clickRadiobtn();
		
		regpage.clickContinue();
		logger.info("Clicked on continue");
		
		String confmsg=regpage.getConfirmationMsg();
		
		logger.info("Validating expected message");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!","Test failed");
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail();
		}
		logger.info("***  Finished TC_001_AccountRegistrationTest ***");	
	}
}

Step:29 Step:20(repeat) testCases -- TC_002_LoginTest.java
	(groups= {"Sanity","Master"}) //Step8 groups added
========================================================================================================
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;


public class TC_002_LoginTest extends BaseClass
{
	@Test(groups= {"Sanity","Master"}) //Step8 groups added
	public void test_Login()
	{
		logger.info(" ***Starting TC_002_LoginTest***");
		
		try
		{				
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account");
			
			hp.clickLogin();
			logger.info("Clicked on Login Link");
			
			
			LoginPage lp=new LoginPage(driver);
			logger.info("Providing login details");
			lp.setEmail(rb.getString("email")); // valid email, get it from config.properties file put form BaseClass.java
			
			lp.setPassword(rb.getString("password")); // valid password, get it from config.properties file put form BaseClass.java
			
			lp.clickLogin();
			logger.info("Clicked on Login button");
			
			
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetpage=macc.isMyAccountPageExists();
						
			Assert.assertEquals(targetpage, true,"Invalid login data");
			
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***Finished TC_002_LoginTest***");
		
	}
	
}


Step:30 Step:13  Step:10(repeat)  testBase Package-- BaseClass.java Class  ---- passing config.properties
	(groups = { "Master", "Sanity", "Regression" }) //Step8 groups added
========================================================================================================

package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;  // logging


public class BaseClass {

	public static WebDriver driver;
	
	public Logger logger; // for logging
	
	public ResourceBundle rb;// to read config.properties

	@BeforeClass(groups = { "Master", "Sanity", "Regression" }) //Step8 groups added
	@Parameters("browser")   // getting browser parameter from testng.xml
	public void setup(String br)
	{
		logger=LogManager.getLogger(this.getClass());  //logging
		
		rb = ResourceBundle.getBundle("config");// Load config.properties
		
		/*ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(options);*/
		
		/*WebDriverManager.chromedriver().setup(); // Not required selenium 4.6.0 later versions
		  driver=new ChromeDriver();*/
		
		//launch right browser based on parameter
		if (br.equals("chrome")) 
		   {
			driver = new ChromeDriver();
		   } 
		else if (br.equals("edge"))
		   {
			driver = new EdgeDriver();
		   } 
		else 
		   {
			driver = new ChromeDriver();
		   }
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(rb.getString("appURL")); // get url from config.properties file
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups = { "Master", "Sanity", "Regression" }) //Step8 groups added
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException 
	{
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try 
		{
			FileUtils.copyFile(source, new File(destination));
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
		return destination;

	}
}

Step:31 grouping.xml tests
========================================================================================================
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="OpenCartSuite">
	
	 <listeners>
		<listener class-name="utilities.ExtentReportManager" />
	</listeners>
	
  <test thread-count="5" name="OpenCartTest">
	  <parameter name="browser" value="chrome" />    <!-- passing browser parameter to BaseClass ->Setup() -->
	  
	  <groups>
   		<run>
			<include name="Master" />
			<!-- <include name="Sanity" />
			<include name="Regression" /> -->
			<exclude name="" />
		</run>
	</groups>	
	
	
    <classes>
     <class name="testCases.TC_001_AccountRegistrationTest"/>
     <class name="testCases.TC_002_LoginTest"/>
      <!--   <class name="testCases.TC_003_LoginDataDrivenTest"/>-->
       
    </classes>
  </test> <!-- OpenCartTest -->
</suite> <!-- OpenCartSuite -->

Step:32 dataDriventests.xml tests
========================================================================================================
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="OpenCartSuite">
	
	 <listeners>
		<listener class-name="utilities.ExtentReportManager" />
	</listeners>
	
  <test thread-count="5" name="OpenCartTest">
	  <parameter name="browser" value="chrome" />    <!-- passing browser parameter to BaseClass ->Setup() -->
    <classes>
   
       <class name="testCases.TC_003_LoginDataDrivenTest"/>
       
    </classes>
  </test> <!-- OpenCartTest -->
</suite> <!-- OpenCartSuite -->

Step:33 Automation generating this file in test-output  --- testng-failed.xml
========================================================================================================
9) Run Failed Tests.
           test-output  ---> testng-failed.xml



	
Step:34 POM.XML file add two plugins and dependenices
	                  1) maven compiler plugin
                          2) maven surefire plugin

========================================================================================================
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>OpenCart</groupId>
  <artifactId>OpenCart</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  
  
  <build>
	  
    <pluginManagement>
		
      <plugins>
		  
	        <plugin>
				
	          <groupId>org.apache.maven.plugins</groupId>
	          <artifactId>maven-compiler-plugin</artifactId>
	          <version>3.11.0</version>
	          <configuration>
	            <!-- put your configurations here -->
	          </configuration>
	          
	        </plugin>
        
      
	         <plugin>
	          <groupId>org.apache.maven.plugins</groupId>
	          <artifactId>maven-surefire-plugin</artifactId>
	          <version>3.1.2</version>
	          
	          <configuration>
	                <suiteXmlFiles>
			    <suiteXmlFile> mastertestng.xml</suiteXmlFile>
			</suiteXmlFiles>
		   </configuration>
	        </plugin>
        
      </plugins>
      
    </pluginManagement>
    
  </build>
  
  
  <dependencies>
	  
			  <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
		<dependency>
		    <groupId>org.seleniumhq.selenium</groupId>
		    <artifactId>selenium-java</artifactId>
		    <version>4.12.1</version>
		</dependency>

	  
				<!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
		<dependency>
		    <groupId>io.github.bonigarcia</groupId>
		    <artifactId>webdrivermanager</artifactId>
		    <version>5.5.3</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
		<dependency>
		    <groupId>org.apache.poi</groupId>
		    <artifactId>poi</artifactId>
		    <version>5.2.3</version>
		</dependency>


		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
		<dependency>
		    <groupId>org.apache.poi</groupId>
		    <artifactId>poi-ooxml</artifactId>
		    <version>5.2.3</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
		<dependency>
		    <groupId>org.apache.logging.log4j</groupId>
		    <artifactId>log4j-core</artifactId>
		    <version>3.0.0-alpha1</version>
		</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
		<dependency>
		    <groupId>org.apache.logging.log4j</groupId>
		    <artifactId>log4j-api</artifactId>
		    <version>3.0.0-alpha1</version>
		</dependency>

	<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
	<dependency>
	    <groupId>commons-io</groupId>
	    <artifactId>commons-io</artifactId>
	    <version>2.13.0</version>
	</dependency>

		<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
	<dependency>
	    <groupId>org.apache.commons</groupId>
	    <artifactId>commons-lang3</artifactId>
	    <version>3.13.0</version>
	</dependency>
	
		<!-- https://mvnrepository.com/artifact/org.testng/testng -->
	<dependency>
	    <groupId>org.testng</groupId>
	    <artifactId>testng</artifactId>
	    <version>7.8.0</version>
	    <scope>test</scope>
	</dependency>

	<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
	<dependency>
	    <groupId>com.aventstack</groupId>
	    <artifactId>extentreports</artifactId>
	    <version>5.1.0</version>
	</dependency>

		
  </dependencies>
</project>

Step:35   Maven in two ways
               1) one plugin dy default in eclipse(within eclipse use it)
               2) like os in outside of eclipse(without eclipse use it)
========================================================================================================
https://maven.apache.org/download.cgi
Download ---- after exact here folder ---- put in c drive 
C:\apache-maven-3.9.4(copy the path)
This PC --- go properties --- advanced system settings
Environment variables ---- New ---- varaible name : MAVEN_HOME  ,varaible value: C:\apache-maven-3.9.4
then ok 
select the path ---- Edit--- New ----%MAVEN_HOME%\bin--ok
Open the commadpormat (cmd) ---- mvn -version (type it)
it show 3.9.4 which version in our pc.

Step:36   How to run the pom.xml using the cmdpormat?
========================================================================================================
Project folder ----- right click ---- go to properites ---resource ----- copy the path.
C:\Users\win\eclipse-workspace\OpenCart(project location)
Open the cmdpormat
cd C:\Users\win\eclipse-workspace\OpenCart
After mvn test

Step:37   Create bat file
========================================================================================================
Project Folder --- right click --- new --- file ---- run.bat(create)
run.bat ---- open with text editor ---- after add below 2 lines
cd C:\Users\win\eclipse-workspace\OpenCart
mvn test
After Go to project folder location ---- run.bat ---- double click on bat file --- it will automatically start ….

Git install(Local repository) ------git
Remote/Global repository-------github(github account create)

Step:38   Github workflow
========================================================================================================
working directory:  C:\Users\win\eclipse-workspace\OpenCart

1st round
-----------
1) git init  --- create an empty local repository 
2) git config --global user.name "your name"
   git config --global user.email "your email"
3) git add -A   --- add all the files and folders to staging area
 git add filename.txt
 git add *.java
 git add foldername
git status
4) git commit -m "commit msg"
5)  git remote add origin "github URL"
6) git push -u origin master

2nd round
--------------
1) git add -A
2) git commit -m "commit msg"
3) git push -u origin master

Change the reportory
------------------------
git remote -v 
git remote set-url origin https://github.com/pradeepyalamasetti/Opencartselenium.git

How to get code from remote reportory
---------------------------------------
git pull   -- get files from github to workspace

clone - get entire project into your workspce
git clone "github repo url"  <folder> <br>
Git tutorials: https://youtube.com/playlist?list=PLUDwpEzHYYLuMNNTu0EdWBeBtXdRhj4Lv

how to delete complete reporsitory in github repository
how to delete file in github repository
how to add file in github repository

Step:39  Install in jenkins and configuration git,maven,JDK
========================================================================================================
https://www.jenkins.io/download/
download jenkins 85.0mb size
Create one folder for Jenkins --- paste jenkins.war
open the cmdpmt
cd C:\Jenkins
java -jar jenkins.war
Running with Java 20 from C:\Program Files\Java\jdk-20, which is not yet fully supported.
Run the command again with the --enable-future-java flag to enable preview support for future Java versions.
Supported Java versions are: [11, 17]
See https://jenkins.io/redirect/java-support/ for more information.
C:\Program Files\Java\jdk-20
C:\Program Files\Java\jdk-17.0.8
open links------ http:localhost:9090
C:\ProgramData\Jenkins\.jenkins\secrets\initialAdminPassword
4d028c63adaf4319b7a439df14990b46
install suggested Plugins(all) --- 5min wait

username : admin
pswd :admin

1.Manage jenkins ---go plugins ----- available--- search(maven integeration,git,github)
2.Dashboard→Manage Jenkins→ tools 
         JDK ---- name(Java)-----Java_home(path C:\Program Files\Java\jdk-17.0.8)

         GIT ---name(mygit) ----path_to_git(path C:\Program Files\Git\bin\git.exe)

         Maven ----- name(mymaven) ----MAVEN_HOME(path C:\apache-maven-3.9.4)
Finally Save and apply ……………

https://github.com/pradeepyalamasetti/Opencartselenium.git
Enter the name(OpencartseleniumGit) ------ select Maven project -----ok 

soucre code management ---- select radio button Git ----- repository URL(paste urlg from github)

Build ---- show (pom.xml)  ----Goals and options(test)
Save 

Go to Dashboard ---- click on OpencartseleniumGit ----Build Now

Enter the name(OpencartLocal) ------ select Maven project -----ok 

soucre code management ---- select None Git -----
Build ---- Root POM(pom.xml  total path(C:\Users\win\eclipse-workspace\OpenCart\pom.xml))  ----test
Apply and save.

Step:40  TC_004_SearchProductTest
	 HomePage.java,SearchPage.java,TC_004_SearchProductTest.java
========================================================================================================

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement lnkMyaccount;

	@FindBy(linkText = "Register")
	WebElement lnkRegister;

	@FindBy(linkText = "Login")   // Login page Locator added 
	WebElement linkLogin;
	
	@FindBy(xpath="//input[@placeholder='Search']")  //For Search Product Test
	WebElement txtSearchbox;
	
	@FindBy(xpath="//div[@id='search']//button[@type='button']") //For Search Product Test
	WebElement btnSearch;
	
	
	// Action Methods
	public void clickMyAccount() {
		lnkMyaccount.click();
	}

	public void clickRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin()    // Login page method added 
	{
		linkLogin.click();
	}
	
	public void enterProductName(String pName)   //For Search Product Test
	{
		txtSearchbox.sendKeys(pName);
	}
	
	public void clickSearch()  //For Search Product Test
	{
		btnSearch.click();
	}
	
}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage
{   
	WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}	
	
		@FindBy(xpath="//*[@id='content']/div[3]//img")
		List<WebElement> searchProducts;
				
		@FindBy(xpath="//input[@id='input-quantity']")
		WebElement txtquantity;
		
		@FindBy(xpath="//button[@id='button-cart']")
		WebElement btnaddToCart;
		
		@FindBy(xpath="//div[contains(text(),'Success: You have added')]")
		WebElement cnfMsg;
		
		public boolean isProductExist(String productName)
		{
			boolean flag=false;
			for(WebElement product:searchProducts)
			{				
				if(product.getAttribute("title").equals(productName))
				{
				flag=true;
				break;
				}
			}
			
			return flag;
		
		}
		
		public void selectProduct(String productName)
		{
			for(WebElement product:searchProducts)
			{				
				if(product.getAttribute("title").equals(productName))
				{
					product.click();
				}
			}
		
		}
		
		public void setQuantity(String qty)
		{
			txtquantity.clear();
			txtquantity.sendKeys(qty);
		}
		
		public void addToCart()
		{
			btnaddToCart.click();
		}
		
		public boolean checkConfMsg()
		{
			try
			{
			return cnfMsg.isDisplayed();
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

@Test
public class TC_004_SearchProductTest extends BaseClass {

	public void test_pruductSearch() throws InterruptedException {
		logger.info(" Starting TC_004_SearchProductTest ");

		try {
			
			HomePage hm=new HomePage(driver);
			
			//hm.enterProductName("iPhone");
			hm.enterProductName("mac");
			
			hm.clickSearch();
			
			SearchPage sp=new SearchPage(driver);
			sp.isProductExist("MacBook");

			Assert.assertEquals(sp.isProductExist("MacBook"),true);

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_004_SearchProductTest ");

	}
}

Step:41  TC_004_SearchProductTest
	 HomePage.java,SearchPage.java,TC_004_SearchProductTest.java
========================================================================================================
