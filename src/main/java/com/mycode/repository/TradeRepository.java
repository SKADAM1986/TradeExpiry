package com.mycode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycode.entity.Trade;

public interface TradeRepository extends JpaRepository<Trade, Long> {
}
