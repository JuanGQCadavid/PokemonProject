#!/bin/bash

SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
cd $SCRIPT_DIR/../../

kubectl apply -f k8/configmap.yaml

kubectl apply -f k8/deployment.yaml

kubectl apply -f k8/nodeport-service.yaml