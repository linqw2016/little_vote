package com.graphqljava.little_vote.Service;

import com.graphqljava.little_vote.Mapper.PersonMapper;
import com.graphqljava.little_vote.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonMapper personMapper;

    // 查询加入缓存
    @Cacheable(value = "person1", key = "#root.targetClass + T(String).valueOf(#personId)", unless = "#result eq null")
    public Person getById(int personId) {
        System.out.println("=====================缓存中查找失败，从数据库中获取，personID="+personId);
        Person person =personMapper.getPersonById(personId);
        return person;
    }

    //投票操作调用
    //更新则删除缓存中的内容
    @CacheEvict(value="person",key = "#root.targetClass + #person.username")
    public boolean updatePerson(Person person) {
        System.out.println("===================从数据库中更新，从缓存中删除,id="+person.getId());
//        Person personSelected=new Person(id,voteNums);
        return personMapper.updatePerson(person);
    }

    //投票操作调用
    @Cacheable(value = "person", key = "#root.targetClass + #username", unless = "#result eq null")
    public Person getByUsername(String username) {
        System.out.println("=====================缓存中查找失败，从数据库中获取，username="+username);
        return personMapper.getPersonByUsername(username);
    }
}
