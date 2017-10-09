package com.anant.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class allianceVersusMonsterDynamicProgramming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(allianceVersusMonster(new int[] { 110, 30, 50 }, new int[] { 12, 11, 20 }));
		// System.out.println(allianceVersusMonster(new int[] { 10, 4, 4, 4 }, new int[]
		// { 1, 1, 1, 1 }));

	}

	static class Memo {

		int monsterHealthPoints;
		int index;

		public Memo(int monsterHealthPoints, int index) {
			this.monsterHealthPoints = monsterHealthPoints;
			this.index = index;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + index;
			result = prime * result + monsterHealthPoints;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Memo other = (Memo) obj;
			if (index != other.index)
				return false;
			if (monsterHealthPoints != other.monsterHealthPoints)
				return false;
			return true;
		}

	}

	static int allianceVersusMonster(int[] healthPoints, int[] attackDamage) {

		int result = maxWarriorsAllive1(healthPoints[0], attackDamage[0],
				Arrays.copyOfRange(healthPoints, 1, healthPoints.length),
				Arrays.copyOfRange(attackDamage, 1, attackDamage.length), 0, new HashMap<Memo, Integer>());

		return result;
	}

	static int maxWarriorsAllive1(int monsterHealthPoints, int monsterAttackDamage, int warriorHealthPoints[],
			int warriorAttackDamage[], int index, Map<Memo, Integer> memoziation) {

		System.out.print(index + "," + monsterHealthPoints + ",");
		for (int value : warriorHealthPoints) {
			System.out.print(value + ",");
		}
		System.out.println();
		;

		int result = 0;

		if (index >= warriorHealthPoints.length) {
			return 0;
		}

		if (monsterHealthPoints <= 0) {

			for (int value : warriorHealthPoints) {
				if (value > 0) {
					++result;
				}
			}
			return result;
		}

		if (memoziation.get(new Memo(monsterHealthPoints, index)) != null) {
			return memoziation.get(new Memo(monsterHealthPoints, index));
		}

		int result2 = 0;

		int tmpMonsterHealthPoints = monsterHealthPoints - warriorAttackDamage[index];
		int[] copyOfWarriorHealthPoints = Arrays.copyOf(warriorHealthPoints, warriorHealthPoints.length);

		if (!(copyOfWarriorHealthPoints[index] <= 0)) {

			if (tmpMonsterHealthPoints > 0)
				copyOfWarriorHealthPoints[index] -= monsterAttackDamage;

			result2 = maxWarriorsAllive1(tmpMonsterHealthPoints, monsterAttackDamage, copyOfWarriorHealthPoints,
					warriorAttackDamage, index, memoziation);
		}

		int result1 = maxWarriorsAllive1(monsterHealthPoints, monsterAttackDamage,
				Arrays.copyOf(warriorHealthPoints, warriorHealthPoints.length), warriorAttackDamage, index + 1,
				memoziation);

		result = Math.max(result1, result2);

		memoziation.put(new Memo(monsterHealthPoints, index), result);

		return result;
	}

}
