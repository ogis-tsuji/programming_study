package linkedlist;

public class LinkedList {
	private class Node {
		private Object obj;
		private Node nextNode = null;
		public Node(Object o){
			obj = o;
		}
		public Object getObj() {
			return obj;
		}
		public Node getNextNode() {
			return nextNode;
		}
		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
	};

	private int num = 0;
	private Node pseudoNode;
	
	public LinkedList(){
		pseudoNode = new Node(null); 
	}
	
	public int size(){
		return num;
	}
	public void append(Object obj){
		Node newNode = new Node(obj);
		Node tailNode = getNode(num-1);
		tailNode.setNextNode(newNode);
		num++;
	}
	public Object get(int index){
		checkBound(index);
		Node currentNode = getNode(index);
		return currentNode.getObj();
	}
	
	public void delete(int index){
		checkBound(index);
		Node prevNode = getNode(index-1);
		Node targetNode = prevNode.getNextNode();
		prevNode.setNextNode(targetNode.getNextNode());
		num--;
	}
	public void insert(int index, Object obj){
		checkBound(index);
		Node newNode = new Node(obj);
		Node prevNode = getNode(index-1);
		Node nextNode = prevNode.getNextNode();
		newNode.setNextNode(nextNode);
		prevNode.setNextNode(newNode);
		num++;
	}
	private Node getNode(int index){
		Node currentNode = pseudoNode;
		// 指定したノードまで進める
		for(int i=0;i<=index;i++){
			currentNode = currentNode.getNextNode();
		}		
		return currentNode;
	}
	private void checkBound(int index){
		if(num <=index || index < 0){
			throw new IndexOutOfBoundsException();
		}
	}

}
