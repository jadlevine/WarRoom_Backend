package sh.joshlevine.warroombackend.game;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/warroom")
public class GameController {
  private final GameService gameService;

  @Autowired
  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @GetMapping
  public List<Game> getGames() {
    return gameService.getGames();
  }

  @PostMapping
  public void addGame(@RequestBody Game game) {
    Game newGame = new Game();
    newGame.setName(game.getName());
    newGame.setScenario(game.getScenario());
    gameService.addNewGame(newGame);
  }

}
