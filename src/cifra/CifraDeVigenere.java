package cifra;

import java.util.Scanner;

public class CifraDeVigenere {

	public static void main(String[] args) {
	    String alfabetoValido = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ,;._";
	    String texto = "Oi, meu nome e helton";
        String key = "helton";
        System.out.println("primeiro teste com texto \""+ texto+"\" e key: \""+ key+"\"");
        String textoCifrado = cifrar(texto,key,alfabetoValido);
        System.out.println("Texto cifrado: " + textoCifrado);
        String textodecifrado = decifrar(textoCifrado,key,alfabetoValido);
        System.out.println("Texto decifrado: " + textodecifrado);
        
        texto = "Na formula 1 em 2025 teremos um brasileiro correndo";
        key = "Gabriel Bortoleto";
        System.out.println("\n\nsegundo teste com texto \""+ texto+"\" e key: \""+ key+"\"");
        textoCifrado = cifrar(texto,key,alfabetoValido);
        System.out.println("Texto cifrado: " + textoCifrado); 
        textodecifrado = decifrar(textoCifrado,key,alfabetoValido);
        System.out.println("Texto decifrado: " + textodecifrado);
        
        texto = "nao aguento mais testar isso, espero que funcione, agora";
        key = "Por favor";
        System.out.println("\n\nterceiro teste com texto \""+ texto+"\" e key: \""+ key+"\"");
        textoCifrado = cifrar(texto,key,alfabetoValido);
        System.out.println("Texto cifrado: " + textoCifrado);
        textodecifrado = decifrar(textoCifrado,key,alfabetoValido);
        System.out.println("Texto decifrado: " + textodecifrado);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nteste manual");
        System.out.println("Escreva o texto a ser cifrado e decifrado:");
        texto = sc.nextLine();
        System.out.println("Escreva a key:");
        key = sc.nextLine();
        textoCifrado = cifrar(texto,key,alfabetoValido);
        System.out.println("Texto cifrado: " + textoCifrado);
        textodecifrado = decifrar(textoCifrado,key,alfabetoValido);
        System.out.println("Texto decifrado: " + textodecifrado);

        sc.close();
	}
	
	public static void validarTexto(String texto,String alfabeto) {
        for (char caractere : texto.toCharArray()) {
            if (alfabeto.indexOf(caractere) == -1) {
                throw new IllegalArgumentException("Caracter inválido encontrado: " + caractere);
            }
        }
	}
	
    public static String keyExpandida(String texto, String chave) {
        StringBuilder keyExpandida = new StringBuilder();
        while (keyExpandida.length() < texto.length()) {
        	keyExpandida.append(chave);
        }
        return keyExpandida.substring(0, texto.length());
    }
    
    public static String cifrar(String texto, String chave, String alfabeto) {
        validarTexto(texto,alfabeto);
        validarTexto(chave,alfabeto);
        String chaveExpandida = keyExpandida(texto, chave);
        StringBuilder textoCifrado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char caractereOriginal = texto.charAt(i);
            int posicaoOriginal = alfabeto.indexOf(caractereOriginal);

            char caractereChave = chaveExpandida.charAt(i);
            int posicaoChave = alfabeto.indexOf(caractereChave);

            int posicaoCifrada = (posicaoOriginal + posicaoChave) % alfabeto.length();
            textoCifrado.append(alfabeto.charAt(posicaoCifrada));
        }

        return textoCifrado.toString();
    }
    public static String decifrar(String textoCifrado, String chave, String alfabeto) {
        validarTexto(textoCifrado,alfabeto);
        validarTexto(chave,alfabeto);

        String chaveExpandida = keyExpandida(textoCifrado, chave);
        StringBuilder textoDecifrado = new StringBuilder();

        for (int i = 0; i < textoCifrado.length(); i++) {
            char caractereCifrado = textoCifrado.charAt(i);
            int posicaoCifrada = alfabeto.indexOf(caractereCifrado);

            char caractereChave = chaveExpandida.charAt(i);
            int posicaoChave = alfabeto.indexOf(caractereChave);

            int posicaoDecifrada = (posicaoCifrada - posicaoChave + alfabeto.length()) % alfabeto.length();
            textoDecifrado.append(alfabeto.charAt(posicaoDecifrada));
        }

        return textoDecifrado.toString();
    }

}
