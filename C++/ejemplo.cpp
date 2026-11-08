#include<iostream>//ejemplo: lectura, recuperacion de informacion des estructuras del tipo de dato de persona definida
using namespace std;
struct Persona{
Persona p, *p1;
char nombre[30];
int edad1;
float altura1;
float peso1;
}
int main(){

cout<<"introduzca nombre:";
cin.getline(p.nombre, 30);
cout<<"introduzca edad,altura,peso:" ;
cin>>p.edad>>p.altura>>p.peso;
cout<<p.nombre<<" "<<p.edad<<" "<<p.altura<<" "<<p.peso<<" "<<endl;
cin.getline(p1->nombre,2);
cout<<"introduzca nombre:";
cin.getline(p1->nombre,30);
cin>>p1->edad>>p1->altura<<p1->peso;
cout<<p1->nombre<<" "<<p1->edad<<p1->altura<<p1->peso<<endl;
strcpy(nombre,p.nombre);
strcpy(p.nombre,p1->nombre);
edad1=p.edad;
altura1=p1->altura
}
