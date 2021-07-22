import org.knowm.xchange.Exchange;
import org.knowm.xchange.ExchangeFactory;
import org.knowm.xchange.ExchangeSpecification;
import org.knowm.xchange.currency.CurrencyPair;
import org.knowm.xchange.dto.Order;
import org.knowm.xchange.dto.marketdata.Ticker;
import org.knowm.xchange.dto.trade.LimitOrder;
import org.knowm.xchange.dto.trade.MarketOrder;
import org.knowm.xchange.dto.trade.StopOrder;
import org.knowm.xchange.ftx.FtxExchange;
import org.knowm.xchange.ftx.service.FtxAccountService;

import java.io.IOException;
import java.math.BigDecimal;

public class Main {
    private static final String API_KEY = "lftGwHbRnxHT9AE1jnE_N1Xtq3MpIomw1g5QVtH3";
    private static final String SECRET_KEY = "6VAhY1UjO3XroZH63rBU17cF754rE1MTZhwOZySg";
    public static void main(String[] args) throws IOException {
        ExchangeSpecification exchangeSpecification = new ExchangeSpecification(FtxExchange.class);
        exchangeSpecification.setApiKey(API_KEY);
        exchangeSpecification.setSecretKey(SECRET_KEY);
        Exchange ftx = ExchangeFactory.INSTANCE.createExchange(exchangeSpecification);

        MarketOrder marketOrder = new MarketOrder(Order.OrderType.BID, new BigDecimal("0.0002"),
                CurrencyPair.BTC_USDT, null);

        LimitOrder limitOrder = new LimitOrder(Order.OrderType.BID, new BigDecimal("0.0001"),
                CurrencyPair.BTC_USDT, null, null, new BigDecimal("29000"));

        StopOrder stopOrder = new StopOrder(Order.OrderType.BID, new BigDecimal("0.0001"),
                CurrencyPair.BTC_USDT, null, null, new BigDecimal("31600"));
//        working

//        System.out.println(ftx.getAccountService().getAccountInfo().getWallets());
//        System.out.println(ftx.getTradeService().placeMarketOrder(marketOrder));
        System.out.println(ftx.getTradeService().placeLimitOrder(limitOrder));
//        System.out.println(ftx.getAccountService().getAccountInfo());
//        System.out.println(ftx.getTradeService().cancelOrder("65280062127"));
//        System.out.println(ftx.getMarketDataService().getOrderBook(CurrencyPair.BTC_USDT, null));
//        System.out.println(ftx.getTradeService().getOpenOrders());

        System.out.println(ftx.getMarketDataService().getTickers(null));
//        System.out.println(ftx.getMarketDataService().getTicker(CurrencyPair.BTC_USDT, null));
//        System.out.println(ftx.getExchangeSpecification().getUserName());

        FtxAccountService accountService = new FtxAccountService(ftx);
//        accountService.getSubaccountInfo("qwe");

//        not working

//        System.out.println(ftx.getTradeService().placeStopOrder(stopOrder));

    }
}
