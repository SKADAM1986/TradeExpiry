package com.mycode.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Getter
@Setter
@ToString
public class Trade {
	
	@Id
	private String tradeId;
	
	private String version;
	
	private String desc;
	
	private int quantity;
	
	private int alias;
}
