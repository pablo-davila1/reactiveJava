package com.programacion.resctiva.part01;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Ejemplo4 {
    public static void main(String[] args) {
        List<String> arr = new ArrayList<>();
        arr.add("juan");
        arr.add("pao");
        arr.add("john");

        Flux<String> flux = Flux.fromIterable(arr);
        AtomicReference<Integer> c = new AtomicReference<>(0);

        flux.doOnNext(
                element -> {
                    c.updateAndGet(value -> value + 1);
                    System.out.println("item "+c+" : "+element);
                }
        ).subscribe();

    }
}
