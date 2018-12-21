Commands to execute:
1. docker pull jenkins:2.138.1
2. docker build -t myjenkins .
3. docker run -p 8080:8080  -v `pwd`/downloads:/var/jenkins_home/downloads -v `pwd`/jobs:/var/jenkins_home/jobs/ --rm --name myjenkins myjenkins:latest.


