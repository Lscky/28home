package platform.order;

import platform.product.Product;

public class SellOrder<T extends Product> extends Order<T> {

    private SellOrder(T product, String client) {
        super(product, client);
    }

    public static <T extends Product> SellOrder with(T product, String client) {
        return new SellOrder<>(product, client);
    }

    public int compareValueOnEquals() {
    	return 1;
    }

}
