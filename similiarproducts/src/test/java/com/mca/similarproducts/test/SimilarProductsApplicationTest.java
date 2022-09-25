package com.mca.similarproducts.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mca.similarproducts.SimilarProductsApplication;

@ExtendWith(SpringExtension.class)
public class SimilarProductsApplicationTest {

	@Test
	public void entryPointTest() {

		assertDoesNotThrow(() -> SimilarProductsApplication.main(new String[] {}));

	}
	
}
