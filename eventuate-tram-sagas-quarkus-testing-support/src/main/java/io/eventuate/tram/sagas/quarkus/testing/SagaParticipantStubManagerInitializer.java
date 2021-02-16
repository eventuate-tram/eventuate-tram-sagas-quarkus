package io.eventuate.tram.sagas.quarkus.testing;

import io.eventuate.tram.sagas.testing.SagaParticipantStubManager;
import io.quarkus.runtime.Startup;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Singleton;

@Startup
@Singleton
public class SagaParticipantStubManagerInitializer {

  @Inject
  Instance<SagaParticipantStubManager> sagaParticipantStubManagers;

  @PostConstruct
  public void init() {
    sagaParticipantStubManagers.stream().forEach(SagaParticipantStubManager::initialize);
  }
}
