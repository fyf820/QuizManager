//main class
package com.example.r2dbc;

import io.r2dbc.spi.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.connectionfactory.init.ConnectionFactoryInitializer;
import org.springframework.data.r2dbc.connectionfactory.init.ResourceDatabasePopulator;

import java.time.Duration;
import java.util.Arrays;

@SpringBootApplication
public class R2dbcApplication {

    private static final Logger log = LoggerFactory.getLogger(R2dbcApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(R2dbcApplication.class, args);
    }

    @Bean
    ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

        ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
        initializer.setConnectionFactory(connectionFactory);
        initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));

        return initializer;
    }

    @Bean
    public CommandLineRunner demo(AccountRepository repository) {

        return (args) -> {
            // save a few accounts, 1 and 3 have the same name
            repository.saveAll(Arrays.asList(new Account("123", "Bauer", 1),
                new Account("234", "O'Brian",2),
                new Account("345", "Bauer",3),
                new Account("456", "Palmer",4),
                new Account("567", "Dessler",5)))
                .blockLast(Duration.ofSeconds(10));
            
            //find account by account number
            log.info("");
            log.info("Account found with findByNumber('123'):");
            log.info("--------------------------------------------");
            repository.findByNumber("123").doOnNext(bauer -> {
                log.info(bauer.toString());
            }).blockLast(Duration.ofSeconds(10));;

            //find account by owner name with a containing string and ignore case
            log.info("");
            log.info("Account found with findBynameContainingIgnoreCase(\"b\"):");
            log.info("--------------------------------------------");
            repository.findByNameContainingIgnoreCase("b").doOnNext(owner -> {
                log.info(owner.toString());
            }).blockLast(Duration.ofSeconds(10));;
            
            //find account by owner name with a prefix string
            log.info("");
            log.info("Using prefix to find Account with findBynameLike(\"Ba_\"):");
            log.info("--------------------------------------------");
            repository.findByNameLike("%Ba_%").doOnNext(bauer -> {
                log.info(bauer.toString());
            }).blockLast(Duration.ofSeconds(10));;
            
        	//delete account by account number, print the number of accounts it deleted
            log.info("");
            log.info("Result of deleteByName(\"123\") =");
            repository.deleteByNumber("123").doOnNext(counter -> {
                log.info(""+counter);
            }).block(Duration.ofSeconds(10));;;
            
            //find top 2 balance account
            log.info("");
            log.info("findTop2ByBalance() to find top 2 balance:");
            log.info("--------------------------------------------");
            repository.findTop2ByOderByBalanceDesc().doOnNext(tops -> {
                log.info(tops.toString());
            }).blockLast(Duration.ofSeconds(10));;
            
            //count the number of accounts
            log.info("");
            log.info("Number of accounts =");
            repository.count().doOnNext(counter -> {
                log.info(""+counter);
            }).block(Duration.ofSeconds(10));;
        };
    }

}
