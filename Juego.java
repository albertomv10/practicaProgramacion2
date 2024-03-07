package practica2evaluacion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Juego {

	private ArrayList<Jugador> jugadores;
	private ArrayList<Pregunta> preguntas;
	public static ArrayList<Juego> lista_juegos = new ArrayList<>();

	// preguntas por defecto
	private Pregunta p1 = new Pregunta("¿Cuánto pesa snorlax?", "287kg", "376kg", "460kg", 2);
	private Pregunta p2 = new Pregunta("¿Contra qué es débil el tipo dragón?", "Contra si mismo", "Contra el Hada",
			"Ambas son correctas", 2);
	private Pregunta p3 = new Pregunta("¿De que generación es el pokemon Dragapult?", "octava", "sexta", "segunda", 0);
	private Pregunta p4 = new Pregunta("¿Con cuantas Medallas se puede entrar a la liga?", "8", "5",
			"Si eres buen entrenador puedes ir", 0);
	private Pregunta p5 = new Pregunta("¿En qué generación se incluyó el tipo siniestro?", "segunda", "cuarta",
			"tercera", 0);
	private Pregunta p6 = new Pregunta("¿Con cuantos pokemon cuenta la pokedex actual?", "997 pokemons",
			"1450 pokemons", "1015 pokemons", 2);
	private Pregunta p7 = new Pregunta("¿Cuántos tipos de piedras evolutivas hay actualmente?", "3", "5", "10", 2);
	private Pregunta p8 = new Pregunta("¿Charizard es de tipo dragón en algún caso?", "No", "Si",
			"Charizard solo es de tipo fuego y volador", 1);
	private Pregunta p9 = new Pregunta("¿Cuánto mide Exxegutor alola?", ">10 m", "<10 m",
			"Lo mismo que su forma anterior", 0);
	private Pregunta p10 = new Pregunta("¿Cuál es el pokemon que tiene más ps?", "Blissey", "Snorlax", "Drapion", 0);
	private Pregunta p11 = new Pregunta("¿Cuál es el primer Pokémon en la Pokédex nacional?", "Bulbasaur", "Charmander",
			"Squirtle", 0);
	private Pregunta p12 = new Pregunta("¿Qué tipo de Pokémon es Pikachu?", "Normal", "Eléctrico", "Eléctrico/Volador",
			1);
	private Pregunta p13 = new Pregunta("¿Quién es el líder del gimnasio tipo agua en la región de Kanto?", "Brock",
			"Misty", "Sabrina", 1);
	private Pregunta p14 = new Pregunta("¿Qué tipo de Pokémon es Mewtwo?", "Psíquico/Siniestro", "Psíquico/Volador",
			"Psíquico", 2);
	private Pregunta p15 = new Pregunta(
			"¿Cuál es el legendario Pokémon de la tercera generación que controla la tierra?", "Groudon", "Kyogre",
			"Rayquaza", 0);
	private Pregunta p16 = new Pregunta("¿Qué tipo de Pokémon es Gengar?", "Fantasma/Veneno", "Fantasma/Siniestro",
			"Fantasma", 0);
	private Pregunta p17 = new Pregunta("¿Cuál es el Pokémon inicial de tipo hierba en la región de Sinnoh?", "Turtwig",
			"Chimchar", "Piplup", 0);
	private Pregunta p18 = new Pregunta("¿Qué tipo de Pokémon es Arceus?", "Normal", "Normal/Dragón",
			"Es de todos los tipos", 2);
	private Pregunta p19 = new Pregunta("¿Cuál es el Pokémon que se dice que trae consigo la primavera?", "Celebi",
			"Shaymin", "Phione", 1);
	private Pregunta p20 = new Pregunta("¿Qué tipo de Pokémon es Eevee?", "Normal/Raro", "Normal", "Normal/Volador", 1);

	// jugadores por defecto
	private Jugador j1 = new Jugador("Álvaro", 18);
	private Jugador j2 = new Jugador("Alberto", 25);
	private Jugador j3 = new Jugador("Fran", 30);

	public Juego() {

		this.jugadores = new ArrayList<>();
		this.preguntas = new ArrayList<>();

		preguntas.add(p1);
		preguntas.add(p2);
		preguntas.add(p3);
		preguntas.add(p4);
		preguntas.add(p5);
		preguntas.add(p6);
		preguntas.add(p7);
		preguntas.add(p8);
		preguntas.add(p9);
		preguntas.add(p10);
		preguntas.add(p11);
		preguntas.add(p12);
		preguntas.add(p13);
		preguntas.add(p14);
		preguntas.add(p15);
		preguntas.add(p16);
		preguntas.add(p17);
		preguntas.add(p18);
		preguntas.add(p19);
		preguntas.add(p20);
		jugadores.add(j1);
		jugadores.add(j2);
		jugadores.add(j3);

	}

	public ArrayList<Pregunta> getPreguntas() {
		return preguntas;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void anadirJugador() {

		int edad = -1;
		String i = "";
		boolean incorrecto = true;
		String nombre = JOptionPane.showInputDialog(null, "Introduzca el nombre", Constantes.TITULO, 3);
		if (nombre != null) {
			do {
				try {
					i = JOptionPane.showInputDialog(null, "Introduzca la edad", Constantes.TITULO, 3);
					edad = Integer.parseInt(i);
					if (edad >= 0) {
						Jugador nuevo_jugador = new Jugador(nombre, edad);

						jugadores.add(nuevo_jugador);

						JOptionPane.showMessageDialog(null, "Jugador añadido correctamente", Constantes.TITULO, 0,
								Constantes.icono_pikachu);
						incorrecto = false;

					} else {
						JOptionPane.showMessageDialog(null, "Edad no válida", Constantes.TITULO,
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (java.lang.NumberFormatException e) {
					if (i != null) {
						JOptionPane.showMessageDialog(null, "Edad no válida", Constantes.TITULO,
								JOptionPane.ERROR_MESSAGE);

					} else {
						incorrecto = false;
					}
				}

			} while (incorrecto);
		}
	}

	public void eliminarJugador() {

		if (!jugadores.isEmpty()) {
			String jugador = (String) JOptionPane.showInputDialog(null, "¿Qué jugador deseas eliminar?",
					Constantes.TITULO, JOptionPane.DEFAULT_OPTION, Constantes.icono_eliminar, jugadores_string1(),
					jugadores_string1()[0]);

			if (jugadores_string().indexOf(jugador) != -1) {

				jugadores.remove(jugadores_string().indexOf(jugador));
				JOptionPane.showMessageDialog(null, "Jugador eliminado correctamente", Constantes.TITULO, 0,
						Constantes.icono_meowth);
			}

		} else {
			JOptionPane.showMessageDialog(null, "No hay jugadores", Constantes.TITULO, 2, Constantes.icono_snorlax);
		}

	}

	public void mostrarJugadores() {

		JOptionPane.showMessageDialog(null, stringJugadores(), Constantes.TITULO, 2, Constantes.icono_pokedolares);
	}

	public ArrayList<String> jugadores_string() {
		ArrayList<String> jugadoresString = new ArrayList<>();
		for (Jugador jugador : jugadores) {

			jugadoresString.add(jugador.toString());
		}

		return jugadoresString;
	}

	public void anadirPregunta() {

		int sol;

		String nompregunta = JOptionPane.showInputDialog(null, "Introduzca el enunciado de la pregunta",
				Constantes.TITULO, 3);
		if (nompregunta != null) {
			String nomrespuestas0 = JOptionPane.showInputDialog(null, "Introduzca la respuesta 1", Constantes.TITULO,
					3);
			String nomrespuestas1 = JOptionPane.showInputDialog(null, "Introduzca la respuesta 2", Constantes.TITULO,
					3);
			String nomrespuestas2 = JOptionPane.showInputDialog(null, "Introduzca la respuesta 3", Constantes.TITULO,
					3);
			String[] nomrespuestas = { nomrespuestas0, nomrespuestas1, nomrespuestas2 };
			sol = JOptionPane.showOptionDialog(null, "¿Cuál es la respuesta correcta?", Constantes.TITULO,
					JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, Constantes.icono_psyduck, nomrespuestas,
					null);
			Pregunta preguntax = new Pregunta(nompregunta, nomrespuestas0, nomrespuestas1, nomrespuestas2, sol);
			preguntas.add(preguntax);
			JOptionPane.showMessageDialog(null, "Se ha añadido correctamente", Constantes.TITULO, 2,
					Constantes.icono_exeggutor);
		}

	}

	public String[] jugadores_string1() {

		String[] jugadoresString = new String[jugadores.size()];
		int i = 0;

		for (Jugador jugador : jugadores) {

			jugadoresString[i] = jugador.toString();
			i++;

		}

		return jugadoresString;
	}

	public String stringJugadores() {
		String space = "\t -------------------------- \t";
		String string_jugadores = "<html><b style=\"color:black; font-family:courier; font-size:11px;\">Jugador ---------- Puntuación \r\n";
		for (Jugador jugador : jugadores) {

			string_jugadores += "<html><p style=\"color:black; font-family:courier; font-size:10px;\">"
					+ jugador.getNombre() + " " + space.substring(jugador.getNombre().length())
					+ jugador.getPuntuacion() + "\r\n";
		}

		return string_jugadores;
	}

}
