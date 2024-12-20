package cifra;

public class CifraDeVigenere {

	public static void main(String[] args) {
	    final String alfabetoValido = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ,;.";
	    String texto = "Oi helton";
        String chave = "key";

        String textoCifrado = cifrar(texto, chave,alfabetoValido);
        System.out.println("Texto cifrado: " + textoCifrado);
	}
	
    public static String chaveExpandida(String texto, String chave) {
        StringBuilder chaveExpandida = new StringBuilder();
        while (chaveExpandida.length() < texto.length()) {
            chaveExpandida.append(chave);
        }
        return chaveExpandida.substring(0, texto.length());
    }
    
    public static String cifrar(String texto, String chave, String alfabeto) {

        String chaveExpandida = chaveExpandida(texto, chave);
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

}
