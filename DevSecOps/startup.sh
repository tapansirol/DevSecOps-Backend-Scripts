SCRIPT=$(readlink -f "$0")
SCRIPTPATH=$(dirname "$SCRIPT")

cd $SCRIPTPATH
#cd /home/ubuntu/Tapan/DevSecOps
sudo ./start-all-containers.sh

cd $(pwd)/Jenkins/Jenkins-automation
sudo ./startup.sh
