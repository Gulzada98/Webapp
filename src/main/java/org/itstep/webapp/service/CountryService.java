package org.itstep.webapp.service;

import org.itstep.webapp.entity.Country;

import java.util.List;

public interface CountryService {

    Country getCountry(Long id);

    List<Country> getAllCountries();

    void saveCountry(Country country);

    void deleteCountryByid(Long id);
}
