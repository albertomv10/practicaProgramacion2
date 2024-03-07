package practica2evaluacion;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class QuizMain {

	public static void reproducirMusica(String location) {
		String h = "hola";
		try {
			File file = new File(location);

			if (file.exists()) {
				AudioInputStream audioImput = AudioSystem.getAudioInputStream(file);
				Clip clip = AudioSystem.getClip();
				clip.open(audioImput);
				clip.start();
			} else {
				System.out.println("No existe el archivo de musica");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

		Juego juego = new Juego();
		int opcion;

		File file1 = new File("src/practica2evaluacion/Pokemon.wav");
		File file2 = new File("src/practica2evaluacion/GymLeader.wav");

		AudioInputStream audioImput1 = AudioSystem.getAudioInputStream(file1);
		AudioInputStream audioImput2 = AudioSystem.getAudioInputStream(file2);
		Clip clip1 = AudioSystem.getClip();
		Clip clip2 = AudioSystem.getClip();
		clip1.open(audioImput1);
		clip2.open(audioImput2);
		clip1.start();

		int p = JOptionPane.showConfirmDialog(null,
				"¡Bienvenid@ al PokeQuiz!\r\nCon este juego pondrás a prueba \r\ntus conocimientos sobre pokemon\r\n"
						+ "¿Estas list@?",
				Constantes.TITULO, JOptionPane.OK_CANCEL_OPTION, JOptionPane.DEFAULT_OPTION, Constantes.icono_PokeQuiz);

		String[] opciones = { "Jugar", "Añadir jugador", "Mostrar puntuaciones", "Eliminar jugadores",
				"Añadir pregunta", "Salir" };
		if (p == 0) {
			do {

				opcion = JOptionPane.showOptionDialog(null, "Elige una entre las siguientes opciones",
						Constantes.TITULO, JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION,
						Constantes.icono_PokeQuizPeque, opciones, null);

				switch (opcion) {
				case 0:

					if (!juego.getJugadores().isEmpty()) {
						String i1 = (String) JOptionPane.showInputDialog(null, "¿Con que jugador quieres jugar?",
								Constantes.TITULO, JOptionPane.DEFAULT_OPTION, Constantes.icono_jugador,
								juego.jugadores_string1(), juego.jugadores_string1()[0]);

						clip1.stop();
						clip2.start();
						juego.getJugadores().get(juego.jugadores_string().indexOf(i1)).jugar(juego);
						clip2.stop();
						clip1.start();

					} else {
						JOptionPane.showMessageDialog(null, "No hay jugadores", Constantes.TITULO, 0,
								Constantes.icono_psyduck);
					}

					break;

				case 1:
					juego.anadirJugador();

					break;
				case 2:
					juego.mostrarJugadores();
					break;
				case 3:
					juego.eliminarJugador();
					break;
				case 4:
					juego.anadirPregunta();
					break;

				}
			} while (5 != opcion && opcion != -1);

		}

	}

}
