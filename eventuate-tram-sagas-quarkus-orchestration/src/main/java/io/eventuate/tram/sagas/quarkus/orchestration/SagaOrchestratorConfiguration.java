package io.eventuate.tram.sagas.quarkus.orchestration;

import io.eventuate.common.id.ApplicationIdGenerator;
import io.eventuate.common.jdbc.EventuateJdbcStatementExecutor;
import io.eventuate.common.jdbc.EventuateSchema;
import io.eventuate.tram.commands.producer.CommandProducer;
import io.eventuate.tram.messaging.consumer.MessageConsumer;
import io.eventuate.tram.sagas.common.SagaLockManager;
import io.eventuate.tram.sagas.orchestration.*;

import javax.enterprise.inject.Instance;
import javax.inject.Singleton;
import java.util.stream.Collectors;

@Singleton
public class SagaOrchestratorConfiguration {
  @Singleton
  public SagaInstanceRepository sagaInstanceRepository(EventuateJdbcStatementExecutor eventuateJdbcStatementExecutor,
                                                       EventuateSchema eventuateSchema) {
    return new SagaInstanceRepositoryJdbc(eventuateJdbcStatementExecutor, new ApplicationIdGenerator(), eventuateSchema);
  }

  @Singleton
  public SagaCommandProducer sagaCommandProducer(CommandProducer commandProducer) {
    return new SagaCommandProducerImpl(commandProducer);
  }

  @Singleton
  public SagaInstanceFactory sagaInstanceFactory(SagaInstanceRepository sagaInstanceRepository,
                                                 CommandProducer commandProducer, MessageConsumer messageConsumer,
                                                 SagaLockManager sagaLockManager, SagaCommandProducer sagaCommandProducer, Instance<Saga<?>> sagas) {
    SagaManagerFactory smf = new SagaManagerFactory(sagaInstanceRepository, commandProducer, messageConsumer,
            sagaLockManager, sagaCommandProducer);
    return new SagaInstanceFactory(smf, sagas.stream().collect(Collectors.toList()));
  }
}
