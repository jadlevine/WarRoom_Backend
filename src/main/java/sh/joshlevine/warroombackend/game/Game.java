package sh.joshlevine.warroombackend.game;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import sh.joshlevine.warroombackend.country.Country;

@Setter
@Getter
@Entity
@Table(name = "game")
public class Game {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // just let database come up with unique id using its own method
  private Long id;

  private String name;
  private LocalDate date;
  private String scenario;

  @OneToMany(mappedBy = "game", cascade = CascadeType.PERSIST) // so when a game is saved, both the game and all country
                                                               // entities will be persisted to the database
  // @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
  // @OneToMany(mappedBy = "game", cascade = { CascadeType.PERSIST,
  // CascadeType.MERGE, CascadeType.DETACH,
  // CascadeType.REFRESH })
  // @OneToMany
  // @JoinColumn(name = "game_id")
  private List<Country> countries = new ArrayList<>();

  public void addCountryToGame(Country country) {
    country.setGame(this);
    countries.add(country);
  }

  public Game() {
  }

  public Game(String name, String scenario) {
    this.name = name;
    this.scenario = scenario;
    this.date = LocalDate.now();
    // this.countries = buildCountryList();
    buildCountryList();
  }

  // private List<Country> buildCountryList() {
  private void buildCountryList() {
    if (scenario.equals("global")) {
      Country china = new Country("China", 4);
      this.addCountryToGame(china);
      Country usa = new Country("USA", 5);
      this.addCountryToGame(usa);
      Country uk = new Country("UK", 6);
      this.addCountryToGame(uk);
      Country ussr = new Country("USSR", 6);
      this.addCountryToGame(ussr);
      Country germany = new Country("Germany", 6);
      this.addCountryToGame(germany);
      Country italy = new Country("Italy", 4);
      this.addCountryToGame(italy);
      Country japan = new Country("Japan", 6);
      this.addCountryToGame(japan);
      // return new ArrayList<Country>(List.of(china, usa, uk, ussr, germany, italy,
      // japan));
    } else if (scenario.equals("warInEurope")) {
      Country usa = new Country("USA", 4);
      this.addCountryToGame(usa);
      Country uk = new Country("UK", 4);
      this.addCountryToGame(uk);
      Country ussr = new Country("USSR", 5);
      this.addCountryToGame(ussr);
      Country germany = new Country("Germany", 6);
      this.addCountryToGame(germany);
      Country italy = new Country("Italy", 4);
      this.addCountryToGame(italy);
      // return new ArrayList<Country>(List.of(usa, uk, ussr, germany, italy));
    } else if (scenario.equals("easternFront")) {
      Country ussr = new Country("USSR", 6);
      this.addCountryToGame(ussr);
      Country germany = new Country("Germany", 6);
      this.addCountryToGame(germany);
      // return new ArrayList<Country>(List.of(ussr, germany));
    } else if (scenario.equals("pacific")) {
      Country china = new Country("China", 4);
      this.addCountryToGame(china);
      Country usa = new Country("USA", 4);
      this.addCountryToGame(usa);
      Country uk = new Country("UK", 4);
      this.addCountryToGame(uk);
      Country japan = new Country("Japan", 6);
      this.addCountryToGame(japan);
      // return new ArrayList<Country>(List.of(china, usa, uk, japan));
    } else if (scenario.equals("northAfrica")) {
      Country usa = new Country("USA", 4);
      this.addCountryToGame(usa);
      Country uk = new Country("UK", 4);
      this.addCountryToGame(uk);
      Country germany = new Country("Germany", 6);
      this.addCountryToGame(germany);
      Country italy = new Country("Italy", 4);
      this.addCountryToGame(italy);
      // return new ArrayList<Country>(List.of(usa, uk, germany, italy));
    } else {
      throw new Error("invalid scenario selection");
    }
  }

  @Override
  public String toString() {
    return "Game [id=" + id + ", name=" + name + ", date=" + date + ", scenario=" + scenario + ", countries="
        + countries + "]";
  }

}
