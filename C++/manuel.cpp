#include <iostream>
using namespace std;

struct arista{
	int datoDestino;
	int peso;
	arista *sgteArista;
};

typedef arista *parista;

struct vertice{
	int datoOrigen;
	arista *adyacente;
	vertice *sgteVertice;
};

typedef vertice *pvertice;

class grafo{
    private:
    pvertice pGrafo;
    public:
    grafo();
    ggrafo();
    void insertarVertice(int);
    void insertarArista(int,int,int);
    void imprimirGrafo();
    int sumadePesos();
};

grafo::grafo(){
pGrafo=NULL;
}

grafo::ggrafo(){
pvertice p,rp;
parista r,ra;
p=pGrafo;
while(p!=NULL){
r=p->adyacente;
while(r!=NULL){
ra=r;
r=r->sgteArista;
delete ra;
}
rp=p;
p=p->sgteVertice;
delete rp;
}
}

void grafo::insertarVertice(int x){
pvertice p;
p=new vertice;
p->datoOrigen=x;
p->adyacente=NULL;
p->sgteVertice=pGrafo;
pGrafo=p;
}

void grafo::insertarArista(int x, int y, int peso){
pvertice p;
parista a;
p=pGrafo;
if(p!=NULL){
while(p->datoOrigen!=x && p!=NULL)
p=p->sgteVertice;
if(p!=NULL){
a=new arista;
a->datoDestino=y;
a->peso=peso;
a->sgteArista=p->adyacente;
p->adyacente=a;
}
}
}

void grafo::imprimirGrafo(){
pvertice p;
parista a;
p=pGrafo;
if(p==NULL) 
cout<<"Grafo vacio"<<endl;
else{
while(p!=NULL){
cout<<p->datoOrigen<<" --> ";
a=p->adyacente;
while(a!=NULL){
cout<<a->datoDestino<<"(peso: "<<a->peso<<")->";
a=a->sgteArista;
}
//cout<<" "<<endl;
 p=p->sgteVertice;
}
}
}
//funcion de suma de pesos
int grafo::sumadePesos(){
pvertice p;
parista a;
p=pGrafo;
int suma = 0;
while(p!=NULL){
a=p->adyacente;
while(a!=NULL){
suma += a->peso;
a=a->sgteArista;
}
p=p->sgteVertice;
}
 
    return suma;
}

int main(){
grafo g;
int x,y;
g.insertarVertice(4);
g.insertarVertice(5);
g.insertarVertice(6);
g.insertarVertice(3);

g.insertarArista(3,5,5);
g.insertarArista(3,4,3);
g.insertarArista(5,6,4);
g.insertarArista(4,6,10);
cout<< "Vert   /  Aristas" <<endl;
g.imprimirGrafo();
cout << "La suma total de las aristas es: " << g.sumadePesos() << endl;
return 0;
}
