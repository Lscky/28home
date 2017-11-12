package platform.order;

import platform.product.Product;

import java.math.BigDecimal;
import java.time.LocalDate;

abstract class Order<T extends Product> {

    private T product;
    private String client;
    private LocalDate expirationDate;

    Order(T product, String client) {
        this.product = product;
        this.client = client;
    }

    public String client() {
        return client;
    }

    public T product() {
        return product;
    }

    BigDecimal productPrice() {
        return product.price();
    }

    boolean priceIsLargerThen(Order order) {
        return productPrice().compareTo(order.productPrice()) > 0;
    }

}
