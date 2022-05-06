

SCRIPT_DIR=$( cd -- "$( dirname -- "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )
cd $SCRIPT_DIR/../../


# This will generate the java package.
docker run -it --rm  \
    -v ${PWD}/pokemon:/usr/src/pokemon \
    -v ${HOME}/.m2:/root/.m2 \
    -v ${PWD}/pokemon/target:/usr/src/pokemon/target \
    -w /usr/src/pokemon maven:3.8.5-jdk-8-slim mvn package 

# This will generate the image that will use the package.
docker build -t pokemon-service .

# TODO ->  Be able to call this in whatever part of the folder!

