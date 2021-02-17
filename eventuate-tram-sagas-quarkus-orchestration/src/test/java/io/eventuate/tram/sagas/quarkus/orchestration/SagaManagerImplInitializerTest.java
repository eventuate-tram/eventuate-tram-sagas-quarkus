package io.eventuate.tram.sagas.quarkus.orchestration;

import io.eventuate.tram.sagas.orchestration.SagaManager;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.inject.Inject;
import javax.inject.Named;

@QuarkusTest
public class SagaManagerImplInitializerTest {

  @Inject
  @Named("sagaManager1")
  SagaManager<SampleSagaData1> sagaManager1;

  @Inject
  @Named("sagaManager2")
  SagaManager<SampleSagaData2> sagaManager2;

  @Test
  public void testSagaManagersInitialized() {
    Mockito.verify(sagaManager1).subscribeToReplyChannel();
    Mockito.verify(sagaManager2).subscribeToReplyChannel();
  }
}
