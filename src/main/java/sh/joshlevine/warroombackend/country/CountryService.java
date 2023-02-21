package sh.joshlevine.warroombackend.country;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

  @Autowired
  private CountryRepository countryRepository;

  public List<Country> getCountries() {
    return countryRepository.findAll();
  }

  public Optional<Country> getCountry(Long countryId) {
    return countryRepository.findById(countryId);
  }

  public void addCountry(Country country) {
    countryRepository.save(country);
  }
}
