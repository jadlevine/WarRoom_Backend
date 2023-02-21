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

  // NO need for @PostMapping, because the only time we will create a country is
  // when a game is initialized

  // @PutMapping // to update a country

}
