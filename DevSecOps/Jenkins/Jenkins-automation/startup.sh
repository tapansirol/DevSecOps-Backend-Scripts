docker build -t myjenkins .
docker run  -d -v /var/run/docker.sock:/var/run/docker.sock -v $(which docker):/usr/bin/docker -v /home/config/onetest:/var/jenkins_home/onetest  --env-file /home/config/config.properties -p 9292:8080 myjenkins
