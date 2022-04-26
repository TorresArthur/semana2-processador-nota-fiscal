package br.com.alura.oobj.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


class PedidoTest {

    ItemPedido itemPedido = new ItemPedido();
    List<ItemPedido> itens = new ArrayList<>();
    Pedido pedido = new Pedido();


    @Test
    void deveRetornarValorTotalComApenas1Item(){
        itemPedido.setValorUnitario(new BigDecimal("50"));
        itemPedido.setQuantidade(1);

        itens.add(itemPedido);
        pedido.setItens(itens);

        Assertions.assertEquals(new BigDecimal(50), pedido.getTotal());

    }

    @Test
    void deveRetornarValorTotalComVariosItens(){


        itemPedido.setValorUnitario(new BigDecimal("50"));
        itemPedido.setQuantidade(1);

        ItemPedido itemPedido2 = new ItemPedido();
        itemPedido2.setValorUnitario(new BigDecimal("100"));
        itemPedido2.setQuantidade(1);


        itens.add(itemPedido);
        itens.add(itemPedido2);
        pedido.setItens(itens);

        Assertions.assertEquals(new BigDecimal(150), pedido.getTotal());

    }

    @Test
    void deveRetoranarExcecaoQuandoAListaEVazia(){

        itens = null;
        pedido.setItens(itens);

       Assertions.assertThrows(IllegalArgumentException.class,
                () -> pedido.getTotal());
    }
}