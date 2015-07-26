package client;

import model.Person;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import service.PersonService;

import java.util.Scanner;

/**
 * Created by sai on 26/07/2015.
 */
public class Client {

    public static void main(final String[] args) throws Exception {
        PersonService service = new PersonService();
        Scanner scan = new Scanner(System.in);
        System.out.println(" ########################################### Person search  #################################################\n\n");
        System.out.print("Enter the country names (part of) separated by commas (For example: ndia, ger, america): ");
        String searchTerm = scan.nextLine();
        System.out.println();
        System.out.print("Enter how many records you want to retrieve max: ");
        int maxLimit = scan.nextInt();
        System.out.println();
        System.out.print("Do you want the server to stream the results? (Y|N): ");
        String stream = scan.next();
        System.out.println();
        if (stream.equalsIgnoreCase("n")) {
            // Non responsive.
            service.searchPersonByCountry(maxLimit, searchTerm.split(",")).forEach(Client::printPersonToConsole);
        } else {
            Observable<Person> persons = service.searchPersonByCountryStreamed(maxLimit, searchTerm.split(","));
            persons.subscribe(Client::printPersonToConsole);
        }
    }

    private static void printPersonToConsole(final Person person) {
        System.out.println(person);
    }
}
