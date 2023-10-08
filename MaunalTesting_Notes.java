1. What is Manual Testing?
Ans. Manual Testing is a kind of software testing in which a software tester develops and executes the test cases without using any automated testing tools.
     
2. What tool is used for Manual Testing?
Ans. Manual testing tools such as Bugzilla, JIRA, JMeter, and many more.
     
3. What is the Advantage of Manual Testing?
Ans. 1.Manual testing can be done on all kinds of applications.
     2.Application must be tested manually before it is automated.
     3.It allows tester to perform adhoc testing.
     4.It is preferred in the projects where the requirements change frequently and for the products where the GUI changes constantly.
     
4. What are the disadvantages of Manual testing?
Ans. 1.time-consuming
     2.More number of human resource are required.
     3.Repeating the same task again and again is almost impossiable.
     
5. Will manual testing end in the future?
Ans. No,It will never going to happened because After compeleting Manual testing we will go with automation testing.
     
6. What is Regression Testing?
Ans. Regression testing is the process of retesting the software apllication to ensure that new code changes have not affected existing functioanlities.
     
7. How do you decide on test cases for the regression suite?
Ans. Which ever the repetitive test cases ,we can add that test cases for regression suite.
     For example:
     In Frame work level multiple user can login.So here we will check with different data will be having different logins.
8. How do you find the regression scenarios if a defect is fixed?
Ans. By Requirement Traceability Matrix is used for the impact analysis. RTM tells you the relationship between the features.
     Once you had done retesting after a bug fixes, you need to identify the other affected areas then execute their test cases. 
     Similarly, once there is a new feature added check the affected area and execute the already written test cases for the affected areas.
     
9. You have 20 bugs, and you need to fix them as well as you need to run the regression. You are the only
   two people in a team. How will you do it, and which one will you prioritise?
Ans. Which bugs will come under regression test that we will be testing according to the priority.And Two people we will sharing equally.
     
10. Difference between Regression and retesting?
Ans. Regression:
     1.It is know as generic testing.
     2.Regression testing is the process of retesting the software apllication to ensure that new code changes have not affected existing functioanlities.
     3.It takes more time in performing regression testing as it explore the whole application.
     Re-testing:
     1.It is know as planned testing.
     2.Testing again and again to make sure the defect has been fixed or not.
     3.It take less time as it focus only on defect of the application.
----->If you want we can give examples for both.
     
11. If you have a situation like need to execute all test cases under the project for regression before
release, how you can manage the situation?
Ans. Splitting the test cases with the team.
     In regression test we will be testing all the approches like top-down approach,bottom-up approach.
     we can check random approach by checking integration test.

12. What is Smoke Testing?
Ans. 1.Smoke testing performs on initial build.
     2.smoke testing is done to assure that the acute fucntionalities of program is working fine.
     
13. What is Sanity testing?
Ans. 1.Sanity testing is done on stable build or for introduced new features in software.
     2.sanity testing is done to check bugs have been fixed after the build.
     
14. What is the Sanity Test, Adhoc Testing & Smoke Testing? When will you use the Above Tests?
Ans. Smoke testing:
     smoke testing is used to test all over function of the system.
     Sanity testing:
     sanity testing is used in the case of only modified or defect fucntions of the system.
     Adhoc testing:
     Adohc testing is used when we don't have documentation.
     
15. Difference between smoke and sanity?
Ans. Smoke testing:
     1.It is also called as subset of accetance testing.
     2.smoke testing is done to assure that the acute fucntionalities of program is working fine.
     3.smoke testing is used to test all over function of the system.
     4.Smoke testing performs on initial build.
     5.It is performed by both testers and developer.
     Sanity testing:
     1.It is also called as subset of regression testing.
     2.sanity testing is done to check bugs have been fixed after the build.
     3.sanity testing is used in the case of only modified or defect fucntions of the system.
     4.Sanity testing is done on stable build or for introduced new features in software.
     5.It is performed by only testers.
     
16. How do you decide on the test case for the smoke test suite?
Ans. what ever the test cases are in initial build we will called it as smoke suite.
     
17. What is Functional Testing?
Ans.Checking how the software working as per functional requirement document.
18. What is functional testing and types of functional testing?
Ans.Functional testing:
    Checking how the software working as per functional requirement document.
    Types of testing:
    1.Field Display
    2.Business logic
      --1.Business logic positive
     ---2.Business logic negative
    3.End to End Flow.
    4.Data validation.
     
