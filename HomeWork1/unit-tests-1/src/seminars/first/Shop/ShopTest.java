package seminars.first.Shop;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */
    public static void main(String[] args) {
        List<Product> myProducts= new ArrayList<Product>();
        Product expensiveProduct=null;

        Product prod1=new Product();
        prod1.setTitle("Апельсины");
        prod1.setCost(100);

        Product prod2=new Product();
        prod2.setTitle("Бананы");
        prod2.setCost(90);

        Product prod3=new Product();
        prod3.setTitle("Яблоки");
        prod3.setCost(80);

        myProducts.add(prod1);
        myProducts.add(prod2);
        myProducts.add(prod3);

        Shop myShop = new Shop();
        /*
        expensiveProduct=myShop.getMostExpensiveProduct();
        System.out.println("Самый дорогой продукт: "+expensiveProduct.getTitle() + ":" + expensiveProduct.getCost());
        */

        myShop.setProducts(myProducts);

        /*
        myShop.printProducts();
        System.out.println("----------------------------------------");
        */

        assertThat(myShop.getProducts()).hasSize(3);
        assertThat(myShop.getProducts()).contains(prod1,prod2,prod3);
        assertThat(myShop.getProducts()).containsSequence(prod1,prod2,prod3);

        expensiveProduct=myShop.getMostExpensiveProduct();

        assertThat(expensiveProduct).isEqualTo(prod1);

//        System.out.println("Самый дорогой продукт: "+expensiveProduct.getTitle() + ":" + expensiveProduct.getCost());

        myShop.sortProductsByPrice();

//        myShop.printProducts();

        assertThat(myShop.getProducts()).hasSize(3);
        assertThat(myShop.getProducts()).contains(prod1,prod2,prod3);
        assertThat(myShop.getProducts()).containsSequence(prod3,prod2,prod1);

        expensiveProduct=myShop.getMostExpensiveProduct();

        assertThat(expensiveProduct).isEqualTo(prod1);

//        System.out.println("Самый дорогой продукт: "+expensiveProduct.getTitle() + ":" + expensiveProduct.getCost());
    }

}