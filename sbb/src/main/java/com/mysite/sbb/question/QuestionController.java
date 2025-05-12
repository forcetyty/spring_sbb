package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import groovyjarjarantlr4.v4.parse.ANTLRParser.finallyClause_return;
import lombok.RequiredArgsConstructor;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	// RequiredArgsConstructor에 의해서 객체가 자동 주입
	// private final QuestionRepository questionRepository;
	
	private final QuestionService questionService;

    @GetMapping("/list")
    //@ResponseBody
    public String list(Model model) {
    	//List<Question> questionList = this.questionRepository.findAll(); //레포지터리에 직접 접근 - 임시
    	List<Question> questionList = this.questionService.getList();
    	model.addAttribute("questionList", questionList);
    	
        return "question_list";	// Templates에서 해당 파일명으로 매
    }
    
    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
    	Question question = this.questionService.getQuestion(id);
    	model.addAttribute("question", question);
    	return "question_detail";
    }

}
