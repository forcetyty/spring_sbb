package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysite.sbb.answer.AnswerForm;

import groovyjarjarantlr4.v4.parse.ANTLRParser.finallyClause_return;
import jakarta.validation.Valid;
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
    public String detail(Model model, @PathVariable("id") Integer id
    		, AnswerForm answerForm) {
    	Question question = this.questionService.getQuestion(id);
    	model.addAttribute("question", question);
    	return "question_detail";
    }
    
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
    	return "question_form";
    }
    
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
    	
    	if(bindingResult.hasErrors()) {
    		return "question_form";
    	}
    	
    	this.questionService.create(questionForm.getSubject(), questionForm.getContent());
    	return "redirect:/question/list";	// 질문 저장 후 질문 목록으로 이동 
    }
    
    /*
    @PostMapping("/create")
    public String questionCreate(@RequestParam(value="subject") String subject
    		, @RequestParam(value="content") String content) {
    	this.questionService.create(subject, content);
    	return "redirect:/question/list";	// 질문 저장 후 질문 목록으로 이동 
    }
    */

}
