package io.eventuate.tram.sagas.quarkus.participant;

import io.eventuate.tram.commands.common.CommandNameMapping;
import io.eventuate.tram.messaging.consumer.MessageConsumer;
import io.eventuate.tram.messaging.producer.MessageProducer;
import io.eventuate.tram.sagas.common.SagaLockManager;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcherFactory;

import javax.enterprise.inject.Instance;
import javax.inject.Singleton;

@Singleton
public class SagaParticipantFactory {
  @Singleton
  public SagaCommandDispatcherFactory sagaCommandDispatcherFactory(Instance<MessageConsumer> messageConsumer,
                                                                   Instance<MessageProducer> messageProducer,
                                                                   SagaLockManager sagaLockManager, CommandNameMapping commandNameMapping) {
    return new SagaCommandDispatcherFactory(messageConsumer.get(), messageProducer.get(), sagaLockManager, commandNameMapping);
  }
}
