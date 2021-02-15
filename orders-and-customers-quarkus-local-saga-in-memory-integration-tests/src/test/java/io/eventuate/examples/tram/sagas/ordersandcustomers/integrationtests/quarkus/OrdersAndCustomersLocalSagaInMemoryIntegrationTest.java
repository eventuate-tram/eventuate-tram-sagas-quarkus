package io.eventuate.examples.tram.sagas.ordersandcustomers.integrationtests.quarkus;

import io.eventuate.examples.tram.sagas.ordersandcustomers.commondomain.Money;
import io.eventuate.examples.tram.sagas.ordersandcustomers.customers.domain.Customer;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.domain.Order;
import io.eventuate.examples.tram.sagas.ordersandcustomers.orders.service.OrderDetails;
import io.eventuate.examples.tram.sagas.ordersandcustomers.quarkus.tests.AbstractOrdersAndCustomersIntegrationTest;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class OrdersAndCustomersLocalSagaInMemoryIntegrationTest extends AbstractOrdersAndCustomersIntegrationTest {

  protected Order createOrder(Customer customer) {
    return getOrderService().localCreateOrder(new OrderDetails(customer.getId(), new Money("123.40")));
  }


  @Override
  protected void assertCreateOrderSagaCompletedSuccesfully(Order order) {
    // do nothing
  }

  @Override
  protected void assertCreateOrderSagaRolledBack(Order order) {
    // do nothing
  }

}
