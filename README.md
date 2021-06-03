# The Pokemon Project

!["Octodex img 1"](https://octodex.github.com/images/privateinvestocat.jpg)

## Endpoints

    URL -> http://18.198.197.44:8080
    Swagger documentation -> /swagger-ui.html
    Poke api routes -> /api/v1/pokemon/
        GET /api/v1/pokemon/
        GET /api/v1/pokemon/?start=<Number>&size=<Number>
        GET /api/v1/pokemon/<pokeId>

    Examples

        http://18.198.197.44:8080/swagger-ui.html
        http://18.198.197.44:8080/api/v1/pokemon/
        http://18.198.197.44:8080/api/v1/pokemon/?start=10&size=20
        http://18.198.197.44:8080/api/v1/pokemon/5
        



## Deployment

### Containerization
In order to deploy this awesome solution we should go do:

1. Go to backend folder

2. Build the docker -> docker build -t <name:version> . 

3. Publish it to docker hub (https://docs.docker.com/engine/reference/commandline/login/) -> docker push <name:version>


### Deploying it 

Now we got the solution on Docker hub, we could deploy it wherever we want, I'm going to deploy it on AWS using some fancy services

#### AWS Fancy service one

![Octodex 2](https://octodex.github.com/images/boxertocat_octodex.jpg)

I decided to deploy it using AWS ECS due to its scalability options, this could be a little be more handy that just creating an EC2 machine but this will pay the bills, moreover, we are going to use aws Fargate!

1. Go to AWS ECS service and create a new task (https://console.aws.amazon.com/ecs/home?region=us-east-1#/taskDefinitions/create)


1.1. Choose fargate.
1.2. Put a name the task
1.3 On task size you should probably set 1GB of ram  and 0.5vCPu
1.4 Add a container image, on image field put docker.io/<username>/<docker name>
1.5 Scroll down a little and add the port 8080 to the docker
1.6 Save the docker configuration
1.6 Create the task


2. Create a cluster 
2.1. Networking only
2.2 put it a name 
2.3 create a VPC 
2.4 Create the cluster
2.5 Start praying that everything works!

3. On cluster dashboard, add a new task
* Select the task definition we recently  create


docker.io/jquirozcadavid/pokemon 