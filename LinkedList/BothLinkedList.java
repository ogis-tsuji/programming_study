package linkedlist;

public class BothLinkedList{
	private class Node {
		private Object obj;
		private Node prevNode = null;
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
		
		public Node getPrevNode() {
			return prevNode;
		}
		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
		public void setPrevNode(Node prevNode) {
			this.prevNode = prevNode;
		}
	};

	private int num = 0;
	private Node firstPseudoNode;
	private Node lastPseudoNode;
	
	public BothLinkedList(){
		firstPseudoNode = new Node(null);
		lastPseudoNode = new Node(null); 
		firstPseudoNode.setNextNode(lastPseudoNode);
		lastPseudoNode.setPrevNode(firstPseudoNode);
	}
	
	public int size(){
		return num;
	}
	public void appendLast(Object obj){
		Node newNode = new Node(obj);
		Node tailNode = lastPseudoNode.getPrevNode();
		Node nextNode = lastPseudoNode;
		tailNode.setNextNode(newNode);
		newNode.setPrevNode(tailNode);
		newNode.setNextNode(nextNode);
		nextNode.setPrevNode(newNode);
		num++;
	}
	public void appendFirst(Object obj){
		Node newNode = new Node(obj);
		Node firstNode = firstPseudoNode.getNextNode();
		Node prevNode = firstPseudoNode;
		firstNode.setPrevNode(newNode);
		newNode.setNextNode(firstNode);
		newNode.setPrevNode(prevNode);
		prevNode.setNextNode(newNode);
		num++;
	}

	
	public Object get(int index){
		checkBound(index);
		// 早い方で検索
		Node currentNode = getNode(index);
		return currentNode.getObj();
	}
	
	public void delete(int index){
		checkBound(index);
		Node prevNode = getNode(index-1);
		Node targetNode = prevNode.getNextNode();
		Node nextNode = targetNode.getNextNode();
		prevNode.setNextNode(nextNode);
		nextNode.setPrevNode(prevNode);
		num--;
	}
	public void insert(int index, Object obj){
		checkBound(index);
		Node newNode = new Node(obj);
		Node prevNode = getNode(index-1);
		Node nextNode = prevNode.getNextNode();
		newNode.setNextNode(nextNode);
		nextNode.setPrevNode(newNode);
		prevNode.setNextNode(newNode);
		newNode.setPrevNode(prevNode);
		num++;
	}
	private Node getNode(int index){
		Node currentNode = null;
		if(index < num/2){
			currentNode = firstPseudoNode;
			// 指定したノードまで進める
			for(int i=0;i<=index;i++){
				currentNode = currentNode.getNextNode();
			}		
		}else{
			currentNode = lastPseudoNode;
			// 指定したノードまで進める
			for(int i=num;i>index;i--){
				currentNode = currentNode.getPrevNode();
			}		
		}
		return currentNode;

	}
	private void checkBound(int index){
		if(num <=index || index < 0){
			throw new IndexOutOfBoundsException();
		}
	}
	
	// first番目 から tail番目までの要素取得（tailが要素数以上を指定している場合は、要素数を上限とする 
	public Iterator gets(int first, int tail){
		if(first<0 || tail<0){
			throw new IllegalArgumentException("マイナス値");
		}
		if(first > tail){
			throw new IllegalArgumentException("firstの方がtailよりも大木ボンド");
		}
		if(num<=tail){
			tail = num-1;
		}
		Node firstNode = getNode(first);
		return new IteratorImpl(firstNode, tail-first);
	}

	public Iterator iterator(){
		return new IteratorImpl(firstPseudoNode.getNextNode(), num-1);
	}

	
	private class IteratorImpl implements Iterator {
		Node currentNode;
		int num;
		public IteratorImpl(Node firstNode, int num){
			currentNode = firstNode;
			this.num = num;	
		}
		public boolean hasNext(){
			return num >= 0 ? true : false;
			
		}
		public Object next(){
			Object obj = null;
			if(num >= 0){
				obj = currentNode.getObj();
				currentNode = currentNode.getNextNode();
				num--;
			}
			return obj;
		}
		public Object remove(){
			Object obj = null;
			if(num >= 0){
				Node prevNode = currentNode.getPrevNode();
				Node prevPrevNode = prevNode.getPrevNode();
				prevPrevNode.setNextNode(currentNode);
				currentNode.setPrevNode(prevPrevNode);
				obj = prevNode.getObj();
			}
			return obj;
		}
	}
}

