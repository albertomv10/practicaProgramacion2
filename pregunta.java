package practica2evaluacion;

public class Pregunta {

	private String pregunta;
	private String respuesta1;
	private String respuesta2;
	private String respuesta3;
	private int solucion;
	private String[] lista_respuestas;

	public Pregunta(String pregunta, String respuesta1, String respuesta2, String respuesta3, int solucion) {

		this.pregunta = pregunta;
		this.respuesta1 = respuesta1;
		this.respuesta2 = respuesta2;
		this.respuesta3 = respuesta3;
		this.solucion = solucion;
		this.lista_respuestas = new String[3];
		lista_respuestas[0] = respuesta1;
		lista_respuestas[1] = respuesta2;
		lista_respuestas[2] = respuesta3;

	}

	public String getPregunta() {
		return pregunta;
	}

	public String getRespuesta1() {
		return respuesta1;
	}

	public String getRespuesta2() {
		return respuesta2;
	}

	public String getRespuesta3() {
		return respuesta3;
	}

	public int getSolucion() {
		return solucion;
	}

	public String[] getLista_respuestas() {
		return lista_respuestas;
	}

}
