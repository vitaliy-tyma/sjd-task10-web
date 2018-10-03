package info.sjd.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {

	@Test
	void testProductToXML() {
		Product product = new Product("product_name", "display", "cpu", "ram", "hdd", "keyboard", "color",
				"product_number", "os", "battery");

		assertNotNull(product.toString());
		assertEquals("product_name", product.getName());

	}

}
