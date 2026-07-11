package com.cognizant.ormlearn;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.cognizant.ormlearn.repository.StockRepository;

@SpringBootApplication
public class OrmLearnApplication {

    @Autowired
    private StockRepository stockRepository;

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);

        OrmLearnApplication app = context.getBean(OrmLearnApplication.class);

        app.testFacebookStocks();
        app.testGoogleStocks();
        app.testHighestVolume();
        app.testLowestNetflixStocks();

        context.close();
    }

    public void testFacebookStocks() {

        System.out.println("Facebook Stocks - September 2019");

        stockRepository.findByCodeAndDateBetween(
                "FB",
                LocalDate.of(2019, 9, 1),
                LocalDate.of(2019, 9, 30))
                .forEach(System.out::println);
    }

    public void testGoogleStocks() {

        System.out.println("\nGoogle Stocks - Closing Price > 1250");

        stockRepository.findByCodeAndCloseGreaterThan(
                "GOOGL",
                new BigDecimal("1250"))
                .forEach(System.out::println);
    }

    public void testHighestVolume() {

        System.out.println("\nTop 3 Highest Volume Transactions");

        stockRepository.findTop3ByOrderByVolumeDesc()
                .forEach(System.out::println);
    }

    public void testLowestNetflixStocks() {

        System.out.println("\nLowest 3 Netflix Closing Prices");

        stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX")
                .forEach(System.out::println);
    }
}