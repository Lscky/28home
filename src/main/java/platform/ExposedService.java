package platform;

import platform.order.BuyOrder;
import platform.order.OrderService;
import platform.order.PumpkinOrderService;
import platform.order.SellOrder;
import platform.product.pumpkin.Pumpkin;
import platform.trade.Trade;

import java.util.List;

public class ExposedService {

    private OrderService orderService = new PumpkinOrderService();

    public void sell(Pumpkin pumpkin, String client) {
        SellOrder sellOrder = SellOrder.with(pumpkin, client);
        orderService.process(sellOrder);
    }


    public void buy(Pumpkin pumpkin, String client) {
        BuyOrder buyOrder = BuyOrder.with(pumpkin, client);
        orderService.process(buyOrder);
    }

    public List<Trade> performedTrades() {
        return orderService.performedTrades();
    }

}
