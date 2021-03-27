#!/bin/bash

export POSTGRES_DB_NAME=brewmaster
export POSTGRES_USER=brewmaster
export POSTGRES_PASSWORD=brewmaster
export DATABASE_PORT=5432
export DATABASE_HOST=beerhouse-database

mvn clean package -Dmaven.test.skip=true

docker-compose up --build
