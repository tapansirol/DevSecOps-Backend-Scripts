echo 'executing UrbancodeVelocity docker-compose stop'
cd $(pwd)/UrbanCodeVelocity
sudo  docker-compose stop
cd ..

#Stopping UrbanCode Deploy container
echo 'executing UrbanCodeDeploy docker-compose stop'
cd $(pwd)/UrbanCodeDeploy
sudo docker-compose stop
cd ..

#Stopping SonarQube container
echo 'executing SonarQube docker-compose stop'
cd $(pwd)/sonar
sudo docker-compose stop
cd ..
#Stop jenkins container
echo 'Stopping jenkins container'
sudo docker container stop myjenkins

