package junit_test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class JUnit_Selenium_Test_Class {
	
	
static WebDriver driver;
	
	@BeforeClass
	public static void BrowserOpen() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromerdriver92\\chromedriver.exe"); 
		driver= new ChromeDriver() ;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	// ###########################################################################################
	// --------------------------------------- TEST CASE 1 ---------------------------------------
	// ###########################################################################################
	
	@Test
	public void testCase1() throws IOException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("D:\\Program Files (x86)\\Eclipse\\eclipse saves\\JUnit_Selenium_Testing\\src\\junit_test\\Project4\\index.html");
		driver.manage().window().maximize();
		
		// TEST CASE 1
		// Sign-up page works properly (no same e-mails, e-mail is properly formatted)
		System.out.println("\n\n\n");
		System.out.println("Test case 1 junit selenium");
		
		// Find fields and button from the web page
		WebElement reg_id_field = driver.findElement(By.id("email1"));
		WebElement reg_pass_field1 = driver.findElement(By.id("password1"));
		WebElement reg_pass_field2 = driver.findElement(By.id("password2"));
		
		WebElement submit_btn = driver.findElement(By.xpath("html/body/div/div/div/form/div[3]/button"));
		
		// The test e-mails and passwords are stored in this array by reading from files.
		String test_case_1_inputs[] = new String[100];
		String test_case_1_filepath = "D:\\Program Files (x86)\\Eclipse\\eclipse saves\\JUnit_Selenium_Testing\\src\\junit_test\\Test_Case_1.txt";
		
		readFiles(test_case_1_filepath, test_case_1_inputs);
		
		int txt_counter = 0;
		for (int i = 0; i < 5; i++) {
			
			reg_id_field.clear();
			reg_pass_field1.clear();
			reg_pass_field2.clear();
			

			System.out.println("Testing mail " + test_case_1_inputs[txt_counter] + ", with counter " + txt_counter);
			reg_id_field.sendKeys(test_case_1_inputs[txt_counter]);
			txt_counter++;
			
			System.out.println("Testing pass1 " + test_case_1_inputs[txt_counter] + ", with counter " + txt_counter);
			reg_pass_field1.sendKeys(test_case_1_inputs[txt_counter]);
			txt_counter++;
			
			System.out.println("Testing pass2 " + test_case_1_inputs[txt_counter] + ", with counter " + txt_counter);
			reg_pass_field2.sendKeys(test_case_1_inputs[txt_counter]);
			txt_counter++;
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			TimeUnit.SECONDS.sleep(2);
			
			submit_btn.click();

			TimeUnit.SECONDS.sleep(2);	
		}
		driver.findElement(By.xpath("html/body/div/div/div/form/a")).click();
		System.out.println("Test Case 1 Finished\n");	
		TimeUnit.SECONDS.sleep(2);
	}
	
	// ###########################################################################################
	// --------------------------------------- TEST CASE 2 ---------------------------------------
	// ###########################################################################################
	
	@Test
	public void testCase2() throws IOException, InterruptedException {
		// TEST CASE 2
		// Login page works properly (email is properly formatted, email exists in database, password matches with saved email)
		System.out.println("\n\n\n");
		System.out.println("Test case 2 junit selenium");
		
		// Find fields and button from the web page
		WebElement log_id_field = driver.findElement(By.id("email1"));
		WebElement log_pass_field = driver.findElement(By.id("password1"));
		
		WebElement submit_btn = driver.findElement(By.xpath("html/body/div/div/div/form/div[3]/button"));
		
		// The test e-mails and passwords are stored in this array by reading from files.
		String test_case_2_inputs[] = new String[100];
		String test_case_2_filepath = "D:\\Program Files (x86)\\Eclipse\\eclipse saves\\JUnit_Selenium_Testing\\src\\junit_test\\Test_Case_2.txt";
		
		readFiles(test_case_2_filepath, test_case_2_inputs);
		
		int txt_counter = 0;
		for (int i = 0; i < 5; i++) {
		
			log_id_field.clear();
			log_pass_field.clear();
			
			System.out.println("Testing mail " + test_case_2_inputs[txt_counter] + ", with counter " + txt_counter);
			log_id_field.sendKeys(test_case_2_inputs[txt_counter]);
			txt_counter++;
			
			System.out.println("Testing pass1 " + test_case_2_inputs[txt_counter] + ", with counter " + txt_counter);
			log_pass_field.sendKeys(test_case_2_inputs[txt_counter]);
			txt_counter++;
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			TimeUnit.SECONDS.sleep(2);
			
			submit_btn.click();

			TimeUnit.SECONDS.sleep(2);	
		}
		System.out.println("Test Case 2 Finished\n");	
		TimeUnit.SECONDS.sleep(2);
	}
	
	// ###########################################################################################
	// --------------------------------------- TEST CASE 3 ---------------------------------------
	// ###########################################################################################
	
	@Test
	public void testCase3() throws IOException, InterruptedException {
		
		// TEST CASE 3
		// Front page needs fields to be filled, all fields except symptoms cannot be
		// changed once submitted. The test submits info for one user then logs out 
		// and submits new info for a second user and logs out for test case 4.
		System.out.println("\n\n\n");
		System.out.println("Test case 3 junit selenium");
		
		// Find fields and button from the web page
		WebElement front_name_field = driver.findElement(By.id("name"));
		WebElement front_surname_field = driver.findElement(By.id("surname"));
		WebElement front_age_field = driver.findElement(By.id("age"));
		Select front_gender_select = new Select(driver.findElement(By.id("gender")));
		
		WebElement submit_btn = driver.findElement(By.xpath("html/body/div/div/div/form/div[11]/button"));
		
		// The test e-mails and passwords are stored in this array by reading from files.
		String test_case_3_inputs[] = new String[100];
		String test_case_3_filepath = "D:\\Program Files (x86)\\Eclipse\\eclipse saves\\JUnit_Selenium_Testing\\src\\junit_test\\Test_Case_3.txt";
		
		readFiles(test_case_3_filepath, test_case_3_inputs);
		
		int txt_counter = 0;
		int symptoms_clicked = 0;
		for (int i = 0; i < 2; i++) {
			
			front_name_field.clear();
			front_surname_field.clear();
			front_age_field.clear();
			
			// NAME SURNAME AGE FIELDS
			System.out.println("Testing mail " + test_case_3_inputs[txt_counter] + ", with counter " + txt_counter);
			front_name_field.sendKeys(test_case_3_inputs[txt_counter]);
			txt_counter++;
			
			System.out.println("Testing pass1 " + test_case_3_inputs[txt_counter] + ", with counter " + txt_counter);
			front_surname_field.sendKeys(test_case_3_inputs[txt_counter]);
			txt_counter++;
			
			System.out.println("Testing pass1 " + test_case_3_inputs[txt_counter] + ", with counter " + txt_counter);
			front_age_field.sendKeys(test_case_3_inputs[txt_counter]);
			txt_counter++;
			
			// GENDER SELECT FIELD
			front_gender_select.selectByVisibleText("Male");
			
			// SYMPTOMS FIELD
			// So we choose the symptoms only once (double clicks would uncheck the boxes
			if (symptoms_clicked == 0) {

				driver.findElement(By.id("inlineCheckbox4")).click();
				driver.findElement(By.id("inlineCheckbox1")).click();
				symptoms_clicked++;
			}
			
			// CHOOSE VACCINATED
			driver.findElement(By.id("flexRadioDefault1")).click();
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			TimeUnit.SECONDS.sleep(2);
			
			submit_btn.click();

			TimeUnit.SECONDS.sleep(4);		
		}
		
		// When the test of first user's submission is done. Log out and login with another user
		// and submit their info too.
		
		// LOGOUT
		driver.findElement(By.id("logoutbtn")).click();
		
		// LOGIN PAGE
		// Find fields and button from the web page
		WebElement log_id_field = driver.findElement(By.id("email1"));
		WebElement log_pass_field = driver.findElement(By.id("password1"));
		
		WebElement login_btn = driver.findElement(By.xpath("html/body/div/div/div/form/div[3]/button"));
		
		// ENTER SECOND USER INFO TO LOGIN
		log_id_field.clear();
		log_pass_field.clear();
		
		System.out.println("Testing mail " + test_case_3_inputs[txt_counter] + ", with counter " + txt_counter);
		log_id_field.sendKeys(test_case_3_inputs[txt_counter]);
		txt_counter++;
		
		System.out.println("Testing pass1 " + test_case_3_inputs[txt_counter] + ", with counter " + txt_counter);
		log_pass_field.sendKeys(test_case_3_inputs[txt_counter]);
		txt_counter++;
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		TimeUnit.SECONDS.sleep(3);
		
		login_btn.click();

		TimeUnit.SECONDS.sleep(3);	
		
		// INSIDE THE SECOND USER DASHBOARD
		// Find fields and button from the web page
		WebElement front_name_field2 = driver.findElement(By.id("name"));
		WebElement front_surname_field2 = driver.findElement(By.id("surname"));
		WebElement front_age_field2 = driver.findElement(By.id("age"));
		Select front_gender_select2 = new Select(driver.findElement(By.id("gender")));
		
		WebElement submit_btn2 = driver.findElement(By.xpath("html/body/div/div/div/form/div[11]/button"));
		// FILL THE FIELDS AND SUBMIT
		front_name_field2.clear();
		front_surname_field2.clear();
		front_age_field2.clear();
		
		// NAME SURNAME AGE FIELDS
		System.out.println("Testing mail " + test_case_3_inputs[txt_counter] + ", with counter " + txt_counter);
		front_name_field2.sendKeys(test_case_3_inputs[txt_counter]);
		txt_counter++;
		
		System.out.println("Testing pass1 " + test_case_3_inputs[txt_counter] + ", with counter " + txt_counter);
		front_surname_field2.sendKeys(test_case_3_inputs[txt_counter]);
		txt_counter++;
		
		System.out.println("Testing pass1 " + test_case_3_inputs[txt_counter] + ", with counter " + txt_counter);
		front_age_field2.sendKeys(test_case_3_inputs[txt_counter]);
		txt_counter++;
		
		// GENDER SELECT FIELD
		front_gender_select2.selectByVisibleText("Male");
		
		// SYMPTOMS CHECKBOXES
		driver.findElement(By.id("inlineCheckbox2")).click();
		driver.findElement(By.id("inlineCheckbox6")).click();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		TimeUnit.SECONDS.sleep(2);
		
		submit_btn2.click();

		TimeUnit.SECONDS.sleep(4);	
		
		// LOGOUT
		driver.findElement(By.id("logoutbtn")).click();
		
		System.out.println("Test Case 3 Finished\n");	
		TimeUnit.SECONDS.sleep(2);		
	}
	
	// ###########################################################################################
	// --------------------------------------- TEST CASE 4 ---------------------------------------
	// ###########################################################################################
	
	@Test
	public void testCase4() throws IOException, InterruptedException {
		// TEST CASE 4
		// User data is saved and retrieved successfully for the next time login
		// First user account is logged in and logged out. Then second user is logged in and logged out.
		// Showing data is being saved for next logins even with multiple accounts
		System.out.println("\n\n\n");
		System.out.println("Test case 4 junit selenium");
		
		
		// Find fields and button from the web page
		WebElement log_id_field = driver.findElement(By.id("email1"));
		WebElement log_pass_field = driver.findElement(By.id("password1"));
		
		WebElement login_btn = driver.findElement(By.xpath("html/body/div/div/div/form/div[3]/button"));
		
		// The test e-mails and passwords are stored in this array by reading from files.
		String test_case_4_inputs[] = new String[100];
		String test_case_4_filepath = "D:\\Program Files (x86)\\Eclipse\\eclipse saves\\JUnit_Selenium_Testing\\src\\junit_test\\Test_Case_4.txt";
		
		readFiles(test_case_4_filepath, test_case_4_inputs);
		
		int txt_counter = 0;
		
		log_id_field.clear();
		log_pass_field.clear();
		
		System.out.println("Testing mail " + test_case_4_inputs[txt_counter] + ", with counter " + txt_counter);
		log_id_field.sendKeys(test_case_4_inputs[txt_counter]);
		txt_counter++;
		
		System.out.println("Testing pass1 " + test_case_4_inputs[txt_counter] + ", with counter " + txt_counter);
		log_pass_field.sendKeys(test_case_4_inputs[txt_counter]);
		txt_counter++;
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		TimeUnit.SECONDS.sleep(2);
		
		login_btn.click();

		TimeUnit.SECONDS.sleep(2);	
		
		// LOGGED IN TO THE FIRST USER ACCOUNT
		// WAIT FOR OBSERVER TO VIEW THE SAVED/LOADED DATA
		TimeUnit.SECONDS.sleep(4);
		
		// We submit these symptoms again, bcz if we don't the system will overwrite the saved 
		// symptom count with 0 since we have not selected anything
		driver.findElement(By.id("inlineCheckbox4")).click();
		driver.findElement(By.id("inlineCheckbox1")).click();
		driver.findElement(By.xpath("html/body/div/div/div/form/div[11]/button")).click();
		TimeUnit.SECONDS.sleep(4);
				
		// LOGOUT
		driver.findElement(By.id("logoutbtn")).click();
		
		// LOGIN WITH THE SECOND USER
		// Find fields and button from the web page
		log_id_field = driver.findElement(By.id("email1"));
		log_pass_field = driver.findElement(By.id("password1"));
		
		login_btn = driver.findElement(By.xpath("html/body/div/div/div/form/div[3]/button"));
		
		log_id_field.clear();
		log_pass_field.clear();
		
		System.out.println("Testing mail " + test_case_4_inputs[txt_counter] + ", with counter " + txt_counter);
		log_id_field.sendKeys(test_case_4_inputs[txt_counter]);
		txt_counter++;
		
		System.out.println("Testing pass1 " + test_case_4_inputs[txt_counter] + ", with counter " + txt_counter);
		log_pass_field.sendKeys(test_case_4_inputs[txt_counter]);
		txt_counter++;
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		TimeUnit.SECONDS.sleep(2);
		
		login_btn.click();

		TimeUnit.SECONDS.sleep(2);
		
		// LOGGED IN TO THE SECOND USER ACCOUNT
		// WAIT FOR OBSERVER TO VIEW THE SAVED/LOADED DATA
		TimeUnit.SECONDS.sleep(4);
				
		// DO NOT LOG OUT AND PROCEED TO TEST CASE 5
		System.out.println("Test Case 4 Finished\n");	
		TimeUnit.SECONDS.sleep(2);		
		
		
	}

	// ###########################################################################################
	// --------------------------------------- TEST CASE 5 ---------------------------------------
	// ###########################################################################################
	
	@Test
	public void testCase5() throws InterruptedException, IOException {
		
		// TEST CASE 5
		// WEB PAGE WILL UNDERSTAND AND NOTIFY THE USER ABOUT THEIR HEALTH
		// IF SYMPTOMS ARE GETTING WORSE IT WILL SUGGEST THEM TO SEE THEIR DOCTORS
		// IF THEIR SYMPTOMS ARE GETTING BETTER IT GIVES POSITIVE MESSAGES
		System.out.println("\n\n\n");
		System.out.println("Test case 5 junit selenium");
		
		WebElement submit_btn = driver.findElement(By.xpath("html/body/div/div/div/form/div[11]/button"));
		
		// Pick only one symptom for second user this time
		driver.findElement(By.id("inlineCheckbox2")).click();
		submit_btn.click();
		
		// TIME TO READ THE MESSAGE
		TimeUnit.SECONDS.sleep(5);	
		
		// LOGOUT
		driver.findElement(By.id("logoutbtn")).click();
		
		// NOW LOGIN WITH THE FIRST USER
		// Find fields and button from the web page
		WebElement log_id_field = driver.findElement(By.id("email1"));
		WebElement log_pass_field = driver.findElement(By.id("password1"));
		
		WebElement login_btn = driver.findElement(By.xpath("html/body/div/div/div/form/div[3]/button"));
		
		// The test e-mails and passwords are stored in this array by reading from files.
		String test_case_5_inputs[] = new String[100];
		String test_case_5_filepath = "D:\\Program Files (x86)\\Eclipse\\eclipse saves\\JUnit_Selenium_Testing\\src\\junit_test\\Test_Case_5.txt";
		
		readFiles(test_case_5_filepath, test_case_5_inputs);
		
		int txt_counter = 0;
		
		log_id_field.clear();
		log_pass_field.clear();
		
		System.out.println("Testing mail " + test_case_5_inputs[txt_counter] + ", with counter " + txt_counter);
		log_id_field.sendKeys(test_case_5_inputs[txt_counter]);
		txt_counter++;
		
		System.out.println("Testing pass1 " + test_case_5_inputs[txt_counter] + ", with counter " + txt_counter);
		log_pass_field.sendKeys(test_case_5_inputs[txt_counter]);
		txt_counter++;
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		TimeUnit.SECONDS.sleep(2);
		
		login_btn.click();

		TimeUnit.SECONDS.sleep(2);	
		
		// FIND SUBMIT BTN
		submit_btn = driver.findElement(By.xpath("html/body/div/div/div/form/div[11]/button"));
		
		// Pick 3 symptoms for first user this time
		driver.findElement(By.id("inlineCheckbox1")).click();
		driver.findElement(By.id("inlineCheckbox3")).click();
		driver.findElement(By.id("inlineCheckbox4")).click();
		submit_btn.click();
		
		// TIME TO READ THE MESSAGE
		TimeUnit.SECONDS.sleep(5);	
		
		// ALL TEST CASES ARE COMPLETED.
		System.out.println("Test Case 4 Finished\n");
		TimeUnit.SECONDS.sleep(2);
	}
	
	@AfterClass
	public static void BrowserClose() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		driver.quit();
	}
	
	public void readFiles(String filename, String [] test_case_array) throws IOException {
		File file = new File(filename);
		  
		BufferedReader br = new BufferedReader(new FileReader(file));
		  
		String st;
		
		int counter = 0;
		while ((st = br.readLine()) != null) {
			test_case_array[counter] = st;
			counter++;
		}
		br.close();
	}
	

}
