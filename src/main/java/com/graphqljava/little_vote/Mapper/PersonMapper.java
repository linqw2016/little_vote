package com.graphqljava.little_vote.Mapper;

import com.graphqljava.little_vote.bean.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PersonMapper {
    boolean updatePerson(Person person);
    Person getPersonById(Integer id);

    Person getPersonByUsername(String username);
}
