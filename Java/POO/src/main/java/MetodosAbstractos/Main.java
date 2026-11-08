package MetodosAbstractos;

public class Main {
    public static void main(String[] args){
       Planta planta = new Planta();
       AnimalCarnivoro animalc = new AnimalCarnivoro();
       animalc.alimentarse();
       planta.alimentarse();
    }
}
