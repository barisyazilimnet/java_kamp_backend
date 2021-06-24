package kodlamaio.nortwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.nortwind.business.abstracts.ProductService;
import kodlamaio.nortwind.core.utilities.results.DataResult;
import kodlamaio.nortwind.core.utilities.results.Result;
import kodlamaio.nortwind.entities.concretes.Product;
import kodlamaio.nortwind.entities.dtos.ProductWithCategoryDto;

@RestController // Controller oldugunu belirtmek için
@RequestMapping("/api/products/") // bu linkten gelecek istegi karşılıcak olan class budur demek // örnek ->
@CrossOrigin									// barisyazilim.net/api/products
public class ProductsController {
	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("getAll") // gelen get isteginin bu methoda karşılık geldigini söler // örnek ->
							// barisyazilim.net/api/products/getall
	public DataResult<List<Product>> getAll() {
		return this.productService.getAll();
	}

	@PostMapping("add") // gelen post isteginin bu methoda karşılık geldigini söler // örnek ->
						// barisyazilim.net/api/products/add
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}

	@GetMapping("getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);
	}

	@GetMapping("getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,
			@RequestParam("categoryId") int categoryId) {
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}

	@GetMapping("getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
		return this.productService.getByProductNameContains(productName);
	}

	@GetMapping("getAllByPage")
	public DataResult<List<Product>> getAll(int pageNumber, int pageSize) {
		return this.productService.getAll(pageNumber, pageSize);
	}

	@GetMapping("getAllSorted")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}

	@GetMapping("getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return this.productService.getProductWithCategoryDetails();
	}
}
