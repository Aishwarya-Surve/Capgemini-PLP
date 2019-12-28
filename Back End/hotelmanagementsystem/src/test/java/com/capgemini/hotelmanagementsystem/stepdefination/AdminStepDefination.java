package com.capgemini.hotelmanagementsystem.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AdminStepDefination {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	WebDriver driver;
	
	@Given("^the admin has loaded the application in the browser$")
	public void the_admin_has_loaded_the_application_in_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
		driver.manage().window().maximize();
	}

	@When("^the admin clicks on sign in link$")
	public void the_admin_clicks_on_sign_in_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
	}

	@When("^the admin enters the valid email$")
	public void the_admin_enters_the_valid_email() throws Throwable {
		driver.findElement(By.name("userEmail")).sendKeys("admin@gmail.com");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the admin enters the valid password$")
	public void the_admin_enters_the_valid_password() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Admin@123");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the admin clicks on the sign in button$")
	public void the_admin_clicks_on_the_sign_in_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^the admin page must be displayed$")
	public void the_admin_page_must_be_displayed() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Admin']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
//	@When("^the admin clicks on hotels counter$")
//	public void the_admin_clicks_on_hotels_counter() throws Throwable {
//		driver.findElement(By.xpath("//button[text()='Hotels Counter']")).click();
//	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}
//
//	@When("^the admin clicks on delete button$")
//	public void the_admin_clicks_on_delete_button() throws Throwable {
//		driver.findElement(By.xpath("//button[text()='Delete']")).click();
//	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}
//
//	@When("^the admin clicks on admin link$")
//	public void the_admin_clicks_on_admin_link() throws Throwable {
//		driver.findElement(By.xpath("//a[text()='Admin']")).click();
//	}
	
	@When("^the admin clicks on manager counter$")
	public void the_admin_clicks_on_manager_counter() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Manager Counter']")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@When("^the admin clicks on register manager$")
	public void the_admin_clicks_on_register_manager() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Click here to Register Manager']")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the admin enters manager name$")
	public void the_admin_enters_manager_name() throws Throwable {
		driver.findElement(By.name("userName")).sendKeys("Harry Styles");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the admin enters email$")
	public void the_admin_enters_email() throws Throwable {
		driver.findElement(By.name("userEmail")).sendKeys("harry@gmail.com");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the admin enters password$")
	public void the_admin_enters_password() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("harry@123");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the admin clicks on register manager button$")
	public void the_admin_clicks_on_register_manager_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Register Manager']")).click();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.close();
	}
	
	@When("^the admin clicks on Add Hotel$")
	public void the_admin_clicks_on_Add_Hotel() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Add Hotel']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^admin enters hotel name$")
	public void admin_enters_hotel_name() throws Throwable {
		driver.findElement(By.name("hotelName")).sendKeys("Mayuri");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^admin enters ac rooms$")
	public void admin_enters_ac_rooms() throws Throwable {
		driver.findElement(By.name("availableAcRoom")).sendKeys("40");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^admin enters non-ac room$")
	public void admin_enters_non_ac_room() throws Throwable {
		driver.findElement(By.name("availableNonAcRoom")).sendKeys("20");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^admin enters hotel location$")
	public void admin_enters_hotel_location() throws Throwable {
		driver.findElement(By.name("location")).sendKeys("Goa");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^admin clicks on add hotel$")
	public void admin_clicks_on_add_hotel() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Add Hotel']")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    Thread.sleep(2000);
	}

	@When("^the admin clicks on admin$")
	public void the_admin_clicks_on_admin() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Admin']")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^admin clicks on hotels counter$")
	public void admin_clicks_on_hotels_counter() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Hotels Counter']")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.close();
	}
}
