package com.event.myapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.event.myapp.dao.BaseDaoOfMailSender;
import com.event.myapp.dao.EventDao;
import com.event.myapp.dao.JoinDao;
import com.event.myapp.dao.UserDao;
import com.event.myapp.domain.Event;
import com.event.myapp.domain.Join;
import com.event.myapp.domain.User;

@Controller
public class JoinController {

	@Autowired
	private JoinDao joinDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private EventDao eventDao;

	// Join event
	@RequestMapping(value = "/joinEvent/{id}")
	public String joinEvent(@PathVariable("id") Integer eventId, Model model, HttpSession session) throws Exception {
		Join join = new Join();
		User loginUser = userDao.findById((Integer) session.getAttribute("userId"));
		join.setUser(loginUser);
		Event event = eventDao.findById(eventId);
		join.setEvent(event);
		joinDao.insert(join);

		//set mailSender
		String toMail = event.getUser().getMail();

		ApplicationContext ac = new ClassPathXmlApplicationContext("mailHbm/spring-mail.xml",
				"mailHbm/applicationContext.xml");

		BaseDaoOfMailSender sender = (BaseDaoOfMailSender) ac.getBean("BaseDaoOfMailSender");	//get beseDao of MailSender

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(toMail);//to somebody
		mail.setFrom("kkklkj@126.com");//from myE-mail
		mail.setSubject("Event System自動配信：イベント「"+ event.getTitle() +"」の参加人数の変更");//titles
		mail.setText("イベント「"+ event.getTitle() +"」の管理者様\n\n先程、"+ session.getAttribute("userName") +"様がこのイベントを参加になりました。\n具体的な内容はイベントシステムを登録してください。\n\nEvent System を利用頂いてありがとう御座いました。");//text
		sender.send(mail);

		return "redirect:/detailsEvent/{id}";
	}

	// cancel event
	@RequestMapping(value = "/cancelEvent/{id}")
	public String cancelEvent(@PathVariable("id") Integer eventId, Model model, HttpSession session) throws Exception {
		// ログインユーザーをセッションから取得
		User loginUser = userDao.findById((Integer) session.getAttribute("userId"));
		// 参加するイベントを取得
		Event event = eventDao.findById(eventId);
		// イベント参加テーブルから参加IDを探し、削除
		joinDao.delete(joinDao.findByUserAndEvent(loginUser, event));
		// イベント詳細ページにリダイレクト

		//set mailSender
		String toMail = event.getUser().getMail();

		ApplicationContext ac = new ClassPathXmlApplicationContext("mailHbm/spring-mail.xml",
				"mailHbm/applicationContext.xml");

		BaseDaoOfMailSender sender = (BaseDaoOfMailSender) ac.getBean("BaseDaoOfMailSender");	//get beseDao of MailSender

		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(toMail);//to somebody
		mail.setFrom("kkklkj@126.com");//from myE-mail
		mail.setSubject("Event System自動配信：イベント「"+ event.getTitle() +"」の参加人数の変更");//titles
		mail.setText("イベント「"+ event.getTitle() +"」の管理者様\n\n先程、"+ session.getAttribute("userName") +"様がこのイベントを取り消すになりました。\n具体的な内容はイベントシステムを登録してください。\n\nEvent System を利用頂いてありがとう御座いました。");//text
		sender.send(mail);

		return "redirect:/detailsEvent/{id}";
	}

}
