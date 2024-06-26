package br.com.alurafood.pedidos.amqp;

import br.com.alurafood.pedidos.dto.PagamentoDTO;
import br.com.alurafood.pedidos.service.PedidoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoListener {

    @Autowired
    private PedidoService service;

    @RabbitListener(queues = "pagamentos.pedidos")
    public void receberMensagem(PagamentoDTO pagamento){
        String mensagem = """
                Dados do pagamento: %s
                Número do pedido: %s
                Valor R$: %s
                Status: %s
                """.formatted(pagamento.getId(),
                pagamento.getPedidoId(),
                pagamento.getValor(),
                pagamento.getStatus());

        System.out.println("Recebi a mensagem " + mensagem);
        service.aprovaPagamentoPedido(pagamento.getPedidoId());
    }
}
