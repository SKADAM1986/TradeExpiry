package com.mycode.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.mycode.entity.Trade;

@Component
public class Processor implements ItemProcessor<Trade, Trade> {

	@Override
	public Trade process(Trade trade) throws Exception {
		
		System.out.println("Validating Expiry date...");
		//if trade is expired, set update flag to false
		System.out.println(trade.toString());
		return trade;
	}

}
