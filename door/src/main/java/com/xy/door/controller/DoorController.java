package com.xy.door.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xy.door.bean.ResponseBean;
import com.xy.door.service.PermissionService;
import com.xy.door.vo.PermissionVo;
import com.xy.door.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author xiayun
 * @version V1.0.0
 * @description DoorController
 * @date   2019/12/11 16:37
 */
@Controller
@RequestMapping(value = "/door")
public class DoorController extends BaseController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public ResponseBean login(String loginName, String password, HttpSession session) throws Exception {
        System.out.println(loginName + " " + password);
        if (StringUtils.isEmpty(loginName) || StringUtils.isEmpty(password)) {
            return null;
        }
        try{
            Map<String, Object> map = permissionService.login(loginName, password);
            if (map != null && map.get("id") != null) {
                UserVo vo = objectMapper.readValue(objectMapper.writeValueAsString(map), UserVo.class);
                session.setAttribute("user", vo);
                return ResponseBean.OK(vo);
            } else if (map != null && "500".equals(map.get("code"))) {
                return new ResponseBean("500", "系统故障,请稍后重试！");
            } else {
                return new ResponseBean("300", "用户名密码错误！");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
       return ResponseBean.FAILURE();
    }


    @RequestMapping(value = "/main")
    public String main(ModelMap map, HttpSession session) throws JsonProcessingException {
        UserVo user = (UserVo) session.getAttribute("user");
        if (user == null || user.getId() == null) {
            return "/index";
        }

        List<PermissionVo> list = permissionService.getPermissionsByUserId(user.getId());

        List<PermissionVo> list1 = new ArrayList<>();
        List<PermissionVo> list2 = new ArrayList<>();

        list.forEach(vo -> {
            if (vo.getLevel() == 1) {
                list1.add(vo);
            } else if (vo.getLevel() == 2) {
                list2.add(vo);
            }
        });
        System.out.println(objectMapper.writeValueAsString(list));

        // map.addAttribute("permissions", list);
        map.addAttribute("permissions1", list1);
        map.addAttribute("permissions2", list2);
        map.addAttribute("user", user);
        return "main";
    }

}
