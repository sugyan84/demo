package com.practice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.practice.consumers.stockPrice.StockPriceConsumer;


@RestController
@RequestMapping("/stock")
public class StockResource {

    @Autowired
    private StockPriceConsumer consumer;

    @GetMapping()
    public String getStockDetails(){
        return consumer.getTimeSeriesDailyStockPrices("TIME_SERIES_INTRADAY",
                                                        "MSFT",
                                                        "5min");
    }
}
