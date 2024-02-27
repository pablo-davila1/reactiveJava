package com.programacion.resctiva.part03.trans.comb;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {

        //FlatMap
        System.out.println("FlatMap use: {");
        Flux.fromArray( new String[]{"Juan","Lore","Pao","John"} )
                .flatMap( main::modificarNombreEnMono )
                .subscribe(System.out::println);
        System.out.println("}");
        System.out.println("--------------------------");

        //Mergue
        System.out.println("Merge use: {");
        Flux<String> names1 = Flux.just("Luna","Max","Jacob","Gato");
        Flux<String> names2 = Flux.just("Lore","Pao","Jonh","Juan");

        Flux<String> fluxMerge = Flux.merge(names1, names2);
        fluxMerge.subscribe(System.out::println);

        System.out.println("}");
        System.out.println("--------------------------");

        //Concat
        System.out.println("concat use: {");
        Flux<String> fluxConcat = Flux.concat(names1,names2);
        fluxConcat.subscribe(System.out::println);

        System.out.println("}");
        System.out.println("--------------------------");

        //Zip
        System.out.println("zip use: {");
        Flux<Integer> nums1 = Flux.just(1,2,3,5);
        Flux<Integer> nums2 = Flux.just(6,7,8,9);

        Flux<Integer> zipFlux = Flux.zip(nums1,nums2, (n1, n2) -> {
            return plusTwoNums(n1,n2);
        });
        zipFlux.subscribe(System.out::println);
        System.out.println("}");

        System.out.println("--------------------------");

        System.out.println("concatWith use: {");
        Mono<Integer> numMono = Mono.just(56);

        Flux<Integer> concatWith = Flux.concat(nums1,nums2).concatWith(numMono);

        Flux<Integer> connt = Flux.concat(concatWith).concatWith( Mono.just(2) );

        concatWith.subscribe(System.out::println);
        System.out.println("zip use: }");



    }

    private static Mono<String> modificarNombreEnMono (String nombre){
        return Mono.just( nombre.concat(" mutante") );
    }

    private static Integer plusTwoNums (Integer num1, Integer num2){
        return (num2+num1);
    }
}
