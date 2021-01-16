package org.sid.inventoryservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
   @Bean
		CommandLineRunner start( ProductRepository productRepository, RepositoryRestConfiguration restConfiguration ){
		restConfiguration.exposeIdsFor ( Product.class );
		return  args -> {
			productRepository.save ( new Product (null,"Ordinateur",12345,12));
			productRepository.save ( new Product (null,"Imprimante",1245,123));
			productRepository.save ( new Product (null,"Smartphone",145,1245));
			productRepository.findAll ().forEach ( p->{
				System.out.println ( p.getName() );
			});
		};
	}
}
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
class Product{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double price;
	private double quantity;

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice( double price ) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity( double quantity ) {
		this.quantity = quantity;
	}
}
@RepositoryRestResource
@CrossOrigin("*")

interface ProductRepository extends JpaRepository<Product,Long>{

}
