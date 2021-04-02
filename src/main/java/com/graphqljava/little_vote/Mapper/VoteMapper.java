package com.graphqljava.little_vote.Mapper;

import com.graphqljava.little_vote.Service.PersonService;
import com.graphqljava.little_vote.bean.Person;
import com.graphqljava.little_vote.bean.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Mapper
@Component
public class VoteMapper{
    @Autowired
    PersonService personService;
    public RespBean vote(List<String> selectedPersons) {
        Queue<String> dealSelected=new LinkedList<String>(selectedPersons);
        while (!dealSelected.isEmpty()){
            String selectedName=dealSelected.poll();
            //某一person阻塞时先去投其他person；
            if (!addVoteNum(selectedName)){
                dealSelected.offer(selectedName);
            }
        }
        return new RespBean("投票成功！", "谢谢支持！");
    }
    private boolean addVoteNum(String selectedName) {
//        int personId=Integer.parseInt(personID);
        Person person=personService.getByUsername(selectedName);
        personService.updatePerson(person);
        return true;
    }
}
