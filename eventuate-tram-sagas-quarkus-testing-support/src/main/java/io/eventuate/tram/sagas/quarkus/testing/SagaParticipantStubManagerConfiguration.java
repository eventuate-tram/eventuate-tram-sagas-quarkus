package io.eventuate.tram.sagas.quarkus.testing;

import io.eventuate.tram.messaging.consumer.MessageConsumer;
import io.eventuate.tram.messaging.producer.MessageProducer;
import io.eventuate.tram.sagas.testing.SagaParticipantChannels;
import io.eventuate.tram.sagas.testing.SagaParticipantStubManager;

import javax.enterprise.inject.Instance;
import javax.inject.Singleton;

@Singleton
public class SagaParticipantStubManagerConfiguration {

  @Singleton
  public SagaParticipantStubManager sagaParticipantStubManager(Instance<SagaParticipantChannels> sagaParticipantChannels,
                                                               Instance<MessageConsumer> messageConsumer,
                                                               Instance<MessageProducer> messageProducer) {
    return new SagaParticipantStubManager(sagaParticipantChannels.get(), messageConsumer.get(), messageProducer.get());
  }
}
