package platform.order;

import platform.product.Product;

import java.math.BigDecimal;
import java.time.LocalDate;

abstract class Order<T extends Product> implements Comparable<Order> {

    abstract int compareValueOnEquals();

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

    @Override
    public int compareTo(Order o) {
        int priceCompare = this.productPrice().compareTo(o.productPrice());
        if (priceCompare == 0) {
            if (this.client().equals(o.client())) {
                return 0;
            } else {
                return compareValueOnEquals();
            }
        }
        return priceCompare;
    }

}
