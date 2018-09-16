

public class ExtractAAATest {
	public static void main(String[] args) {
		ExtractAAA a1 = new ExtractAAA();
		String test1 = "AAABBBCCCDDDEEE";
		String answer1 = a1.convert(test1);
		System.out.println(answer1);

		String test2 = "AAAAAAAA";
		String answer2 = a1.convert(test2);
		System.out.println(answer2);
	
		String test3 = "AAAAAAAAaaaaa";
		String answer3 = a1.convert(test3);
		System.out.println(answer3);

		String test4 = "aaaaAAaAaAAAaaaAA";
		String answer4 = a1.convert(test4);
		System.out.println(answer4);

		String test5 = "111123ABCAAAAABBBBCCCDEFaaaabc";
		String answer5 = a1.convert(test5);
		System.out.println(answer5);

	}

}
