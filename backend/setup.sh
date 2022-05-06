SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )

alias build="sh $SCRIPT_DIR/scripts/dev/docker-build.sh"
alias deploy_docker="sh $SCRIPT_DIR/scripts/dev/docker-deploy.sh"
alias deploy_k8s="sh $SCRIPT_DIR/scripts/dev/k8-deploy.sh"
alias clean="sh $SCRIPT_DIR/scripts/dev/clean.sh"
alias logs_docker="docker logs -f $(docker ps -f name=pokemon -q)"


