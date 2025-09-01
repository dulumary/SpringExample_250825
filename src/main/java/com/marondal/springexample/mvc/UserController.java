package com.marondal.springexample.mvc;

import com.marondal.springexample.mvc.domain.User;
import com.marondal.springexample.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/mvc/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
//    @RequestMapping(value="/add", method=RequestMethod.POST)
    @PostMapping("/add")
    public String addUser(
            @RequestParam("name") String name
            , @RequestParam("birthday") String birthday
            , @RequestParam("email") String email
            , @RequestParam(value="introduce", required=false) String introduce) {

        int count = userService.createUser(name, birthday, email, introduce);

        return "실행 결과 : " + count;
    }

    @GetMapping("/form")
    public String userForm() {
        return "mvc/userForm";
    }

    @GetMapping("/info")
    public String userInfo(Model model) {
        // 가장 최근 등록된 사용자 정보
        User user = userService.getLastUser();
        model.addAttribute("title", "가장 최근에 등록된 사용자 정보");
        model.addAttribute("result", user);

        return "mvc/userInfo";
    }

}
