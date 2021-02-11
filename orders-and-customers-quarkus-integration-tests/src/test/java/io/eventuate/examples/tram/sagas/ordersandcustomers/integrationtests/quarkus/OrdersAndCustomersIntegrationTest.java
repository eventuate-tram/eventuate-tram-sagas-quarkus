package io.eventuate.examples.tram.sagas.ordersandcustomers.integrationtests.quarkus;

import io.eventuate.common.quarkus.jdbc.test.configuration.TestProfileResolver;
import io.eventuate.examples.tram.sagas.ordersandcustomers.quarkus.tests.AbstractOrdersAndCustomersIntegrationTest;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;

@QuarkusTest
@TestProfile(TestProfileResolver.class)
public class OrdersAndCustomersIntegrationTest extends AbstractOrdersAndCustomersIntegrationTest {
}
