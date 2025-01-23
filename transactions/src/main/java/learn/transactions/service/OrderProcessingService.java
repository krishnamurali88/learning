package learn.transactions.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import learn.transactions.entity.Orders;
import learn.transactions.entity.Products;
import learn.transactions.handler.Inventoryhandler;
import learn.transactions.handler.OrderHandler;

@Service
public class OrderProcessingService {
  private final OrderHandler orderHandler;

  private final Inventoryhandler inventoryhandler;

  private Orders saveOrder;

  public OrderProcessingService(OrderHandler orderHandler, Inventoryhandler inventoryhandler) {
    this.orderHandler = orderHandler;
    this.inventoryhandler = inventoryhandler;
  }

  // How multiple transactions can communicate with each other
  // REQUIRED : join an existing transaction or create a new one if not exist
  // REQUIRES_NEW : Always create a new transaction , suspending if any existing
  // transaction
  // MANDATORY : Require an existing transaction , if nothing found it will throw
  // exception
  // NEVER : Ensure the method will run without transaction , throw an exception
  // if found any
  // NOT_SUPPORTED : Execute method without transaction, suspending any active
  // transaction
  // SUPPORTS : Supports if there is any active transaction , if not execute
  // without transaction
  // NESTED : Execute within a nested transaction, allowing nested transaction to
  // rollback independently if there is any exception without impacting outer
  // transaction

  // isolation : controls the visibility of changes made by one transaction to
  // other transaction

  @Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
  public Orders placeAnOrder(Orders order) {

    // get the product from the inventory
    Products product = inventoryhandler.getProducts(order.getProductId());

    // validate the stock availability < 5
    validateStockAvailability(order, product);

    // update total price in order entity
    order.setTotalPrice(order.getQuantity() * product.getPrice());

    // save the order
    Orders saveOrder = orderHandler.saveOrder(order);

    // update stock in inventory
    updateInventoryStock(order, product);

    return saveOrder;
  }

  private void validateStockAvailability(Orders order, Products product) {
    if (order.getQuantity() > product.getStockQuantity()) {
      throw new RuntimeException();
    }
  }

  private void updateInventoryStock(Orders order, Products product) {
    int availableStock = product.getStockQuantity() - order.getQuantity();
    product.setStockQuantity(availableStock);
    inventoryhandler.updateProductDetails(product);
  }

}
