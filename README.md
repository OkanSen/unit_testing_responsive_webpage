# unit_testing_responsive_webpage

The project can be downloaded as a folder from the GitHub Repository. However, the zip version is also included.

In order to create a successful project for testing, you should first download JUnit, Selenium for Java and chromedriver.
The versions used in the project are as below;

The first two are accessible on the Github page of JUnit, the others can be accessed from their download pages:
- JUnit-4.13.2.jar
- hamcrest-core-1.3.jar

- Selenium for Java 3.141.59

- Chromedriver Version 92

Once all are downloaded, it is safe to create a new project using Eclipse. The version of the eclipse project's 
Java SDK should be set to exaclty 1.8. Above 1.8 has compatibility issues with Selenium and will not work.

No module is needed. Normally, 1.8 does not use module system, however, if Eclipse somehow asks for a module,
it should not be created.

After the project is loaded, create a new package with name "junit_test",
inside that package add a Java Class named "JUnit_Selenium_Test_Class".

Then, right click on the project in the Package Explorer view. Find "Build Path -> Configure Build Path"
Here, we will add JUnit and Selenium to our project.

Click "Add External JARs" on the right side of the panel. 

First, add these two JARs from where you have downloaded/placed JUnit JARs. 
- JUnit-4.13.2.jar
- hamcrest-core-1.3.jar

Then navigate to the folder where you have placed Selenium components.
- Add all JARs inside of the lib folder first (byte-buddy-1.8.15.jar, commons-exec-1.3.jar, etc...)
- Now add the two JARs outside of the lib folder in Selenium folder (client-combined-3.141.59.jar, client-combined-3.141.59-sources.jar)


Before launching the code, make sure to set the paths to your relative paths given below, that are included in the code;

System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromerdriver92\\chromedriver.exe")

driver.get("D:\\Program Files (x86)\\Eclipse\\eclipse saves\\JUnit_Selenium_Testing\\src\\junit_test\\Project4\\index.html")

String test_case_1_filepath = "D:\\Program Files (x86)\\Eclipse\\eclipse saves\\JUnit_Selenium_Testing\\src\\junit_test\\Test_Case_1.txt"

String test_case_2_filepath = "D:\\Program Files (x86)\\Eclipse\\eclipse saves\\JUnit_Selenium_Testing\\src\\junit_test\\Test_Case_2.txt"

String test_case_3_filepath = "D:\\Program Files (x86)\\Eclipse\\eclipse saves\\JUnit_Selenium_Testing\\src\\junit_test\\Test_Case_3.txt"

String test_case_4_filepath = "D:\\Program Files (x86)\\Eclipse\\eclipse saves\\JUnit_Selenium_Testing\\src\\junit_test\\Test_Case_4.txt"

String test_case_5_filepath = "D:\\Program Files (x86)\\Eclipse\\eclipse saves\\JUnit_Selenium_Testing\\src\\junit_test\\Test_Case_5.txt"




The test project is ready to go!

To run the code with JUnit, right click on the project in the Package Explorer view and click
"Run As -> JUnit Test"

This step is also included in the demo video right at the beginning.



Github Page: https://github.com/OkanSen/unit_testing_responsive_webpage


