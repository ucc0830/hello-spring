package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    //정적 컨텐츠
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    //MVC & template engine
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "name",required = false) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    //문자열 그대로 반환
    @GetMapping("hello-spring")
    @ResponseBody
    public String helloSring(@RequestParam("name") String name){
        return "heelo " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;
        //java bean standard
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
