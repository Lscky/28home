package platform.order;

import platform.trade.PumpkinBuyTrade;
import platform.trade.PumpkinSellTrade;
import platform.trade.Trade;

import java.util.*;

public class PumpkinOrderService implements OrderService {

    private TreeSet<SellOrder> sellOrders = new TreeSet<>();
    private TreeSet<BuyOrder> buyOrders = new TreeSet<>();

    private List<Trade> performedTrades = new ArrayList<>();

    @Override
    public synchronized void process(SellOrder sellOrder) {
        if (buyOrders.isEmpty()) {
            sellOrders.add(sellOrder);
        } else {
            BuyOrder buyOrder = buyOrders.last();

            if (sellOrder.priceIsLargerThen(buyOrder)) {
                sellOrders.add(sellOrder);
            } else {
                buyOrders.remove(buyOrder);
                Trade trade = createSellTrade(sellOrder, buyOrder);
                savePerformedTrade(trade);
            }
        }
    }

    @Override
    public synchronized void process(BuyOrder buyOrder) {
        if (sellOrders.isEmpty()) {
            buyOrders.add(buyOrder);
        } else {
            SellOrder sellOrder = sellOrders.first();

            if (sellOrder.priceIsLargerThen(buyOrder)) {
                buyOrders.add(buyOrder);
            } else {
                sellOrders.remove(sellOrder);
                Trade trade = createBuyTrade(sellOrder, buyOrder);
                savePerformedTrade(trade);
            }
        }
    }

    @Override
    public List<Trade> performedTrades() {
        return performedTrades;
    }

    private Trade createBuyTrade(SellOrder sellOrder, BuyOrder buyOrder) {
        return new PumpkinBuyTrade(sellOrder, buyOrder);
    }

    private Trade createSellTrade(SellOrder sellOrder, BuyOrder buyOrder) {
       return new PumpkinSellTrade(sellOrder, buyOrder);
    }

    private void savePerformedTrade(Trade trade) {
        performedTrades.add(trade);
    }

}
