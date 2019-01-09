SCRIPT=$(readlink -f "$0")
SCRIPTPATH=$(dirname "$SCRIPT")

cd $SCRIPTPATH
#cd /home/ubuntu/Tapan/DevSecOps
sudo ./exec-sonar-docker-compose.sh

sudo ./exec-udeploy-docker-compose.sh

sudo ./exec-uvelocity-docker-compose.sh

cd $(pwd)/Jenkins/Jenkins-automation
sudo ./startup.sh
