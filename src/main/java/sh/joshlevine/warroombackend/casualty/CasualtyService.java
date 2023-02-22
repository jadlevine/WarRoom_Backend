package sh.joshlevine.warroombackend.casualty;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sh.joshlevine.warroombackend.country.Country;
import sh.joshlevine.warroombackend.country.CountryRepository;

@Service
public class CasualtyService {

  @Autowired
  private CasualtyRepository casualtyRepository;

  @Autowired
  private CountryRepository countryRepository;

  public List<Casualty> getCasualties() {
    return casualtyRepository.findAll();
  }

  public Optional<Casualty> getCasualty(Long casualtyId) {
    return casualtyRepository.findById(casualtyId);
  }

  // public List<Casualty> getCasualtiesByCountry() {}
  // public List<Casualty> getCasualtiesByCountryAndRound() {}

  // @Transactional
  public void addCasualty(Casualty casualtyRequest, Long countryId) {
    // find country
    Country country = countryRepository.findById(countryId)
        .orElseThrow(() -> new IllegalStateException("country with id: " + countryId + ", not found"));

    country.addCasualtyToCountry(casualtyRequest);

    casualtyRepository.save(casualtyRequest);
  }

  // public void deleteCasualtyById() {}

}
