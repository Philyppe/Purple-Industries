package co.edu.unbosque.controller;

import java.util.InputMismatchException;

import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.Console;

public class Controller {
	
	private Console con; 
	private ModelFacade mf; 
	
	public Controller() {
		con = new Console(); 
		mf = new ModelFacade(); 
	}
	
	public void run() {
		
		cicloPrincipal : while(true) {
			int opcion; 
			cicloOpcionMenu : while(true) {
				try {
					con.imprimirConSalto("");
					
				}catch(InputMismatchException e ) {
					con.quemarLinea();
				}
			}
		}
		
	}
	
	

}
