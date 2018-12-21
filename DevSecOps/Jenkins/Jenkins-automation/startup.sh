docker pull jenkins:latest
docker build -t myjenkins .
docker run --env-file ./env.list -d -p 9292:8080  -v `pwd`/downloads:/var/jenkins_home/downloads -v `pwd`/jobs:/var/jenkins_home/jobs/ --rm --name myjenkins myjenkins:latest

