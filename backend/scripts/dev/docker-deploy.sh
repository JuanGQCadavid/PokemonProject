#!/bin/bash

CONTAINER_ID=$(docker run \
                    --name pokemon \
                    --rm \
                    -p 8080:8080 \
                    -d \
                    -t pokemon-service /bin/bash /app/start.sh)

docker logs -f $CONTAINER_ID