package com.programacion.resctiva.part02;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class TestUsuarios {

    private static final Logger log = LoggerFactory.getLogger(TestUsuarios.class);

    public static void main(String[] args) {

        User user1 = new User(1,"juan",true);
        User user2 = new User(2,"pao",false);
        User user3 = new User(3,"john",true);
        List<User> users = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user3);

        Flux<User> userFlux = Flux.fromIterable(users);

        userFlux.doOnNext(
                user -> {
                    user.setId( user.getId()+1 );
                    user.setName( user.getName().toUpperCase() );
                })
                .filter(user -> !user.getActive() )
                .doOnNext( user ->
                {
                    if(user.getName().equals("")){
                        throw new RuntimeException("Los nombres no pueden estar vacios");
                    }
                    System.out.println(user.getName().concat(" -> ").concat(user.getActive().toString()));
                })
                .map( user -> {
                    System.out.println(user.toString());
                    return user.toString();
                } )
                .subscribe(System.out::println);

     }

}
