package com.anant.queuesstacks;

import java.util.LinkedList;
import java.util.Queue;

public class CountClouds {

	// Solution to
	// https://codefights.com/interview-practice/task/HdgqPhHqs3NciAHqH/solutions

	static class Position {
		int row;
		int col;

	}

	int countClouds(char[][] skyMap) {
		if (skyMap.length == 0)
			return 0;
		int result = 0;
		boolean[][] visited = new boolean[skyMap.length][skyMap[0].length];
		int numberOfRows = skyMap.length;
		int numberOfCols = skyMap[0].length;

		for (int i = 0; i < numberOfRows; i++) {
			for (int j = 0; j < numberOfCols; j++) {

				if (skyMap[i][j] == '0') {
					visited[i][j] = true;
				} else if (visited[i][j] == false && skyMap[i][j] == '1') {
					++result;
					Queue<Position> positions = new LinkedList<Position>();
					Position position = new Position();
					position.row = i;
					position.col = j;
					positions.add(position);
					markAllNeighboringClouds(positions, numberOfCols, numberOfRows, skyMap, visited);
				}
			}
		}

		return result;
	}

	void markAllNeighboringClouds(Queue<Position> positions, int maxCols, int maxRows, char[][] skyMap,
			boolean[][] visited) {

		while (positions.size() > 0) {
			Position position = positions.poll();

			// Check col - 1
			if (position.col - 1 >= 0 && visited[position.row][position.col - 1] == false
					&& skyMap[position.row][position.col - 1] == '1') {
				Position tmpPosition = new Position();
				tmpPosition.row = position.row;
				tmpPosition.col = position.col - 1;
				visited[position.row][position.col - 1] = true;

				positions.add(tmpPosition);
			}

			// Check col + 1
			if (position.col + 1 < maxCols && visited[position.row][position.col + 1] == false
					&& skyMap[position.row][position.col + 1] == '1') {
				Position tmpPosition = new Position();
				tmpPosition.row = position.row;
				tmpPosition.col = position.col + 1;
				visited[position.row][position.col + 1] = true;

				positions.add(tmpPosition);
			}

			// Check row - 1
			if (position.row - 1 >= 0 && visited[position.row - 1][position.col] == false
					&& skyMap[position.row - 1][position.col] == '1') {
				Position tmpPosition = new Position();
				tmpPosition.row = position.row - 1;
				tmpPosition.col = position.col;
				visited[position.row - 1][position.col] = true;
				positions.add(tmpPosition);
			}

			// Check row + 1
			if (position.row + 1 < maxRows && visited[position.row + 1][position.col] == false
					&& skyMap[position.row + 1][position.col] == '1') {
				Position tmpPosition = new Position();
				tmpPosition.row = position.row + 1;
				tmpPosition.col = position.col;
				visited[position.row + 1][position.col] = true;
				positions.add(tmpPosition);
			}

		}

	}

}
