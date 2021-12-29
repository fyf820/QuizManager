// repository, store query functions that offer service
package com.example.r2dbc;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AccountRepository extends ReactiveCrudRepository<Account, Long> {
	//find account by account number, return a list of account
	Flux<Account> findByNumber(String number);
	//find account by owner name with a containing string and ignore case, return a list of account
	Flux<Account> findByNameContainingIgnoreCase(String partialName);
	//find account by owner name with a prefix string, return a list of account
	Flux<Account> findByNameLike(String prefixName);
	//delete account by account number, return the number of accounts it deleted
	Mono<Long> deleteByNumber(String number);
	//find top 2 balance account, the method function returns a list so I customized it, return a list of account
	@Query("SELECT TOP 2 * from Account ORDER BY BALANCE DESC")
	Flux<Account> findTop2ByOderByBalanceDesc();
	//count the number of accounts, changed original function name to count to use query methods, return the number of accounts
	Mono<Long> count();
}

