
public class DoublyLinkedList<T>{
	
	public Node first;
	public Node last;
	
	public DoublyLinkedList(){
		this.first = null;
		this.last = null;
	}
	
	public void addFirst(T data){
		Node newNode = new Node(data);
		
		if (isEmpty()){
			first = newNode;
			last  = newNode;
		}else{
			first.prev = newNode;
			newNode.next = first;
			first = newNode;
		}
	}
	
	public void addLast(T data){
		Node newNode = new Node(data);
		
		if (isEmpty()){
			first = newNode;
			last  = newNode;
		}else{
			last.next = newNode;
			newNode.prev = last;
			last = newNode;
		}
	}
	
	public Node moveForward(int index, Node node){
		//Node nodeToReturn = null;
		for (int i = 0; i < index; i++){
			node = node.next;
		}
		return node;
	}
	
	public Node moveBackward(int index, Node node){
		//Node nodeToReturn = null;
		for (int i = 0; i<index; i++){
			node = node.prev;
		}
		return node;
	}
	
	public boolean canMoveForward(int index, Node node){
		
		for (int i = 0; i < index; i++){
			if (node.next == null){
				return false;
			}
			node = node.next;
		}
		return true;
	}
	
	public boolean canMoveBackward(int index, Node node){
		for (int i = 0; i < index; i++){
			if (node.prev == null){
				return false;
			}
			node = node.prev;
		}
		return true;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public String toString(){
		if (isEmpty()){
			return "It is empty";
		}
		Node current = first;
		String toReturn = "";
		while (current != null){
			toReturn += current.data + ", ";
			current = current.next;
		}
		return toReturn;
	}
	
}

class Node<T>{
	protected T    data;
	protected Node next;
	protected Node prev;
	
	public Node(T data){
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	public String toString(){
		return "Number : " + this.data;
	}
}
