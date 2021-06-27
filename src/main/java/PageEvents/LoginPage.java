package main.java.PageEvents;

import main.java.PageObjects.LoginPageElements;
import main.java.utils.ElementFetch;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;

public class LoginPage {

    public void ClickLogin()
    {
        ElementFetch elementFetch= new ElementFetch();
        elementFetch.getWebElement("Xpath", LoginPageElements.btn).click();

    }

    public void EnterEmail(String Email)
    {
        ElementFetch elementFetch= new ElementFetch();
        elementFetch.getWebElement("Xpath", LoginPageElements.name).sendKeys(Email);

    }
    public void EnterPassword(String Pass)
    {
        ElementFetch elementFetch= new ElementFetch();
        elementFetch.getWebElement("Xpath", LoginPageElements.pass).sendKeys(Pass);

    }
    public String GetTextInfo()
    {
        ElementFetch elementFetch= new ElementFetch();

        return elementFetch.getWebElement("Xpath", LoginPageElements.info_text).getText();


    }





}
