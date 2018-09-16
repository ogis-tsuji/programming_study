package linkedlist;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		String s1 = "あ";
		String s2 = "い";
		String s3 = "う";
		String s4 = "え";
		list.append(s1);
		list.append(s2);
		list.append(s3);
		list.append(s4);
		
		printLinkedList(list);
		list.delete(0);
		printLinkedList(list);
		list.delete(1);
		printLinkedList(list);

		list.insert(0, "か");
		printLinkedList(list);

		list.insert(2, "き");
		printLinkedList(list);

		list.insert(3, "く");
		printLinkedList(list);

		list.append("こ");
		printLinkedList(list);
		
		Iterator itor = list.gets(2, 3);
		while(itor.hasNext()){
			String s = (String)itor.next();
			System.out.println(s);
		}

	}
	public static void printLinkedList(LinkedList list){
		for(int i=0;i<list.size();i++){
			String s = (String)list.get(i);
			System.out.println(s);
		}
		System.out.println("****");
	}
}
