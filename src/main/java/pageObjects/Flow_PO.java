package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class Flow_PO extends Base_PO{

    private @FindBy(xpath = "/html/body/div[1]/header/div[2]/ul/li[2]/a")
    WebElement click_To_Login_Page;
    private @FindBy(id = "email")
    WebElement email_TextField;

    private @FindBy(id = "pass")
    WebElement pass_TextField;

    private @FindBy(id = "send2")
    WebElement login_Button;

    private @FindBy(xpath = "//div[@class='slick-slide slick-active']//div//a[@title='Cooluli Mini Nevera 4L'][normalize-space()='Cooluli Mini Nevera 4L']")
    WebElement product;

    private @FindBy(xpath = "//button[@id='buy-now']")
    WebElement buy_Now;

    private @FindBy(xpath = "//span[@class='title']")
    WebElement message;

    private @FindBy(xpath = "//a[@class='action showcart']")
    WebElement shopping_cart;

    private @FindBy(xpath = "//a[@class='action delete']")
    WebElement delete_Button;

    public Flow_PO(){
        super();
    }
    public void navigateToFlow_LoginPage(){
        navigateTo_URL("https://flow.bo/");
        madeClick(click_To_Login_Page);
    }
    public void doLogin(String email, String password){
        sendKeys(email_TextField, email);
        sendKeys(pass_TextField, password);
        madeClick(login_Button);
    }
    public void setEmail(String email){
        sendKeys(email_TextField, email);
    }
    public void setPassword(String password){
        sendKeys(pass_TextField, password);
    }
    public void click_Login_Button(){
        madeClick(login_Button);
    }
    public void search_Product(){
        Actions actions = new Actions(getDriver());
        actions.scrollToElement(product);
    }
    public void click_Product(){
        madeClick(product);
    }
    public void click_Comprar_Ahora_Button() {
        try {
            madeClick(buy_Now);
            sleep(4000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void redirect_To_Checkout_And_Compare(){
        try {
            sleep(2000);
            Assert.assertEquals(message.getText(),"Resumen del pedido");
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void clean_Data(){
        madeClick(shopping_cart);
        madeClick(delete_Button);
    }
}
