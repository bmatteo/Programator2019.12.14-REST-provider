package pl.programator.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.programator.model.Country;
import pl.programator.model.Currency;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController {

    static List<Country> countryList = null;

    static {
        Country c1 = new Country();
        c1.setName("Polska");
        c1.setCapital("Warszawa");
        c1.setCurrency(Currency.PLN);
        c1.setPopulation(38000000);

        Country c2 = new Country();
        c2.setName("Spain");
        c2.setCapital("Madrit");
        c2.setCurrency(Currency.EUR);
        c2.setPopulation(70000000);

        Country c3 = new Country();
        c3.setName("Switzerland");
        c3.setCapital("Zurich");
        c3.setCurrency(Currency.CHF);
        c3.setPopulation(8500000);

        CountryController.countryList = new ArrayList<Country>() {{
            add(c1);
            add(c2);
            add(c3);
        }};
    }

    @GetMapping("/getCountryByName/{name}")
    public Country getCountryByName(@PathVariable String name) {
        for (Country country : CountryController.countryList) {
            if(country.getName().equals(name)) {
                return country;
            }
        }

        return new Country();
    }
}
