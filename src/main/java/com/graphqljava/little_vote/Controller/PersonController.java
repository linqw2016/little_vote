package com.graphqljava.little_vote.Controller;

import com.graphqljava.little_vote.Service.PersonService;
import com.graphqljava.little_vote.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;
    /*
    * 查询接口
    * Description:get the votesNum of the person whose ID={id}
    */
    @GetMapping("/getCurrentTicket/{id}")
    @ResponseBody
    public Person getCurrentTicket(@PathVariable int id){
        System.out.println("select person's ID:"+id);
        return personService.getById(id);
    }
}
