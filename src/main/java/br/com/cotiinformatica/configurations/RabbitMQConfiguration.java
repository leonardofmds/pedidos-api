package br.com.cotiinformatica.configurations;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {


    @Value("${queue.name}")
    private String queueName;

    @Bean
    Queue queue() {
        return new Queue(queueName, true);
    }
}
