package br.com.cotiinformatica.events;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Data
public class PedidoCriado {

    private UUID id;
    private Date dataPedido;
    private Double valor;
    private String cliente;
    private String detalhes;
    private String status;
    private LocalDateTime dataHoraCriacao;
}
