package platform.order;

import platform.trade.Trade;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    void process(SellOrder order);
    void process(BuyOrder order);

    List<Trade> performedTrades();
}
