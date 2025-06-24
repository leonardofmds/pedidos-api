package br.com.cotiinformatica.components;

import br.com.cotiinformatica.events.PedidoCriado;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    Queue queue;

    public void send(PedidoCriado pedidoCriado){
        try {
            var json = objectMapper.writeValueAsString(pedidoCriado);
            rabbitTemplate.convertAndSend(queue.getName(),json);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