19. What is the defect life cycle?
Ans. New: When a new defect is logged and posted for the first time. It is assigned a status as NEW.
     Assigned: Once the bug is posted by the tester, the lead of the tester approves the bug and assigns the bug to the developer team
     Open: The developer starts analyzing and works on the defect fix
     Fixed: When a developer makes a necessary code change and verifies the change, he or she can make bug status as “Fixed.”
     Pending retest: Once the defect is fixed the developer gives a particular code for retesting the code to the tester. Since the software testing remains 
     pending from the testers end, the status assigned is “pending retest.”
     Retest: Tester does the retesting of the code at this stage to check whether the defect is fixed by the developer or not and changes the status to “Re-test.”
     Verified: The tester re-tests the bug after it got fixed by the developer. If there is no bug detected in the software, then the bug is fixed and the status 
     assigned is “verified.”
     Reopen: If the bug persists even after the developer has fixed the bug, the tester changes the status to “reopened”. Once again the bug goes through the 
     life cycle.
     Closed: If the bug is no longer exists then tester assigns the status “Closed.” 
     Duplicate: If the defect is repeated twice or the defect corresponds to the same concept of the bug, the status is changed to “duplicate.”
     Rejected: If the developer feels the defect is not a genuine defect then it changes the defect to “rejected.”
     Deferred: If the present bug is not of a prime priority and if it is expected to get fixed in the next release, then status “Deferred” is 
     assigned to such bugs.
     Not a bug: If it does not affect the functionality of the application then the status assigned to a bug is “Not a bug”.

20. What is the software development life cycle(SDLC)?
Ans. 1.Requirement Analysis:
     In this phase,the project team members will be gather and they analysis the requirement i.e,what software should do and what features it should have.
     2.Design:
     In this phase,the system architecture and design are crearted.It invloves high-level architecture.
     3.Implementation:
     In this phase,Developer will write the code according to the requirement and design specification.
     4.Testing:
     In this phase,Tester will be identify defects,verify that it meets the specified requirement or not.
     5.Deployment:
     In this phase,once software testing is done and it ready for production.
     
21. What is the software testing life cycle(STLC)?
Ans. 1.Requirement Analysis: Requirement Analysis is the first step of the Software Testing Life Cycle (STLC). In this phase quality assurance team understands 
     the requirements like what is to be tested.
     2.Test Planning: Test Planning is the most efficient phase of the software testing life cycle where all testing plans are defined. In this phase manager 
     of the testing, team calculates the estimated effort and cost for the testing work. This phase gets started once the requirement-gathering phase is completed.
     3.Test Case Development: The test case development phase gets started once the test planning phase is completed. In this phase testing team notes down 
     the detailed test cases. The testing team also prepares the required test data for the testing. When the test cases are prepared then they are reviewed 
     by the quality assurance team.
     4.Test Environment Setup: Test environment setup is a vital part of the STLC. Basically, the test environment decides the conditions on which software is
     tested. This is independent activity and can be started along with test case development. In this process, the testing team is not involved. 
     either the developer or the customer creates the testing environment.
     5. Test Execution: After the test case development and test environment setup test execution phase gets started. In this phase testing team starts
     executing test cases based on prepared test cases in the earlier step.
     6.Test Closure: Test closure is the final stage of the Software Testing Life Cycle (STLC) where all testing-related activities are completed and documented. 
     The main objective of the test closure stage is to ensure that all testing-related activities have been completed and that the software is ready for release.

22. In which phase of SDLC, your work starts?
Ans.Testing
23. You find the existing testing process is not up to mark in your current organisation. How will you approach your manager to bring changes?
Ans.First fall i will go through all the documentation and screen short.I will grather all the information and i will explain the problem to the manager 
     what wrong in the testing process.
     
