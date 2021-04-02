package com.graphqljava.little_vote.GraphQL.Resolver.mutation;

import com.graphqljava.little_vote.Service.PersonService;
import com.graphqljava.little_vote.bean.Person;
import com.graphqljava.little_vote.bean.RespBean;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class personMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private PersonService personService;

    public RespBean updatePerson(int id, int voteNums) throws NotFoundException {
        Optional<Person> optPerson = Optional.ofNullable(personService.getById(id));
        if (optPerson.isPresent()) {
            Person person=personService.getById(id);
            if(personService.updatePerson(person)){
                return new RespBean("投票成功！","用户"+id+"当前票数为:"+voteNums);
            };
            return new RespBean("投票失败！","updatePerson错误");
        }
        throw new NotFoundException("Not found Person to update!");
    }
}
