compile + run Tennis application
- have java 24 preinstalled 
- run 'mvn clean compile'
- run com.bnp.tennis.application.TennisApplication


There are 2 main endpoints:

--> start a new game with 2 players 

POST http://localhost:8080/api/tennis/newGame
{
  "player1": {
    "name": "player1"
  },
  "player2": {
    "name": "player2"
  }
}

--> one player scores a point

PUT http://localhost:8080/api/tennis/{gameId}/scorePoint/{playerId}
