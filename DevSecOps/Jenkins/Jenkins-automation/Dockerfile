#This is the base image we use to create our image from

FROM jenkinsci/jenkins

#just info about who created this

USER root
MAINTAINER Tapan

#get rid of admin password setup

ENV JAVA_OPTS="-Djenkins.install.runSetupWizard=false"

#automatically installing all plugins

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
COPY scripts/* /usr/share/jenkins/ref/scripts/

#RUN curl https://public.dhe.ibm.com/software/products/UrbanCode/plugins/ibmucd/jenkins-pipeline-ud-plugin/ibm-ucdeploy-build-steps-2.9.993392.hpi -o ucd-build-step.hpi
RUN wget https://public.dhe.ibm.com/software/products/UrbanCode/plugins/ibmucd/jenkins-pipeline-ud-plugin/ibm-ucdeploy-build-steps-2.9.993392.hpi

RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

#adding scripts

COPY init.groovy.d/* /usr/share/jenkins/ref/init.groovy.d/
Copy scripts/* /var/jenkins_home/plugins/
COPY conf/* /var/jenkins_home/
COPY downloads/* /var/jenkins_home/
