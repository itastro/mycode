package com.bailian.car.utils;

public class StringU {

	public static String getString(double d) {

		String value = String.valueOf(d);
		int i = value.lastIndexOf(".");
		String substring = value.substring(0, i);
		return substring;
	}

}
