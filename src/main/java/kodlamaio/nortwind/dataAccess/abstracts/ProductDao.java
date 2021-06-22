package kodlamaio.nortwind.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.nortwind.entities.concretes.Product;
import kodlamaio.nortwind.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer> {
	Product getByProductName(String productName); // select * from products where product_name = productName;

	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId); // select * from products where product_name = productName and category_id = categoryId;

	List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId); // select * from products where product_name = productName or category_id = categoryId;

	List<Product> getByCategory_CategoryIdIn(List<Integer> categories); // select * from products where category_id in(categories);

	List<Product> getByProductNameContains(String productName); // select * from products where contains(product_name, "productName");

	List<Product> getByProductNameStartsWith(String productName); // select * from products where product_name like "productName%";

	@Query("From Product where productName=:productName and category.categoryId=:categoryId") // tabloya göre degil entitydeki class a göre yazılır
																					// : -> deger verilmiştir
	List<Product> getByNameAndCategory_CategoryId(String productName, int categoryId); // select * from products where product_name = productName and category_id = categoryId;
	
	@Query("Select new kodlamaio.nortwind.entities.dtos.ProductWithCategoryDto(p.productId, p.productName, c.categoryName) From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
