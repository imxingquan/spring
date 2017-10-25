package com.example.demo1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/jdbc")
public class JdbcTestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/{field}",method= RequestMethod.GET)
    public String select(@PathVariable("field") String field,
                               Model model){
        String sql = "select * from t_user";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
        System.out.println(list.toString());
        return "ok";

    }
}
