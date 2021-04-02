package com.graphqljava.little_vote.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Component
public class TicketManager {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    //String类型便于加密存储；
    public static Map<String, String> codeMap = new HashMap<String, String>();
    //假设一张票最多能用10次;
    public static Integer MAX_USE_TIMES=10;
    private Integer id=1;

    @PostConstruct
    public void init() {
        long startTime = System.currentTimeMillis();
        try {
            BufferedReader in = new BufferedReader(new FileReader("remainID.txt"));
            String str=in.readLine();
            String[] strs = str.split(" ");
            id=Integer.parseInt(strs[1]);
            MAX_USE_TIMES=Integer.parseInt(strs[3]);
        } catch (IOException e) {
            System.out.println("读取有效票据和次数失败。");
        }finally {
            Integer ticketId = id++;
            codeMap.put("ticket",ticketId.toString());
//        logger.info("ticket：" + ticketId);
            MAX_USE_TIMES=10;
        }

    }

    @PreDestroy
    public void destroy() {
        //系统运行异常导致结束，保留上次的id值做灾备
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("remainID.txt"));
            out.write("当前id为： "+id.toString()+" ，剩余次数为： "+MAX_USE_TIMES);
//            out.write("当前id为："+id.toString()+"，剩余次数为："+MAX_USE_TIMES);
            out.close();
            System.out.println("id及剩余次数保留成功");
        } catch (IOException e) {
        }
    }

    /**
     * 这里是每5s执行一次，更新ticket缓存
     * 可以根据token有效时长进行更新
     * @return
     */
    @Scheduled(cron = "0/50 * * * * ? ")
    public void start() {
        init();
    }
}
