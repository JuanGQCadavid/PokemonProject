docker run -it --rm -v ${PWD}/pokemon:/usr/src/mymaven -v ${HOME}/.m2:/root/.m2 -v ${PWD}/pokemon/target:/usr/src/mymaven/target -w /usr/src/mymaven maven:3.8.5-jdk-8-slim mvn package 

docker build -t pokemon-service .
