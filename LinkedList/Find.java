package linkedlist;

public class Find {
	public static int find(LinkedList list, Object target){
		for(int i=0; i< list.size(); i++){
			Object obj = list.get(i);
			if(obj.equals(target)){
				return i;
			}
		}
		return -1;
	}
}
