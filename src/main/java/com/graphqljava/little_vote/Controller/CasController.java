package com.graphqljava.little_vote.Controller;

import com.graphqljava.little_vote.bean.RespBean;
import com.graphqljava.little_vote.bean.TicketManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* Description: get current cass number;
 */
@RestController
public class CasController {
    @GetMapping("/getCurrentCas")
    public RespBean getCas(){
        String cas=TicketManager.codeMap.get("ticket");
        return new RespBean("查询成功","当前有效票据是"+cas);
    }
}
