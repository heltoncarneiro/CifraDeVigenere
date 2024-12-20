package org.junit.jupiter.api;

import static org.junit.Assert.assertEquals;

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
}
