mvn -B -f ./backend/pokemon/pom.xml -DskipTests clean dependency:list install
java -jar /backend/pokemon/target/pokemon-0.0.1-SNAPSHOT.jar