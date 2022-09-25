package com.mca.similarproducts.service.impl.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mca.similarproducts.response.ProductDetail;
import com.mca.similarproducts.service.impl.SimilarProductsServiceImpl;

@ExtendWith(SpringExtension.class)
public class SimilarProductsServiceImplTest {

	@InjectMocks
	SimilarProductsServiceImpl similarProductsServiceImpl;

	@BeforeEach
	public void initTest() {
		ProductDetail productDetail = new ProductDetail();
		productDetail.setAvailability(true);
	}
	
	
	@Test
	public void getOkSimilarProducts() {

		assertNotNull(similarProductsServiceImpl.getSimilarProductos("1"));

	}

	@Test
	public void getKOSimilarProducts() {

		assertThrows(Exception.class, () -> similarProductsServiceImpl.getSimilarProductos(null));

	}

	@Test
	public void getKOSimilarProductsBad() {

		assertThrows(RuntimeException.class, () -> similarProductsServiceImpl.getSimilarProductos(null));

	}
}
