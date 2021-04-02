package com.graphqljava.little_vote.Service;

import com.graphqljava.little_vote.Mapper.VoteMapper;
import com.graphqljava.little_vote.bean.RespBean;
import com.graphqljava.little_vote.bean.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {
    @Autowired
    VoteMapper voteMapper;

    public RespBean vote(List<String> selectPersons) {
        return voteMapper.vote(selectPersons);
    }
}
