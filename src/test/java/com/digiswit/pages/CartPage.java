package com.digiswit.pages;

import com.digiswit.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//span[@data-a-class='quantity']")
    private List<WebElement> quantity;

    @FindBy(id = "sc-subtotal-amount-buybox")
    private WebElement changedPriceOnCart;

    @FindBy(xpath = "//span[@id='sc-subtotal-label-activecart']")
    public WebElement quantityOnCart;

    @FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']")
    public WebElement subTotalPriceOnCart;

    public int getItemQuantity() {
        return Integer.parseInt(quantityOnCart.getText().substring(10,11));
    }

    public String totalPrice() {
        waitForVisibility(subTotalPriceOnCart);
        return subTotalPriceOnCart.getText().substring(2);
    }

    public void verifyTheQuantity(String quantity) {
        int expectedQuantity = Integer.parseInt(quantity);
        Assert.assertEquals("I should see expected quantity and item quantity on the cart is same",expectedQuantity, getItemQuantity());
    }

    public void verifyTheTotalPrice(String quantity) {
        Assert.assertEquals("I should see expected total price and item total price on the cart is same", getExpectedTotalPrice(), totalPrice());
    }

    public WebElement selectList(int value) {

        String locator = "(//select[@name='quantity'])[" + value + "]";

        return Driver.get().findElement(By.xpath(locator));
    }

    public String getQuantityOnCart() {
       return quantityOnCart.getText();
    }

    public String getPriceOnTheCart() {
        return subTotalPriceOnCart.getText().trim();
    }

    public String getChangedPriceOnCart() {
        return changedPriceOnCart.getText().trim();
    }

    public void selectByValue(int value){
        waitForVisibility(selectList(2));
        Select select = new Select(selectList(2));
        select.selectByValue(String.valueOf(value));
    }

    private List<WebElement> getPriceLocator() {
        return Driver.get().findElements(By.xpath("//div[@class='a-section a-spacing-mini']"));
    }

    public String getExpectedTotalPrice() {

        Double totalPrice = 0.0;

        for (int i = 0; i < quantity.size(); i++) {
            String quantityOnCart = quantity.get(i).getText().substring(4);
            String priceOnCart = getPriceLocator().get(i).getText().substring(1);
            totalPrice += Double.parseDouble(priceOnCart) * Integer.parseInt(quantityOnCart);
        }
        return String.format("%.2f", totalPrice);
    }
}