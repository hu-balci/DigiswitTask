Amazon Task notes:

1. Since Amazon gets updated very frequently you may not be able to get the test passed on the first try.
2. On some occasions Amazon homepage doesnot load, so most probably you will see locator issue please rerun tests
3.  Even though in the task, selected option size is not mentioned, for some cases I have to take into account it.
    Because without choosing size, it is impossible add product to cart.
    To solve this issue I have added a simple try catch exception
4. There is two try catch on my tests that is for handling quantity issue.
   Because on some first hats option, selected size does not have enough quantity in that case try catch choose available one
5. While testing I have seen some hats do not have Spain shipping option so add to cart button does not appear in those cases.
   Please rerun the test in those cases.
6. And lastly, also in some occasion first hat option for men and women could be same as it shows  unisex hat
   in that cases assertions failing since on the cart all hats appear in one hat type. please rerun the test

And finally I just want to mention that recommended hat options been changed every 30 mins.
If the test fail repetitively because of one of the reason above, i would kindly recommend it to rerun it after 30 mins.