package cifra;

public class CifraDeVigenere {

	public static void main(String[] args) {
	    String alfabetoValido = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ,;._";
	    String texto = "asdfgsdfgsdfgsdfgsdfgsdfgsdfgsdfgsdfgsdf";
        String key = "b";

        String textoCifrado = cifrar(texto,key,alfabetoValido);
        System.out.println("Texto cifrado: " + textoCifrado);
        
        String textodecifrado = decifrar(textoCifrado,key,alfabetoValido);
        System.out.println("Texto decifrado: " + textodecifrado);
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
