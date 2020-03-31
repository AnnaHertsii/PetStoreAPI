package test.cart_tests.functionality.add_to_cart.negative.add_less_than_min_value_of_product_qty.button_check;

import com.opencart.pages.product.ProductPage;
import com.opencart.tools.cart_test_ranner.AbstractCartTestRunner;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddProductToCartWithOptionsTest extends AbstractCartTestRunner {

    @Test
    @Parameters({"productNameOfCinema", "radioButtonOptionName",
            "checkBoxOptionName", "selectOptionsOptionName", "valueOf1", "emptyCartButtonText"})
    public void checkAddProductWithOptionsToCartWith1Qty(String productNameOfCinema, String radioButtonOptionName,
                                                             String checkBoxOptionName, String selectOptionsOptionName,
                                                             String valueOf1,
                                                             String emptyCartButtonText) {
        ProductPage cinemaPage = ((ProductPage) getHomePage()
                .clickProductComponentAddToCartButtonByName(productNameOfCinema))
                .addToCartProductWitOptions(radioButtonOptionName, checkBoxOptionName,
                        selectOptionsOptionName, Integer.valueOf(valueOf1));

        Assert.assertEquals(cinemaPage.getCartButtonText(), emptyCartButtonText);
    }

}