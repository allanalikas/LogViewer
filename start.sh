#!/bin/bash

./stop.sh

echo "Removing old images/containers that could stop our containers from running"

docker rm $(docker ps -q -f status=exited)
docker rmi $(docker images -q -f "dangling=true")

echo "Starting our containers in the background"

echo "Starting our project"
docker-compose -f ./docker-compose.yml up -d --force-recreate --build
