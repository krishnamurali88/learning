package learn.transactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import learn.transactions.entity.Products;

public interface InventoryRepository extends JpaRepository<Products, Integer> {

}
