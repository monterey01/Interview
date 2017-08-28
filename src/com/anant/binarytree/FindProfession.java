package com.anant.binarytree;

public class FindProfession {

	// Solution to
	// https://codefights.com/interview-practice/task/FwAR7koSB3uYYsqDp/description
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(findProfession(20, 171971));

	}

	// E D 1
	// ED DE 2
	// EDDE DEED 3
	// EDDE DEED DEED EDDE 4
	// EDDE DEED DEED EDDE DEED EDDE EDDE DEED 5
	// EDDE DEED DEED EDDE DEED EDDE DEED

	static String findProfession(int level, int pos) {
		String profession="";
		if (level == 1)
			profession= "Engineer";

		if (level > 1) {
			int tmpPos = (int) Math.ceil((double) pos / (double) 2);
			 profession = findProfession(level - 1, tmpPos);

			if (profession.equals("Engineer")) {
				if (pos < tmpPos * 2) {
					profession = "Engineer";
				} else {
					profession = "Doctor";
				}

			} else {
				if (pos < tmpPos * 2) {
					profession = "Doctor";
				} else {
					profession = "Engineer";
				}
			}
		}

		return profession;
	}

}
