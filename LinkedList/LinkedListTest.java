package linkedlist;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		String s1 = "あ";
		String s2 = "い";
		String s3 = "う";
		String s4 = "え";
		String s5 = "お";
		list.append(s1);
		list.append(s2);
		list.append(s3);
		list.append(s4);
		list.append(s5);
		
		// 「あいうえお」 の 「い 」と「え」を交換
		int i1 = Find.find(list, s2);
		int i2 = Find.find(list, s4);
		list.delete(i1);
		list.insert(i1, s4);
		list.delete(i2);
		list.insert(i2, s2);
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
