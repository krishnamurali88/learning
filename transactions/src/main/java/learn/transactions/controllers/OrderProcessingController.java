package learn.transactions.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learn.transactions.entity.Orders;
import learn.transactions.service.OrderProcessingService;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/orders")
public class OrderProcessingController {

  private final OrderProcessingService orderProcessingService;

  public OrderProcessingController(OrderProcessingService orderProcessingService) {
    this.orderProcessingService = orderProcessingService;
  }

  /**
   * API to place order
   * 
   * @param orders
   * @return Processed order with updated price
   */
  @PostMapping
  public ResponseEntity<?> placeOrder(@RequestBody Orders orders) {
    return ResponseEntity.ok(orderProcessingService.placeAnOrder(orders));
  }

}
