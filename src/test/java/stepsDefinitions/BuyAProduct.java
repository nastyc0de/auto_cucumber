package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Flow_PO;

import java.time.Duration;
import static java.lang.Thread.*;

public class BuyAProduct extends Base_PO {

    private WebDriver driver = getDriver();
    private Flow_PO flow_po;
    public BuyAProduct(Flow_PO flow_po){
        this.flow_po = flow_po;
    }
    @Given("I access to Flow bo")
    public void i_access_to_flow_bo() {
        flow_po.navigateToFlow_LoginPage();
    }
    @When("I do login with my account")
    public void i_do_login_with_my_account() {
        flow_po.doLogin("andres.rueda@trueforce.com", "v32@S.1rue");
    }
    @And("I search a product")
    public void i_search_a_product() {
        flow_po.search_Product();
    }
    @And("I select a product")
    public void i_select_a_product() {
        flow_po.click_Product();
    }
    @And("I click on the Comprar Ahora button")
    public void i_click_on_the_comprar_ahora_button(){
        flow_po.click_Comprar_Ahora_Button();
    }
    @Then("I should be redirected to the checkout page")
    public void i_should_be_redirected_to_the_checkout_page(){
        flow_po.redirect_To_Checkout_And_Compare();
    }
}
