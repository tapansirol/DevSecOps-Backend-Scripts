#!/bin/sh
set -e

#Changing present working directory to execute Urbancode Deploy docker-compose file.
cd $(pwd)/UrbanCodeDeploy
sudo docker-compose up -d
