package dev.bank.bankstatement.model;

import java.time.LocalDate;

public class BankTransaction {
    
    private LocalDate date; // 거래날짜
    private double amount; // 금액
    private String description; // 거래처 명세

	public BankTransaction(LocalDate date, double amount, String description) {
		this.date = date;
		this.amount = amount;
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "BankTransaction [amount=" + amount + ", date=" + date + ", description=" + description + "]";
	}
    
}
