#include <cstdlib>
#include <cstring> //strlen, strcpy
#include <iomanip> //std::setprecision
#include <sstream> //stringstream
#include "Cliente.h"

//Cliente::Cliente(long int d, char *nom, Fecha f):fechaAlta(f.getDia(), f.getMes(), f.getAnio()) {
Cliente::Cliente(long int d, char *nom, Fecha f):fechaAlta(f) { //esta cabecera es mas corta (invoco
  this->dni=d;                                                  //constructor copia de fecha
                                                                //en vez de constructor de 3 parametros)
  //this->nombre=nombre;  //MAL!!!!
  this->nombre=new char[strlen(nom)+1];
  strcpy(this->nombre, nom);

  //this->fechaAlta=f;//MAL!!!! los tipos no primitivos debe ir en zona inicializadores
}
/*Cliente::Cliente(const Cliente &c):fechaAlta(c.fechaAlta){
this->dni=c.dni;
this->nombre=new char[strlen(c.nombre)+1];
  strcpy(this->nombre,c.nombre);
}*/

Cliente::~Cliente() {
  delete [] this->nombre; //si en el constructor uso new [] en el destructor uso delete []
}

Cliente& Cliente::operator=(const Cliente& c) {
  if (this != &c) { //si no es x=x
    this->dni=c.dni;
    delete [] this->nombre;
    //this->nombre=c.nombre;  //MAL!!!!
    this->nombre=new char[strlen(c.nombre)+1];
    strcpy(this->nombre, c.nombre);
    this->fechaAlta=c.fechaAlta;
  }
  return *this;
}

bool Cliente::operator==(Cliente c) const {
  if ((this->dni==c.dni)&&(strcmp(this->nombre, c.nombre)==0) && (this->fechaAlta.getDia()==c.fechaAlta.getDia())&&
  (this->fechaAlta.getMes()==c.fechaAlta.getMes())&&(this->fechaAlta.getAnio()==c.fechaAlta.getAnio())){
  return true;}
  else{
    return false;}
}

void Cliente::setNombre(char*n){
delete [] nombre;
nombre=new char[strlen(n)+1];
strcpy(nombre,n);
}
ostream& operator<<(ostream& s,const Cliente &c){
s<<"Nombre: "<< c.getNombre()<<" - DNI: "<<c.getDni()<<" - Fecha: "<<c.getFecha()<<endl;
return s;
}

//RESTO DE METODOS Y FUNCIONES A RELLENAR POR EL ALUMNO...
