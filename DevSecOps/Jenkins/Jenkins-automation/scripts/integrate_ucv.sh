#!/bin/bash

set -e

echo "Integrating UrbanCode Velocity........."

#pretty_sleep() {
#  secs=${1:-60}
#  tool=${2:-service}
#  while [ $secs -gt 0 ]; do
#    echo -ne "$tool unavailable, sleeping for: $secs\033[0Ks\r"
#    sleep 1
#    : $((secs--))
#  done
#  echo "$tool was unavailable, so slept for: ${1:-60} secs"
#}

echo "* Waiting for the Sonar user token api to become available - this can take a few minutes"
TOOL_SLEEP_TIME=30
until [[ $(curl -I -s -u admin:admin -X POST http://localhost:9000/api/user_tokens/generate|head -n 1|cut -d$' ' -f2) == 400 ]]; do pretty_sleep 10 Sonar; done

# Validating if token already exists:
UCV_TOKEN=$(curl -k  --request POST \
  --url https://192.168.49.206/release-events-api/graphql \
  --header 'authorization: Bearer SOtdm2bA94e9DbPoOWe3SlYrpqGXOzttu2PP8P0m6AN3DjigU0n3UkrLvXhsFp7w8ykK8yydIJg0f9dOW5pTOw' \
  --header 'content-type: application/json' \
  --data '{"query":"mutation {\n  addJenkinsIntegration(tenantId:\"5ade13625558f2c6688d15ce\" name:\"Jenkins_Int\") {\n    _id\n    name\n    token\n  }\n}"}'|
python -c "
import sys, json, os     
def tokenExists(userTokens):
    if len(userTokens) == 0: 
	    return 'ifff'    
    return userTokens
userTokens = json.load(sys.stdin)['data']
l = userTokens['addJenkinsIntegration']
r = dict()
token = l['token']
id = l['_id']
r['UCV_TOKEN'] = token
r['UCV_ID'] = id
print(r)
")

echo "************************************ UCV Tokens *********************************************"
echo $UCV_TOKEN["UCV_ID"]
