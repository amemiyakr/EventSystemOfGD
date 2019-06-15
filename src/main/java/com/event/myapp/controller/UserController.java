package com.event.myapp.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.event.myapp.dao.GroupDao;
import com.event.myapp.dao.TypeDao;
import com.event.myapp.dao.UserDao;
import com.event.myapp.domain.Group;
import com.event.myapp.domain.Type;
import com.event.myapp.domain.User;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private GroupDao groupDao;

	@Autowired
	private TypeDao typeDao;

	//find all of users
	@RequestMapping(value = { "/userList" })
	public String userlist(
			Model model) throws Exception {
		List<User> userList = userDao.findAll();
		model.addAttribute("userList", userList);

		String action="userList";
		model.addAttribute("action", action);

		return "userList"; //userListにmodelに返す

	}

	// ユーザー登録GET
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addGet(Model model, HttpSession session) throws Exception {
		User user = new User();
		model.addAttribute("user", user);
		List<Group> group = groupDao.findAll();
		model.addAttribute("group", group);
		List<Type> type = typeDao.findAll();
		model.addAttribute("type", type);

		String action="userList";
		model.addAttribute("action", action);

		return "addUser";
	}

	// ユーザー登録POST
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addPost(
			@Valid User user,
			@RequestParam("file") MultipartFile multipartfile,
			Errors errors,
			Model model) throws Exception {
		List<Group> group = groupDao.findAll();
		model.addAttribute("group", group);
		List<Type> type = typeDao.findAll();
		model.addAttribute("type", type);
		String has = BCrypt.hashpw(user.getPass(), BCrypt.gensalt());
		user.setPass(has);

		if (!errors.hasErrors()) {
			//File upload
			if (!multipartfile.isEmpty()) {
				SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
				String[] originalName = multipartfile.getOriginalFilename().split("\\."); //split the OriginalFilename of file
				String extensions = originalName[1]; //get the extensions as "jpg,png,gif"
				String saveName = "img" + fmt.format(new Date()) + "." + extensions; //set SaveName like "img20190611124900.png"
				File transferSaveFile = new File(
						"C:\\Users\\User\\Desktop\\k_cyu\\pleiades\\pleiades\\workspace\\EventSystem\\src\\main\\webapp\\uploads\\",
						saveName); //the really savePath
				user.setImg(saveName); //set SaveName into "saveName" of "UserTable"
				multipartfile.transferTo(transferSaveFile); //upload file transfer into a new savePath

			} else {

				user.setImg("imgDefault.jpg"); //set default into "saveName" of "UserTable"
			}

			userDao.insert(user);

			String action="userList";
			model.addAttribute("action", action);

			return "addUserDone";
		} else {
			model.addAttribute("user", user);

			String action="userList";
			model.addAttribute("action", action);

			return "addUser";
		}
	}

	// ユーザー詳細
	@RequestMapping(value = "/detailsUser/{id}", method = RequestMethod.GET)
	public String detail(@PathVariable("id") Integer userId, Model model) throws Exception {
		User user = userDao.findById(userId);
		model.addAttribute("user", user);

		String action="userList";
		model.addAttribute("action", action);

		return "detailsUser";
	}

	//ユーザー削除
	@RequestMapping(value = "/delUser/{id}")
	public String del(@PathVariable("id") Integer id, Model model, HttpSession session) throws Exception {
		// 削除するユーザーを読み込む
		User user = userDao.findById(id);
		// ユーザーを削除
		userDao.delete(user);

		String action="userList";
		model.addAttribute("action", action);

		return "delUser";
	}

	// ユーザー編集GET
	@RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
	public String editGet(@PathVariable("id") Integer userId, Model model, HttpSession session) throws Exception {
		User user = userDao.findById(userId);
		User loginUser = userDao.findById((Integer) session.getAttribute("userId"));
		if (loginUser.getType().getTypeId() != Type.ADMIN) {
			return "redirect:/eventList";
		}
		model.addAttribute("user", user);
		List<Group> group = groupDao.findAll();
		model.addAttribute("group", group);
		List<Type> type = typeDao.findAll();
		model.addAttribute("type", type);

		String action="userList";
		model.addAttribute("action", action);

		return "editUser";
	}

	// ユーザー編集POST
	@RequestMapping(value = "/editUser/{userId}", method = RequestMethod.POST)
	public String editPost(
			@RequestParam("passNew") String passNew,
			@Valid User user,
			@RequestParam("file") MultipartFile multipartfile,
			Errors errors,
			HttpSession session,
			Model model) throws Exception {
		User loginUser = userDao.findById((Integer) session.getAttribute("userId"));
		if (loginUser.getType().getTypeId() != Type.ADMIN) {
			return "redirect:/eventList";
		}
		List<Group> group = groupDao.findAll();
		model.addAttribute("group", group);
		List<Type> type = typeDao.findAll();
		model.addAttribute("type", type);

		if (!passNew.isEmpty()) {
			if (BCrypt.checkpw(passNew, user.getPass())) {
				errors.rejectValue("pass", "error.passEditForSame");
				return "editUser";
			} else {
				user.setPass(BCrypt.hashpw(passNew, BCrypt.gensalt()));
			}
		}
		if (!errors.hasErrors()) {
			//File upload
			if (!multipartfile.isEmpty()) {
				SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
				String[] originalName = multipartfile.getOriginalFilename().split("\\."); //split the OriginalFilename of file
				String extensions = originalName[1]; //get the extensions as "jpg,png,gif"
				String saveName = "img" + fmt.format(new Date()) + "." + extensions; //set SaveName like "img20190611124900.png"
				File transferSaveFile = new File(
						"C:\\Users\\User\\Desktop\\k_cyu\\pleiades\\pleiades\\workspace\\EventSystem\\src\\main\\webapp\\uploads\\", saveName); //the really savePath
				user.setImg(saveName); //set SaveName into "saveName" of "UserTable"
				multipartfile.transferTo(transferSaveFile);	//upload file transfer into a new savePath
			}
			userDao.update(user);
			if (session.getAttribute("userId").equals(user.getUserId())) {
				session.setAttribute("userId", user.getUserId());
				session.setAttribute("loginId", user.getLoginId());
				session.setAttribute("userName", user.getUserName());
				session.setAttribute("typeId", user.getType().getTypeId());
			}

			String action="userList";
			model.addAttribute("action", action);

			return "editUserDone";
		} else {
			model.addAttribute("user", user);
			System.out.println(errors);

			String action="userList";
			model.addAttribute("action", action);

			return "editUser";
		}
	}
}