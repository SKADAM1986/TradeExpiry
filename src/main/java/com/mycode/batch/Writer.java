package com.mycode.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mycode.entity.Trade;
import com.mycode.repository.TradeRepository;

@Component
public class Writer implements ItemWriter<Trade>{
	
	@Autowired
	private TradeRepository repo;

	@Override
	@Transactional
	public void write(List<? extends Trade> trades) throws Exception {
		System.out.println("Writing data into DB...");
		trades.forEach(System.out::println);
		repo.saveAll(trades);
	}
	
}
