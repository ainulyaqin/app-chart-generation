#!/bin/sh

cd /Users/admin/Documents/code/app-chart-generation

fuser -k 8080/tcp

git pull

mvn clean package

java -jar target/app-chart-generation-1.0.jar &
