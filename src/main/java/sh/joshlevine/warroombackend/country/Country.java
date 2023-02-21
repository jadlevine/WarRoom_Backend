package sh.joshlevine.warroombackend.country;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import sh.joshlevine.warroombackend.game.Game;

@Setter
@Getter
@Entity
@Table(name = "countries")
public class Country {
  @Id
  @SequenceGenerator(name = "countries_seq", sequenceName = "countries_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "countries_seq")
  @Column(name = "countryId")
  private Long id;

  private String name;
  private Integer casualtyCount;
  private Integer stressLevel;
  private Integer medalCount;
  private Integer consumerGoodsCount;
  private Integer moralePenalty;
  private Integer moraleTriggerPoint;

  @JsonBackReference // prevents the infinite loop when looking up countries and games (necessary
                     // when you have both manyToOne AND oneToMany)
  @ManyToOne
  // @JoinColumn(name = "game_id", nullable = false)
  private Game game;

  public Country() {
  }

  // does game need to be included in constructor below?

  public Country(String name, Integer moraleTriggerPoint) {
    this.name = name;
    this.casualtyCount = 0;
    this.stressLevel = 0;
    this.medalCount = 0;
    this.consumerGoodsCount = 0;
    this.moralePenalty = 0;
    this.moraleTriggerPoint = moraleTriggerPoint;
    // this.game = game;
  }

  @Override
  public String toString() {
    return "Country [id=" + id + ", name=" + name + ", casualtyCount=" + casualtyCount + ", stressLevel=" + stressLevel
        + ", medalCount=" + medalCount + ", consumerGoodsCount=" + consumerGoodsCount + ", moralePenalty="
        + moralePenalty + ", moraleTriggerPoint=" + moraleTriggerPoint + ", game=" + game + "]";
  }

}
