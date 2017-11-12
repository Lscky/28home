package platform.trade;

import platform.order.BuyOrder;
import platform.order.SellOrder;

public class PumpkinBuyTrade extends Trade {

    public PumpkinBuyTrade(SellOrder sellOrder, BuyOrder buyOrder) {
        super(sellOrder, buyOrder);
    }

    @Override
    public String inHumanReadableFormat() {
        return buyOrder.client() + " bought a pumpkin from " + sellOrder.client() + " for " + buyOrder.product().price();
    }

}