24. Explain testing process followed by your company?
Ans. 1.In my organization we will be having KT's on that particular project by onsite team by daily basis on coference call's and we will be getting BRD's 
     we will go through that and depending on the BRD doc's and usecases we will be finding test scenario's.
     2.On the other part high level management(PM, TL) they will start preparing Test plan.when the Test plan review and sign off done by client the
     other side we will be finishing for Test scenario's.These scenarios's will be reviewed by our track lead and depending on his comments 
     we will do modifications.
     3.Then after RTM (Requirement Tracebility matrix) is done for Test scenarios'. Here we will check whether we have covered all the scenarios for the 
     requirements(every requirement will be having unique ID (for ex: i.e: 2.1.3))this is called maping the requirements.
     4.Then after we start writting test cases. after TL review and signoff will start executing test cases when the buil is deployed in stage environment 
     (there 3 environments: dev-for developers, stage- for testing, production- client side.).
     5.In execution stage will be doing smoke testing, system testing. when ever we find bug's will log through Quality center and post that bug to developer's. 
     when the fix is done on that bug it will reflect in the next build. first will do Re-testing. if the bug is really fixed then put the status 
     as closed if not re-open it and resend it to developer.
     6.Then will do Regression Testing(means Rigourously test) the application thoroughly to ensure that fix doesn't have any impact on the other functionalities.
     7.when all the defects get closed and 100% execution is completed then UAT (User Acceptance Test )is done and get signoff from business and approval 
     to deploy it in production environment (client side). Thus our job is finished. after sucessful go live. 
     
25. What is the Test design technique you used in your organisation like error guessing, Equivalence partition, Boundary value analysis?    
Ans.Mostly i used error guessing
     1.error guessing is find bugs based on tester's prior experience.
     2.we don't follow any specific rules.
     3.It depends on tester's analytical skills and experience.
     
26. Apart from the RTM, how do you ensure that your Test Design coverage is optimum?
Ans. Bu using test Design techniques are
     1.Boundary Value Analysis (BVA)
     2.Equivalence Partitioning (EP)
     3.Decision Table Testing
     4.State Transition Diagrams(STD)
     5.Test coverage.
     
27. Explain Test Design Techniques
Ans. 1.Boundary Value Analysis (BVA):
     Boundary Value Analysis (BVA) identifies errors at the input domain’s boundary. A simple example of boundary value analysis would be testing a text box 
     that requires the user to enter a number between 1 and 10. In this case, the boundary values would be 1 and 10, and we would test with values that are 
     just above, at, and just below these boundaries.
     For example, 
     we would test with 0, 1, 2, 9, 10, and 11. We can expect that errors or defects are most likely to occur at or near the boundary values. 
     Identifying these issues early can help prevent them from causing problems later in the software development process.
    2.Equivalence Partitioning (EP):
     Equivalence Partitioning (EP) is another technique that helps reduce the required test cases. By partitioning test input data into classes with 
     an equivalent number of data, one can design test cases for each class or partition. This technique ensures that one thoroughly tests the software 
     while minimizing the required test cases.
     For example, 
     if a program requires an input of numbers between 1 and 100, an EP test would include a range of values, such as 1-50 and 51-100, and numbers outside 
     that range, such as -1 or 101. Testing one value from each partition is sufficient to test all values within that partition.
    3.Decision Table Testing:
     Decision Table Testing is a technique that involves designing test cases based on decision tables formulated using different combinations of inputs 
     and their corresponding outputs based on various conditions and scenarios sticking to other business rules. This technique ensures that we test the 
     software thoroughly and accurately.
     For example,
     if a program offers discounts based on the type of customer and the amount spent, a decision table would list all possible combinations of customer 
     types and the amount paid to receive a discount. Each cell in the table would specify the value that should be applied. Testers can ensure the program
     behaves correctly under various scenarios by testing all combinations.
   4.State Transition Diagrams(STD):
     State Transition Diagrams(STD) to test software with a finite number of states of different types. A set of rules that define the response to various
     inputs guides the transition from one state to another. This technique is handy for systems with specific workflows within them.
     For example,
     consider an e-commerce website that has different states such as “logged out,” “logged in,” “cart empty,” “cart not empty,” and “order placed.” 
     The transitions between the states would be triggered by login in and logout, adding the product to the cart, removing the product from the cart,
     proceeding to checkout, etc. An STD can help visualize and test such complex states and transitions in a system.

28. What levels of Testing have you worked on?
Ans. system level and system integration level.
     
29. What is Unit Testing?
Ans. 1.unit testing is performed by the developer.
     2.we are going to test each and every individual module.
     3.it is also called as white -box testing.
     
30. What is Integration testing?
Ans. 1.performed by developer
     2.integration testing is combined the individual modules.
     3.it is aslo called as white box testing.
     
31. What is the difference in writing the test cases for Integration testing and system testing?
Ans. System testing is a type of software testing in which a software product is tested as a whole for the validation of 
     its functional and non-functional requirements, 
     whereas integration testing is a testing in which a software product is tested for the interfacing between its different modules that 
     are interlinked with each other.

