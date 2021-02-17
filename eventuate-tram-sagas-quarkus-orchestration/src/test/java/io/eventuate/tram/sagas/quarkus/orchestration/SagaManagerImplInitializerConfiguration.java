package io.eventuate.tram.sagas.quarkus.orchestration;

import io.eventuate.tram.sagas.orchestration.SagaManager;
import org.mockito.Mockito;

import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class SagaManagerImplInitializerConfiguration {

  @Named("sagaManager1")
  @Singleton
  public SagaManager<SampleSagaData1> sagaManager1() {
    return Mockito.mock(SagaManager.class);
  }

  @Named("sagaManager2")
  @Singleton
  public SagaManager<SampleSagaData2> sagaManager2() {
    return Mockito.mock(SagaManager.class);
  }
}
