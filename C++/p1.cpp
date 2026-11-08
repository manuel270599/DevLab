#include<iostream>
using namespace std;
void pedirdatos(int n,float A[100]){
	for(int i=0;i<n;i++){
		cout<<"ingrese el numero N°"<<i+1<<":";
		cin>>A[i];
	}
}
void promediardatos(int n,float suma , float prom, float A[100]){
	for(int i=0;i<n;i++){
		suma=suma+A[i];
	}
	prom=suma/n;
	cout<<"el promedio de los numeros ingresados es "<<prom<<"."<<endl;	
}
int main(){
	int n;
	float A[100];
	float suma;
	float prom;
	cout<<"ingresa la cantidad de numeros que va a ingresar:";
	cin>>n;
	if(n<100){
	pedirdatos(n,A);
	promediardatos(n,suma,prom,A);	
	}
	else{cout<<"la suma no es posible"<<endl;
	}
	return 0;
}
