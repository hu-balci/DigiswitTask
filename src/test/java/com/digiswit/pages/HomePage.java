package com.digiswit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;


    @FindBy(id = "nav-search-submit-button")
    public WebElement searchButton;

    public void addSearchInputBox(String productName) {
        searchBox.sendKeys(productName);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

}
