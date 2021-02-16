#! /bin/bash

set -e

export EVENTUATEDATABASE=postgresql
export QUARKUS_PROFILE=postgresql
export database=postgres
export target=postgres

./_build-and-test-all.sh