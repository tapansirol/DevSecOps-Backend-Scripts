#!/bin/sh
set -e

#Changing present working directory to execute SonarQube docker-compose file.
cd $(pwd)/sonar
docker-compose up -d
