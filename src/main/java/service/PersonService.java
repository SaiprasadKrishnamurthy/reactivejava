package service;

import database.PersonDao;
import model.Person;
import rx.Observable;

import java.util.List;

/**
 * Created by sai on 26/07/2015.
 */
public class PersonService {

    private PersonDao personDao = new PersonDao();

    public List<Person> searchPersonByCountry(final int limit, final String... countriesSearchTags) {
        return personDao.personsByCountry(limit, countriesSearchTags);
    }

    public Observable<Person> searchPersonByCountryStreamed(final int limit, final String... countriesSearchTags) {
        return personDao.personsByCountryStreamed(limit, countriesSearchTags);
    }
}
