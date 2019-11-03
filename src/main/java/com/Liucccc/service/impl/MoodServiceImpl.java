package com.Liucccc.service.impl;

import com.Liucccc.dao.MoodDao;
import com.Liucccc.dao.UserDao;
import com.Liucccc.dao.UserMoodPraiseRelDao;
import com.Liucccc.dto.MoodDTO;
import com.Liucccc.entity.Mood;
import com.Liucccc.entity.User;
import com.Liucccc.entity.UserMoodPraiseRel;
import com.Liucccc.mq.MoodProducer;
import com.Liucccc.service.MoodService;
import com.Liucccc.service.UserService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static com.Liucccc.consts.CacheConsts.PRAISE_HASH_KEY;

/**
 * com.Liucccc.service.impl
 *
 * @author Liucccc
 * @Date 2019/11/3
 * @Description
 */
@Service
public class MoodServiceImpl implements MoodService {
    @Resource
    private MoodDao moodDao;
    @Resource
    private UserDao userDao;
    @Resource
    private UserMoodPraiseRelDao userMoodPraiseRelDao;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private UserService userService;
    @Resource
    private MoodProducer moodProducer;

    //队列
    private static Destination destination = new ActiveMQQueue("");


    @Override
    public List<MoodDTO> findAll() {
        List<Mood> moodList = moodDao.findAll();
        return converMode2DTO(moodList);
    }

    @Override
    public boolean praiseMood(String userId, String moodId) {
        UserMoodPraiseRel userMoodPraiseRel = new UserMoodPraiseRel();
        userMoodPraiseRel.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        userMoodPraiseRel.setMoodId(moodId);
        userMoodPraiseRel.setUserId(userId);
        userMoodPraiseRelDao.save(userMoodPraiseRel);

        Mood mood = this.findById(moodId);
        mood.setPraiseNum(mood.getPraiseNum() + 1);
        this.update(mood);

        return Boolean.TRUE;
    }

    @Override
    public boolean update(Mood mood) {
        return moodDao.update(mood);
    }

    @Override
    public Mood findById(String id) {
        return moodDao.findById(id);
    }

    @Override
    public List<MoodDTO> findAllForRedis() {
        List<Mood> moodList = moodDao.findAll();
        if (CollectionUtils.isEmpty(moodList)) {
            return Collections.EMPTY_LIST;
        }
        List<MoodDTO> moodDTOList = new ArrayList<MoodDTO>();
        for (Mood mood : moodList) {
            MoodDTO moodDTO = new MoodDTO();
            moodDTO.setId(mood.getId());
            moodDTO.setUserId(mood.getUserId());
            moodDTO.setContent(mood.getContent());
            moodDTO.setPraiseNum(redisTemplate.opsForSet().size(mood.getId()).intValue());
            moodDTO.setPublishTime(mood.getPublishTime());

            User user = userDao.find(mood.getUserId());
            moodDTO.setUserName(user.getName());
            moodDTO.setUserAccount(user.getAccount());
            moodDTOList.add(moodDTO);
        }
        return moodDTOList;
    }

    @Override
    public boolean praiseMoodForRedis(String userId, String moodId) {
//        redisTemplate.opsForSet().add(PRAISE_HASH_KEY, moodId);
//        redisTemplate.opsForSet().add(moodId, userId);
        MoodDTO moodDTO = new MoodDTO();
        moodDTO.setId(moodId);
        moodDTO.setUserId(userId);
        moodProducer.sendMessage(destination, moodDTO);

        return false;
    }

    private List<MoodDTO> converMode2DTO(List<Mood> moodList) {
        if (CollectionUtils.isEmpty(moodList)) {
            return Collections.EMPTY_LIST;
        }
        List<MoodDTO> moodDTOList = new ArrayList<MoodDTO>();
        for (Mood mood : moodList) {
            MoodDTO moodDTO = new MoodDTO();
            moodDTO.setId(mood.getId());
            moodDTO.setContent(mood.getContent());
            moodDTO.setPraiseNum(mood.getPraiseNum());
            moodDTO.setPublishTime(mood.getPublishTime());
            moodDTO.setUserId(mood.getUserId());
            User user = userDao.find(mood.getUserId());
            moodDTO.setUserName(user.getName());
            moodDTO.setUserAccount(user.getAccount());
            moodDTOList.add(moodDTO);
        }
        return moodDTOList;
    }
}
