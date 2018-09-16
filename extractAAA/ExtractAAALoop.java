

public class ExtractAAALoop implements ExtractAAA{
	private char dummyChar = '?';
	private final int num;
	
	public ExtractAAALoop(){
		num = 3;
	}
	public ExtractAAALoop(int num){
		this.num = num;
	}
	public String convert(String s){
		StringBuilder inputSB = new StringBuilder(s);
		for(int i = 0; i<num; i++){
			inputSB.append(dummyChar);
		}
		char[] input = inputSB.toString().toCharArray();

		StringBuilder answer = new StringBuilder();
		for(int i = 0; i < input.length - num; i++){
			if(Character.isUpperCase(input[i])){
				boolean isHit = true;
				int j = 1;
				for(; j < num; j++){
					if(input[i] != input[i+j]){
						isHit = false;
						break;
					}
				}
				if(isHit == true){
					answer.append("[");
				}
				for(int k=0; k<j; k++){
					answer.append(input[i+k]);
				}
				if(isHit == true){
					answer.append("]");
				}
				i = i + j - 1;
				continue;
			}
			answer.append(input[i]);
		}
		return answer.toString();
	}
}
