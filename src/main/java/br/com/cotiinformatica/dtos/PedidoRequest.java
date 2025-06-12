package br.com.cotiinformatica.dtos;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PedidoRequest {

    @NotNull(message="Informe o valor do pedido")
    @DecimalMin(value = "0.01", message = "O valor do pedido deve ser maior que zero")
    private Double valor;

    @NotEmpty(message="Informe o cliente do pedido")
    @Size(min = 8, max = 100, message = "O nome do cliente deve ter entre 3 e 100 caracteres")
    private String cliente;

    @NotEmpty(message="Informe os detalhes do pedido")
    @Size(min = 8, max = 250, message = "Os detalhes do pedido devem ter entre 10 e 250 caracteres")
    private String detalhes;
}
