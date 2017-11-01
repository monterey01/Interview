package com.anant.string;

public class ValidateIPAddress {
	public static String validIPAddress(String IP) {

		// Check if

		if (isIP4Address(IP))
			return "IPv4";
		if (isIP6Address(IP))
			return "IPv6";

		return "";

	}

	private static boolean isIP4Address(String IP) {
		String[] ip4ca = IP.split("\\.");

		if (ip4ca.length == 4) {
			for (int i = 0; i < ip4ca.length; i++) {
				boolean hasNonZero = false;

				char[] tmpca = ip4ca[i].toCharArray();
				if (tmpca.length == 0)
					return false;
				int j = 0;
				while (j < tmpca.length) {
					if (!(Character.isDigit(tmpca[j])))
						return false;
					if (tmpca[j] != '0')
						hasNonZero = true;
					if (tmpca[j] == '0' && !hasNonZero)
						return false;

					j++;
				}

				if (!(Integer.parseInt(ip4ca[i]) > -1 && Integer.parseInt(ip4ca[i]) < 256))
					return false;
				if (i == 3)
					return true;
			}
		}

		return false;

	}

	private static boolean isIP6Address(String IP) {
		String[] ip6ca = IP.split("\\:");

		if (ip6ca.length == 7) {

			for (int i = 0; i < ip6ca.length; i++) {
				boolean hasNonZero = false;
				char[] tmpca = ip6ca[i].toCharArray();

				if (tmpca.length == 0)
					return false;
				int j = 0;
				while (j < tmpca.length) {
					char c = tmpca[j];
					c = Character.toLowerCase(c);

					if (!(Character.isDigit(c) || c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e'))
						return false;
					if (c == 'a' || c == 'b' || c == 'c' || c == 'd' || c == 'e' || (Character.isDigit(c) && c != '0'))
						hasNonZero = true;

					if (tmpca[j] == '0' && !hasNonZero)
						return false;
					++j;
				}

				if (i == 6)
					return true;
			}

		}
		return false;

	}
}
