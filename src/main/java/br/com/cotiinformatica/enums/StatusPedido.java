package br.com.cotiinformatica.enums;

public enum StatusPedido {

	PENDENTE,		//Pedido criado, aguardando aprovação de pagamento 
	PROCESSANDO,	//Pedido em preparação
	ENVIADO,		//Pedido enviado para o cliente
	ENTREGUE,		//Pedido entregue ao cliente
	CANCELADO		//Pedido cancelado pelo cliente
}
