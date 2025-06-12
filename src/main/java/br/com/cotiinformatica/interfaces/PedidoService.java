package br.com.cotiinformatica.interfaces;

import br.com.cotiinformatica.dtos.PedidoRequest;
import br.com.cotiinformatica.dtos.PedidoResponse;
import br.com.cotiinformatica.entities.Pedido;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface PedidoService {

    PedidoResponse criar(PedidoRequest request);

    PedidoResponse alterar(UUID id, PedidoRequest request);

    PedidoResponse excluir(UUID id);

    Page<PedidoResponse> consultar(int page, int size, String sortBy, String sortDirection);

    PedidoResponse obterPorId(UUID id);

}
