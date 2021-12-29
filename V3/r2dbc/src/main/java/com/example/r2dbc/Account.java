// Account class that for the account data
// changed original Account class to Customer's format
package com.example.r2dbc;
import org.springframework.data.annotation.Id;

public class Account {
	//private value id, number, name, and balance, changed the data type of balance to long
    @Id
    private Long id;

    private final String number;

    private final String name;
    
    protected long balance;

    //initialize number, name and balance
    public Account(String number, String name, long balance) {
        this.number = number;
        this.name = name;
        this.balance =  balance;
    }
    
    //getters and setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnumber() {
        return this.number;
    }

    public String getname() {
        return this.name;
    }
    
    public long getbalance() {
        return this.balance;
    }
    
    //convert account to string
    @Override
    public String toString() {
        return String.format(
            "Account[id=%d, number='%s', name='%s', balance='%d']",
            id, number, name, balance);
    }
}
