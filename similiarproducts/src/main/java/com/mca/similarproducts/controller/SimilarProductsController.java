package com.mca.similarproducts.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mca.similarproducts.response.SimilarProducts;
import com.mca.similarproducts.service.SimilarProductsService;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * The Class SimilarProductsController.
 */
@RestController
@RequestMapping("/product")
public class SimilarProductsController {

	/** The similar products service. */
	private SimilarProductsService similarProductsService;

	/**
	 * Instantiates a new similar products controller.
	 *
	 * @param similarProductsService the similar products service
	 */
	public SimilarProductsController(SimilarProductsService similarProductsService) {

		this.similarProductsService = similarProductsService;

	}

	/**
	 * Gets the similar products.
	 *
	 * @param productId the product id
	 * @return the similar products
	 */
	@ApiResponses(value = { @ApiResponse(content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = SimilarProducts.class))) }) })
	@GetMapping(value = "/{productId}/similar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getSimilarProducts(
			@PathVariable(value = "productId", required = true) String productId) {

		List<SimilarProducts> listSimilarProducts = new ArrayList<>();
		try {

			listSimilarProducts = similarProductsService.getSimilarProductos(productId);

		} catch (Exception ex) {
			return new ResponseEntity<>("Product Not found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(listSimilarProducts, HttpStatus.OK);

	}

}
