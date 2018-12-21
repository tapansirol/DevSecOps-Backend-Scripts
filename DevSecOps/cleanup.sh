#!/bin/sh
set -e


SCRIPT=$(readlink -f "$0")
SCRIPTPATH=$(dirname "$SCRIPT")

cd $SCRIPTPATH
./stop-all-containers.sh

sudo docker system prune --all --force --volumes
