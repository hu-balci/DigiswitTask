package com.digiswit.pages;

import com.digiswit.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class  BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void waitForVisibility(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element){
        waitForVisibility(element);
        scrollInto(element);
        element.click();
    }

    public void scrollInto(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].scrollIntoView();",element);
    }

}
