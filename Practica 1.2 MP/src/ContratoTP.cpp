#include "ContratoTP.h"

int ContratoTP::minutosTP=300;
float ContratoTP::precioTP=10;
const float ContratoTP::precioExcesoMinutos=0.15;

ContratoTP::ContratoTP(long int dni,Fecha f, int minHablados):Contrato(dni,f){
minutosHablados=minHablados;
}

ContratoTP::ContratoTP(const ContratoTP& c):Contrato(c.getDniContrato(), c.getFechaContrato()){
    minutosHablados = c.getMinutosHablados();
}

float ContratoTP::factura() const {
    float factura;
    if(minutosHablados>minutosTP){
        factura=precioTP+((minutosHablados-minutosTP)*precioExcesoMinutos);
    }else{
    factura=precioTP;
    }
return factura;
}

void ContratoTP::ver() const{
Contrato::ver();
    cout<< minutosHablados << "min, "
                << minutosTP << "(" << precioTP <<")"<<endl;

}
ostream& operator<<(ostream &s, const ContratoTP &c){
s<<c.getDniContrato()<<" (" <<c.getIdContrato()<<" - "<<c.getFechaContrato()<<")"<<c.getMinutosHablados()<<"min, "<<c.getLimiteMinutos()<<"("<<c.getPrecio()<<") - "<<c.factura()<<" euros"<<endl;
return s;
}
//static se pone en el .h (no se pone en el .cpp)
void ContratoTP::setTarifaPlana(int m, float p) {
  ContratoTP::minutosTP=m; //puedo poner minutosTP=m ...pongo ContratoTP::minutosTP para recordar que es estatico
  ContratoTP::precioTP=p;  //puedo poner precioTP=p  ...pongo ContratoTP::precioTP para recordar que es estatico
}

//RESTO DE METODOS Y FUNCIONES A RELLENAR POR EL ALUMNO...
