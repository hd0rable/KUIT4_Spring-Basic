package kuit.springbasic.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kuit.springbasic.db.QuestionRepository;
import kuit.springbasic.domain.Question;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    private final QuestionRepository questionRepository;

//   //생성자 하나면 오토와이어드 생략해도 자동주입
//    public HomeController(QuestionRepository questionRepository) {
//        this.questionRepository = questionRepository;
//    }

    /**
     * TODO: showHome
     * showHomeV1 : parameter - HttpServletRequest, HttpServletResponse / return - ModelAndView
     * showHomeV2 : parameter - none / return - ModelAndView
     * showHomeV3 : parameter - Model / return - String
     */

    @RequestMapping("/homeV1")
    public ModelAndView showHomeV1(HttpServletRequest req, HttpServletResponse res) {
        log.info("showHomeV1");
        ModelAndView mav = new ModelAndView("home");

        Collection<Question> questions = questionRepository.findAll();
        mav.addObject("questions",questions);
        return mav;

    }

    @RequestMapping("/homeV2")
    public ModelAndView showHomeV2() {
        log.info("showHomeV2");
        ModelAndView mav = new ModelAndView("home");

        Collection<Question> questions = questionRepository.findAll();
        mav.addObject("questions",questions);
        return mav;

    }

    @RequestMapping("/")
    public String showHomeV3(Model model){
        log.info("showHomeV3");
        Collection<Question> questions = questionRepository.findAll();
        model.addAttribute("questions",questions);
        return "home";
    }


}
