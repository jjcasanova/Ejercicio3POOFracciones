package operacionesfracciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class principal {

	public static void main(String[] args) {
		
		fraccion mifraccion= new fraccion();
		fraccion mifraccion2=new fraccion();
		System.out.println("Primera fracción");
		mifraccion.rellenar();
		System.out.println("Segunda fracción");
		mifraccion2.rellenar();
		int opcion=0;
		do {
			menu();
			opcion=opcion();
			erutamiento(opcion,mifraccion,mifraccion2);
		}while(opcion!=5);
	}

	private static void menu() {
		System.out.println("Elige entre las siguientes opciones");
		System.out.println("1- Suma de fracciones");
		System.out.println("2- resta de fracciones");
		System.out.println("3- Producto de fracciones");
		System.out.println("4- División de fracciones");
		System.out.println("5- Salir");
	}

	private static void erutamiento(int opcion, fraccion mifraccion, fraccion mifraccion2) {
		switch(opcion) {
		case 1:
			fraccion suma= new fraccion();
			suma=mifraccion.suma(mifraccion2);
			System.out.println("La suma de las fracciones" + mifraccion.getNumerador() + "/"+mifraccion.getDenominador() + " y " +mifraccion2.getNumerador() +"/"+mifraccion2.getDenominador() + " es "+ suma.getNumerador() + "/" + suma.getDenominador());
			break;
		case 2:
			fraccion resta= new fraccion();
			resta=mifraccion.resta(mifraccion2);
			System.out.println("La resta de las fracciones" + mifraccion.getNumerador() + "/"+mifraccion.getDenominador() + " y " +mifraccion2.getNumerador() +"/"+mifraccion2.getDenominador() + " es "+ resta.getNumerador() + "/" + resta.getDenominador());
			break;
		case 3:
			fraccion producto=new fraccion();
			producto=mifraccion.producto(mifraccion2);		
			System.out.println("El producto de las fracciones" + mifraccion.getNumerador() + "/"+mifraccion.getDenominador() + " y " +mifraccion2.getNumerador() +"/"+mifraccion2.getDenominador() + " es "+ producto.getNumerador() + "/" + producto.getDenominador());
			break;
		case 4:
			fraccion division=new fraccion();
			division=mifraccion.division(mifraccion2);
			System.out.println("La división de las fracciones" + mifraccion.getNumerador() + "/"+mifraccion.getDenominador() + " y " +mifraccion2.getNumerador() +"/"+mifraccion2.getDenominador() + " es "+ division.getNumerador() + "/" + division.getDenominador());
			break;
		case 5:
			System.out.println("Salimos del programa");
			break;
			default:
			System.out.println("La opción elegida no existe. Elige entre 1 y 5");
			break;
		}
	}

	private static int opcion() {
		int opcion=0;
		boolean introducido=false;
		do {
			try {
				System.out.println("Introduce la opción");
				opcion=Integer.parseInt(introducirdato());
				introducido=true;
			}catch(NumberFormatException ex) {
				System.out.println("Por favor, introduce un número, no un carácter");
			}
		}while(!introducido);
		return opcion;
	}

	private static String introducirdato() {
		String teclado=null;
		BufferedReader leer= new BufferedReader(new InputStreamReader(System.in));
		try {
			teclado=leer.readLine();
		} catch (IOException e) {
			System.out.println("No he podido leer el dato");
		}
		return teclado;
	}
}
