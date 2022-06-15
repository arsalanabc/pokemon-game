FROM alvistack/openjdk-11
WORKDIR app
COPY /target/pokemon-game-0.0.1-SNAPSHOT.war app.war

CMD "java -jar app.war"

