package kodlamaio.nortwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getterları ve setterları otomatik olarak ekler
@Entity // hangi katmana ait oldugunu belirler
@Table(name = "products") // veritabanında hangi tabloya karşılık geldigini söler
@AllArgsConstructor // tüm alanları kullanrak constructor ekler
@NoArgsConstructor // boş constructor ekler
public class Product {
	@Id // tablodaki primary key in tablo idsinin hangisi oldugunu söler
	@GeneratedValue(strategy = GenerationType.IDENTITY) // idnin bir bir otomatik artması gerektigini söler
	@Column(name = "product_id") // veritabanında hangi sütuna karşılık geldigini söler
	private int productId;
//	 @Column(name = "category_id")
//	 private int productCategoryId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "unit_price")
	private double productUnitPrice;
	@Column(name = "units_in_stock")
	private short productUnitsInStock;
	@Column(name = "quantity_per_unit")
	private String productQuantityPerUnit;
	@ManyToOne()
	@JoinColumn(name = "category_id") // hangi sütunla eşleşecegini sölüyoruz
	private Category category; // category idsini sölemiş oluyoruz
}
