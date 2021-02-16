package io.eventuate.tram.sagas.quarkus.common;

import io.eventuate.common.jdbc.EventuateJdbcStatementExecutor;
import io.eventuate.common.jdbc.EventuateSchema;
import io.eventuate.tram.sagas.common.SagaLockManager;
import io.eventuate.tram.sagas.common.SagaLockManagerImpl;

import javax.inject.Singleton;

@Singleton
public class EventuateTramSagaCommonFactory {

  @Singleton
  public SagaLockManager sagaLockManager(EventuateJdbcStatementExecutor eventuateJdbcStatementExecutor,
                                         EventuateSchema eventuateSchema) {
    return new SagaLockManagerImpl(eventuateJdbcStatementExecutor, eventuateSchema);
  }
}