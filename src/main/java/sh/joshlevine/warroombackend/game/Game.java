package sh.joshlevine.warroombackend.game;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import sh.joshlevine.warroombackend.country.Country;
// import sh.joshlevine.warroombackend.country.CountryRepository;

@Setter
@Getter
@Entity
@Table(name = "games")
public class Game {
  @Id
  @SequenceGenerator(name = "games_seq", sequenceName = "games_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "games_seq")
  private Long id;

  private String name;
  private LocalDate date;
  private String scenario;
  // @Transient // contries involved will be determined by scenario name
  // private ArrayList<Country> countriesInvolved;

  @OneToMany(mappedBy = "game")
  private List<Country> countries;

  // @Autowired
  // private CountryRepository countryRepository;

  public Game() {
    // this.date = LocalDate.now();
  }

  public Game(String name, String scenario) {
    this.name = name;
    this.scenario = scenario;
    this.date = LocalDate.now();
    this.countries = buildCountryList();
  }

  // // getters and setters
  // public Long getId() {
  // return id;
  // }

  // public void setId(Long id) {
  // this.id = id;
  // }

  // public String getName() {
  // return name;
  // }

  // public void setName(String name) {
  // this.name = name;
  // }

  // public LocalDate getDate() {
  // return date;
  // }

  // public void setDate(LocalDate date) {
  // this.date = date;
  // }

  // public String getScenario() {
  // return scenario;
  // }

  // public void setScenario(String scenario) {
  // this.scenario = scenario;
  // }

  public ArrayList<Country> buildCountryList() {
    if (scenario.equals("global")) {
      Country china = new Country("China", 4);
      // countryRepository.save(china);
      Country usa = new Country("USA", 5);
      // countryRepository.save(usa);
      Country uk = new Country("UK", 6);
      // countryRepository.save(uk);
      Country ussr = new Country("USSR", 6);
      // countryRepository.save(ussr);
      Country germany = new Country("Germany", 6);
      // countryRepository.save(germany);
      Country italy = new Country("Italy", 4);
      // countryRepository.save(italy);
      Country japan = new Country("Japan", 6);
      // countryRepository.save(japan);
      return new ArrayList<Country>(List.of(china, usa, uk, ussr, germany, italy, japan));
    } else if (scenario.equals("warInEurope")) {
      Country usa = new Country("USA", 4);
      Country uk = new Country("UK", 4);
      Country ussr = new Country("USSR", 5);
      Country germany = new Country("Germany", 6);
      Country italy = new Country("Italy", 4);
      return new ArrayList<Country>(List.of(usa, uk, ussr, germany, italy));
    } else if (scenario.equals("easternFront")) {
      Country ussr = new Country("USSR", 6);
      Country germany = new Country("Germany", 6);
      return new ArrayList<Country>(List.of(ussr, germany));
    } else if (scenario.equals("pacific")) {
      Country china = new Country("China", 4);
      Country usa = new Country("USA", 4);
      Country uk = new Country("UK", 4);
      Country japan = new Country("Japan", 6);
      return new ArrayList<Country>(List.of(china, usa, uk, japan));

    } else if (scenario.equals("northAfrica")) {
      Country usa = new Country("USA", 4);
      Country uk = new Country("UK", 4);
      Country germany = new Country("Germany", 6);
      Country italy = new Country("Italy", 4);
      return new ArrayList<Country>(List.of(usa, uk, germany, italy));
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
