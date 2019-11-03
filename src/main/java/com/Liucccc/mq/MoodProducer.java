package com.Liucccc.mq;

import com.Liucccc.dto.MoodDTO;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.util.logging.Logger;

/**
 * com.Liucccc.mq
 *
 * @author Liucccc
 * @Date 2019/11/3
 * @Description
 */
@Component
public class MoodProducer {
    @Resource
    private JmsTemplate jmsTemplate;

    private Logger log = Logger.getLogger(String.valueOf(this.getClass()));

    public void sendMessage(Destination destination, final MoodDTO moodDTO) {
        log.info("生产者>>>>>>>>>用户id：" + moodDTO.getUserId() + "给说说id:" + moodDTO.getId() + "点赞");
        jmsTemplate.convertAndSend(destination, moodDTO);
    }
}
