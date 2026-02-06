package co.edu.unbosque.persistance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileManager {
	private static Scanner lectorDeArchivo;
	private static File archivo;
	private static PrintWriter escritorArchivo;
	private static final String RUTA_CARPETA = "src/archivos";

	public FileManager() {
		// TODO Auto-generated constructor stub
	}

	public static void crearCarpeta() {
		archivo = new File(RUTA_CARPETA);
		if (!archivo.exists() || !archivo.isDirectory()) {
			archivo.mkdir();
		}
	}

	public static void escribirArchivoDeTexto(String nombreArchivo, String contenido) {
		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);

			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			escritorArchivo = new PrintWriter(archivo);
			escritorArchivo.println(contenido);
			escritorArchivo.close();

		} catch (IOException e) {
			System.out.println("Error al escribir el archivo de texto (Creacion del archivo).");
			e.printStackTrace();
		}

	}

	public static String leerArchivoTexto(String nombreArchivo) {
		try {
			archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			lectorDeArchivo = new Scanner(archivo);
			String contenido = "";
			while (lectorDeArchivo.hasNext()) {
				contenido += lectorDeArchivo.nextLine() + "\n";
			}
			lectorDeArchivo.close();
			return contenido;

		} catch (IOException e) {
			System.out.println("Error al escribir el archivo de texto (Leer del archivo).");
			e.printStackTrace();
		}
		return null;

	}

}
