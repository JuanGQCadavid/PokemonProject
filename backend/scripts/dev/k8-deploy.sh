

alias k="kubectl"

k apply -f k8/configmap.yaml

k apply -f k8/deployment.yaml

k apply -f k8/nodeport-service.yaml