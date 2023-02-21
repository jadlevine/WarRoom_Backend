package sh.joshlevine.warroombackend.country;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/vi/warroom/countries")
public class CountryController {
  @Autowired
  private CountryService countryService;

  @GetMapping
  public List<Country> getCountries() {
    return countryService.getCountries();
  }

  @GetMapping(path = "/{countryId}")
  public Optional<Country> getCountry(@PathVariable("countryId") Long countryId) {
    return countryService.getCountry(countryId);
  }

  // will eventually need @PutMapping to update a country...

  // maybe this is NOT necessary? only time we are adding new countries (for now)
  // is when we initialize a game.

  // @PostMapping
  // public void addNewCountry(@RequestBody Country country) {
  // countryService.addCountry(country);
  // }

}
