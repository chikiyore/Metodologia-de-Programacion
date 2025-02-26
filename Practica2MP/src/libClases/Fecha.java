/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libClases;

/**
 *
 * @author jarro
 */
import java.util.Scanner;

public final class Fecha implements Cloneable, Proceso {
	private int dia;
	private int mes;
	private int anio;

	//CONSTRUCTORES
	
	public Fecha(int d, int m, int a) {
		setFecha(d,m,a);
	}
	
	public Fecha(Fecha f) {
		setFecha(f.dia,f.mes,f.anio);
	}
	
	
	//SABER SI UN ANIO ES BISIESTO
	public boolean bisiesto() {
		boolean b=false;
		
		if (anio % 4 == 0) {
			b=true;
			if (anio%100 == 0 && anio%400 !=0 )
				b=false;
		}
		return b;
	}
	
	public void setFecha(Fecha f) {
		setFecha(f.dia,f.mes,f.anio);
	}
	
	//PONER UNA FECHA
	public void setFecha(int d, int m, int a) {
		int maxDias [] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		this.dia = d;
		this.mes = m;
		this.anio = a;
		
		if(m<1)
			this.mes = 1;
		else if(m > 12)
			this.mes = 12;
		
		if (bisiesto())
			maxDias[2] = 29; 
		
		if (dia<1)
			this.dia=1;
		else if(dia>maxDias[this.mes]) //decremento porque si metemos mes = 3 -> ser�a marzo pero en la tabla ser�a abril
			this.dia=maxDias[this.mes];

	}
	
	//DEVOLVER DIA, MES O ANIO:
	
	public int getDia() {
		return this.dia;
	}
	
	public int getMes() {
		return this.mes;
	}
	
	
	public int getAnio() {
		return this.anio;
	}
	
	/*public static Fecha pedirFecha() {
			Fecha fecha = null;
			boolean valida = false;
			
			Scanner sc = new Scanner(System.in);
			
			int dia, mes, anio;
			
			do {
				System.out.println("Introduce la Fecha (dd/mm/aaaa): ");
				String cadena = sc.next();
				String[] tokens = cadena.split("/");
				
				try {
					if (tokens.length != 3)
					throw new NumberFormatException();
					dia = Integer.parseInt(tokens[0]); //parseInt lanza la excepcion
					mes = Integer.parseInt(tokens[1]); //NumberFormatException si no
					anio = Integer.parseInt(tokens[2]);//puede convertir el String a int
					fecha = new Fecha(dia, mes, anio);
					if (fecha.getDia() != dia || fecha.getMes() != mes)
						throw new NumberFormatException();
					valida=true;
				} 
				
				catch(NumberFormatException e) {
					System.out.println("Fecha no valida");
				}
			}while(!valida);
			sc.close();
			
			return fecha;
	}*/
	
	
	
	public static Fecha pedirFecha(){
        Scanner s = new Scanner(System.in);
        Fecha f = null;
        boolean valida;
        
        do{
            System.out.print("Introduce una fecha (dd/mm/aaaa): ");
            String[] datos = s.nextLine().split("/");
            if(datos.length != 3){
                valida = false;
            }else{
                int fDia = Integer.parseInt(datos[0]), fMes = Integer.parseInt(datos[1]), fAnio = Integer.parseInt(datos[2]);
                int maxDias[] = {0,31,(fAnio%400 == 0 || (fAnio%4 == 0 && fAnio%100 != 0))?29:28,31,30,31,30,31,31,30,31,30,31};
                valida = fMes >= 1 && fMes <= 12 && fDia >= 1 && fDia <= maxDias[fMes];
                if(valida)
                    f = new Fecha(fDia, fMes, fAnio);
            }
            if(!valida)
                System.out.println("Fecha no valida");
        }while(!valida);
        return f;
    }
	
	
	
	
	
	static public boolean mayor(Fecha f1, Fecha f2) {
		if (f1.anio*10000+f1.mes*100+f1.dia>f2.anio*10000+f2.mes*100+f2.dia)
			return true;
		else
			return false;
	}
	
        @Override
	public void ver() {
		System.out.println(this/*.toString()*/);
	}
	
        @Override
	public String toString() {
		String s="";
		if (dia<10) s=s+0;
		s=s+dia+"/";
		if (mes<10) s=s+0;
		s=s+mes+"/"+anio;
		return s;
		//LO ANTERIOR SE PUEDE SUSTITUIR POR LO SIGUIENTE
		//return String.format("%02d/%02d/%02d", dia, mes, anio);
	}
	
	public Fecha diaSig() {
		Fecha fechaSig = new Fecha(this.dia,this.mes,this.anio);
		
		int diaMes[] = {0,31,28,31,30,31,30,31,31,30,31,30,31};
	    if (bisiesto())                          //si el a�o es bisiesto febrero tiene 29 dias
	      diaMes[2]=29;

	    fechaSig.dia=this.dia+1;

	    if (fechaSig.dia>diaMes[fechaSig.mes]) {                          //si al incrementar dia superamos el numero de dias de dicho mes
	        do{
	        	fechaSig.dia=fechaSig.dia-diaMes[fechaSig.mes];             //pasamos al dia del mes anterior
	        	fechaSig.mes++;			                //incrementamos un mes
	            if (fechaSig.mes>12) {                    //si al incrementar mes pasamos de 12 meses
	            	fechaSig.mes=1;                       //pasamos al mes 1
	            	fechaSig.anio++;                      //del a�o siguiente
	                if (fechaSig.bisiesto())              //si el a�o es bisiesto febrero tiene 29 dias
	                    diaMes[2]=29;
	                else
	                    diaMes[2]=28;
	            }
	        }while(fechaSig.dia>diaMes[fechaSig.mes]);                    //hasta que el dia < diamax del mes en el q ns encontremos
	    }
		
		return fechaSig;
	}
	
	 @Override
    public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
            
        }
        return obj;
    }
	
    @Override
    public boolean equals(Object o){
        if(!(o instanceof Fecha)) return false;
        Fecha f = (Fecha)o;
        return dia == f.dia && mes == f.mes && anio == f.anio;
    }
}

