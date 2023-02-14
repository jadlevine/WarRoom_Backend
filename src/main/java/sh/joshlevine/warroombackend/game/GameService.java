package sh.joshlevine.warroombackend.game;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
  private final GameRepository gameRepository;

  @Autowired
  public GameService(GameRepository gameRepository) {
    this.gameRepository = gameRepository;
  }

  // get all games
  public List<Game> getGames() {
    return gameRepository.findAll();
  }

  // add a new game
  public void addNewGame(Game game) {
    Optional<Game> gameOptional = gameRepository.findGameById(game.getId());
    if (gameOptional.isPresent()) {
      throw new IllegalStateException("game id taken");
    }
    gameRepository.save(game);
  }

  // delete a game
  public void deleteGame(Long gameId) {
    boolean exists = gameRepository.existsById(gameId);
    if (!exists) {
      throw new IllegalStateException("game with id " + gameId + " does not exist");
    }
    gameRepository.deleteById(gameId);
  }

  // update a game
  // @Transactional

}
