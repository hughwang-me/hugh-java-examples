#!/usr/bin/env bash
docker rmi $(docker images | grep 'jiafinance' | awk '{print $1":"$2}')
docker rmi $(docker images | grep 'deayea' | awk '{print $1":"$2}')

docker run -d -p 8080:8082 -v /etc/localtime:/etc/localtime:ro registry.cn-shanghai.aliyuncs.com/jiafinance-uwjx/jiafinance-cn-api:dev8.26.0
