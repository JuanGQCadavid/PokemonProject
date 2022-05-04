mvn -B -f ./backend/pokemon/pom.xml -DskipTests clean dependency:list install
java -Dserver.port=$PORT $JAVA_OPTS -jar /backend/pokemon/target/pokemon-0.0.1-SNAPSHOT.jar