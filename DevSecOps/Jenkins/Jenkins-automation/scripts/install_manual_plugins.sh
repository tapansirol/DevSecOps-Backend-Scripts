#!/bin/bash
cd /var/jenkins_home/plugins

echo $pwd

echo "***********************************************************"
echo "**********************************************************"
curl https://public.dhe.ibm.com/software/products/UrbanCode/plugins/ibmucd/jenkins-pipeline-ud-plugin/ibm-ucdeploy-build-steps-2.9.993392.hpi -o ucd-build-step.hpi
