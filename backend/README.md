

Commands:

docker run --name pokemon --rm -i -t pokemon-service bash

docker run --name pokemon -p 8080:8080  --rm  -t pokemon-service /bin/bash /app/start.sh