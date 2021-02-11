package io.eventuate.tram.sagas.quarkus.inmemory;

import io.eventuate.common.inmemorydatabase.EventuateDatabaseScriptSupplier;

import javax.inject.Named;
import javax.inject.Singleton;
import java.util.Collections;

@Singleton
public class TramSagaInMemoryConfiguration {
  @Singleton
  @Named("TramSagasEventuateDatabaseScriptSupplier")
  public EventuateDatabaseScriptSupplier eventuateCommonInMemoryScriptSupplierForEventuateTramSagas() {
    return () -> Collections.singletonList("eventuate-tram-sagas-embedded.sql");
  }
}
