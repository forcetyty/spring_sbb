package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class SbbApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;

	@Transactional
	@Test
	void testJpa() {
		// 데이터 저장 
		/*
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);
		
		Question q2 = new Question();
		q2.setSubject("스프링부트 모델 질문입니다.");
		q2.setContent("id는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
		*/
		
		// findAll -  저장된 모든 값 확인 
		/*
		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());
		
		Question q = all.get(0);
		// 테스트 데이터와 실제 값이 일치하는지 확
		assertEquals("sbb가 무엇인가요?", q.getSubject());
		*/
		
		// findById - 기본키를 이용한 데이터 조회
		/*
		Optional<Question> oq = this.questionRepository.findById(1);
		
		if(oq.isPresent()) {
			Question q= oq.get();
			assertEquals("sbb가 무엇인가요?", q.getSubject());
		}
		*/
		
		// findBySubject - subject 값으로 데이터 조회
		/*
		Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
		assertEquals(1, q.getId());
		*/
		
		// findBySubjectAndContent - Where 조건에 And 조건을 추가하여 검색하는 기능 
		/*
		Question q = this.questionRepository.findBySubjectAndContent("sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
		assertEquals(1, q.getId());
		*/
		
		// findBySubjectLike - Like 조건을 이용해서 특정 문자열이 포함되어 있는지 확인하는 쿼리
		/*
		List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
		Question q = qList.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
		*/
		
		// 질문 데이터 수정하기
		/*
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		q.setSubject("수정된 제목");
		this.questionRepository.save(q);
		*/
		
		// 질문 데이터 삭제하기
		/*
		assertEquals(2, this.questionRepository.count());
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		this.questionRepository.delete(q);
		assertEquals(1, this.questionRepository.count());
		*/
		
		// 답변 데이터 저장하기
		/*
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		Answer a = new Answer();
		a.setContent("네 자동으로 생성됩니다.");
		a.setQuestion(q); // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a);
		*/
		
		// 답변 데이터 조회하기
		/*
		Optional<Answer> oa = this.answerRepository.findById(1);
		assertTrue(oa.isPresent());
		Answer a = oa.get();
		assertEquals(2, a.getQuestion());
		*/
		
		// 답변 데이터를 통해 질문 데이터 찾기 vs 질문 데이터를 통해 답변 데이터 찾기
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		List<Answer> answerList = q.getAnswerList();
		// 데이터를 필요한 시점에 가져오는 방식을 지연(Lazy) 방식
		// q 객체를 조회할 때 미리 answer 리스트를 모두 가져오는 방식은 즉시 방
		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
		
	}
	

}
