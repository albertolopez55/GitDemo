package stepDefinitions;


import java.io.FileInputStream;
import java.util.Properties;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

//@RunWith(Cucumber.class)
public class stepDefinitionsSelenium {
	public WebDriver driver;
	

    @Given("^User is on Greencart Landing page$")
    public void user_is_on_greencart_landing_page() throws Throwable {    
    	Properties prop = new Properties();
    	FileInputStream fis = new FileInputStream("C:\\CucumberCourse\\SeleniumCucumber\\src\\test\\java\\cucumberAutomation\\global.properties");
    	prop.load(fis);
    	System.setProperty("webdriver.chrome.driver", "C:\\CucumberCourse\\drivers\\chromedriver.exe");    	
        driver = new ChromeDriver();        
        driver.get(prop.getProperty("url"));
    }

    @When("^User searched for \"([^\"]*)\" vegetable$")
    public void user_searched_for_something_vegetable(String strArg1) throws Throwable {    
    	driver.findElement(By.xpath("//input[@type='search']")).sendKeys(strArg1);
    	driver.findElement(By.xpath("//button[@class='search-button']")).click();
    }

    @Then("^\"([^\"]*)\" results are displayed$")
    public void something_results_are_displayed(String strArg1) throws Throwable {
    	Assert.assertTrue(driver.findElement(By.cssSelector("h4.product-name")).getText().contains(strArg1));
    }

    @And("^Added items to cart$")
    public void added_items_to_cart() throws Throwable {
    	driver.findElement(By.xpath("//div[@id='root']/div[@class='container']/div[@class='products-wrapper']//div[@class='stepper-input']/a[2]")).click();    	//
    	driver.findElement(By.xpath("//div[@id='root']/div[@class='container']/div[@class='products-wrapper']//button[@type='button']")).click();
    }

    @And("^User proced to Checkout page for purchase$")
    public void user_proced_to_checkout_page_for_purchase() throws Throwable {
    	driver.findElement(By.xpath("//div[@id='root']/div[@class='container']//div[@class='cart']/a[@href='#']/img[@alt='Cart']")).click();
    	driver.findElement(By.xpath("//div[@id='root']/div[@class='container']/header/div[@class='container']//button[@type='button']")).click();    	    	        
    }

    @Then("^verify selected \"([^\"]*)\" items are displayed in checkout page$")
    public void verify_selected_something_items_are_displayed_in_checkout_page(String strArg1) throws Throwable {
    	Assert.assertTrue(driver.findElement(By.cssSelector(".product-name")).getText().contains(strArg1));
    }
    
    
}