32. Difference between Unit and Integration Testing?
Ans. In unit testing, each module of the software is tested separately. In integration testing, all modules of the software are tested combined.
     
33.What is User Acceptance Testing?
Ans. checking software working as per business requirement documment.
     
34. Explain UAT?
Ans. UAT- User Acceptance Testing
     1.checking software working as per business requirement documment.
     2.User Acceptance Testing (UAT) is the final stage of any software development or change request lifecycle before go-live.
     
35. What is a defect?
Ans. variation between actual result and expected result.
     
36. What is a Latent defect?
Ans. Latent defect is a type of bug which has been residing in current version software application & was not caught in previous releases of the application.
     Mostly, these types of bugs are unexpected outcome of any corner/edge case scenarios which was executed with some specific set of test data.

37. The difference between bug, defect, and fault?
Ans. bug:
     find any mismatch in the application in testing phase.
     defect:
     variation between actual result and expected result.
     fault:
     fault is an error or defect in a program that causes it to produce incorrect or unexpected results. 
     
38. What are must present fields while raising a defect?
Ans. A defect report consists of Defect ID,Defect Description,Version,Action Steps,Expected Result,Actual Result,Severity,Assigned to.
     
39. What are the steps to reproduce while logging a defect?
Ans. Logging a defect, also known as a bug report or issue report, is an essential part of software testing. 
     Clear and detailed defect reports help developers understand and fix issues efficiently. 
     Here are the steps to reproduce while logging a defect in software testing:
     1.Understand the Issue:
        Before logging a defect, ensure that you thoroughly understand the problem you've encountered. 
        Reproduce the issue on your end to confirm its existence and gather as much information as possible. 
        This includes understanding what the expected behavior should be.
     2.Access the Application:
       Access the software application or system where the defect was observed. 
       Use the appropriate login credentials or access paths to replicate the issue.
     3.Prepare the Test Environment:
       Ensure that the test environment is set up correctly. 
       Make sure all necessary software, hardware, and configurations are in place to reproduce the defect accurately.
     4.Use the Exact Test Data:
       Input the same data and conditions that triggered the defect originally. 
       This includes any specific inputs, configurations, or data files necessary to reproduce the issue.
     5.Record the Steps:
       Document the exact steps you take to reproduce the defect. 
       Be precise and clear in your descriptions, providing all necessary details to make it easy for the developer to follow your steps.
     6.Include the Environment Details:
       Note the environment details such as the operating system, browser version, hardware specifications, and any relevant software versions. 
       These details can be crucial for reproducing and diagnosing the issue.
     7.Capture Screenshots or Recordings:
       If applicable, take screenshots or screen recordings to visually demonstrate the defect. 
       Visual evidence can be very helpful for developers to understand the problem quickly.
     8.Provide Logs and Error Messages:
       If the application generates error messages or logs, include these in your defect report. 
       These messages can contain valuable information for identifying the root cause.
     9.Specify the Expected and Actual Behavior:
       Clearly state what the expected behavior should be, based on the requirements or design, and describe the actual behavior you observed.
       Highlight the discrepancy between the two.
     10. Assign Severity and Priority:
        Assign a severity level to the defect (e.g., critical, major, minor) based on its impact on the system or users. 
        Assign a priority (e.g., high, medium, low) based on its importance in the current context.
     11.Attach Relevant Files:
        If there are any files, documents, or additional resources related to the defect, attach them to the report for reference.
     12.Submit the Defect Report:
        Using the defect tracking or issue management system in your organization, submit the defect report. 
        Be sure to fill in all required fields and provide all the information you've gathered.
     13.Communicate Clearly:
        If needed, communicate with developers, product managers, or other stakeholders to ensure that they understand the defect and its impact.
     14.Follow Up:
        Monitor the status of the defect and participate in discussions related to it. Be prepared to provide additional information or 
        clarify details if requested.
     15.Verify the Fix:
        Once the developer resolves the defect, verify the fix by following the same steps to reproduce it. 
       If the issue is resolved, close the defect report. If not, reopen it with additional information as necessary.

By following these steps, you can create clear and actionable defect reports that facilitate efficient defect resolution in the software development process.
40. What are defect tracking tools?
Ans. 1.SpiraTeam	
     2.Jira Software	
     3.BugHerd	
     4.Zoho Projects

41. What is a blocker defect?
Ans. when they occur tester is not able to test the software further. 
     For example :
     if in an application user can perform any function after the login. 
     If login function is not working then tester is not able to test any further feature in this application.

