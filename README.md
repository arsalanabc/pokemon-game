### POKEMON SERVER

A simple spring boot app

#### Setup
    - java version 11
    - mvm installed
    - IDE Intellij


#### Running locally
To test:

    mvn test
To run with mvn:

    mvn spring-boot:run

To run with java:

    mvn clean package
    java -jar .\target\pokemon-game.war

### Game Menu
#### Option 1
- Shows the list of all the Pokemons players can choose

#### Option 2
- Allows Player 1 to pick a pokemon

#### Option 3
- Allows Player 2 to pick a pokemon

#### Option 4
- Starts a battle once both players have picked the pokemons. Players can retry battles many times.

#### Option 5
- Shows the winner of the last battle

#### Option 6
- Reset a game   

#### Option 7
- Show the game menu to the players

#### Option 0
- End the game and exit the application