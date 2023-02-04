package stepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static java.lang.Thread.*;

public class BuyAProduct {

    private WebDriver driver;
    @Before
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I access to Flow bo")
    public void i_access_to_flow_bo() {
        driver.get("https://flow.bo/");
        driver.findElement(By.cssSelector("div[class='header content'] li[data-label='o'] a")).click();
    }
    @When("I do login with my account")
    public void i_do_login_with_my_account() {
        driver.findElement(By.id("email")).sendKeys("andres.rueda@trueforce.com");
        driver.findElement(By.id("pass")).sendKeys("v32@S.1rue");
        driver.findElement(By.id("send2")).click();
    }
    @And("I search a product")
    public void i_search_a_product() {
        WebElement product = driver.findElement(By.xpath("//div[@class='slick-slide slick-active']//div//a[@title='Cooluli Mini Nevera 4L'][normalize-space()='Cooluli Mini Nevera 4L']"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(product);
    }
    @And("I select a product")
    public void i_select_a_product() {
        WebElement product = driver.findElement(By.xpath("//div[@class='slick-slide slick-active']//div//a[@title='Cooluli Mini Nevera 4L'][normalize-space()='Cooluli Mini Nevera 4L']"));
        product.click();
    }
    @And("I click on the Comprar Ahora button")
    public void i_click_on_the_comprar_ahora_button(){
        driver.findElement(By.xpath("//button[@id='buy-now']")).click();
    }
    @Then("I should be redirected to the checkout page")
    public void i_should_be_redirected_to_the_checkout_page() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='title']")));
        WebElement message = driver.findElement(By.xpath("//span[@class='title']"));
        sleep(2000);
        Assert.assertEquals(message.getText(),"Resumen del pedido");
    }
}
