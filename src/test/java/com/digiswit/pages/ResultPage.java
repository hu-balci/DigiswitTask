package com.digiswit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ResultPage extends BasePage {


    @FindBy(xpath = "(//div[@data-cel-widget='search_result_1']//following-sibling::div//a[@class='a-link-normal s-no-outline'])[1]")
    public WebElement firstItem;

    @FindBy(xpath = "//select[@id='native_dropdown_selected_size_name']")
    public WebElement selectSize;

    @FindBy(id = "quantity")
    public WebElement quantityButton;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCart;

    @FindBy(id = "nav-cart-count")
    public WebElement cart;

    @FindBy(id = "quantity_1")
    public WebElement quantity_1;

    public void clickFirstItem(){
        waitForVisibility(firstItem);
        firstItem.click();
    }

    public void selectByValue(String value){
        Select select = new Select(quantityButton);
        select.selectByValue(String.valueOf(value));
        click(quantity_1);
    }

    public void clickToCart() {
        cart.click();
    }
}
