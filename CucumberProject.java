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
package stepDefinitions;

import io.cucumber.java.en.*;

public class steps {
	@Given("User Launch browser")
	public void user_launch_browser() {
	    
	}

	@Given("opens URL {string}")
	public void opens_url(String string) {
	    
	}

	@When("User navigate to MyAccount menu")
	public void user_navigate_to_my_account_menu() {
	   
	}

	@When("click on Login")
	public void click_on_login() {
	    
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String string, String string2) {
	    
	}

	@When("Click on Login button")
	public void click_on_login_button() {
	   
	}

	@Then("User navigates to MyAccount Page")
	public void user_navigates_to_my_account_page() {
	   
	}

}

