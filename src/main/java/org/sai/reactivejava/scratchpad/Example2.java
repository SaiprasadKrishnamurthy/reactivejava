package org.sai.reactivejava.scratchpad;

import rx.Observable;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by sai on 26/07/2015.
 */
public class Example2 {

    public static void main(String[] args) {
        List<Integer> ints = IntStream.range(0, 100).boxed().collect(toList());

        Observable.from(ints).subscribe((incomingNumber) -> System.out.println("incomingNumber " + incomingNumber),
                (error) -> System.out.println("Something went wrong" + ((Throwable) error).getMessage()),
                () -> System.out.println("This observable is finished"));

        Observable.just("Hello World").map(String::length).subscribe(Example2::onResult);
    }

    private static void onResult(final int value) {
        System.out.println("Length: "+value);
    }
}
