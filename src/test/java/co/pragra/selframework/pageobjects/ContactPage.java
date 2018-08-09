package co.pragra.selframework.pageobjects;

import co.pragra.selframework.config.SelectorConfig;
import co.pragra.selframework.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {
    private WebDriver driver;


    private WebElement nameInput;

    private WebElement emailInput;

    private WebElement subject;

    private WebElement message;

    public ContactPage(WebDriver driver){
        this.driver = driver;
        nameInput = getElement(driver, SelectorConfig.getProperty("contactpage.name")); //contactpage.name=name$your-name
        emailInput = getElement(driver,SelectorConfig.getProperty("contactpage.email"));
    }

    public ContactPage enterName(String name){
        this.nameInput.sendKeys(name);
        return this;
    }

    public ContactPage enterEmail(String email){
        this.emailInput.sendKeys(email);
        return this;
    }





    private WebElement getElement(WebDriver driver, String selectorProperty){
        String [] tokens = Utils.getToken(selectorProperty,"$");
        if(tokens[0].equalsIgnoreCase("xpath")){
            return  driver.findElement(By.xpath(tokens[1]));
        }
        if(tokens[0].equalsIgnoreCase("id")){
            return  driver.findElement(By.id(tokens[1]));
        }
        if(tokens[0].equalsIgnoreCase("name")){
            return  driver.findElement(By.name(tokens[1]));
        }
        if(tokens[0].equalsIgnoreCase("tagName")){
            return  driver.findElement(By.tagName(tokens[1]));
        }if(tokens[0].equalsIgnoreCase("cssSelector")){
            return  driver.findElement(By.cssSelector(tokens[1]));
        }
        if(tokens[0].equalsIgnoreCase("className")){
            return  driver.findElement(By.className(tokens[1]));
        }
        return null;

    }

}
