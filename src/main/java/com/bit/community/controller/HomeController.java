package com.bit.community.controller;

import com.bit.community.entity.DiscussPost;
import com.bit.community.entity.Page;
import com.bit.community.entity.User;
import com.bit.community.service.DiscussPostService;
import com.bit.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    DiscussPostService discussPostService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        page.setRows(discussPostService.selectDiscussPostRows(0));
        page.setPath("/index");
        List<DiscussPost> discussPosts = discussPostService.selectDiscussPosts(0, 0, 10);
        List<Map<String, Object>> discussPost = new ArrayList<>();
        for (DiscussPost post : discussPosts) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("post", post);
            User user = userService.findUserById(post.getUserId());
            map.put("user", user);
            discussPost.add(map);
        }
        model.addAttribute("discussPosts", discussPost);
        return "/index";
    }
}
