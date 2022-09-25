package com.mca.similarproducts.controller.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mca.similarproducts.controller.SimilarProductsController;
import com.mca.similarproducts.service.SimilarProductsService;
import com.mca.similarproducts.service.impl.SimilarProductsServiceImpl;

@ExtendWith(SpringExtension.class)
public class SimilarProductsControllerTest {

	@InjectMocks
	SimilarProductsController similarProductsController;

	@Mock
	SimilarProductsService similarProductsService = new SimilarProductsServiceImpl();

	@Test
	public void getOkSimilar() {

		assertNotNull(similarProductsController.getSimilarProducts("1"));

	}

	@Test
	public void getKoSimilar() {

		Mockito.when(similarProductsService.getSimilarProductos("")).thenThrow(new RuntimeException());

		assertNotNull(similarProductsController.getSimilarProducts("1"));

	}

}
