package gmoStepDefs;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GmoStepsHooks {

	static WebDriver driver = null;
	static WebElement we;
	static String pageTitle = null;

	@BeforeAll
	public static void beforeAllScenario() {
		// code here will get executed before each scenario statements in all feature
		// files
		System.out.println("beforeAllScenario - Opening the chrome browser");
		// For firefox browser
		System.setProperty("webdriver.chrome.driver",
				"F:\\Training\\Selenium\\CoreFiles\\BrowserDrivers\\chromedriver107.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("http://demo.borland.com/gmopost/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	}
	@AfterAll
	public static void afterAllScenarios() {
		// code here will get executed after all scenario statements in all feature files
		driver.quit();
		System.out.println("Browser closed-afterAllScenarios");
	}
	@Before
	public void beforeEachScenario() {
		// code here will get executed before each scenario statements in all feature
		// files
		System.out.println("beforeEachScenario - NA for this feature");
	}
	@BeforeStep
	public void beforeEachStep() {
		// code here will get executed before each step in all scenario statements in
		// all feature files
		System.out.println("beforeEachStep - NA for this feature");
	}

	@After
	public void afterEachScenario() {
		// // code here will get executed after each scenario statement in all feature files
		System.out.println("afterEachScenario - NA for this feature");
		
	}
	@AfterStep
	public void afterEachStep() {
		// code here will get executed after each step in scenario statements in all feature files
		System.out.println("afterEachStep - NA for this feature");
	}
	
	@Given("I am on gmo home page")
	public void i_am_on_gmo_home_page() {
		pageTitle = driver.getTitle();
		System.out.println("UDC//: I am on gmo home page");
		Assert.assertEquals("Welcome to Green Mountain Outpost", pageTitle);
	}

	@When("I enter gmo online")
	public void i_enter_gmo_online() {
		System.out.println("UDC//: I click on enter gmo online button");
		we = driver.findElement(By.name("bSubmit"));
		we.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	}

	@Then("I should see catalag page")
	public void i_should_see_catalag_page() {
		pageTitle = driver.getTitle();
		System.out.println("UDC//: I should see catalag page");
		Assert.assertEquals("OnLine Catalog", pageTitle);
	}

	@Given("Catalog page is displayed")
	public void catalog_page_is_displayed() {
		pageTitle = driver.getTitle();
		System.out.println("UDC//: Catalog page is displayed");
		Assert.assertEquals("OnLine Catalog", pageTitle);
	}

	@When("I select {int} qty of Glacier Sun Glasses and place order")
	public void i_select_qty_of_glacier_sun_glasses_and_place_order(Integer int1) {
		we = driver.findElement(By.name("QTY_GLASSES"));
		String qty = String.valueOf(int1);
		we.clear();
		we.sendKeys(qty);
		we = driver.findElement(By.name("bSubmit"));
		we.click();
		System.out.println("UDC//: select " + qty + " qty of Glacier Sun Glasses and place order");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	}

	@Then("Place order page is displayed with items selected")
	public void place_order_page_is_displayed_with_items_selected() {
		pageTitle = driver.getTitle();
		System.out.println("UDC//: Place order page is displayed with items selected");
		Assert.assertEquals("Place Order", pageTitle);
	}

	@Given("Place order page is displayed")
	public void place_order_page_is_displayed() {
		pageTitle = driver.getTitle();
		System.out.println("UDC//: Place order page is displayed");
		Assert.assertEquals("Place Order", pageTitle);
	}

	@When("I checkout")
	public void i_checkout() {
		we = driver.findElement(By.name("bSubmit"));
		we.click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		System.out.println("UDC//: I checkout by clicking Proceed with order button");
	}

	@Then("billing information page should be displayed")
	public void billing_information_page_should_be_displayed() {
		pageTitle = driver.getTitle();
		System.out.println("UDC//: billing information page should be displayed");
		Assert.assertEquals("Billing Information", pageTitle);
	}

	@Given("Billing page is displayed")
	public void billing_page_is_displayed() {
		pageTitle = driver.getTitle();
		System.out.println("UDC//: billing information page is displayed");
		Assert.assertEquals("Billing Information", pageTitle);
	}

	@When("I input correct billing address")
	public void i_input_correct_billing_address() {
		driver.findElement(By.name("billName")).sendKeys("sakha global");
		driver.findElement(By.name("billAddress")).sendKeys("BSK II stage");
		driver.findElement(By.name("billCity")).sendKeys("bilBengalurul");
		driver.findElement(By.name("billState")).sendKeys("karnataka");
		driver.findElement(By.name("billZipCode")).sendKeys("12345");
		driver.findElement(By.name("billPhone")).sendKeys("1234567890");
		driver.findElement(By.name("billEmail")).sendKeys("sg@blr.in");
		driver.findElement(By.name("CardNumber")).sendKeys("123456789012345");
		driver.findElement(By.name("CardDate")).sendKeys("12/25");
		driver.findElement(By.name("shipSameAsBill")).click();
		driver.findElement(By.name("bSubmit")).click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
	}

	@Then("the system should take me to receipt page")
	public void the_system_should_take_me_to_receipt_page() {
		pageTitle = driver.getTitle();
		System.out.println("UDC//: receipt page is displayed");
		Assert.assertEquals("OnLine Store Receipt", pageTitle);
	}

	@Given("I am on receipt page")
	public void i_am_on_receipt_page() {
		pageTitle = driver.getTitle();
		System.out.println("UDC//: I am on receipt page");
		Assert.assertEquals("OnLine Store Receipt", pageTitle);
	}

	@When("I return to home page")
	public void i_return_to_home_page() {
		driver.findElement(By.name("bSubmit")).click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		System.out.println("UDC//: I return to home page");
	}

	@Then("Home page should be displayed")
	public void home_page_should_be_displayed() {
		pageTitle = driver.getTitle();
		System.out.println("UDC//: Home page should be displayed");
		Assert.assertEquals("Welcome to Green Mountain Outpost", pageTitle);

	}

}
