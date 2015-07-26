package org.sai.reactivejava.scratchpad;

import rx.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

// Full Blocking. Clients will have to wait.
class DBServer {
    public static List<String> results(final int numberOfResults) throws Exception {
        List<String> results = new ArrayList<>();
        IntStream.range(0, numberOfResults).forEach(n -> {
            results.add(data());
        });
        return results;
    }

    private static String data() {
        delay();
        return UUID.randomUUID().toString();
    }


    public static Observable<String> resultsStreaming(final int numberOfResults) throws Exception {
        return Observable.create(subscriber -> {
            IntStream.range(0, numberOfResults).mapToObj(index -> data()).forEach(subscriber::onNext);
        });
    }


    private static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

/**
 * Created by sai on 26/07/2015.
 */
public class Example1 {

    public static void main(String[] args) throws Exception {
        System.out.println("Query Results (Non Streaming): " + DBServer.results(5));
        System.out.println("Query Results (Streaming): " + DBServer.resultsStreaming(5).subscribe(System.out::println));

    }
}
