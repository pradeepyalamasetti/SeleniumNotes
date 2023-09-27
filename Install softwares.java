Create Oracle account -------------(in 3days)
java -version -------------------- (cmd check)
git -v --------------------------- (cmd check)
Create Github account  ------------(username and pswd)
mvn -version --------------------- (cmd check) (apache-maven-3.9.4)



1.Install Java using this link
=====================================================================================================
vedios : https://www.udemy.com/course/learn-selenium-with-java-live-project/learn/lecture/34764504#content
https://www.oracle.com/java/technologies/downloads/#java11-windows
  
Download & Install Java
-------------------------------
step1) downlaod & install JDK
       create account in Oracle.then after you can download exe file in 3 days
	i am java.exe file in software folder.

step2) set jdk path 
JAVA_HOME ~~~~~~ C:\Program Files\Java\jdk-11
path ~~~~~~ C:\Program Files\Java\jdk-11\bin

Right click This PC --> properties-->Advanced system settings
-->Environemnt varaibles button-->system variables
-- select path varaible--> click on EDIT
--> Click on New button-paste your JDK Path.

step3) open command prompt
	java -version

2.Install Eclipse and run
=====================================================================================================
https://www.eclipse.org/downloads/packages/
	

2.Setup Webdriver in Eclipse
=====================================================================================================
1) Selenium client Library
2) Browser Specific drivers
3) Browsers (chrome, edge, firefox...)

Manual testing
-----------------------------------
In your system 3Dots --- help ----- About Google CHrome ---Check Version 117.0.5938.92 (Official Build) (64-bit)
Go Selenium website  ---- downloads ---- browsers ------ chrome --- documentation ----- older version(somethings is wrong)
	
Steps
-----
1) Create Maven project in Eclipse
	File--> Other--> Maven project.(or)
	Right Click ---- New ---- Project -- Maven ---- Maven project ---- 
	create simple project --- Project id name (two times) --- finish




	
3.Setup POM.XML file ----- plugins and dependencies
=====================================================================================================
First Create the Pom.xml file some line of code is come automatically after that you can added dependencies and plugins
	otherwise you face issuse
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>CucumberProject</groupId>
  <artifactId>CucumberProject</artifactId>
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
	          
	    <!-- <configuration>
	                <suiteXmlFiles>
				          <suiteXmlFile> mastertestng.xml</suiteXmlFile>
			         </suiteXmlFiles>
			   </configuration>-->
	        </plugin>  
      </plugins>
      
    </pluginManagement>
    
  </build>
  
  
  <dependencies>
	  
			  <!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
		<dependency>
		    <groupId>io.cucumber</groupId>
		    <artifactId>cucumber-java</artifactId>
		    <version>7.14.0</version>
		</dependency>
		
				<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
		<dependency>
		    <groupId>io.cucumber</groupId>
		    <artifactId>cucumber-junit</artifactId>
		    <version>7.14.0</version>
		    <scope>test</scope>
		</dependency>


	  
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

	
3.Setup maven.apache.org
=====================================================================================================
https://maven.apache.org/ ------- Downloads --------- zip file for windows ----- C:\software\apache-maven-3.9.4
This PC ------ properties properties ---- Advance system settings --- environment variables -----
MAVEN_HOME ----C:\software\apache-maven-3.9.4 ---- ok ------ path file ---- Edit ---- paste(%MAVEN_HOME%\bin)----ok
	
