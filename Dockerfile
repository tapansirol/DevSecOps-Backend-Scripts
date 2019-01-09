# Ubuntu 15.04 with Java 7 installed.

# Build image with:  docker build -t krizsan/ubuntu1504java7:v1 .

FROM ubuntu:latest

MAINTAINER Tapan
#USER root

COPY devsecops.tgz /tmp 

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get update && \
    apt-get install -y openjdk-8-jdk docker.io curl tar sudo && \
    apt-get clean && \
    curl -L "https://github.com/docker/compose/releases/download/1.23.1/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose && \
    chmod +x /usr/local/bin/docker-compose && \
    cd /home  && \
    tar xvfz /tmp/devsecops.tgz 
	

VOLUME  /var/run/docker.sock /var/run/docker.sock

WORKDIR /home

EXPOSE 8888
CMD    ["java", "-jar", "devsecops-ui-0.0.1-SNAPSHOT.jar"]

