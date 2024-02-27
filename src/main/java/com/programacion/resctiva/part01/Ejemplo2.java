package com.programacion.resctiva.part01;

import reactor.core.publisher.Mono;

public class Ejemplo2 {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("hello world");
        mono.subscribe(
                data -> System.out.println(data), // onNext
                err -> System.out.println(err.getCause()), //onError
                () -> System.out.println("Completado !") //onComplete
        );
    }

}
