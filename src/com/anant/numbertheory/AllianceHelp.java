package com.anant.numbertheory;

public class AllianceHelp {

	// Solution to https://codefights.com/fight/YsbwjfYAbHLQHKxBK/solutions

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(allianceHelp(999, 11));

	}

	static int allianceHelp(int t, int allianceSize) {

		int tenPercentOfTotalTime = (int) Math.floor((t * 10) / 100);

		int maxBoostByUsingTenPercent = tenPercentOfTotalTime * Math.min(allianceSize, 10);

		int maxBoostByUsingSixySeconds = 60 * Math.min(allianceSize, 10);

		int result = t - Math.max(maxBoostByUsingSixySeconds, maxBoostByUsingTenPercent);
		result = result < 0 ? 0 : result;
		return result;
	}

}
