#!/bin/sh
set -e

#Changing present working directory to execute UrbanCode Velocity docker-compose file.
cd UrbanCodeVelocity
sudo docker-compose up -d

#Changing present working directory to execute UrbanCode Deploy docker-compose file.
cd ../UrbanCodeDeploy
sudo docker-compose up -d

#Changing present working directory to execute SonarQube docker-compose file.
cd ../sonar
sudo docker-compose up -d

