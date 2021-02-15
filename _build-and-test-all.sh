#! /bin/bash

set -e

./gradlew testClasses

if [[ "${EVENTUATEDATABASE}" = "mysql" ]]; then

  export EVENTUATEDATABASE=h2

  ./gradlew :orders-and-customers-quarkus-in-memory-integration-tests:cleanTest :orders-and-customers-quarkus-in-memory-integration-tests:test \
    :orders-and-customers-quarkus-local-saga-in-memory-integration-tests:cleanTest :orders-and-customers-quarkus-local-saga-in-memory-integration-tests:test

  export EVENTUATEDATABASE=mysql
fi

./gradlew "${database}AllComposeDown"
./gradlew "${database}AllComposeUp"

./gradlew cleanTest -x :orders-and-customers-quarkus-in-memory-integration-tests:test -x :orders-and-customers-quarkus-local-saga-in-memory-integration-tests:test cleanTest build

export EVENTUATE_OUTBOX_ID=1
export USE_DB_ID=true

./gradlew "${database}AllComposeDown"
./gradlew "${database}AllComposeUp"

./gradlew cleanTest -x :orders-and-customers-quarkus-in-memory-integration-tests:test -x :orders-and-customers-quarkus-local-saga-in-memory-integration-tests:test  cleanTest build

./gradlew "${database}AllComposeDown"
