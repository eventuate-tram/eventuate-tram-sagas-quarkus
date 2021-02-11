package io.eventuate.examples.tram.sagas.ordersandcustomers.quarkus.customers.domain;

import io.eventuate.examples.tram.sagas.ordersandcustomers.customers.domain.Customer;
import io.eventuate.examples.tram.sagas.ordersandcustomers.customers.domain.CustomerDao;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Singleton
public class CustomerDaoImpl implements CustomerDao {

  @PersistenceContext
  EntityManager entityManager;

  @Override
  public Customer findById(long id) {
    return entityManager.find(Customer.class, id);
  }

  @Override
  @Transactional
  public Customer save(Customer customer) {
    entityManager.persist(customer);
    return customer;
  }
}
