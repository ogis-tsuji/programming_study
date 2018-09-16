

public class ExtractAAA {
	public String convert(String s){
		StringBuilder inputSB = new StringBuilder(s);
		inputSB.append("??");
		char[] input = inputSB.toString().toCharArray();

		StringBuilder answer = new StringBuilder();
		int i = 0;
		while(i < input.length - 2){
			if(Character.isUpperCase(input[i])){
				if(input[i] == input[i+1]){
					if( input[i] == input[i+2]){
						answer.append("[").append(input[i]).append(input[i+1]).append(input[i+2]).append("]");
						i += 3;
						continue;
					}else{
						answer.append(input[i]).append(input[i+1]);
						i += 2;
						continue;
					}
				}
			}
			answer.append(input[i]);
			i++;
		}
		return answer.toString();
	}
}
