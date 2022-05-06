docker run -it --rm -v ${PWD}:/usr/src -v ${HOME}/.m2:/root/.m2 -v ${PWD}/target:/usr/src/target -w /usr/src maven:3.8.5-jdk-8-slim mvn clean package 

