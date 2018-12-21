#!/bin/sh
set -e

#Changing present working directory to execute Urbancode Deploy docker-compose file.
cd $(pwd)/Jenkins/Jenkins-automation
echo $(pwd)
sudo docker-compose down -v

cd $(pwd)/urbancode_products
sudo docker-compose down -v
