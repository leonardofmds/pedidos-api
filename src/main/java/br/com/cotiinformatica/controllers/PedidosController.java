package br.com.cotiinformatica.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/pedidos")
@Tag(name = "Pedidos", description = "Endpoints para gerenciar pedidos")
public class PedidosController {

    @PostMapping
    @Operation(summary = "Criar um novo pedido", description = "Endpoint para criar um novo pedido")
    public ResponseEntity<String> post() {
        return ResponseEntity.ok("Pedido criado com sucesso!");
    }

    @Operation(summary = "Atualizar um pedido existente", description = "Endpoint para atualizar um pedido existente")
    @PutMapping
    public ResponseEntity<String> put() {
        return ResponseEntity.ok("Pedido atualizado com sucesso!");
    }

    @Operation(summary = "Buscar um pedido", description = "Endpoint para buscar um pedido")
    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Pedido encontrado com sucesso!");
    }

    @Operation(summary = "Excluir um pedido", description = "Endpoint para excluir um pedido")
    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok("Pedido excluído com sucesso!");
    }


}
