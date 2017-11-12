package platform.trade;

import platform.order.BuyOrder;
import platform.order.SellOrder;

public class PumpkinSellTrade extends Trade {

    public PumpkinSellTrade(SellOrder sellOrder, BuyOrder buyOrder) {
        super(sellOrder, buyOrder);
    }

    @Override
    public String inHumanReadableFormat() {
        return sellOrder.client() + " sold a pumpkin to " + buyOrder.client() + " for " + sellOrder.product().price();
    }



}
