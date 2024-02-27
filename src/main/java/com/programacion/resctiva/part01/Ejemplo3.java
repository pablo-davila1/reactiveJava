package com.programacion.resctiva.part01;

import reactor.core.publisher.Mono;

public class Ejemplo3 {
    public static void main(String[] args) {
        Mono<String> mono = Mono.fromSupplier(() -> {
            throw  new RuntimeException("Exeption ocurred");
        });

        mono.subscribe();
    }
}
