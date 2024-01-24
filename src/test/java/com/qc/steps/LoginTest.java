package com.qc.steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	
	WebDriver driver;
	WebElement email,pass,signin;
	
	
	@Given("To launch the browser {string}")
	public void to_launch_the_browser(String browserName) {
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		else {
			new FirefoxDriver();
		}
		  driver.manage().window().maximize(); 
	    
	
	}
	@Given("To zoom login page {string}")
	public void to_zoom_login_page(String appUrl) {
		 driver.get(appUrl);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	@Given("To locate on email textbox & enter email {string}")
	public void to_locate_on_email_textbox_enter_email(String uName) {
		   email = driver.findElement(By.id("email"));
		   email.sendKeys(uName);
	
	}
	@Given("To locate on password textbox & enter password {string}")
	public void to_locate_on_password_textbox_enter_password(String uPass) {
		  pass = driver.findElement(By.id("password"));
		  pass.sendKeys(uPass);
	
	}
	@When("To locate on signin button & click on it")
	public void to_locate_on_signin_button_click_on_it() {
		  signin = driver.findElement(By.id("js_btn_login"));
		  signin.click();
	
	}
	@Then("To validate user should be on zoom meeting page {string}")
	public void to_validate_user_should_be_on_zoom_meeting_page(String expResult) {
	      String actResult = driver.getTitle();
		  Assert.assertEquals(actResult,expResult);
	
	}
	

	@Then("To validate user should be on zoom signin page {string}")
	public void to_validate_user_should_be_on_zoom_signin_page(String expResult) {
		  String actResult = driver.getTitle();
		  Assert.assertEquals(actResult,expResult);

	}
    @Then("To close the browser")
	public void to_close_the_browser() {
		driver.close();
	    
	
	}



	
	
}
