package linkedlist;

public class BothLinkedListTest {

	public static void main(String[] args) {
		BothLinkedList list = new BothLinkedList();
		String s1 = "あ";
		String s2 = "い";
		String s3 = "う";
		String s4 = "え";
		String s5 = "お";
		list.appendLast(s1);
		list.appendLast(s2);
		list.appendLast(s3);
		list.appendLast(s4);
		list.appendLast(s5);
		printLinkedList(list);

		BothLinkedList list2 = new BothLinkedList();
		list2.appendFirst(s1);
		list2.appendFirst(s2);
		list2.appendFirst(s3);
		list2.appendFirst(s4);
		list2.appendFirst(s5);
		printLinkedList(list2);

//		// 「あいうえお」 の 「い 」と「え」を交換
//		int i1 = Find.find(list, s2);
//		int i2 = Find.find(list, s4);
//		list.delete(i1);
//		list.insert(i1, s4);
//		list.delete(i2);
//		list.insert(i2, s2);
//		printLinkedList(list);
		
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

		list.appendLast("こ");
		printLinkedList(list);
		
//		Iterator itor = list.gets(2, 3);
//		while(itor.hasNext()){
//			String s = (String)itor.next();
//			System.out.println(s);
//		}

	}
	public static void printLinkedList(BothLinkedList list){
		for(int i=0;i<list.size();i++){
			String s = (String)list.get(i);
			System.out.println(s);
		}
		System.out.println("****");
	}
}
