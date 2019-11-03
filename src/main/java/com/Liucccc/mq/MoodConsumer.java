package com.Liucccc.mq;

import com.Liucccc.dto.MoodDTO;
import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.logging.Logger;

import static com.Liucccc.consts.CacheConsts.PRAISE_HASH_KEY;

/**
 * com.Liucccc.mq
 *
 * @author Liucccc
 * @Date 2019/11/3
 * @Description
 */
@Component
public class MoodConsumer implements MessageListener {

    private Logger log = Logger.getLogger(String.valueOf(this.getClass()));

    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public void onMessage(Message message) {
        try {
            MoodDTO moodDTO = (MoodDTO) ((ActiveMQObjectMessage) message).getObject();
            redisTemplate.opsForSet().add(PRAISE_HASH_KEY, moodDTO.getId());
            redisTemplate.opsForSet().add(moodDTO.getId(), moodDTO.getUserId());
            log.info("消费者>>>>>>>>用户id：" + moodDTO.getUserId() + " 给说说id:" + moodDTO.getId() + " 点赞");
        } catch (JMSException e) {
            System.out.println(e);
        }
    }
}
