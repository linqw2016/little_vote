package com.graphqljava.little_vote.GraphQL.Resolver.query;

import com.graphqljava.little_vote.Utils.AesEncryptUtils;
import com.graphqljava.little_vote.bean.RespBean;
import com.graphqljava.little_vote.bean.TicketManager;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Slf4j
@Validated
public class CasQueryResolver implements GraphQLQueryResolver {

    public RespBean getCas() throws Exception {
        String cas= TicketManager.codeMap.get("ticket");
        return new RespBean("查询成功","当前有效票据是"+ AesEncryptUtils.encrypt(cas));
    }

}
