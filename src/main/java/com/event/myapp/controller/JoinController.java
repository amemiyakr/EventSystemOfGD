package com.event.myapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

	// イベントに参加する
	@RequestMapping(value = "/joinEvent/{id}")
	public String joinEvent(@PathVariable("id") Integer eventId, Model model, HttpSession session) throws Exception {
		// 新しい参加レコードを生成
		Join join = new Join();
		// ログインユーザーをセッションから取得し、参加レコードに設定
		User loginUser = userDao.findById((Integer) session.getAttribute("userId"));
		join.setUser(loginUser);
		// 参加するイベントを取得し、参加レコードに設定
		Event event = eventDao.findById(eventId);
		join.setEvent(event);
		// 参加レコードをイベント参加テーブルに登録
		joinDao.insert(join);
		// イベント詳細ページにリダイレクト
		return "redirect:/detailsEvent/{id}";
	}

	// イベントの参加を取り消す
	@RequestMapping(value = "/cancelEvent/{id}")
	public String cancelEvent(@PathVariable("id") Integer eventId, Model model, HttpSession session) throws Exception {
		// ログインユーザーをセッションから取得
		User loginUser = userDao.findById((Integer) session.getAttribute("userId"));
		// 参加するイベントを取得
		Event event = eventDao.findById(eventId);
		// イベント参加テーブルから参加IDを探し、削除
		joinDao.delete(joinDao.findByUserAndEvent(loginUser, event));
		// イベント詳細ページにリダイレクト
		return "redirect:/detailsEvent/{id}";
	}

}
