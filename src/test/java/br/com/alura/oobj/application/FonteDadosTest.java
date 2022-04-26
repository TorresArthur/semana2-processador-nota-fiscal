package br.com.alura.oobj.application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class FonteDadosTest {



    @Test
    void deveLerUmArquivoXml(){
        LeitorFonteDados leitor = FonteDados.obtemLeitor("Teste.xml");
        Assertions.assertEquals(LeitorFonteDadosXML.class, leitor.getClass());
    }

    @Test
    void deveLerUmArquivoCsv(){
        LeitorFonteDados leitor = FonteDados.obtemLeitor("Teste.csv");
        Assertions.assertEquals(LeitorFonteDadosCSV.class, leitor.getClass());
    }

    @Test
    void deveLancarUmaExcecaoQuandoOArquivoForInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> FonteDados.obtemLeitor(Mockito.anyString()));
    }

}