package br.com.alura.oobj.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class SubTotalPorClasseFiscalTest {



    @Test
    void deveRetornarOSubTotal(){
        ItemPedido itemPedido = new ItemPedido();

        itemPedido.setValorUnitario(new BigDecimal(50));
        itemPedido.setQuantidade(2);
        itemPedido.setClasseFiscal("9999.90.90");


        SubTotalPorClasseFiscal subTotalPorClasseFiscal = new SubTotalPorClasseFiscal();
        subTotalPorClasseFiscal.adicionaItemPedido(itemPedido);

        for (SubTotalPorClasseFiscal.Item item : subTotalPorClasseFiscal){
            Assertions.assertEquals("9999.90.90", item.getClasseFiscal());
            Assertions.assertEquals(new BigDecimal("100"), item.getSubTotal());
       }
    }




}