package operacionesfracciones;

import java.io.*;

public class fraccion {
	private int numerador, denominador;
	
	public fraccion(){
		
	}

	protected void setNumerador(int numerador) {
		this.numerador=numerador;
	}

	protected void setDenominador(int denominador) {
		this.denominador=denominador;
	}
	
	protected fraccion suma(fraccion fraccion2){
		fraccion suma= new fraccion();
		int mcm=0;
		if (fraccion2.getDenominador()==denominador) {
			suma.setDenominador(denominador);
			suma.setNumerador(fraccion2.getNumerador()+numerador);
		}else{
			mcm=mcm(fraccion2.getDenominador());
			suma.setDenominador(mcm);
			suma.setNumerador((mcm/fraccion2.getDenominador()*fraccion2.getNumerador())+(mcm/denominador*numerador));
		}
		suma=simplificar(suma);
		return suma;
	}

	protected int getNumerador() {
		return numerador;
	}

	protected int mcm(int denominador) {
		int mcm=1;
		boolean encontrado=false;
		for (int i=1;i<=denominador*this.denominador && !encontrado;i++) {
			if (i % denominador==0 && i % this.denominador==0) {
				mcm=i;
				encontrado=true;
			}
		}
		return mcm;
	}

	protected int getDenominador() {
		return denominador;
	}
	
	protected fraccion resta(fraccion fraccion2){
		fraccion resta= new fraccion();
		int mcm=0;
		if (fraccion2.getDenominador()==denominador) {
			resta.setDenominador(denominador);
			resta.setNumerador(fraccion2.getNumerador()-numerador);
		}else {
			mcm=mcm(fraccion2.getDenominador());
			resta.setDenominador(mcm);
			resta.setNumerador((mcm/denominador*numerador)-(mcm/fraccion2.getDenominador()*fraccion2.getNumerador()));
		}
		resta=simplificar(resta);
		return resta;
	}	
	
	protected fraccion producto(fraccion fraccion2){
		fraccion producto= new fraccion();
		producto.setDenominador(fraccion2.getDenominador()*denominador);
		producto.setNumerador(fraccion2.getNumerador()*numerador);
		producto=simplificar(producto);
		return producto;
	}
	
	protected fraccion division(fraccion fraccion2){
		fraccion division= new fraccion();
		division.setDenominador(fraccion2.getNumerador()*denominador);
		division.setNumerador(fraccion2.getDenominador()*numerador);
		division=simplificar(division);
		return division;
	}	

	private fraccion simplificar(fraccion mifraccion) {
		fraccion simplificada= new fraccion();
		int menor=menor(mifraccion.getDenominador(),mifraccion.getNumerador());
		boolean encontrado=false;
		int mcd=1;
		for (int i=menor;i>1 & !encontrado;i--) {
			if (mifraccion.getDenominador() % i ==0 && mifraccion.getNumerador() % i ==0) {
				encontrado=true;
				mcd=i;
			}
		}
		simplificada.setDenominador(mifraccion.getDenominador()/mcd);
		simplificada.setNumerador(mifraccion.getNumerador()/mcd);
		return simplificada;
	}

	private int menor(int denominador, int numerador) {
		int menor=0;
		if (denominador<numerador) {
			menor=denominador;
		}else menor=numerador;
		return menor;
	}

	protected void rellenar() {
		boolean introducido=false;
		do {
			System.out.println("Elige el numerador");
			try {
				this.numerador=Integer.parseInt(introducirdato());
				introducido=true;
			}catch(NumberFormatException ex) {
				System.out.println("Por favor, introduce un número, no un carácter");
			}
		}while(!introducido);
		introducido=false;
		do {
			System.out.println("Elige el denominador");
			try {
				this.denominador=Integer.parseInt(introducirdato());
				if (denominador!=0)introducido=true;
				else System.out.println("Introduce un número distinto de cero, por favor");
			}catch(NumberFormatException ex) {
				System.out.println("Por favor, introduce un número, no un carácter");
			}			
		}while(!introducido);
}	
	
	private String introducirdato() {
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
