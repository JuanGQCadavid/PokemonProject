
# K8 Clean

alias k="kubectl"

k delete -f k8/configmap.yaml

k delete -f k8/deployment.yaml --wait=true

k delete -f k8/nodeport-service.yaml


# Docker clean

docker kill pokemon

#docker image rm pokemon-service