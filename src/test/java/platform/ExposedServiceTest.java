package platform;

import org.junit.Test;
import platform.product.pumpkin.Pumpkin;
import platform.trade.Trade;

import java.math.BigDecimal;
import java.util.List;

public class ExposedServiceTest {

    @Test
    public void testHomeworkExample() {
        ExposedService exposed = new ExposedService();
        exposed.buy(pumpkinWithPrice(10), "Client A");
        exposed.buy(pumpkinWithPrice(11), "Client B");
        exposed.sell(pumpkinWithPrice(15), "Client C");
        exposed.sell(pumpkinWithPrice(9), "Client D");
        exposed.buy(pumpkinWithPrice(10), "Client E");
        exposed.sell(pumpkinWithPrice(10), "Client F");
        exposed.buy(pumpkinWithPrice(100), "Client G");

        List<Trade> performedTrades = exposed.performedTrades();
        assert performedTrades.size() == 3;

        Trade firstTrade = performedTrades.get(0);
        Trade secondTrade = performedTrades.get(1);
        Trade thirdTrade = performedTrades.get(2);

        assert firstTrade.inHumanReadableFormat().equals("Client D sold a pumpkin to Client B for 9");
        assert secondTrade.inHumanReadableFormat().equals("Client F sold a pumpkin to Client A for 10");
        assert thirdTrade.inHumanReadableFormat().equals("Client G bought a pumpkin from Client C for 100");

        printPerformedTests(performedTrades);
    }

    @Test
    public void testDifferentSituation() {
        ExposedService exposed = new ExposedService();
        exposed.buy(pumpkinWithPrice(1), "Client A");
        exposed.sell(pumpkinWithPrice(1), "Client B");
        exposed.sell(pumpkinWithPrice(10), "Client C");
        exposed.buy(pumpkinWithPrice(10), "Client D");
        exposed.buy(pumpkinWithPrice(10), "Client E");
        exposed.buy(pumpkinWithPrice(150), "Client F");
        exposed.sell(pumpkinWithPrice(100), "Client G");

        List<Trade> performedTrades = exposed.performedTrades();
        assert performedTrades.size() == 3;

        Trade firstTrade = performedTrades.get(0);
        Trade secondTrade = performedTrades.get(1);
        Trade thirdTrade = performedTrades.get(2);

        assert firstTrade.inHumanReadableFormat().equals("Client B sold a pumpkin to Client A for 1");
        assert secondTrade.inHumanReadableFormat().equals("Client D bought a pumpkin from Client C for 10");
        assert thirdTrade.inHumanReadableFormat().equals("Client G sold a pumpkin to Client F for 100");

        printPerformedTests(performedTrades);
    }

    private Pumpkin pumpkinWithPrice(int price) {
        return new Pumpkin(BigDecimal.valueOf(price));
    }

    private void printPerformedTests(List<Trade> performedTrades) {
        System.out.println("Performed trades:");
        for (Trade trade : performedTrades) {
            System.out.println(trade.inHumanReadableFormat());
        }
        System.out.println("-----");
    }

}
