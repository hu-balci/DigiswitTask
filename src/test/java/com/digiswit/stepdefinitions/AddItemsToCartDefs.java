package com.digiswit.stepdefinitions;

import com.digiswit.pages.CartPage;
import com.digiswit.pages.HomePage;
import com.digiswit.pages.ResultPage;
import com.digiswit.utilities.ConfigReader;
import com.digiswit.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class AddItemsToCartDefs {

    HomePage homePage = new HomePage();
    ResultPage resultPage = new ResultPage();
    CartPage cartPage = new CartPage();


    @Given("I am on the Amazon homepage")
    public void iAmOnAmazonHomepage() {
        Driver.get().get(ConfigReader.get("url"));
        Driver.get().navigate().refresh();
        Driver.get().navigate().refresh();
    }

    @When("I search for {string}")
    public void searchForProduct(String product) {
        homePage.addSearchInputBox(product);
        homePage.clickSearchButton();
    }


    @And("I select the first hat")
    public void iSelectTheFirstHat() {
        resultPage.clickFirstItem();
    }

    @And("I add to the cart with quantity {string}")
    public void IAddToTheCartWithQuantity(String quantity) throws InterruptedException {
        try {
            Select optionsSize = new Select(resultPage.selectSize);
            optionsSize.selectByIndex(2);
        } catch (Exception e) {
        }
        try {
            resultPage.selectByValue(quantity);
        } catch (Exception e) {
        }

        Thread.sleep(3000);
        resultPage.click(resultPage.addToCart);
    }


    @Then("I open the cart")
    public void openCart() {
        resultPage.clickToCart();
    }


    @And("I assert the total price and quantity {string} are correct")
    public void iAssertTheTotalPriceAndQuantityAreCorrect(String quantity) {
        cartPage.verifyTheQuantity(quantity);
        cartPage.verifyTheTotalPrice(quantity);
    }


    @Then("I change the quantity for second item as {int} on Cart")
    public void iChangeTheQuantityOnCart(Integer lastQuantity) {
        cartPage.selectByValue(lastQuantity);
    }


    @Then("I should see total price and quantity {string} are changed correctly")
    public void the_user_should_see_total_price_and_quantity_are_changed_correctly(String expectedQuantity) throws InterruptedException {
        Thread.sleep(2000);
        String actualItemQuantity = cartPage.getQuantityOnCart();

        String expectedPrice = cartPage.getPriceOnTheCart();

        String actualPriceChanged = cartPage.getChangedPriceOnCart();

        assertEquals("I should see expected price and actual price is same", expectedPrice, actualPriceChanged);
        assertEquals("I should see expected quantity and actual quantity is same", expectedQuantity, actualItemQuantity.substring(10, 11));
    }
}
