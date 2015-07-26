package client;

import service.PersonService;

import java.util.Scanner;

/**
 * Created by sai on 26/07/2015.
 */
public class Client {

    public static void main(final String[] args) throws Exception {
        PersonService service = new PersonService();
        Scanner scan = new Scanner(System.in);
        System.out.println(" ########################################### Person search (Non Responsive version) #################################################\n\n");
        System.out.print("Enter the country names (part of) separated by commas (For example: ndia, ger, america)\t:\t");
        String searchTerm = scan.next();
        System.out.println();
        System.out.print("Enter how many records you want to retrieve max\t:\t");
        int maxLimit = scan.nextInt();
        System.out.println();
        System.out.print("Do you want the server to stream the results? (Y|N)\t:\t");
        String stream = scan.next();
        System.out.println();

        if (stream.equalsIgnoreCase("n")) {
            // Non responsive.
            service.searchPersonByCountry(maxLimit, searchTerm.split(",")).forEach(System.out::println);
        } else {
            service.searchPersonByCountryStreamed(maxLimit, searchTerm.split(",")).forEach(System.out::println);

        }


    }
}
