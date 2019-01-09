tar cvzf devsecops.tgz config/ DevSecOps/ devsecops-ui-0.0.1-SNAPSHOT.jar
docker build -t mydevsecops .
#docker run -p 8888:8888 -v /var/run/docker.sock:/var/run/docker.sock -v /home/config:/home/config mydevsecops

