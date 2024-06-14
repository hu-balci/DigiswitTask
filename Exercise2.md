I have created a simple test plan for front-end task

**Test Plan: Adding Hats to Cart**

**Test Objectives:**
1. Verify that the user can successfully add hats for men to the cart.
2. Ensure that the total price and quantity in the cart are accurate.
3. Validate that the user can modify the quantity of items in the cart and see the updated total price and quantity.

**Test Environment:**
* Browser: Google Chrome (latest version)
* Operating System: Windows 10
* Amazon Website: Amazon.com

**Test Scenarios:**
   1. Scenario 1: Add Hats for Men to the Cart
   2. Scenario 2: Add Hats for Women to the Cart
   3. Scenario 3: Modify Quantity in Cart

**Test Cases:**

   Test Case 1: Add Hats for Men to the Cart

        Step 1: Search for "hats for men"
        Step 2: Select the first hat
        Step 3: Add to the cart with quantity "2"
        Step 4: Open the cart
        Step 5: Assert the total price and quantity "2" are correct

   Test Case 2: Add Hats for Women to the Cart

        Step 1: Search for "hats for women"
        Step 2: Select the first hat
        Step 3: Add to the cart with quantity "1"
        Step 4: Open the cart
        Step 5: Assert the total price and quantity "3" are correct

   Test Case 3: Modify Quantity in Cart

        Step 1: Open the cart
        Step 2: Change the quantity for the second item (hats for men) to "1"
        Step 3: Verify that the total price and quantity "2" are changed correctly


**Test Data:**

    1.Search Terms:
        1. hats for men
        2. hats for woman

    2.Quantity Values
        1. Initially "2" for "hats for men" search
        2. "1" for "hats for women" search
        3. "1" for modifying "hats for men" quatity on the cart

    Expected Results:
        1.Total price and quantity "2" are correct for hats for men
        2.Total price and quantity "3" are correct for hats for women
        3.Total price and quantity "2" are changed correctly after modifying quantity in cart
