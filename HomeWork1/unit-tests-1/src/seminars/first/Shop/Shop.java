package seminars.first.Shop;

import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        // Допишите реализацию метода самостоятельно
        products.sort((o1, o2) -> ((Integer) o1.getCost()).compareTo(o2.getCost()));

        return null;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        // Допишите реализацию метода самостоятельно
        if (products==null) return null;

        Product resultProduct=products.get(0);
        int maxCost=products.get(0).getCost();
        for (Product p : products) {
            if (p.getCost()>maxCost) {
                resultProduct=p;
            }
        }
        return resultProduct;
    }

    public void printProducts() {
        for (Product p : products) {
            System.out.println(p.getTitle() + " : " + p.getCost());
        }
    }

}