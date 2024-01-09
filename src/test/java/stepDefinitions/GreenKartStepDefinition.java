package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


import java.util.Iterator;
import java.util.Set;

import static java.lang.Thread.sleep;

public class GreenKartStepDefinition {

        public WebDriver driver;
        public String landingPageProductName;
        public String offerPageProductName;

        @Given("User is on GreenCart Landing page")
        public void user_is_on_green_cart_landing_page () {


            ChromeOptions options = new ChromeOptions();

            options.addArguments("-inprivate");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        }
        @When("user searched with shortname {string} and extracted actual name of product")
        public void user_searched_with_shortname_and_extracted_actual_name_of_product (String shortName){
            driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            landingPageProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
            System.out.println(landingPageProductName + "is extracted from Home page");
        }

        @Then("user searched for {string} shortname in offers page")
        public void user_searched_for_same_shortname_in_offers_page (String shortName){
            driver.findElement(By.linkText("Top Deals")).click();
            Set<String> s1 = driver.getWindowHandles();
            Iterator<String> i1 = s1.iterator();
            String parentWindow = i1.next();
            String childWindow = i1.next();

            driver.switchTo().window(childWindow);
            driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
        }

        @Then("validate product name in offers page matches with Landing Page")
        public void validate_product_name_in_offers_page () {
            Assert.assertEquals(offerPageProductName, landingPageProductName);

        }



}
