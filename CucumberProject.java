Step:1
==============================================================================================================
what is different between TDD and BDD?

TDD - Test Driven Development
Ex: TestNG, junIT

BDD - Behavioral Driven Development
Ex: Cucumber


3 files
1) Feature file  - gherkin launguge(Given, when, and, then etc..)
Scenarios
steps
2) step definitions ------- contains implenments(techical people will be understamd)
3) testRunner (Junit class)

Feature File--> Scenarios---> steps

Create New Maven Project 
Right Click ---- New ---- Project -- Maven ---- Maven project ---- create simple project --- Project id name (two times) --- finish

Adding Dependenics
cucumber-java dependencis
cucumber-juint dependencis
add all others before
pox.xml ------- right click --- Maven --- update project and refresh

In your elliscpe ---go to help -- elliscpe Marketplace  ----cucumber elliscpe plugin --- installed
In your elliscpe ---go to help -- elliscpe Marketplace  ----Natural 0.9  --- installed

Create Features
Right click on --- Features folder ---- New -- file ---xyz.feature(example) extension --- feature


	
Step:2  Create Features package under Create the feature Login file ---- Login.feature

	Note : - One Features file contains multiple Scenarios 
==============================================================================================================
Right click on --- Features folder ---- New -- file ---- Login.feature(example) extension --- feature
                    Run As --- Cucumber Feature
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Feature: Login with Valid Credentials

@sanity
  Scenario: Successful Login with Valid Credentials
    Given User Launch browser
    And opens URL "https://tutorialsninja.com/demo/"
    When User navigate to MyAccount menu
    And click on Login
    And User enters Email as "pradeepkumar@gmail.com" and Password as "pradeep@123"
    And Click on Login button
    Then User navigates to MyAccount Page

	

Step:3  Create stepDefinitions package  under Create steps.java class add this code
==============================================================================================================

Step:4  Total all Files ready after that do 
==============================================================================================================

Step:4  Project Running all Platforms 
==============================================================================================================
Features  contains ~~~~~~~~~~ scenarios
Steps cotains ~~~~~~~logic and implementing code ~~~~~~~scenarios all Methods() is there.checking here
Testrunner ~~~~~~~~~~ Run the file using testrunner

dryRun=false, // coresponding method is avaliable then run the porgram
dryRun=ture, // coresponding method is avaliable or not show in console true or false

Run with failure tests
======================
Note only Failure tests ---------Go to target folder ---- rerun.txt --- enable  @target/rerun.txt 

Run with grouping tests
=======================
#grouping means in cucumber is "tags"
#@sanity @regression

Run with pom.xml test
=====================
Go to Pom.xml file (in plugins remove configuation tag)----- then save --- right click in pom.xml file
 ---- Run As ----- Maven test

BUILD SUCCESS  in POM.XML file

Run with commandpropmt  test
============================
Open the cmdprt ---- check mvn -version ----- project folder ---- right click ---properties ---- 
copy the path(C:\Users\win\eclipse-workspace\CucumberProject)  ----- cd copy the path -----then mvn test

BUILD SUCCESS  in CommandPropmt 

Project add github 
===================
copy the path :  C:\Users\win\eclipse-workspace\CucumberProject
C:\Users\win\eclipse-workspace\CucumberProject  --- open this location --- right click --- git Bash here
steps 
git init
git add -A
git commit -m "first commit"
Before Push ------ git repository create in github repository  link to copy 
Github link : https://github.com/pradeepyalamasetti/CucumberProject.git
git remote add origin "https://github.com/pradeepyalamasetti/CucumberProject.git"
git push -u origin master

After local to remote repository that Project add github 
Run with Jenkins
====================================================================
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Don’t consider this
Open the cmdprt
path the jenkins path(C:\Jenkins)
C:\user\win>cd ..
C:\>cd C:\Jenkins
C:\Jenkins>java -jar jenkins.war
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
Consider this
open the Jenkins --- New item ------- Project name given(CucumberProject_github )---- 
select Maven project ------ok ---- select git --- paste github url(https://github.com/pradeepyalamasetti/CucumberProject.git)
 ---- go build given ---test ---- Apply and save ------Go to Dashborad --- open the project --- Build Now


