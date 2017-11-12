package platform.product;

import java.math.BigDecimal;

public abstract class Product {

    private BigDecimal price;
    private int count;

    protected Product(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal price() {
        return price;
    }

}
