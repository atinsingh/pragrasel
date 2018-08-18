package co.pragra.selframework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
contactpage.name = name$your-name
contactpage.email= cssSelector$input[name='your-email']
contactpage.subject =xpath$//input[@name='your-subject']
contactpage.message = cssSelector$textarea[name='your-message']
contactpage.submitBtn = xpath$//input[@type='submit' and @value='Send']
 */
public class ContactPageV2 {

    @FindBy(name = "your-name")
    private WebElement yourName;

    @FindBy(css = "input[name='your-email']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='your-subject']" )
    private WebElement subject;


    @FindBy(name ="your-message" )
    private WebElement message ;

    public ContactPageV2(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public ContactPageV2 typeName(String name){
        this.yourName.sendKeys(name);
        return this;
    }

    public ContactPageV2 typeEmail(String email){
        this.email.sendKeys(email);
        return this;
    }

    public ContactPageV2 typeSubject(String sub){
        this.subject.sendKeys(sub);
        return this;
    }

    public WebElement getYourName() {
        return yourName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getSubject() {
        return subject;
    }

    public WebElement getMessage() {
        return message;
    }
}
