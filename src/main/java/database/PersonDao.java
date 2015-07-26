package database;

import model.Person;
import rx.Observable;

import java.util.Arrays;
import java.util.List;

import static database.PersonDatabase.*;
import static java.util.stream.Collectors.toList;

/**
 * Created by sai on 26/07/2015.
 */
public class PersonDao {

    public List<Person> personsByCountry(final int maxLimit, final String... countryNames) {
        List<String> personCountryNames = Arrays.asList(countryNames);
        return filter(person ->
                personCountryNames.stream()
                        .filter(countryName -> person.getCountry().trim().toLowerCase().contains(countryName.toLowerCase().trim())).count() > 0)
                .limit(maxLimit).collect(toList());
    }

    public Observable<Person> personsByCountryStreamed(final int maxLimit, final String... countryNames) {
        List<String> personCountryNames = Arrays.asList(countryNames);

        return Observable.create(subscriber -> {
            filter(person -> personCountryNames.stream()
                    .filter(countryName -> person.getCountry().trim().toLowerCase().contains(countryName.toLowerCase().trim())).count() > 0)
                    .limit(maxLimit).forEach(subscriber::onNext);
        });
    }
}
