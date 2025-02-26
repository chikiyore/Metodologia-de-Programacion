/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libClases;

/**
 *
 * @author jarro
 */
public class ClienteMovil extends Cliente implements Cloneable, Proceso {
	
	private Fecha fechaPermanencia;
    private float minutosHablados;
    private float precioMinuto;

	public ClienteMovil(String NIF, String nom, Fecha fNac, Fecha fAlta, Fecha fPermanencia, float minutosHablados, float precioMinuto) {
	    super(NIF, nom, fNac, fAlta); //constructor de Cliente
	    this.minutosHablados = minutosHablados;
	    this.precioMinuto = precioMinuto;
	    this.fechaPermanencia = (Fecha)fPermanencia.clone();
	}
	
	public ClienteMovil(String NIF, String nom, Fecha fNac, Fecha fAlta, float minutosHablados, float precioMinuto) {
	    super(NIF, nom, fNac, fAlta);            
            Fecha per=new Fecha(fAlta.getDia(),fAlta.getMes(),fAlta.getAnio()+1);
            this.fechaPermanencia=per;
            this.minutosHablados = minutosHablados;
	    this.precioMinuto = precioMinuto;
	}
	
	public ClienteMovil(String NIF, String nom, Fecha fNac, float minutosHablados, float precioMinuto) {
	    super(NIF, nom, fNac, getFechaPorDefecto());
            Fecha per=new Fecha(super.getFechaPorDefecto().getDia(),super.getFechaPorDefecto().getMes(),super.getFechaPorDefecto().getAnio()+1);
            this.fechaPermanencia=per;
            this.minutosHablados = minutosHablados;
	    this.precioMinuto = precioMinuto;
	}
	
	public ClienteMovil(ClienteMovil c) {
        super(c);
        this.minutosHablados = c.minutosHablados;
        this.precioMinuto = c.precioMinuto;
        this.fechaPermanencia = (Fecha)fechaPermanencia.clone();
    }
	
	public void setFPermanencia(Fecha fechaper) {
		this.fechaPermanencia = (Fecha)fechaper.clone(); 
		
	}
	
	public Fecha getFPermanencia() {
		return (Fecha)fechaPermanencia.clone();
	}
	
	public float getMinutos(){
        return minutosHablados;
    }
	
    public float getPrecioMinuto(){
        return precioMinuto;
    }
    
    public void setPrecioMinutos(float precio) {
		this.precioMinuto=precio;	
	}
	
	
	@Override 
    public float factura(){
        return minutosHablados*precioMinuto;
    }
	
	
	@Override
    public String toString(){
        return super.toString()+" "+fechaPermanencia+" "+minutosHablados+" x "+precioMinuto+" ---> "+factura();
    }
    @Override
    public Object clone(){
        return new ClienteMovil(super.getNif(), super.getNombre(), super.getFechaNac(), (Fecha)super.getFechaAlta(), getFPermanencia(), getMinutos(), getPrecioMinuto());
    }
    @Override
    public boolean equals(Object o){
        return o instanceof ClienteMovil && super.getNif().equals(((Cliente)o).getNif());
    }

	


}
