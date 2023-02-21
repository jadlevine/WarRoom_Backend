package sh.joshlevine.warroombackend.game;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/warroom/games")
public class GameController {

  @Autowired
  private GameService gameService;

  @GetMapping
  public List<Game> getGames() {
    return gameService.getGames();
  }

  @GetMapping(path = "/{gameId}")
  public Optional<Game> getGame(@PathVariable("gameId") Long gameId) {
    return gameService.getGame(gameId);
  }

  @PostMapping
  public void addGame(@RequestBody Game game) {
    Game newGame = new Game(game.getName(), game.getScenario());
    gameService.addNewGame(newGame);
  }

  @DeleteMapping(path = "/{gameId}")
  public void deleteGame(@PathVariable("gameId") Long gameId) {
    gameService.deleteGame(gameId);
  }

  // for update/putmapping - we want to be able to update the name or scenario of
  // the game, so, we'll need a path & pathVariable (like delete request) AND a
  // requestBody (like post request)... (or we could have separate routes for
  // updating the name and scenario?)

}
