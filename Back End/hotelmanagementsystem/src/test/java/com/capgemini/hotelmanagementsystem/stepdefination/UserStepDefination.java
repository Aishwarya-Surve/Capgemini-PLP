package com.capgemini.hotelmanagementsystem.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserStepDefination {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	WebDriver driver;
	
	@Given("^the user has loaded the application in the browser$")
	public void the_user_has_loaded_the_application_in_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
	}

	@When("^the user clicks on sign in link$")
	public void the_user_clicks_on_sign_in_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
	}

	@When("^the user enters the valid email$")
	public void the_user_enters_the_valid_email() throws Throwable {
		driver.findElement(By.name("userEmail")).sendKeys("user@gmail.com");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the user enters the valid password$")
	public void the_user_enters_the_valid_password() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("User@123");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the user clicks on the sign in button$")
	public void the_user_clicks_on_the_sign_in_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("^the booking page must be displayed$")
	public void the_booking_page_must_be_displayed() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Hotel Booking']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@When("^the user clicks on view bookings$")
	public void the_user_clicks_on_view_bookings() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Booking History']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the user clicks on profile$")
	public void the_user_clicks_on_profile() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@When("^the user clicks on see profile$")
	public void the_user_clicks_on_see_profile() throws Throwable {
		driver.findElement(By.xpath("//a[text()='See Profile']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
	}

}
