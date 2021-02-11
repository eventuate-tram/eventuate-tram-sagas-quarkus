#! /bin/bash

set -e

./gradlew testClasses

./gradlew "${database}AllComposeDown"
./gradlew "${database}AllComposeUp"

./gradlew cleanTest build

export EVENTUATE_OUTBOX_ID=1
export USE_DB_ID=true

./gradlew "${database}AllComposeDown"
./gradlew "${database}AllComposeUp"

./gradlew cleanTest build

./gradlew "${database}AllComposeDown"
