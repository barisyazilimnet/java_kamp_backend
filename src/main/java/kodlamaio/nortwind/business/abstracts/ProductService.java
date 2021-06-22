package kodlamaio.nortwind.business.abstracts;

import java.util.List;

import kodlamaio.nortwind.core.utilities.results.DataResult;
import kodlamaio.nortwind.core.utilities.results.Result;
import kodlamaio.nortwind.entities.concretes.Product;
import kodlamaio.nortwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	DataResult<List<Product>> getAll();

	DataResult<List<Product>> getAll(int pageNumber, int pageSize);

	DataResult<List<Product>> getAllSorted();

	Result add(Product product);

	DataResult<Product> getByProductName(String productName);

	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

	DataResult<List<Product>> getByProductNameContains(String productName);

	DataResult<List<Product>> getByProductNameStartsWith(String productName);

	DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}
