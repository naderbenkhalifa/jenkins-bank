package com.benkhalifa.ICINBank.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PersonalTransaction {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private int accNo;
	
	@Column
	private Date date;
	
	@Column
	private Long prevBalance;
	
	@Column
	private Long newBalance;
	
	@Column
	private String transactionType;
	
	@Column
	private String accType;
	
	public PersonalTransaction(int accNo, Date date, Long prevBalance, Long newBalance, String transactionType,
			String accType) {
		super();
		this.accNo = accNo;
		this.date = date;
		this.prevBalance = prevBalance;
		this.newBalance = newBalance;
		this.transactionType = transactionType;
		this.accType = accType;
	}
	

}
