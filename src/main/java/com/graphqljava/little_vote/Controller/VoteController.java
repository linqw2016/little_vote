package com.graphqljava.little_vote.Controller;

import com.graphqljava.little_vote.Service.VoteService;
import com.graphqljava.little_vote.bean.RespBean;
import com.graphqljava.little_vote.bean.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoteController {
    @Autowired
    VoteService voteService;
    /*
    * 投票接口
    */
    @PostMapping("/vote")
    @ResponseBody
    public Object vote(@RequestBody Vote vote) throws Exception {
        if(!vote.getTicket().isUseful()){
            return new RespBean("投票失败","票据已过期!");
        }
        List<String> selectedPersons=vote.getSelectedPersons();
        return voteService.vote(selectedPersons);
    }
}
