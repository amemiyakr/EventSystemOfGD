package com.event.myapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.event.myapp.dao.EventDao;
import com.event.myapp.dao.GroupDao;
import com.event.myapp.dao.JoinDao;
import com.event.myapp.dao.UserDao;
import com.event.myapp.domain.Event;
import com.event.myapp.domain.Group;
import com.event.myapp.domain.Join;
import com.event.myapp.domain.Type;
import com.event.myapp.domain.User;

@Controller
public class EventController {

	@Autowired
	private EventDao eventDao;
	@Autowired
	private JoinDao joinDao;
	@Autowired
	private GroupDao groupDao;
	@Autowired
	private UserDao userDao;

	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}

	// all of Event
	@RequestMapping(value = { "/eventList" })
	public String list(Model model, HttpServletRequest request) throws Exception {
		List<Event> eventList = eventDao.findAll();
		model.addAttribute("eventList", eventList);

		List<Join> joinList = joinDao.findAll();
		model.addAttribute("joinList", joinList);

		String action = "eventList";
		model.addAttribute("action", action);

		return "eventList";
	}

	//add Event
	@RequestMapping(value = "/addEvent", method = RequestMethod.GET)
	public String addGet(Model model, HttpSession session) throws Exception {
		Event event = new Event();
		User user = new User();
		user.setUserId((Integer) session.getAttribute("userId"));
		model.addAttribute("event", event);
		event.setUser(user);
		List<Group> group = groupDao.findAll();
		Group g = new Group();
		g.setGroupId(null);
		g.setGroupName("全員");
		group.add(0, g); //対象グループの「全員」選択リスト
		model.addAttribute("group", group);

		String action = "MyCreatedEvent";
		model.addAttribute("action", action);

		return "addEvent";
	}

	@RequestMapping(value = "/addEvent", method = RequestMethod.POST)
	public String addPost(
			@RequestParam("startDate") String startDateOfJSP,
			@RequestParam("endDate") String endDateOfJSP,
			@Valid Event event,
			Errors errors,
			Model model) throws Exception {
		List<Group> group = groupDao.findAll();
		model.addAttribute("group", group);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		if (startDateOfJSP != null && endDateOfJSP != null) {	//if startDate and not null
			Date startdate = sdf.parse((startDateOfJSP).replace("T", " "));//replace 2019-06-06T09:00:00 to 2019-06-06 09:00:00
			event.setStartdate(startdate);
			Date enddate = sdf.parse((endDateOfJSP).replace("T", " "));
			event.setEnddate(enddate);
		} else {
			errors.rejectValue("startdate", "error.startDateNull");
			Group g = new Group();
			g.setGroupId(null);
			g.setGroupName("全員");
			group.add(0, g);
			model.addAttribute("group", group);

			String action = "MyCreatedEvent";
			model.addAttribute("action", action);
			return "editUser";
		}

		Date start = event.getStartdate();
		Date end = event.getEnddate();

		if (start != null && end != null) {
			if (end.before(start)) {
				errors.rejectValue("enddate", "error.enddate.id");
				Group g = new Group();
				g.setGroupId(null);
				g.setGroupName("全員");
				group.add(0, g); //対象グループの「全員」選択リスト
				model.addAttribute("group", group);

				String action = "MyCreatedEvent";
				model.addAttribute("action", action);

				return "addEvent";
			}
		}
		if (!errors.hasErrors()) {
			if (event.getGroup().getGroupId() == null) {
				event.setGroup(null);
			}
			eventDao.insert(event);

			String action = "MyCreatedEvent";
			model.addAttribute("action", action);

			return "addEventDone";
		} else {
			Group g = new Group();
			g.setGroupId(null);
			g.setGroupName("全員");
			group.add(0, g); //対象グループの「全員」選択リスト
			model.addAttribute("group", group);

			String action = "MyCreatedEvent";
			model.addAttribute("action", action);

			return "addEvent";
		}
	}

	//edit event
	@RequestMapping(value = "/editEvent/{id}", method = RequestMethod.GET)
	public String editGet(@PathVariable("id") Integer eventId, Model model, HttpSession session) throws Exception {
		Event event = eventDao.findById(eventId);

		User loginUser = userDao.findById((Integer) session.getAttribute("userId"));

		if (loginUser.getUserId() != event.getUser().getUserId() && loginUser.getType().getTypeId() != Type.ADMIN) {
			return "redirect:/detailsEvent/{id}";
		}

		model.addAttribute("event", event);
		List<Group> group = groupDao.findAll();
		Group g = new Group();
		g.setGroupId(null);
		g.setGroupName("全員");
		group.add(0, g);
		model.addAttribute("group", group);

		String action = "MyCreatedEvent";
		model.addAttribute("action", action);

		return "editEvent";
	}

	@RequestMapping(value = "/editEvent/{eventId}", method = RequestMethod.POST)
	public String editPost(
			@RequestParam("startDate") String startDateOfJSP,
			@RequestParam("endDate") String endDateOfJSP,
			@Valid Event event,
			Errors errors,
			Model model,
			HttpSession session) throws Exception {
		User loginUser = userDao.findById((Integer) session.getAttribute("userId"));

		if (loginUser.getUserId() != event.getUser().getUserId() && loginUser.getType().getTypeId() != Type.ADMIN) {
			return "redirect:/detailsEvent/{id}";
		}

		List<Group> group = groupDao.findAll();
		model.addAttribute("group", group);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		if (startDateOfJSP != null && endDateOfJSP != null) {	//if startDate and not null
			Date startdate = sdf.parse((startDateOfJSP).replace("T", " "));//replace 2019-06-06T09:00:00 to 2019-06-06 09:00:00
			event.setStartdate(startdate);
			Date enddate = sdf.parse((endDateOfJSP).replace("T", " "));
			event.setEnddate(enddate);
		} else {
			errors.rejectValue("startdate", "error.startDateNull");
			Group g = new Group();
			g.setGroupId(null);
			g.setGroupName("全員");
			group.add(0, g);
			model.addAttribute("group", group);

			String action = "MyCreatedEvent";
			model.addAttribute("action", action);
			return "editUser";
		}

		Date start = event.getStartdate();
		Date end = event.getEnddate();

		if (start != null && end != null) {
			if (end.before(start)) {
				errors.rejectValue("enddate", "error.enddate.id");
				Group g = new Group();
				g.setGroupId(null);
				g.setGroupName("全員");
				group.add(0, g);
				model.addAttribute("group", group);

				String action = "MyCreatedEvent";
				model.addAttribute("action", action);

				return "editEvent";
			}
		}
		if (!errors.hasErrors()) {
			if (event.getGroup().getGroupId() == null) {
				event.setGroup(null);
			}
			eventDao.update(event);

			String action = "MyCreatedEvent";
			model.addAttribute("action", action);

			return "editEventDone";
		} else {

			System.out.println(errors);

			Group g = new Group();
			g.setGroupId(null);
			g.setGroupName("全員");
			group.add(0, g); //対象グループの「全員」選択リスト
			model.addAttribute("group", group);

			String action = "MyCreatedEvent";
			model.addAttribute("action", action);

			return "editEvent";
		}
	}

	// Event of Today
	@RequestMapping(value = "/todayEvent")
	public String todaylist(
			@RequestParam(value = "p", defaultValue = "0") String p,
			Model model) throws Exception {
		List<Event> todayEventList = eventDao.findEventOfToday();

		PagedListHolder<Event> pagedListHolder = new PagedListHolder<>(todayEventList);
		pagedListHolder.setSource(todayEventList);
		pagedListHolder.setPageSize(5);
		pagedListHolder.setPage(Integer.parseInt(p));
		model.addAttribute("pagedListHolder", pagedListHolder);

		List<Join> joinList = joinDao.findAll();
		model.addAttribute("joinList", joinList);

		String action = "todayEvent";
		model.addAttribute("action", action);

		return "todayEvent";
	}

	// イベント詳細
	@RequestMapping(value = "/detailsEvent/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Integer eventId, Model model, HttpSession session) throws Exception {
		Event event = eventDao.findById(eventId);
		model.addAttribute("event", event);
		// そのイベントの参加者リストを取得
		List<Join> joinList = joinDao.findByEvent(event);
		model.addAttribute("joinList", joinList);
		// ログインユーザーをセッションから取得
		User loginUser = userDao.findById((Integer) session.getAttribute("userId"));
		model.addAttribute("loginUser", loginUser);
		// イベント参加データを取得（参加していない場合null）
		Join yourJoin = joinDao.findByUserAndEvent(loginUser, event);
		model.addAttribute("yourJoin", yourJoin);
		// 管理ユーザーのタイプIDを取得
		model.addAttribute("adminTypeId", Type.ADMIN);

		String action = "eventList";
		model.addAttribute("action", action);

		return "detailsEvent";
	}

	//イベント詳細削除
	@RequestMapping(value = "/delEvent/{id}")
	public String del(@PathVariable("id") Integer id, Model model, HttpSession session) throws Exception {
		// 削除するイベントを読み込む
		Event event = eventDao.findById(id);
		// ログインユーザーをセッションから取得
		User loginUser = userDao.findById((Integer) session.getAttribute("userId"));
		// イベント登録者でも管理ユーザーでもない場合、イベント詳細ページにリダイレクトする
		if (loginUser.getUserId() != event.getUser().getUserId() && loginUser.getType().getTypeId() != Type.ADMIN) {
			return "redirect:/detailsEvent/{id}";
		}

		// 予め、削除するイベントの参加者情報を全て削除しておく
		List<Join> joinList = joinDao.findByEvent(event);
		for (Join join : joinList) {
			joinDao.delete(join);
		}
		// イベントを削除
		eventDao.delete(event);

		String action = "MyCreatedEvent";
		model.addAttribute("action", action);

		return "delEvent";
	}

	// Event of MyCreated
	@RequestMapping(value = { "/myEventList" })
	public String myCreatedList(@RequestParam(value = "p", defaultValue = "0") String p,
			Model model,
			HttpSession session,
			HttpServletRequest request) throws Exception {
		User userId = userDao.findById((Integer) session.getAttribute("userId")); //get SessionUserID

		List<Event> myCreatedList = eventDao.findMyEvent(userId); //take UserID get "myCreatedList"

		PagedListHolder<Event> pagedListHolder = new PagedListHolder<>(myCreatedList);
		pagedListHolder.setSource(myCreatedList);
		pagedListHolder.setPageSize(5);
		pagedListHolder.setPage(Integer.parseInt(p));
		model.addAttribute("pagedListHolder", pagedListHolder);

		String action = "MyCreatedEvent";
		model.addAttribute("action", action);

		return "myEventList";
	}

	// Event of MyJoin
	@RequestMapping(value = { "/", "/joinEventList" })
	public String myJoinList(
			@RequestParam(value = "p", defaultValue = "0") String p, //set PageValue "p"
			Model model,
			HttpSession session,
			HttpServletRequest request) throws Exception {
		User userId = userDao.findById((Integer) session.getAttribute("userId")); //get SessionUserID

		List<Join> myJoinList = joinDao.findMyEvent(userId); //take UserID get "MyEventList"

		PagedListHolder<Join> pagedListHolder = new PagedListHolder<>(myJoinList); //set Pagination
		pagedListHolder.setSource(myJoinList); //set PageData of list
		pagedListHolder.setPageSize(5); //set PageNumber of 5
		pagedListHolder.setPage(Integer.parseInt(p)); //get PageValue "p" of "1.2.3..."
		model.addAttribute("pagedListHolder", pagedListHolder);

		String action = "eventList"; //set manu value of action
		model.addAttribute("action", action);

		return "joinEventList";
	}

}