package org.itstep.webapp.service.impl;

import org.itstep.webapp.entity.Country;
import org.itstep.webapp.repository.CountryRepo;
import org.itstep.webapp.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepo countryRepository;

    @Override
    public Country getCountry(Long id) {
        return countryRepository.getOne(id);
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public void saveCountry(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void deleteCountryByid(Long id) {
        countryRepository.deleteById(id);
    }
}
