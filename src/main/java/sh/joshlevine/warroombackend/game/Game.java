package sh.joshlevine.warroombackend.game;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class Game {
  @Id
  @SequenceGenerator(name = "game_sequence", sequenceName = "game_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_sequence")
  private Long id;
  private String name;
  private LocalDate date;
  private String scenario;
  @Transient // contries involved will be determined by scenario name
  private ArrayList<String> countriesInvolved;

  // Constructors
  public Game() {
    this.date = LocalDate.now();
  }

  public Game(Long id, String name, String scenario) {
    this.id = id;
    this.name = name;
    this.date = LocalDate.now();
    this.scenario = scenario;
  }

  public Game(String name, String scenario) {
    this.name = name;
    this.date = LocalDate.now();
    this.scenario = scenario;
  }

  // getters and setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getScenario() {
    return scenario;
  }

  public void setScenario(String scenario) {
    this.scenario = scenario;
  }

  public ArrayList<String> getCountriesInvolved() {
    if (scenario.equalsIgnoreCase("global")) {
      return new ArrayList<String>(List.of("China", "USA", "UK", "USSR", "Germany", "Italy", "Japan"));
    } else if (scenario.equalsIgnoreCase("warInEurope")) {
      return new ArrayList<String>(List.of("UK", "USSR", "USA", "Germany", "Italy"));
    } else if (scenario.equalsIgnoreCase("easternFront")) {
      return new ArrayList<String>(List.of("USSR", "Germany"));
    } else if (scenario.equalsIgnoreCase("pacific")) {
      return new ArrayList<String>(List.of("China", "UK", "USA", "Japan"));
    } else if (scenario.equalsIgnoreCase("northAfrica")) {
      return new ArrayList<String>(List.of("UK", "USA", "Germany", "Italy"));
    } else {
      throw new Error("invalid scenario selection");
    }
  }

  public void setCountriesInvolved(ArrayList<String> countriesInvolved) {
    this.countriesInvolved = countriesInvolved;
  }

  @Override
  public String toString() {
    return "Game [id=" + id + ", name=" + name + ", date=" + date + ", scenario=" + scenario + ", countriesInvolved="
        + countriesInvolved + "]";
  }

}
