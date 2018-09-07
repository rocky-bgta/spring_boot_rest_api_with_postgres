package com.nybsys.tillboxweb;

import com.nybsys.tillboxweb.broker.client.BrokerSubscriber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    private static BrokerSubscriber brokerSubscriber;

	public static void main(String[] args) {
        brokerSubscriber = new BrokerSubscriber();
        brokerSubscriber.subscribe();
		SpringApplication.run(Application.class, args);
	}
}
