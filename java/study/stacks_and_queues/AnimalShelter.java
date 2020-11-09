package stacks_and_queues;

import java.util.Queue;
import java.util.LinkedList;

public class AnimalShelter {
	class Pet{
		String name;
		Pet next;
		public Pet(String name){
			this.name = name;
		}
	}
	
	LinkedList<Pet> queue;
	Pet lastDog;
	Pet lastCat;
	Pet currDog;
	Pet currCat;
	public AnimalShelter(){
		this.queue = new LinkedList<Pet>();
	}
	public void abandonPet(String name){
		Pet newP = new Pet(name);
		queue.add(newP);
		if(name.equals("d")){
			if(lastDog == null){
				lastDog = newP; 
			}
			else{
				lastDog.next = newP;
				lastDog = lastDog.next;
			}
		}
		
		if(name.equals("c")){
			if(lastCat == null){
				lastCat = newP; 
			}
			else{
				lastCat.next = newP;
				lastCat = lastCat.next;
			}
		}
	}
	public Pet adoptAny(){
		Pet adopted = queue.poll();
		if(adopted == currDog){
			currDog = currDog.next;
		}
		else if(adopted == currCat){
			currCat = currCat.next;
		}
		return adopted;
	}
	
	public Pet adoptCat(){
		Pet cat = currCat;
		currCat = currCat.next;
		return cat;
	}
	
	public Pet adoptDog(){
		Pet dog = currDog;
		currDog = currDog.next;
		queue.remove(dog);
		return dog;
	}
	
	
}
