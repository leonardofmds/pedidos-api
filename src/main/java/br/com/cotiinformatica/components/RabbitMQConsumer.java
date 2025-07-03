package br.com.cotiinformatica.components;
import br.com.cotiinformatica.entities.OutboxMessage;
import br.com.cotiinformatica.repositories.OutboxMessageRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.cotiinformatica.events.PedidoCriado;

import java.time.LocalDateTime;

@Component
public class RabbitMQConsumer {

    @Autowired ObjectMapper objectMapper;
    @Autowired OutboxMessageRepository outboxMessageRepository;
    @Value("${api.faturamentos.host}")
    private String apiFaturamentosHost;

    /*
     * Método para ler a fila constantemente
     */
    @RabbitListener(queues = "pedidos")
    public void receive(@Payload String payload) {



        var outboxMessage = new OutboxMessage();
        outboxMessage.setDataHoraCriacao(LocalDateTime.now());
        outboxMessage.setMensagem(payload);

        try {
            //deserializar os dados lidos da API (json)
            var pedidoCriado = objectMapper.readValue(payload, PedidoCriado.class);

            //enviando para a API de faturamento
            var restTemplate = new RestTemplate();
            var url = "http://apiFaturamentosHost:8082/api/v1/faturamentos";
            var response = restTemplate.postForEntity(url, pedidoCriado, String.class);

            outboxMessage.setTransmitido(response.getStatusCode().is2xxSuccessful());
        }
        catch(Exception e) {
            outboxMessage.setTransmitido(false);
            e.printStackTrace();
        }
        finally {
            outboxMessageRepository.save(outboxMessage);
        }
    }
}


