#!/bin/bash

docker kill postgresql
docker kill logviewer-front
docker kill logviewer_api
docker kill logviewer_rev-proxy_1