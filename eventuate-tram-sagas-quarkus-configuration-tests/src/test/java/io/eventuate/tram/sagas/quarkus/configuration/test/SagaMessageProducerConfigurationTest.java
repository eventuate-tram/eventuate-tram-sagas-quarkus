package io.eventuate.tram.sagas.quarkus.configuration.test;

import io.eventuate.common.quarkus.jdbc.test.configuration.TestProfileResolver;
import io.eventuate.tram.messaging.producer.common.MessageProducerImplementation;
import io.eventuate.tram.messaging.producer.jdbc.MessageProducerJdbcImpl;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
@TestProfile(TestProfileResolver.class)
public class SagaMessageProducerConfigurationTest {

  @Inject
  MessageProducerImplementation messageProducer;

  @Test
  public void testThatJdbcProducerIsUsed() {
    assertTrue(messageProducer instanceof MessageProducerJdbcImpl);
  }
}