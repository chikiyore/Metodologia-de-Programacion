/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libClases;

/**
 *
 * @author jarro
 */
public class Cliente implements Cloneable, Proceso {

    private static int contador = 1;

    private final String nif;
    private final int codCliente;
    private String nombre;
    private final Fecha fechaNac;
    private final Fecha fechaAlta;

    private static final Fecha FechaDefecto = new Fecha(1, 1, 2018);

    public Cliente(String nif, String nom, Fecha fNac, Fecha fAlta) {
        this.nif = nif;
        this.nombre = nom;
        this.fechaNac = (Fecha) fNac.clone();
        this.fechaAlta = (Fecha) fAlta.clone();
        this.codCliente = contador++;
    }

    public Cliente(String nif, String nom, Fecha fNac) {
        Fecha fAlta = (Fecha) FechaDefecto.clone();
        this.nif = nif;
        this.nombre = nom;
        this.fechaNac = (Fecha) fNac.clone();
        this.fechaAlta = (Fecha) fAlta.clone();
        this.codCliente = contador++;
    }

    public Cliente(Cliente c1) {
        this.nif = c1.nif;
        this.nombre = c1.nombre;
        this.fechaNac = (Fecha) c1.fechaNac.clone();
        this.fechaAlta = (Fecha) c1.fechaAlta.clone();
        this.codCliente = contador++;
    }

    //NIF Y CODCLIENTE
    public String getNif() {
        return this.nif;
    }

    public int getCodCliente() {
        return this.codCliente;
    }

    
    //GET Y SET NOMBRE
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
//GET Y SET FECHADEFECTO
    public static Fecha getFechaPorDefecto() {
        return (Fecha) FechaDefecto.clone();
    }

    public static void setFechaPorDefecto(Fecha f) {
        FechaDefecto.setFecha(f);
    }

    //FACTURA PARA PODER USARLA EN MOVIL Y TARIFAPLANA
    public float factura() {
        return 0;
    }

    
    //SET Y GET FECHAS
    public Fecha getFechaNac() {
        return (Fecha) fechaNac.clone();
    }

    public Fecha getFechaAlta() {
        return (Fecha) fechaAlta.clone();
    }

    public void setFechaAlta(Fecha fAlta) {
        fechaAlta.setFecha(fAlta);
    }

    
    //METODOS OVERRIDE
    @Override
    public void ver() {
        System.out.println(this);
    }

    @Override
    public String toString() { 
        return nif + " " + fechaNac + ": " + nombre + " (" + codCliente + " - " + fechaAlta + ")";
    }

    @Override
    public boolean equals(Object o) {
        return o.getClass() == Cliente.class && nif.equals(((Cliente) o).nif);
    }

    @Override
    public Object clone() {
        return new Cliente(this);
    }
}
