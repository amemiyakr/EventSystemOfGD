package com.event.myapp.controller;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.MimeMessageHelper;
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

		event.setSendMail("true"); //change the value of sendMail as "true", means need mail to admin of this event
		eventDao.update(event); //update

		//set AutoTime of sendMail
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 12);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		Date setDate = cal.getTime(); //set datetime as yyyy/mm/dd 12:00:00
		Timer timer = new Timer(false); //new Timer
		Date now = new Date(); //get datetime of now

		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				try {
					List<Event> toMailList = eventDao.findNeedToMail("true");
					for (Event iEvent : toMailList) {
						String toMail = iEvent.getUser().getMail();		//get userMail that need send to
						@SuppressWarnings("resource")
						ApplicationContext ac = new ClassPathXmlApplicationContext("mailHbm/spring-mail.xml",
								"mailHbm/applicationContext.xml");
						BaseDaoOfMailSender sender = (BaseDaoOfMailSender) ac.getBean("BaseDaoOfMailSender"); //get beseDao of MailSender

						MimeMessage mimeMessage = sender.createMimeMessage();
						MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true,
								StandardCharsets.UTF_8.name());
						mimeMessageHelper.setFrom("kkklkj@126.com"); // (4)
						mimeMessageHelper.setTo(toMail); // (5)
						mimeMessageHelper.setSubject("イベント「" + iEvent.getTitle() + "」の変更"); // (6)

						String text = "<html><body bgcolor='#FFFFFF' topmargin='0' bottommargin='0' leftmargin='0' rightmargin='0' link='#F0E0F0'>"
								+ "<div class=\"column\" style=\"text-align: left; color: #8e8e8e; font-size: 16px; line-height: 24px; font-family: PT Sans, Trebuchet MS, sans-serif; max-width: 600px; min-width: 320px; width: 320px; width: calc(28000% - 167400px);\">"
								+ "<div style=\"Margin-left: 20px; Margin-right: 20px; Margin-top: 24px;\"><div style=\"mso-line-height-rule: exactly; line-height: 20px; font-size: 1px;\">&nbsp;</div></div>"
								+ "<h2 style=\"Margin-top: 0; Margin-bottom: 0; font-style: normal; font-weight: normal; color: #F0E0F0; font-size: 22px; line-height: 24px; font-family: PT Serif, Georgia, serif; text-align: center;\">イベント「"
								+ iEvent.getTitle() + "」の変更</h2>"
								+ "<h3 style=\"Margin-top: 20px; Margin-bottom: 12px; font-style: normal; font-weight: normal; color: #929292; font-size: 14px; line-height: 16px; text-align: center;\">「"
								+ iEvent.getTitle() + "」の管理者様へ</h3>"
								+ "<div style=\"Margin-left: 20px; Margin-right: 20px;\"><div style=\"mso-line-height-rule: exactly; line-height: 25px; font-size: 1px;\">&nbsp;</div></div>"
								+ "<div style=\"Margin-left: 20px; Margin-right: 20px;\"><div style=\"mso-line-height-rule: exactly; mso-text-raise: 4px;\">"
								+ "<p class=\"size-16\" style=\"Margin-top: 0; Margin-bottom: 0; font-size: 12px; line-height: 24px;\" lang=\"x-size-16\">先程、このイベントに関する参加人数の変更があります。具体的な内容につきまして、Event Systemを登録してください。</p>"
								+ "<p style=\"font-size: 12px; \">Event Systemを利用して頂いてありがとう御座いました。</p>"
								+ "<div style=\"Margin-left: 20px; Margin-right: 20px; Margin-top: 24px;\"><div style=\"mso-line-height-rule: exactly; line-height: 20px; font-size: 1px;\">&nbsp;</div></div>"
								+ "<div align=\"center\"><img style=\"border: 0; display: block; height: auto; width: 100%; max-width: 174px;\" alt=\"\" width=\"174\" src=\"https://i.ibb.co/9gsscC0/imageedit-16-9841817490.png\">"
								+ "<p style=\"font-size: 12px; \">※本メールはEvent Systemから自動で送付されています。※</p>"
								+ "<p style=\"font-size: 12px; \">The time on the server is ${serverTime}.</p>"
								+ "</div>"
								+ "</div>"
								+ "</div>"
								+ "</div>"
								+ "</body></html>";
						mimeMessageHelper.setText(text, true); // (7)
						sender.send(mimeMessage);

						iEvent.setSendMail("false");
						eventDao.update(iEvent);
					}

				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				timer.cancel();
			}
		};

		if (now.before(setDate)) {		//if now < setDateTime(12:00:00) then...
			cal.set(Calendar.HOUR_OF_DAY, 9);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			timer.schedule(task, cal.getTime());		//set time of send mail at 9:00 o'clock
		} else {
			cal.set(Calendar.HOUR_OF_DAY, 15);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			timer.schedule(task, cal.getTime());		//set time of send mail at 15:00 o'clock
		}

		return "redirect:/detailsEvent/{id}";
	}

	// cancel event
	@RequestMapping(value = "/cancelEvent/{id}")
	public String cancelEvent(@PathVariable("id") Integer eventId, Model model, HttpSession session) throws Exception {
		User loginUser = userDao.findById((Integer) session.getAttribute("userId"));
		Event event = eventDao.findById(eventId);
		joinDao.delete(joinDao.findByUserAndEvent(loginUser, event));

		event.setSendMail("true"); //change the value of sendMail as "true", means need mail to admin of this event
		eventDao.update(event); //update

		//set AutoTime of sendMail
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 12);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		Date setDate = cal.getTime(); //set datetime as yyyy/mm/dd 12:00:00
		Timer timer = new Timer(false); //new Timer
		Date now = new Date(); //get datetime of now

		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				try {
					List<Event> toMailList = eventDao.findNeedToMail("true");
					for (Event iEvent : toMailList) {
						String toMail = iEvent.getUser().getMail();		//get userMail that need send to
						@SuppressWarnings("resource")
						ApplicationContext ac = new ClassPathXmlApplicationContext("mailHbm/spring-mail.xml",
								"mailHbm/applicationContext.xml");
						BaseDaoOfMailSender sender = (BaseDaoOfMailSender) ac.getBean("BaseDaoOfMailSender"); //get beseDao of MailSender

						MimeMessage mimeMessage = sender.createMimeMessage();
						MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true,
								StandardCharsets.UTF_8.name());
						mimeMessageHelper.setFrom("kkklkj@126.com"); // (4)
						mimeMessageHelper.setTo(toMail); // (5)
						mimeMessageHelper.setSubject("イベント「" + iEvent.getTitle() + "」の変更"); // (6)

						String text = "<html><body bgcolor='#FFFFFF' topmargin='0' bottommargin='0' leftmargin='0' rightmargin='0' link='#F0E0F0'>"
								+ "<div class=\"column\" style=\"text-align: left; color: #8e8e8e; font-size: 16px; line-height: 24px; font-family: PT Sans, Trebuchet MS, sans-serif; max-width: 600px; min-width: 320px; width: 320px; width: calc(28000% - 167400px);\">"
								+ "<div style=\"Margin-left: 20px; Margin-right: 20px; Margin-top: 24px;\"><div style=\"mso-line-height-rule: exactly; line-height: 20px; font-size: 1px;\">&nbsp;</div></div>"
								+ "<h2 style=\"Margin-top: 0; Margin-bottom: 0; font-style: normal; font-weight: normal; color: #F0E0F0; font-size: 22px; line-height: 24px; font-family: PT Serif, Georgia, serif; text-align: center;\">イベント「"
								+ iEvent.getTitle() + "」の変更</h2>"
								+ "<h3 style=\"Margin-top: 20px; Margin-bottom: 12px; font-style: normal; font-weight: normal; color: #929292; font-size: 14px; line-height: 16px; text-align: center;\">「"
								+ iEvent.getTitle() + "」の管理者様へ</h3>"
								+ "<div style=\"Margin-left: 20px; Margin-right: 20px;\"><div style=\"mso-line-height-rule: exactly; line-height: 25px; font-size: 1px;\">&nbsp;</div></div>"
								+ "<div style=\"Margin-left: 20px; Margin-right: 20px;\"><div style=\"mso-line-height-rule: exactly; mso-text-raise: 4px;\">"
								+ "<p class=\"size-16\" style=\"Margin-top: 0; Margin-bottom: 0; font-size: 12px; line-height: 24px;\" lang=\"x-size-16\">先程、このイベントに関する参加人数の変更があります。具体的な内容につきまして、Event Systemを登録してください。</p>"
								+ "<p style=\"font-size: 12px; \">Event Systemを利用して頂いてありがとう御座いました。</p>"
								+ "<div style=\"Margin-left: 20px; Margin-right: 20px; Margin-top: 24px;\"><div style=\"mso-line-height-rule: exactly; line-height: 20px; font-size: 1px;\">&nbsp;</div></div>"
								+ "<div align=\"center\"><img style=\"border: 0; display: block; height: auto; width: 100%; max-width: 174px;\" alt=\"\" width=\"174\" src=\"https://i.ibb.co/9gsscC0/imageedit-16-9841817490.png\">"
								+ "<p style=\"font-size: 12px; \">※本メールはEvent Systemから自動で送付されています。※</p>"
								+ "<p style=\"font-size: 12px; \">The time on the server is ${serverTime}.</p>"
								+ "</div>"
								+ "</div>"
								+ "</div>"
								+ "</div>"
								+ "</body></html>";
						mimeMessageHelper.setText(text, true); // (7)
						sender.send(mimeMessage);

						iEvent.setSendMail("false");
						eventDao.update(iEvent);
					}

				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				timer.cancel();
			}
		};

		if (now.before(setDate)) {
			cal.set(Calendar.HOUR_OF_DAY, 9);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			timer.schedule(task, cal.getTime());
		} else {
			cal.set(Calendar.HOUR_OF_DAY, 15);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			timer.schedule(task, cal.getTime());
		}
		return "redirect:/detailsEvent/{id}";
	}

}
