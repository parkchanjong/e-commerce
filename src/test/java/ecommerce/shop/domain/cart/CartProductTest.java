package ecommerce.shop.domain.cart;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import ecommerce.shop.domain.Product;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CartProductTest {

    /**
     * Method under test: {@link CartProduct#CartProduct(Cart, Product)}
     */
    @Test
    void testConstructor() {
        Cart cart = new Cart();
        cart.addCartProducts(new CartProduct());
        Product product = new Product();
        CartProduct actualCartProduct = new CartProduct(cart, product);

        Cart cart2 = actualCartProduct.getCart();
        assertSame(cart, cart2);
        assertNull(actualCartProduct.getProductId());
        assertNull(actualCartProduct.getId());
        Product product2 = actualCartProduct.getProduct();
        assertSame(product, product2);
        assertNull(cart2.getId());
        assertNull(product2.getModifiedDate());
        assertNull(product2.getId());
        assertNull(product2.getCreatedDate());
        assertEquals(1, cart2.getWishList().size());
    }

    /**
     * Method under test: {@link CartProduct#getProductId()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetProductId() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at ecommerce.shop.domain.cart.CartProduct.getProductId(CartProduct.java:38)
        //   See https://diff.blue/R013 to resolve this issue.

        (new CartProduct()).getProductId();
    }

    /**
     * Method under test: {@link CartProduct#getProductId()}
     */
    @Test
    void testGetProductId2() {
        Cart cart = new Cart();
        assertNull((new CartProduct(cart, new Product())).getProductId());
    }
}

