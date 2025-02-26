/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libClases;

/**
 *
 * @author jarro
 */

public class ClienteTarifaPlana extends Cliente implements Cloneable, Proceso {
	private static float tarifa = 20f;
    private static float limiteMinutos = 300;
    private static float costead = 0.15f;
    
    private float minutosHablados;
    private String nacionalidad;

	public ClienteTarifaPlana(String NIF, String nom, Fecha fNac, Fecha fAlta, float minutosHablados, String Nacionalidad) {
	    super(NIF, nom, fNac, fAlta); //constructor de Cliente
	    this.minutosHablados = minutosHablados;
	    this.nacionalidad = Nacionalidad;
	}
	
	public ClienteTarifaPlana(String NIF, String nom, Fecha fNac, float minutosHablados, String Nacionalidad) {
	    super(NIF, nom, fNac); //constructor de Cliente
	    this.minutosHablados = minutosHablados;
	    this.nacionalidad = Nacionalidad;
	}
	
	public ClienteTarifaPlana(ClienteTarifaPlana c) {
		super(c);
                this.minutosHablados=c.minutosHablados;
                this.nacionalidad=c.nacionalidad;
	}

	public void setMinutos(int min) {
		minutosHablados = min;
	}

	public void setNacionalidad(String Nac) {
		this.nacionalidad = Nac;
	}

	public static void setTarifa(int min, float t) {
		limiteMinutos = min;
		tarifa = t;
	}

	public static float getLimite() {
		return limiteMinutos;
	}

	public static float getTarifa() {
		return tarifa;
	}
	
	public float getMinutos() {
		return minutosHablados;
	}
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	@Override
	public float factura(){
		float total=tarifa;
		if(minutosHablados>limiteMinutos)
				total=total+(minutosHablados-limiteMinutos)*costead;
        return total;
    }
	
	@Override
    public String toString(){
        return super.toString()+" "+nacionalidad+" ["+limiteMinutos+" por "+tarifa+"] "+minutosHablados+" ---> "+factura();
    }
    @Override
    public Object clone(){
        return new ClienteTarifaPlana(super.getNif(), super.getNombre(), super.getFechaNac(), super.getFechaAlta(), getMinutos(), getNacionalidad());
    }
    @Override
    public boolean equals(Object o){
        return o instanceof ClienteTarifaPlana && super.getNif().equals(((Cliente)o).getNif());
    }

}