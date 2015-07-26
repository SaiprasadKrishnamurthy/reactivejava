package database;

import model.Person;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by sai on 26/07/2015.
 */
class PersonDatabase {

    static List<Person> persons;

    static {
        persons = new BufferedReader(new InputStreamReader(PersonDatabase.class.getClassLoader().getResourceAsStream("person_database")))
                .lines()
                .map(line -> {
                    String[] arr = line.split("\\|");
                    return new Person(arr[0].trim(), arr[1].trim(), arr[2].trim());
                })
                .collect(toList());
    }

    static Stream<Person> filter(final Predicate<Person> filterFunction) {
        return persons.stream().filter(p -> {
            delay();
            return filterFunction.test(p);
        });
    }


    // Simulate the latency
    static void delay() {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
