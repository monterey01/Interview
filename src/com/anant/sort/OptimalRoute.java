package com.anant.sort;

public class OptimalRoute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double x1 = 1.5;
		double y1 = 1.5;

		double x2 = 1.5;
		double y2 = .5;

		System.out.println(getOptimalRoute(4.4, 1.1, x1, x2, y1, y2, Double.MAX_VALUE));

	}

	public static double getOptimalRoute(double v1, double v2, double x1, double x2, double y1, double y2,
			double previousResult) {

		double result = Double.MAX_VALUE;

		double midPoint = Math.abs(y2 + y1) / 2;

		System.out.println(midPoint);

		double leftHyp = Math.sqrt(Math.pow(x2, 2) + Math.pow(Math.abs(midPoint - y2), 2));
		double rightyp = Math.sqrt(Math.pow(x1, 2) + Math.pow(Math.abs(midPoint - y1), 2));
		result = leftHyp / v1 + rightyp / v2;

		if (result >= previousResult) {

			return result;
		}

		result = Math.min(result, getOptimalRoute(v1, v2, x1, x2, y1, midPoint, result));
		result = Math.min(result, getOptimalRoute(v1, v2, x1, x2, midPoint, y2, result));

		return result;
	}

}
