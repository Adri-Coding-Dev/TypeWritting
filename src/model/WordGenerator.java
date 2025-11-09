package model;
import java.util.*;

public class WordGenerator {
	private static final String[] WORDS = {
			"java", "codigo", "pantalla", "velocidad", "teclado", "raton",
	        "compilar", "logica", "sistema", "memoria", "programa", "error",
	        "ventana", "texto", "objeto", "funcion", "variable", "bucle"
	};

	public static List<String> generateWords(int count){
		Random random = new Random();
		List<String> list = new ArrayList<>();
		for(int i = 0;i< count; i++) {
			list.add(WORDS[random.nextInt(WORDS.length)]);
		}
		return list;
	}
}
