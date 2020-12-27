package criptografia;

import java.util.Random;
import java.util.Scanner;

public class Criptografia {

	static Scanner s = new Scanner(System.in);
	static Random aleatorio = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();

	}

	//Menú de inicio con las funciones
	static void menu() {
		int seleccion = -1;
		String palabra;
		do {
			System.out.println("¿Qué deseas realizar?\n" + "1. - Cifrar\n" + "2. - Descifrar\n" + "3. - Salir\n"
					+ "Tu selección: ");
			seleccion = s.nextInt();
		} while (seleccion < 1 || seleccion > 3);

		s.nextLine();
		switch (seleccion) {
		case 1:
			System.out.println("Introduce la palabra a cifrar");
			palabra = s.nextLine();
			palabra = palabra.toUpperCase();
			cifrar(palabra);
			menu();
			break;
		case 2:
			System.out.println("Introduce la palabra a descifrar");
			palabra = s.nextLine();
			palabra = palabra.toUpperCase();
			descifrar(palabra);
			menu();
			break;
		default:
			System.out.println("Saliendo del programa");
		}
	}

	//Metodo que se encarga del cifrado
	static void cifrar(String p) {
		String cifrado = "";
		// System.out.println(p.length());
		// PASO 1. Cambio de posiciones.
		for (int i = p.length() - 1; i >= 0; i--) {
			cifrado += p.charAt(i);
			// System.out.println("La frase es: " + cifrado);
		}
		System.out.println("Imagen especular: " + cifrado);

		// PASO 2. Sustitución de vocales.
		cifrado = cifrado.replace('A', '5').replace('E', '4').replace('I', '3').replace('O', '2').replace('U', '1');
		System.out.println("Sustitución de vocales: " + cifrado);
		/*
		 * //PASO 3. Añadir letras aleatorias al principio y al final. 
		 * String aleatorio1 = "" + letra(); 
		 * cifrado = aleatorio1 + cifrado; 
		 * cifrado += letra();
		 * System.out.println("Cadena cifrada: " + cifrado);
		 */

		// PASO 3 (MEJORADO). Añadir letras aleatorias al principio y al final de cada
		// palabra.
		String[] palabras = separacionPalabra(cifrado);
		String aleatorio1;
		String aux = "";
		for (int i = 0; i < palabras.length; i++) {
			aleatorio1 = "" + letra();
			palabras[i] = aleatorio1 + palabras[i];
			palabras[i] += letra();
			aux += palabras[i] + " ";
		}
		System.out.println("Cadena cifrada: " + aux);
	}

	//Metodo que coge una letra mayúscula aletaria.
	static String letra() {
		String cadena;
		char letra = (char) (aleatorio.nextInt(90 - 65 + 1) + 65);
		cadena = Character.toString(letra);

		return cadena;
	}

	//Metodo que se encarga de descifrar
	static void descifrar(String p) {
		String descifrado = "";
		String aux = "";

		/*
		*PASO 1. Quitar primera y última letra
		* for (int i = 1; i < p.length() - 1; i++) {
		*	aux += p.charAt(i);
		* }
		* System.out.println("Cadena cifrada: " + aux);
		*/
		
		// PASO 1 (MEJORADO). Quitar letras aleatorias al principio y al final de cadapalabra.
		String[] palabras = separacionPalabra(p);
		String[] aux2 = new String[palabras.length];
		for (int i = 0; i < palabras.length; i++) {
			for (int j = 1; j < palabras[i].length() -1 ; j++) {
				if (j == 1) {
					aux2[i] = "" + palabras[i].charAt(j);
				} else {
					aux2[i] += palabras[i].charAt(j);
				}
			}
			aux += aux2[i] + " ";
		}
		System.out.println("Cadena descifrada: " + descifrado);

		// PASO 2. Sustituir números.
		aux = aux.replace('5', 'A').replace('4', 'E').replace('3', 'I').replace('2', 'O').replace('1', 'U');
		System.out.println("Sustitución de vocales: " + aux);

		// PASO 3. Ordenar cadena.
		for (int i = aux.length() - 1; i >= 0; i--) {
			descifrado += aux.charAt(i);
		}
		System.out.println("Cadena descifrada: " + descifrado);
	}
	
	//Metodo que sirve para separar las palabras dentro del string.
	static String[] separacionPalabra(String p) {
		String[] palabra = p.split(" ");

		return palabra;
	}
}
