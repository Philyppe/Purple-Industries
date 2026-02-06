package co.edu.unbosque.persistance;

import java.util.ArrayList;
import co.edu.unbosque.model.Doctor;

public class DoctorDAO implements OperacionDAO<Doctor> {

	private ArrayList<Doctor> listaDoctores;
	private final String TEXT_FILE_NAME = "doctor.csv";

	public DoctorDAO() {
		listaDoctores = new ArrayList<>();
		cargarDesdeArchivo();
	}

	@Override
	public void crear(Doctor nuevoDato) {
		listaDoctores.add(nuevoDato);
		escribirEnArchivo();
	}

	@Override
	public int eliminar(int index) {
		if (index < 0 || index >= listaDoctores.size()) {
			return 0;
		} else {
			listaDoctores.remove(index);
			escribirEnArchivo();
			return 1;
		}
	}

	@Override
	public int eliminar(Doctor datoAEliminar) {
		if (listaDoctores.remove(datoAEliminar)) {
			escribirEnArchivo();
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int actualizar(int index, Doctor datoAActualizar) {
		if (index < 0 || index > listaDoctores.size()) {
			return 0;
		} else {
			listaDoctores.set(index, datoAActualizar);
			escribirEnArchivo();
			return 1;
		}
	}

	@Override
	public String mostrarTodo() {
		String salida = "";
		for (Doctor doctor : listaDoctores) {
			salida += doctor.toString();
		}
		return salida;
	}

	@Override
	public int cantidad() {
		return listaDoctores.size();
	}

	@Override
	public int comprobarPosicion(int index) {
		if (index < 0 || index >= listaDoctores.size()) {
			return 0;
		} else {
			return 1;
		}
	}

	public void escribirEnArchivo() {
		String contenido = "";

		for (int i = 0; i < listaDoctores.size(); i++) {
			contenido += listaDoctores.get(i).getNombre() + ";";
			contenido += listaDoctores.get(i).getFechaDeNacimiento() + ";";
			contenido += listaDoctores.get(i).getDocumento() + ";";
			contenido += listaDoctores.get(i).getEspecialidad() + "\n";

		}

		FileManager.escribirArchivoDeTexto(TEXT_FILE_NAME, contenido);

	}

	public void cargarDesdeArchivo() {

		String contenido = FileManager.leerArchivoTexto(TEXT_FILE_NAME);

		if (contenido.isBlank() || contenido.isEmpty()) {
			return;
		}
		String[] filas = contenido.split("\n");
		for (int i = 0; i < filas.length; i++) {
			String[] columnas = filas[i].split(";");

			String nombre = columnas[0];
			String fechaDeNacimiento = columnas[1];
			int documento = Integer.parseInt(columnas[2]);
			String especialidad = columnas[3];
			listaDoctores.add(new Doctor(nombre, fechaDeNacimiento, documento, especialidad));

		}

	}

}
