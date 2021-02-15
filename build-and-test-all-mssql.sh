#! /bin/bash

set -e

export database=mssql
export target=mssql
export EVENTUATEDATABASE=mssql

./_build-and-test-all.sh