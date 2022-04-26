package br.com.alura.oobj.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


class ProcessadorFonteDadosTest {


    @Test
    void deveRetornarValorDaQuantidadeTotal(){

        LeitorFonteDados leitor = Mockito.mock(LeitorFonteDados.class);
        ProcessadorFonteDados processadorFonteDados = new ProcessadorFonteDados(leitor);

        Mockito.when(leitor.recupera(Mockito.anyString())).
                thenReturn(pedido());
        ResultadoProcessamento res = processadorFonteDados.processa(Mockito.anyString());


        Assertions.assertEquals(new BigDecimal("240"), res.getTotalPedido());
    }



    private Pedido pedido() {
        Pedido pedido = new Pedido();
        ItemPedido item1 = new ItemPedido();
        ItemPedido item2 = new ItemPedido();
        List<ItemPedido> itens = new ArrayList<>();

        item1.setValorUnitario(new BigDecimal(20.00));
        item1.setClasseFiscal("2018.2022");
        item1.setQuantidade(2);
        item1.setDescricao("Refrigerante");
        itens.add(item1);

        item2.setValorUnitario(new BigDecimal(40.00));
        item2.setClasseFiscal("2015.2022");
        item2.setQuantidade(5);
        item2.setDescricao("Suco");
        itens.add(item2);

        pedido.setItens(itens);

        return pedido;
    }
}