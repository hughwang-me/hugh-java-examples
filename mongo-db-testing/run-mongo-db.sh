#!/usr/bin/env bash

docker run -d -p 27017:27017 -v /root/mongodb/db:/data/db --name mongodb4 mongo
docker run -d -p 27017:27017 -v /root/mongodb/db:/data/db --name mongodb4 mongo --auth

#Mongo Shell
#docker exec -it cc4a mongo
