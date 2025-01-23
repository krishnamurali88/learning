package learn.transactions.handler;

import org.springframework.stereotype.Service;

import learn.transactions.entity.Products;
import learn.transactions.repository.InventoryRepository;

@Service
public class Inventoryhandler {
  private final InventoryRepository inventoryRepository;

  public Inventoryhandler(InventoryRepository inventoryRepository) {
    this.inventoryRepository = inventoryRepository;
  }

  public Products updateProductDetails(Products product) {
    return inventoryRepository.save(product);
  }

  public Products getProducts(int id) {
    return inventoryRepository.findById(id).orElseThrow(
        () -> new RuntimeException("Product not found"));
  }

}
