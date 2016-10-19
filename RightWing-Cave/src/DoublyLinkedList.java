
public class DoublyLinkedList<T>{
	
	public Node first = null;
	public Node last  = null;
	
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
		Node nodeToReturn = null;
		for (int i = 0; i < index; i++){
			nodeToReturn = node.next;
		}
		return nodeToReturn;
	}
	
	public Node moveBackward(int index, Node node){
		Node nodeToReturn = null;
		for (int i = 0; i<index; i++){
			nodeToReturn = node.prev;
		}
		return nodeToReturn;
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
	
	private static class Node<T>{
		private T    data;
		private Node next;
		private Node prev;
		
		public Node(T data){
			this.data = data;
			this.next = null;
			this.prev = null;
		}
		
		public String toString(){
			return "Number : " + this.data;
		}
	}

}
