#!/bin/sh
set -e

#Changing present working directory to execute Urbancode Velocity docker-compose file.
cd $(pwd)/UrbanCodeVelocity
sudo docker-compose up -d
