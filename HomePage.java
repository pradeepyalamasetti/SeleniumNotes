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
