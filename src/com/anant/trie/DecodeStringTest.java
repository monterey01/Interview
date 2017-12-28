package com.anant.trie;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.anant.string.DecodeString;

public class DecodeStringTest {
	DecodeString tester;

	@Before
	public void init() {
		tester = new DecodeString();

	}

	@Test
	public void multiplicationOfZeroIntegersShouldReturnZero() {

		// assert statements
		assertEquals(tester.decodeString("2[abc]3[cd]ef"), "abcabccdcdcdef");

	}
	
	@Test
	public void multiplicationOfZeroIntegersShouldReturnZero1() {

		// assert statements
		assertEquals(tester.decodeString("2[abc]3[cd]ef"), "abcabccdcdcdef");

	}
}
