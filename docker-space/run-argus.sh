#!/usr/bin/env bash

docker run -d -p 8080:8082 -v /etc/localtime:/etc/localtime:ro registry.cn-shanghai.aliyuncs.com/jiafinance-uwjx/jiafinance-cn-api:dev8.26.0
