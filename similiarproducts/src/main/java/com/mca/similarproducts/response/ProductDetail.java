package com.mca.similarproducts.response;

import java.io.Serializable;

import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class SimilarProducts.
 */

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * Instantiates a new product detail.
 */
@NoArgsConstructor

/**
 * Instantiates a new product detail.
 *
 * @param id           the id
 * @param name         the name
 * @param price        the price
 * @param availability the availability
 */
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ProductDetail implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id. */
	@Schema(name = "id", example = "1",description = "Product identifier")
	@Min(value = 1)
	private String id;

	/** The name. */
	@Schema(name = "name", example = "shirt",description = "Product Name")
	@Min(value = 1)
	private String name;

	/** The price. */
	@Schema(name = "price", example = "29",description = "Product Rrice")
	private double price;

	/** The availability. */
	@Schema(name = "availability", example = "true",description = "Product availability")
	private boolean availability;
}
