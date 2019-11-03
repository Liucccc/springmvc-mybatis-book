package com.Liucccc.job;

import com.Liucccc.entity.Mood;
import com.Liucccc.entity.UserMoodPraiseRel;
import com.Liucccc.service.MoodService;
import com.Liucccc.service.UserMoodPraiseRelService;
import com.Liucccc.service.UserService;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Set;
import java.util.UUID;

/**
 * com.Liucccc.job
 *
 * @author Liucccc
 * @Date 2019/11/3
 * @Description
 */
@Component
@Configurable
@EnableScheduling
public class PraiseDataSaveDbJob {

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private UserMoodPraiseRelService userMoodPraiseRelService;
    @Resource
    private MoodService moodService;

    private static final String LIUCCC_PRAISE_HASH_KEY = "spring.mybatis.boot.mood.id.list.key";

    //10秒
    @Scheduled(cron = "*/10 * * * * * ")
    public void savePraiseDataToDB2() {
        Set<String> moods = redisTemplate.opsForSet().members(LIUCCC_PRAISE_HASH_KEY);
        if (CollectionUtils.isEmpty(moods)) {
            return;
        }
        for (String moodId : moods) {
            if (redisTemplate.opsForSet().members(LIUCCC_PRAISE_HASH_KEY) == null) {
                continue;
            } else {
                Set<String> userIds = redisTemplate.opsForSet().members(moodId);
                if (CollectionUtils.isEmpty(userIds)) {
                    continue;
                } else {
                    for (String userId : userIds) {
                        UserMoodPraiseRel userMoodPraiseRel = new UserMoodPraiseRel();
                        userMoodPraiseRel.setId(UUID.randomUUID().toString().replaceAll("-", ""));
                        userMoodPraiseRel.setUserId(userId);
                        userMoodPraiseRel.setMoodId(moodId);
                        userMoodPraiseRelService.save(userMoodPraiseRel);
                    }
                    Mood mood = moodService.findById(moodId);
                    mood.setPraiseNum(mood.getPraiseNum() + redisTemplate.opsForSet().size(moodId).intValue());
                    moodService.update(mood);
                    redisTemplate.delete(moodId);
                }
            }
        }
        redisTemplate.delete(LIUCCC_PRAISE_HASH_KEY);
    }
}
