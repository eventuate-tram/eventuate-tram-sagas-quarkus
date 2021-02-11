#! /bin/bash

set -e

export database=mysql
export target=mysql
export EVENTUATEDATABASE=mysql

./_build-and-test-all.sh