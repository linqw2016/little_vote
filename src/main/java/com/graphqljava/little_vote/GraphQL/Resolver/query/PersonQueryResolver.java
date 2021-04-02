package com.graphqljava.little_vote.GraphQL.Resolver.query;

import com.graphqljava.little_vote.Service.PersonService;
import com.graphqljava.little_vote.bean.Person;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
@Slf4j
@Validated
public class PersonQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private PersonService personService;
        public Person personByUsername(String username) {
//            Person person =personService.getByUsername(username);
        return Optional.ofNullable(personService.getByUsername(username)).orElse(null);
    }

}