42. How do you log the defects in your project?
Ans. Defects are logged in a defect tracking system, along with details such as description, severity, and priority.
43. Difference between bug, error, and defect?
Ans. bug:
     find any mismatch in the application in testing phase.
     defect:
     variation between actual result and expected result.
     error:
     while writing the code we will be getting error.
     
44 . If you have executed 100 test cases, every test case passed but apart from these test cases you found some defect for which the test case is
not prepared, then how can you report the bug?
Ans.
45 . What is a Deferred Defect?
Ans. if the developer feels that the defect is not of very important priority and it can get fixed in the next releases or 
     so in such a case, he can change the status of the defect as 'Deferred'.
     
46 . What is meant by defect triage calls?
Ans. Defect triage is a process to prioritize the defects based on severity, risk, frequency of occurrence.
     
47. What if some defects are not fixed in the current sprint?
Ans. If multiple bugs are found and cannot be fixed in the current sprint, then some of them should be carried over to the following sprint.
     
48. Why does the UAT team usually find defects even when you have completed System
    Testing & signed off?
     its wrong question itseems.
     question may be
     What are the causes of defects in user acceptance testing (UAT)?
Ans.In user acceptance testing (UAT), a defect is a problem or discrepancy between the actual behavior of the software and the expected behavior defined in 
     the requirements. Defects can be identified during UAT when the software is tested by end-users to ensure that it meets their needs and requirements.
     Examples of defects in UAT include:
     Incorrect functionality: The software does not perform the intended function as specified in the requirements.
     User interface issues: The software does not meet the user interface standards and is difficult to use.
     Performance issues: The software does not perform well under normal usage conditions, such as slow response times, crashes, or errors.
     Incomplete or missing functionality: The software does not include all the features specified in the requirements.
     Inconsistent behavior: The software behaves differently in different situations, making it difficult for users to understand how to use it.
     Security vulnerabilities: The software has security weaknesses that could be exploited by malicious actors.
     It is important to identify and address defects during UAT so that the software can be improved and refined before it is released to the end-users. 
     This helps to ensure that the software meets their needs and requirements and provides them with a positive user experience.
     
49. What do you do if a Defect is not reproducible?
Ans. If the bug is not reproducible, then the testing effort used in finding, analyzing and reporting that particular bug/defect is a total waste.
     For understanding and reproducing a bug, it is essential to have detailed and properly explained 'Steps to Reproduce', state and environment 
     in which the bug occurred.
     
50. Explain Defect template?
Ans. 1. Defect ID:
        A unique identification number is used to identify the number of defects in the report.
     2. Defect Description:
        A detailed description is written about the defect with its module and the source where it was found. 
     3. Version:
       Show the current version of the application where the defect was found. 
     4. Action Steps:
       It shows the step-by-step action taken by an end user or QA testers that shows results as the defect.    
     5. Expected Result:
       Also, QA testers need to identify & show the expected result if everything goes accordingly without any defects, which allows 
       developers to know the end goals to achieve. It’s a detailed step-by-step explanation of the expected result. 
     6. Environment:
       Sometimes the test environment plays a significant role in defects like running applications on different smartphones.
       While creating a defect report, this template can be used: 
          Device Type: Hardware & device model
          OS: Name & version
          Tester: Name the tester who finds defects
          Software Version: The software version which will be tested
          Connection Strength: (3G, 4G, 5G, WiFi)
          Rate of Reproduction: Number of times the defect has been reproduced
     7. Actual Result:
        It covers the results of performing the steps that developers want to achieve. Also, add “Additional details” like defects, sources, 
        and specific steps so developers can navigate and resolve more effectively.
     8. Severity:
        It describes the impact of the defect on the application. Each defect has a different severity level, and it’s important to note it in detail.
         Levels of Severity: 
          Low: These bugs can be resolved once and don’t affect the performance again.  
          Medium: Some minor defects that are easy to resolve and affect less. 
          High: These bugs can affect the result of the application and need to be resolved. 
          Critical: In the critical stage, bugs heavily affect the performance and end goal. Like crashing, system freezing, and restarting repeatedly.
     9.screen shot:
       attach screen shot.
     
51. What is the typical defect you raised in your project? 
Ans.
     
52. What is defect density?
Ans. Divide the total defects by total lines of code.
     For example: if you had 5 defects and 1,000 lines of code.You would divide 5/1000=0.005 is the result.








