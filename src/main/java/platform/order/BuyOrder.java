package platform.order;

import platform.product.Product;

public class BuyOrder<T extends Product> extends Order<T> {

    private BuyOrder(T product, String client) {
        super(product, client);
    }

    public static <T extends Product> BuyOrder with(T product, String client) {
        return new BuyOrder<>(product, client);
    }

    public int compareValueOnEquals() {
    	return -1;
    }

}
