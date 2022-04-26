package br.com.alura.oobj.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ItemPedidoTest {
    ItemPedido itemPedido = new ItemPedido();
    @Test
    void deveRetornarSubTotalCom1Unidade(){
        itemPedido.setValorUnitario(new BigDecimal("200"));
        itemPedido.setQuantidade(1);

        Assertions.assertEquals(new BigDecimal("200"), itemPedido.getSubtotal());
    }

    @Test
    void deveRetornarSubTotalComMaisDe1Unidade(){
        itemPedido.setValorUnitario(new BigDecimal("200"));
        itemPedido.setQuantidade(4);

        Assertions.assertEquals(new BigDecimal("800"), itemPedido.getSubtotal());
    }
}