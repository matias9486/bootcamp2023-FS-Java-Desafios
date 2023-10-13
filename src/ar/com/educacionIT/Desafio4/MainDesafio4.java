package ar.com.educacionIT.Desafio4;

public class MainDesafio4 {

	public static void main(String[] args) {		
		CollectionCustom<Integer> enteros = new CollectionCustom<>();		
		System.out.println("Antes de agregar elementos. Esta vacia? " + enteros.empty()+"\n"); // true
		
		enteros.add(1);
		enteros.add(2);
		enteros.add(3);		
		enteros.add(4);
		enteros.add(5);
		enteros.add(4);
        System.out.println(enteros); // [1, 2, 3, 4, 5,4]
        System.out.println("Tamaño: "+ enteros.size()); // 6
        
        System.out.println("\nElemento removido: " +enteros.remove(3)); // 3
        System.out.println(enteros); // [1, 2, 4, 5,4]
        System.out.println("Tamaño: " + enteros.size()); // 5

        enteros.addFirst(0);
        System.out.println("\nAgregó 0 al principio");
        System.out.println(enteros); // [0, 1, 2, 4, 5,4]
        System.out.println("Tamaño: " + enteros.size()); // 6
        
        enteros.addLast(6);
        System.out.println("\nAgregó 6 al final");
        System.out.println(enteros); // [0, 1, 2, 4, 5, 4, 6]
        System.out.println("Tamaño: " + enteros.size()); // 7
        
        enteros.removeAll(4);
        System.out.println("\nRemueve todos los 4");
        System.out.println(enteros); // [0, 1, 2, 5, 6]
        System.out.println("Tamaño: " + enteros.size()); // 5
        
        System.out.println("\nEsta vacia? " + enteros.empty()); // false

        //----------- coleccion de personas---------------
        CollectionCustom<Persona> personas = new CollectionCustom<>();		
		System.out.println("\nAntes de agregar personas. Esta vacia? " + personas.empty()+"\n"); // true
		Persona p = new Persona("Matias");
		Persona p2 = new Persona("Carlos");
		
        personas.add(p);
        personas.add(p2);
        System.out.println(personas);
        System.out.println("Tamaño: "+ personas.size());
        
        System.out.println("\nElemento removido: " +personas.remove(new Persona("Carlos")));
        System.out.println(personas);
        System.out.println("Tamaño: " + personas.size());

        personas.addFirst(p2);
        System.out.println("\nAgregó al principio: "+p2);
        System.out.println(personas);
        System.out.println("Tamaño: " + personas.size());
        
        personas.addLast(p2);
        System.out.println("\nAgregó al final "+ p2);
        System.out.println(personas);
        System.out.println("Tamaño: " + personas.size());
        
        personas.removeAll(p2);
        System.out.println("\nRemueve todos los "+p2);
        System.out.println(personas);
        System.out.println("Tamaño: " + personas.size());
        
        System.out.println("\nEsta vacia? " + personas.empty());
        
	}

}
