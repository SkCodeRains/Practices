package com.coderains.rainsbank.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "account_transactions")
@ToString
@Setter
@Getter
public class AccountTransactions {
	@Id
	@Column(name = "transaction_id")
	private String transactionId;

	@Column(name = "account_number")
	private long accountNumber;

	@Column(name = "customer_id")
	private long customerId;

	@Column(name = "transaction_dt")
	private Date transactionDt;

	@Column(name = "transaction_summary")
	private String transactionSummary;

	@Column(name = "transaction_type")
	private String transactionType;

	@Column(name = "transaction_amt")
	private int transactionAmt;

	@Column(name = "closing_balance")
	private int closingBalance;

	@Column(name = "create_dt")
	private String createDt;
}