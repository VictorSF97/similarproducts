package com.mca.similarproducts.service;

import java.util.List;

import com.mca.similarproducts.response.SimilarProducts;

/**
 * The Interface SimilarProductsService.
 */
public interface SimilarProductsService {

	/**
	 * Gets the similar productos.
	 *
	 * @param productId the product id
	 * @return the similar productos
	 */
	List<SimilarProducts> getSimilarProductos(String productId);

}
