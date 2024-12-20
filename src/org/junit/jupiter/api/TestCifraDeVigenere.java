package org.junit.jupiter.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import cifra.CifraDeVigenere;

public class TestCifraDeVigenere {
    
    @Test
    public void testCifrar() {
        String alfabetoValido = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ,;._";
        String texto = "Oi helton";
        String chave = "key";
        String resultadoEsperado = "YmtriJDsL";

        String textoCifrado = CifraDeVigenere.cifrar(texto, chave, alfabetoValido);
        assertEquals(resultadoEsperado, textoCifrado);
    }

    @Test
    public void testDecifrar() {
        String alfabetoValido = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ,;._";
        String texto = "YmtriJDsL";
        String chave = "key";
        String resultadoEsperado = "Oi helton";

        String textoDecifrado = CifraDeVigenere.decifrar(texto, chave, alfabetoValido);
        assertEquals(resultadoEsperado, textoDecifrado);
    }

    @Test
    public void testCifrarEDecifrar() {
        String alfabetoValido = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ,;._";
        String texto = "Testando123, com ponto; e espaco.";
        String chave = "Segredo";

        String textoCifrado = CifraDeVigenere.cifrar(texto, chave, alfabetoValido);
        String textoDecifrado = CifraDeVigenere.decifrar(textoCifrado, chave, alfabetoValido);

        assertEquals(texto, textoDecifrado);
    }

    @Test
    public void testEntradaComCaracteresInvalidos() {
        String alfabetoValido = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ,;._";
        String textoInvalido = "Texto inválido@";
        String chave = "key";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CifraDeVigenere.cifrar(textoInvalido, chave, alfabetoValido);
        });

        assertEquals("Caracter inválido encontrado: á", exception.getMessage());
    }

    @Test
    public void testChaveComCaracteresInvalidos() {
        String alfabetoValido = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ,;._";
        String texto = "Texto valido e funcional";
        String chaveInvalida = "chave@";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CifraDeVigenere.cifrar(texto, chaveInvalida, alfabetoValido);
        });

        assertEquals("Caracter inválido encontrado: @", exception.getMessage());
    }

    @Test
    public void testChaveMenorQueTexto() {
        String alfabetoValido = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ,;._";
        String texto = "Oi, teste de chave menor que o texto";
        String chave = "curta";

        String textoCifrado = CifraDeVigenere.cifrar(texto, chave, alfabetoValido);
        String textoDecifrado = CifraDeVigenere.decifrar(textoCifrado, chave, alfabetoValido);

        assertEquals(texto, textoDecifrado);
    }

    @Test
    public void testTextoVazio() {
        String alfabetoValido = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ,;._";
        String texto = "";
        String chave = "key";

        String textoCifrado = CifraDeVigenere.cifrar(texto, chave, alfabetoValido);
        String textoDecifrado = CifraDeVigenere.decifrar(textoCifrado, chave, alfabetoValido);

        assertEquals("", textoCifrado);
        assertEquals("", textoDecifrado);
    }
}
