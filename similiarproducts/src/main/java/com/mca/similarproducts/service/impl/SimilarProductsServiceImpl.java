package com.mca.similarproducts.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mca.similarproducts.response.ProductDetail;
import com.mca.similarproducts.response.SimilarProducts;
import com.mca.similarproducts.service.SimilarProductsService;
import com.mca.similarproducts.utils.CustomsConstants;

/**
 * The Class SimilarProductsServiceImpl.
 */
@Service
public class SimilarProductsServiceImpl implements SimilarProductsService {

	/**
	 * Gets the similar productos.
	 *
	 * @param productId the product id
	 * @return the similar productos
	 */
	@Override
	public List<SimilarProducts> getSimilarProductos(String productId) {

		List<SimilarProducts> listSimilarProducts = getSilimilarProductById(productId);

		return listSimilarProducts;
	}

	/**
	 * Gets the silimilar product by id.
	 *
	 * @param productId the product id
	 * @return the silimilar product by id
	 */
	@SuppressWarnings("unchecked")
	private List<SimilarProducts> getSilimilarProductById(String productId) {

		RestTemplate restTemplate = new RestTemplate();
		List<SimilarProducts> listSimilarProducts = new ArrayList<>();
		List<String> listSimilar = new ArrayList<>();

		try {

			if (restTemplate
					.getForObject(CustomsConstants.URI_BEFORE.concat(productId).concat(CustomsConstants.URI_AFTER),
							List.class)
					.isEmpty()) {

			}
		} catch (Exception exception) {

			throw new RuntimeException("\r\n" + "Product Not found");

		}

		listSimilar = restTemplate.getForObject(
				CustomsConstants.URI_BEFORE.concat(productId).concat(CustomsConstants.URI_AFTER), List.class);

		for (int i = 0; i < listSimilar.size(); i++) {

			SimilarProducts similarProducts = new SimilarProducts();

			ProductDetail listSimilar1 = restTemplate.getForObject(
					CustomsConstants.URI_BEFORE.concat(String.valueOf(listSimilar.get(i))), ProductDetail.class);

			similarProducts.setId(listSimilar1.getId());
			similarProducts.setName(listSimilar1.getName());
			similarProducts.setPrice(listSimilar1.getPrice());
			similarProducts.setAvailability(listSimilar1.isAvailability());

			listSimilarProducts.add(similarProducts);
		}
		return listSimilarProducts;
	}

}
