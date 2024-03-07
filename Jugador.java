package practica2evaluacion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Jugador {

	private String nombre;
	private int edad;
	private int puntuacion;

	public Jugador(String nombre, int edad) {

		this.nombre = nombre;
		this.edad = edad;
		this.puntuacion = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	//
	public void jugar(Juego juego) {

		int acertado = 0;
		int questrandom = 0;
		int puntuacion_actual = 0;
		int respuesta = 0;
		ArrayList<Pregunta> preguntas_juego = new ArrayList<>();

		for (Pregunta pregunta : juego.getPreguntas()) {
			preguntas_juego.add(pregunta);
		}

		ArrayList<Pregunta> preguntas_random = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			questrandom = (int) (Math.random() * preguntas_juego.size());
			preguntas_random.add(preguntas_juego.get(questrandom));
			preguntas_juego.remove(questrandom);
		}

		for (Pregunta pregunta : preguntas_random) {
			if (respuesta != -1) {
				int imagen_random = (int) (Math.random() * 3);
				respuesta = JOptionPane.showOptionDialog(null, pregunta.getPregunta(), Constantes.TITULO,
						JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, Constantes.pokemones[imagen_random],
						pregunta.getLista_respuestas(), null);

				int index = juego.getPreguntas().indexOf(pregunta);

				if (respuesta != -1) {

					if (juego.getPreguntas().get(index).getSolucion() == respuesta) {
						puntuacion += 10;
						puntuacion_actual += 10;
						QuizMain.reproducirMusica("src/practica2evaluacion/correct.wav");
						JOptionPane.showMessageDialog(null, "Respuesta correcta", Constantes.TITULO,
								JOptionPane.INFORMATION_MESSAGE, Constantes.icono_tick);
						acertado++;

					} else {
						puntuacion -= 5;
						puntuacion_actual -= 5;
						QuizMain.reproducirMusica("src/practica2evaluacion/wrong.wav");
						JOptionPane.showMessageDialog(null, "Respuesta incorrecta", Constantes.TITULO,
								JOptionPane.INFORMATION_MESSAGE, Constantes.icono_cruz);
					}

				}

			}

		}
		if (respuesta != -1) {
			JOptionPane.showMessageDialog(null,
					"Has acertado " + acertado + " preguntas y has conseguido " + puntuacion_actual + " puntos",
					Constantes.TITULO, JOptionPane.INFORMATION_MESSAGE, Constantes.icono_pikachu);

		}
	}

	@Override
	public String toString() {
		return nombre + " - Edad: " + edad + " - Puntuacion: " + puntuacion;
	}

}
