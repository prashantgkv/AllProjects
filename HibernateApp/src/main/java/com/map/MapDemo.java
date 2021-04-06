package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
  public static void main(String[] args) {
      Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		//creating question
		Question q1=new Question();
	     q1.setQuestionId(1212);
	     q1.setQuestion("what is java?");
	     
	     //creating answer
	     Answer answer=new Answer();
	     answer.setAnswerId(343);
	     answer.setAnswer("Java is a programming language.");
	     answer.setQ(q1);
	     
	     //creating answer
	     Answer answer1=new Answer();
	     answer1.setAnswerId(343);
	     answer1.setAnswer("With the help of java we can create softwares.");
	     answer1.setQ(q1);
	     
	     //creating answer
	     Answer answer2=new Answer();
	     answer2.setAnswerId(343);
	     answer2.setAnswer("Java has different type of framework.");
	     answer2.setQ(q1);
	     
	     List<Answer> list =new ArrayList<Answer>();
	     list.add(answer);
	     list.add(answer1);
	     list.add(answer2);
	     q1.setAnswers(list);
	   //creating question
//			Question q2=new Question();
//		     q2.setQuestionId(242);
//		     q2.setQuestion("what is collection framework?");
//		     
//		     //creating answer
//		     Answer answer1=new Answer();
//		     answer1.setAnswerId(344);
//		     answer1.setAnswer("API to work with objects in java.");
//		    answer1.setQ(q2);
//		     q2.setAnswer(answer1);
	     //session
	     
	     Session s=factory.openSession();
	     Transaction tx=s.beginTransaction();
	     
	     //save
	     
	     s.save(q1);
//	     s.save(q2);
	     s.save(answer);
	     s.save(answer1);
	     s.save(answer2);
	     tx.commit();
	     
	     s.close();
		
	factory.close();
}
}
