package com.Liucccc.controller;

import com.Liucccc.dto.MoodDTO;
import com.Liucccc.service.MoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * com.Liucccc.controller
 *
 * @author Liucccc
 * @Date 2019/11/3
 * @Description
 */
@Controller
@RequestMapping("/mood")
public class MoodController {
    @Resource
    MoodService moodService;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<MoodDTO> moodList = moodService.findAll();
        model.addAttribute("moods", moodList);
        return "mood";
    }

    @GetMapping(value = "/{moodId}/praise")
    public String praise(Model model, @PathVariable(value = "moodId") String moodId, @RequestParam(value = "userId") String userId) {
        boolean result = moodService.praiseMood(userId, moodId);

        List<MoodDTO> moodList = moodService.findAll();
        model.addAttribute("moods", moodList);
        return "mood";
    }

    @GetMapping(value = "/{moodId}/praiseForRedis")
    public String praiseForRedis(Model model, @PathVariable(value = "moodId") String moodId, @RequestParam(value = "userId") String userId) {
        Random random = new Random();
        userId = random.nextInt(100) + "";
        boolean result = moodService.praiseMoodForRedis(userId, moodId);

        List<MoodDTO> moodList = moodService.findAllForRedis();
        model.addAttribute("moods", moodList);
        return "mood";
    }
}
