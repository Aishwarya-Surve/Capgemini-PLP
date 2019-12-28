package com.capgemini.hotelmanagementsystem.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManagerStepDefination {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	WebDriver driver;

	@Given("^the manager has loaded the application in the browser$")
	public void the_manager_has_loaded_the_application_in_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200");
	}

	@When("^the manager clicks on sign in link$")
	public void the_manager_clicks_on_sign_in_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Sign in']")).click();
	}

	@When("^the manager enters the valid email$")
	public void the_manager_enters_the_valid_email() throws Throwable {
		driver.findElement(By.name("userEmail")).sendKeys("manager@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the manager enters the valid password$")
	public void the_manager_enters_the_valid_password() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Manager@123");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the manager clicks on the sign in button$")
	public void the_manager_clicks_on_the_sign_in_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^the manager page must be displayed$")
	public void the_manager_page_must_be_displayed() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Manager']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the manager clicks on employee counter$")
	public void the_manager_clicks_on_employee_counter() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Employee Counter']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the manager clicks on register manager$")
	public void the_manager_clicks_on_register_manager() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Click here to Register Employee']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the manager enters employee name$")
	public void the_manager_enters_employee_name() throws Throwable {
		driver.findElement(By.name("userName")).sendKeys("Namjoon Kim");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the manager enters email$")
	public void the_manager_enters_email() throws Throwable {
		driver.findElement(By.name("userEmail")).sendKeys("namjoon@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the manager enters password$")
	public void the_manager_enters_password() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Namjoon@123");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the manager clicks on register employee button$")
	public void the_manager_clicks_on_register_employee_button() throws Throwable {
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@When("^the manager clicks on manager link$")
	public void the_manager_clicks_on_manager_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Manager']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the manager clicks on customers counter$")
	public void the_manager_clicks_on_customers_counter() throws Throwable {
		driver.findElement(By.xpath("//a[text()='Customers Counter']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
	}

}
