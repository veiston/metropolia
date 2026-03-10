import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    @Test
    public void testAddItem() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Omppu", 1.0);
        cart.addItem("Bansku", 0.5);

        assertEquals(2, cart.getItemCount());
    }

    @Test
    public void testRemoveItem() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Omppu", 1.0);
        cart.addItem("Bansku", 0.5);
        cart.removeItem("Omppu");

        assertEquals(1, cart.getItemCount());
    }

    @Test
    public void testCalculateTotal() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Omppu", 1.0);
        cart.addItem("Bansku", 0.5);
        cart.addItem("Appelsiini", 0.75);

        assertEquals(2.25, cart.calculateTotal(), 0.01);
    }

    @Test
    public void testEmptyCartTotal() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0.0, cart.calculateTotal(), 0.001);
    }
}
