package sh.joshlevine.warroombackend.game;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// annotation below is b/c this is for data access layer
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

  // SQL --> SELECT * FROM student WHERE email = ?
  // two ways to do it (should one of the two lines below be commented out?)
  @Query("SELECT g FROM Game g Where g.id = ?1")
  Optional<Game> findGameById(Long id);
}
