package info.sjd.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class DataSaverTest {

	@Test
	public void testParseName() {
		String[] product_title_quals = {
				"LG gram Thin and Light Laptop - 15.6\" Full HD IPS Display", 
				" Intel Core i5 (8th Gen)", 
				" 8GB RAM", 
				" 256GB SSD", 
				" Back-lit Keyboard - Dark Silver – 15Z980-U.AAS5U1"};

		assertEquals("LG gram Thin and Light Laptop",  DataSaver.parseName(product_title_quals));
	}

}
