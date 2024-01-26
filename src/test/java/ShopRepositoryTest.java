import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ShopRepositoryTest {

    @Test
    public void shouldRemoveExistingItem() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(3, "шарф", 2500);
        Product product2 = new Product(6, "подушка", 4000);
        Product product3 = new Product(12, "бокалы", 1999);
        Product product4 = new Product(994, "чехол для телефона", 50);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.remove(12);

        Product[] expected = {product1, product2, product4};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNotExistingItem() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(3, "шарф", 2500);
        Product product2 = new Product(6, "подушка", 4000);
        Product product3 = new Product(12, "бокалы", 1999);
        Product product4 = new Product(994, "чехол для телефона", 50);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(1));
    }


}