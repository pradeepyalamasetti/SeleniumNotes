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
Ans.
     
22. In which phase of SDLC, your work starts?
Ans.Testing
23. You find the existing testing process is not up to mark in your current organisation. How will you approach your manager to bring changes?
Ans.First fall i will go through all the documentation and screen short.I will grather all the information and i will explain the problem to the manager 
     what wrong in the testing process.
     
24. Explain testing process followed by your company?
Ans.
25. What is the Test design technique you used in your organisation like error guessing, Equivalence partition, Boundary value analysis?
Ans.
26. Apart from the RTM, how do you ensure that your Test Design coverage is optimum?
Ans.
27. Explain Test Design Techniques
Ans.
28. What levels of Testing have you worked on?
Ans.
29. What is Unit Testing?
Ans.
30. What is Integration testing?
Ans.
31. What is the difference in writing the test cases for Integration testing and system testing?
Ans.
32. Difference between Unit and Integration Testing?
Ans.
33.What is User Acceptance Testing?
Ans.
34. Explain UAT?
Ans.    
35. What is a defect?
Ans.
36. What is a Latent defect?
Ans.
37. The difference between bug, defect, and fault?
Ans.
38. What are must present fields while raising a defect?
Ans.
39. What are the steps to reproduce while logging a defect?
Ans.
40. What are defect tracking tools?
Ans.
41. What is a blocker defect?
Ans.
42. How do you log the defects in your project?
Ans.
43. Difference between bug, error, and defect?
Ans.
44 . If you have executed 100 test cases, every test case passed but apart from these test cases you found some defect for which the test case is
not prepared, then how can you report the bug?
Ans.
45 . What is a Deferred Defect?
Ans.
46 . What is meant by defect triage calls?
Ans.
47. What if some defects are not fixed in the current sprint?
Ans.
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
50. Explain Defect template?
51. What is the typical defect you raised in your project?    
52. What is defect density?
Ans. Divide the total defects by total lines of code.
     For example: if you had 5 defects and 1,000 lines of code.You would divide 5/1000=0.005 is the result.








