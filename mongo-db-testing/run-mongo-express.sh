#!/usr/bin/env bash
docker run -d -p 27018:8081 --link mongodb4:mongo mongo-express


docker run -d \
    --name mongo-express \
    -p 27018:8081 \
    -e ME_CONFIG_OPTIONS_EDITORTHEME="ambiance" \
    -e ME_CONFIG_MONGODB_SERVER="ip" \
    -e ME_CONFIG_MONGODB_ENABLE_ADMIN="true" \
    -e ME_CONFIG_MONGODB_ADMINUSERNAME="admin" \
    -e ME_CONFIG_MONGODB_ADMINPASSWORD="Uwjx@2020" \
    -e ME_CONFIG_BASICAUTH_USERNAME="admin" \
    -e ME_CONFIG_BASICAUTH_PASSWORD="Uwjx@2020" \
    mongo-express
