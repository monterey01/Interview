package com.anant.string;
//Solution to https://codefights.com/interview-practice/task/Ss4qyHoGJQhpvaGWc
public class ClassifyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(classifyStrings("quftl?aejluciapqunzpj"));
		
		char c='5';
		StringBuilder sb=new StringBuilder();
		sb.append(c);
		System.out.println(sb);
		String s="ab";
		
	}
	
	
	static String classifyStrings(String s) {

		StringBuilder vowels = new StringBuilder();
		StringBuilder constants = new StringBuilder();
		StringBuilder questions = new StringBuilder();
		boolean hasVowelQuestions = false;
		boolean hasConstantQuestions = false;
		boolean hasQuestions = false;
		String tmpResult = null;

		char[] ca = s.toCharArray();

		for (int i = 0; i < ca.length; i++) {

			switch (ca[i]) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				if (questions.length() > 0) {
					vowels.append(questions);
					questions.setLength(0);
					hasQuestions = false;
					hasVowelQuestions = true;
				}
				if (constants.length() > 0) {
					hasConstantQuestions = false;
					constants.setLength(0);
				}

				vowels.append(ca[i]);

				break;

			case '?':
				if (constants.length() > 0 || vowels.length() > 0) {
					if (vowels.length() > 0) {
						hasQuestions = false;
						vowels.append(ca[i]);
						hasVowelQuestions = true;
					}

					if (constants.length() > 0) {
						hasQuestions = false;
						constants.append(ca[i]);
						hasConstantQuestions = true;
					}
				} else {
					hasQuestions = true;
					questions.append(ca[i]);
				}

				break;

			default:
				if (questions.length() > 0) {
					constants.append(questions);
					questions.setLength(0);
					hasQuestions = false;
					hasConstantQuestions = true;
				}
				if (vowels.length() > 0) {
					hasVowelQuestions = false;
					vowels.setLength(0);
				}
				constants.append(ca[i]);
				break;
			}
			
			if(vowels.length()>0){
				if (ca[i] == '?' && ca[i - 1] != '?'  && (i + 1) < ca.length
						&& !(ca[i + 1] == 'a' || ca[i + 1] == 'e' || ca[i + 1] == 'i' || ca[i + 1] == 'o'
								|| ca[i + 1] == 'u' || ca[i + 1] == '?')) {
					
					if(vowels.length()>=3)constants.append('b');
					if(vowels.length()<3)constants.append('a');
					
					
				}
				
				
			}
			
			if(constants.length()>0){
				if (ca[i] == '?' && ca[i - 1] != '?'   && (i + 1) < ca.length && (ca[i + 1] == 'a' || ca[i + 1] == 'e'
						|| ca[i + 1] == 'i' || ca[i + 1] == 'o' || ca[i + 1] == 'u')) {
					
					if(constants.length()>=5)vowels.append('a');
					if(constants.length()<5)constants.append('b');
		
				}
			}

			if (vowels.length() >= 3) {
				if (hasVowelQuestions) {
					int consecutiveVowels = 0;
					char[] tmpVowels = vowels.toString().toCharArray();

					for (int k = 0; k < tmpVowels.length; k++) {
						if (tmpVowels[k] == 'a' || tmpVowels[k] == 'e' || tmpVowels[k] == 'i' || tmpVowels[k] == 'o'
								|| tmpVowels[k] == 'u') {
							if ((k + 1 < tmpVowels.length && tmpVowels[k + 1] != '?') || (k + 1 >= tmpVowels.length)) {
								++consecutiveVowels;
								if (consecutiveVowels == 3)
									return "bad";
							}
						} else {
							consecutiveVowels = 0;
						}

					}

					tmpResult = "mixed";

					
				} else {
					return "bad";
				}
			} else if (constants.length() >= 5) {
				System.out.println(constants.toString());
				System.out.println(hasConstantQuestions);

				if (hasConstantQuestions) {

					int consecutiveConstants = 0;
					char[] tmpConstants = constants.toString().toCharArray();

					for (int k = 0; k < tmpConstants.length; k++) {
						if (tmpConstants[k] != '?') {
							if ((k + 1 < tmpConstants.length && tmpConstants[k + 1] != '?')
									|| (k + 1 >= tmpConstants.length)) {
								++consecutiveConstants;
								if (consecutiveConstants == 5)
									return "bad";
							}
						} else {
							consecutiveConstants = 0;
						}

					}

					tmpResult = "mixed";
					

				} else {
					return "bad";
				}

			} else if (questions.length() >= 3) {

				tmpResult = "mixed";
			}

		}

		if (tmpResult != null)
			return tmpResult;

		return "good";
	}


}
