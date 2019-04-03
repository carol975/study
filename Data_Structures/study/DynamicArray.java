package study;
import java.lang.ArrayIndexOutOfBoundsException;
public class DynamicArray {
	private int[] array;
	private int size;
	private int capacity;
	
	public DynamicArray(int capacity){
		this.array = new int[capacity];	
		this.capacity = capacity;
		this.size = 0;
	}
	
	public DynamicArray(){
		this.array = null;
		this.capacity = 0;
		this.size = 0;
	}
	
	public int size(){
		return this.size;
	}
	
	public int capacity(){
		return this.capacity;
	}
	
	public boolean isEmpty(){
		if(this.size == 0){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isFull(){
		if(this.size == this.capacity){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isIndexValid(int index){
		if(index < 0 || index >= this.size){
			return false;
		}
		else {
			return true;
		}
	}
	
	public int at(int index){
		if(isIndexValid(index) == false){
			throw new ArrayIndexOutOfBoundsException("Index out of bounds");
		}
		else {
			return this.array[index];
		}
	}
	
	private void expandArray(){
		int newCapacity;
		if(this.capacity == 0){
			newCapacity = 16;
		}
		else {
			newCapacity = 2*this.capacity;
		}
		
		int[] newArr = new int[newCapacity];
		for (int i = 0; i < this.size; i++){
			newArr[i] = this.array[i];
		}
		this.array = newArr;
		this.capacity = newCapacity;
	}
	
	private void shrinkArray(){
		if(4*this.size <= this.capacity ){
			this.capacity = this.capacity/2;
		}
	}
	
	public void push(int val){
		if(this.size == this.capacity){
			expandArray();
		}
		
		array[this.size] = val;
		this.size++;
	}
	
	public void print(){
		for(int i = 0; i < this.size; i++){
			System.out.print(Integer.toString(this.array[i]) + ' ');
		}
		System.out.println("\r\n");
	}
	
	public void printCap(){
		for(int i = 0; i < this.capacity; i++){
			System.out.print(Integer.toString(this.array[i]) + ' ');
		}
		System.out.println("\r\n");
	}
	
	
	public void insert(int index, int val){

		if(this.size == this.capacity){
			expandArray();
		}
		for(int i = this.size-1; i >= index; i--){
			this.array[i+1] = this.array[i];
		}
		
		this.array[index] = val;
		this.size++;
		
			
	}
	
	public void prepend(int val){
		insert(0, val);
	}
	
	public int pop(){
		if(size == 0){
			throw new ArrayIndexOutOfBoundsException();
		}
		else {
			int poped = this.array[this.size-1];
			this.array[this.size-1] = 0; //optional
			this.size--;
			shrinkArray();
			return poped;
		}

	}
	
	public void delete(int index){
		for(int i = index; i < this.size-1; i++){
			this.array[i] = this.array[i+1];
		}
		this.size--;
	}
	
	public void remove(int val){
		for(int i = 0; i < this.size; i++){
			if(this.array[i] == val){
				delete(i);
				i--;
			}
		}
		
	}
	
	public int find(int val){
		for(int i = 0; i < this.size; i++){
			if(this.array[i] == val){
				return i;
			}
		}
		return -1;
	}
	
}
