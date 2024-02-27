package com.programacion.resctiva.part01;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Ejemlo1 {
    public static void main(String[] args) {
        List<Integer> elementosFromMono = new ArrayList<>();
        List<Integer> elementosFromDFlux = new ArrayList<>();

        //Mono y Flux
        Mono<Integer> mono = Mono.just(123);
        Flux<Integer> flux = Flux.just(12,24,775,44);

        //Nos suscribimos al mono y flux
        mono.subscribe(elementosFromMono::add);
        flux.subscribe(elementosFromDFlux::add);

        System.out.println(elementosFromMono);
        System.out.println(elementosFromDFlux);

    }
}
