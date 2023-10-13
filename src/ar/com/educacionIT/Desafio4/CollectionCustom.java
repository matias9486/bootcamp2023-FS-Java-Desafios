package ar.com.educacionIT.Desafio4;

import java.util.Arrays;

public class CollectionCustom<T> {
	private T[] array;

	public CollectionCustom() {
		this.array = (T[]) new Object[0];		
	}

	public int size() {
		return this.array.length;
	}

	public void addFirst(T element) {
		//creo arreglo auxiliar con un espacio mas
		T[] newArray = (T[]) new Object[this.array.length + 1];
		
		//agrego elemento al principio
		newArray[0] = element;
		
		//agrego elementos restantes del arreglo original al auxiliar
		for (int i = 0; i < size(); i++) {
			newArray[i+1] = this.array[i];
		}
		//reemplazo arreglo por el auxiliar
		this.array = newArray;				
	}

	public void addLast(T element) {
		T[] newArray = (T[]) new Object[this.array.length + 1];
		
		//agrego elementos al arreglo auxiliar
		for (int i = 0; i < size(); i++) {
			newArray[i] = this.array[i];
		}
		//agrego elemento al final
		newArray[newArray.length-1] = element;
		//reemplazo arreglo original por el auxiliar
		this.array = newArray;
	}

	public void add(T element) {
		this.addLast(element);
	}

	public T remove(T element) {
		for (int i = 0; i < size(); i++) {
			if (this.array[i].equals(element)) {
				T removedElement = this.array[i];
				//muevo elementos restantes
				for (int j = i; j < size() - 1; j++) {
					this.array[j] = this.array[j + 1];
				}
				
				//creo arreglo auxiliar con un espacio menos
				T[] newArray = (T[]) new Object[this.array.length - 1];								
				//agrego elementos del arreglo original al auxiliar, excepto el ultimo que sobra						
				System.arraycopy(this.array, 0, newArray, 0, newArray.length);				
				//reemplazo arreglo por el auxiliar
				this.array = newArray;							
				return removedElement;
			}
		}
		return null;
	}

	public void removeAll(T element) {
		//lenght auxiliar para arreglo dinamico
		int auxIndex = 0;		
				
		//creo arreglo auxiliar de mismo dimension que el original para agregar los elementos distintos
		T[] distintos = (T[]) new Object[this.array.length];
		
		for (int i = 0; i < size(); i++) {
			//si es distinto agrego al nuevo arreglo
			if (!this.array[i].equals(element)) {
				distintos[auxIndex] = this.array[i];
				auxIndex++;				
			}
		}
		
		//creo arreglo auxiliar con la cantidad de elementos usadas
		T[] auxiliar = (T[]) new Object[auxIndex];
		System.arraycopy(distintos, 0, auxiliar, 0, auxIndex);
		this.array = auxiliar;
	}

	public boolean empty() {
		return this.array.length == 0;
	}
			
	@Override
	public String toString() {
		return Arrays.toString(this.array);
	}
}
