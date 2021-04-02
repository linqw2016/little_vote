package com.graphqljava.little_vote.GraphQL.Resolver.mutation;

import com.graphqljava.little_vote.Service.PersonService;
import com.graphqljava.little_vote.Service.VoteService;
import com.graphqljava.little_vote.bean.RespBean;
import com.graphqljava.little_vote.bean.TicketManager;
import com.graphqljava.little_vote.bean.Vote;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Component
@Validated
public class voteMutationResolver implements GraphQLMutationResolver {
    @Autowired
    VoteService voteService;
    @Autowired
    PersonService personService;

    /*
     * 投票接口
     */
    public RespBean vote(Vote vote) throws Exception {
        List<String> selectedPersons = new ArrayList<>();
        List<String> allSelectedPerson = vote.getSelectedPersons();
        if (!vote.getTicket().isUseful()) {
            return new RespBean("投票失败", "票据不可用!");
        }
        //检查候选人是否合法
        for (int i = 0; i < allSelectedPerson.size(); i++) {
            String username = allSelectedPerson.get(i);
            if(personService.getByUsername(username)==null){
                return new RespBean("投票失败", "找不到候选人");
            }
            selectedPersons.add(username);
        }
        int nums = selectedPersons.size();
        if (nums > TicketManager.MAX_USE_TIMES) {
            return new RespBean("投票失败", "有效次数不足");
        } else {
            TicketManager.MAX_USE_TIMES -= nums;
            System.out.println("剩余次数:" + TicketManager.MAX_USE_TIMES);
        }

        return voteService.vote(selectedPersons);
    }
}
