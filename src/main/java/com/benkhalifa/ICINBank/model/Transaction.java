package com.benkhalifa.ICINBank.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.benkhalifa.ICINBank.exception.InvalidAccountException;
import com.benkhalifa.ICINBank.exception.InvalidTransactionException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="transactions")
public class Transaction {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String description;
	
	@Column
	private Long transactionAmount;
	
	@Column
	private int sourceAccountNumber;
	
	@Column
	private int destinationAccountNumber;
	
	@Column
	private String ifsc;
	

	
	public void runValidationTests(PrimaryAccount sourceAccount, PrimaryAccount destinationAccount) {
        Long transactionAmount = getTransactionAmount();
        
        if (sourceAccount ==null || destinationAccount == null) {
            throw new InvalidAccountException(
                    String.format("Invalid source account %s "
                            + "or destination account %s", 
                            sourceAccount.getAccountNumber(),
                            destinationAccount.getAccountNumber()));
        }
        if (transactionAmount.compareTo(Long.valueOf(0)) <0) {
            throw new InvalidTransactionException(
                    String.format("Transaction %s is invalid"
                            + " due to negative value", getId()));
        }

       
    }

	
	

}
