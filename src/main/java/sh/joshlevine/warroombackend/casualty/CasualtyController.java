package sh.joshlevine.warroombackend.casualty;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/warroom")
public class CasualtyController {
  @Autowired
  private CasualtyService casualtyService;

  @GetMapping(path = "/casualties")
  public List<Casualty> getCasualties() {
    return casualtyService.getCasualties();
  }

  @GetMapping(path = "/casualties/{casualtyId}")
  public Optional<Casualty> getCasualty(@PathVariable("casualtyId") Long casualtyId) {
    return casualtyService.getCasualty(casualtyId);
  }

  @PostMapping(path = "/countries/{countryId}/casualties")
  public void addCasualty(@PathVariable("countryId") Long countryId, @RequestBody Casualty casualtyRequest) {
    Casualty newCasualty = new Casualty(casualtyRequest.getUnitType(), casualtyRequest.getRoundOccurred());
    casualtyService.addCasualty(newCasualty, countryId);
  }

}
