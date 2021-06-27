package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.java.BaseTest;

import java.util.List;

public class ElementFetch {
    public WebElement getWebElement(String identifierType, String identifiervalue) {

    switch (identifierType)
    {
        case "ID":
            return BaseTest.driver.findElement(By.id(identifiervalue));
        case "CSS":
            return BaseTest.driver.findElement(By.cssSelector(identifiervalue));
        case "TagName":
            return BaseTest.driver.findElement(By.tagName(identifiervalue));
        case "Xpath":
            return BaseTest.driver.findElement(By.xpath(identifiervalue));
        default:
            return null;
    }
    }
    public List <WebElement> getListWebElements(String identifierType, String identifiervalue) {

        switch (identifierType)
        {
            case "ID":
                return BaseTest.driver.findElements(By.id(identifiervalue));
            case "CSS":
                return BaseTest.driver.findElements(By.cssSelector(identifiervalue));
            case "TagName":
                return BaseTest.driver.findElements(By.tagName(identifiervalue));
            case "Xpath":
                return BaseTest.driver.findElements(By.xpath(identifiervalue));
            default:
                return null;
        }
    }



}
