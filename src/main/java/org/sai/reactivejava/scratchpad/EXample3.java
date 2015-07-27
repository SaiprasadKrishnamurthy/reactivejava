package org.sai.reactivejava.scratchpad;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by sai on 27/07/2015.
 */
public class Example3 {

    public static void main(String[] args) {
        Observable
                .just("The", "Dave", "Brubeck", "Quartet", "Time", "Out")
                .take(5)
                .doOnNext(value -> {
                    if (value.length() == 4) {
                        throw new RuntimeException("Invalid name");
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("Completed Observable.");
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.err.println("Whoops: " + throwable.getMessage());
                    }

                    @Override
                    public void onNext(String name) {
                        System.out.println("Got: " + name);
                    }
                });
    }
}
