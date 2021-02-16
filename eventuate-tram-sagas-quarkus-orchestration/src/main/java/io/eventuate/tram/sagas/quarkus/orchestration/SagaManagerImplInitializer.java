package io.eventuate.tram.sagas.quarkus.orchestration;

import io.eventuate.tram.sagas.orchestration.SagaManager;
import io.quarkus.runtime.Startup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Singleton;

@Startup
@Singleton
public class SagaManagerImplInitializer {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Inject
  Instance<SagaManager<?>> sagaManagers;

  @PostConstruct
  public void init() {
    logger.info("Initializing saga managers");
    sagaManagers.stream().forEach(SagaManager::subscribeToReplyChannel);
    logger.info("Initialized saga managers");
  }
}
