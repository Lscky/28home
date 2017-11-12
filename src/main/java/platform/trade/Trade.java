package platform.trade;

import platform.order.BuyOrder;
import platform.order.SellOrder;

public abstract class Trade {

    public abstract String inHumanReadableFormat();

    SellOrder sellOrder;
    BuyOrder buyOrder;

    Trade(SellOrder sellOrder, BuyOrder buyOrder) {
        this.sellOrder = sellOrder;
        this.buyOrder = buyOrder;
    }

}