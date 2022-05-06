
SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
cd $SCRIPT_DIR/../../

# K8 Clean

kubectl delete -f k8/configmap.yaml

kubectl delete -f k8/deployment.yaml --wait=true

kubectl delete -f k8/nodeport-service.yaml


# Docker clean

docker kill pokemon

#docker image rm pokemon-service