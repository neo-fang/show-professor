package com.springboot.professor.showprofessor.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.professor.showprofessor.domain.User;
import com.springboot.professor.showprofessor.repository.UserRepository;

/**
 * User控制器
 * @author Administrator
 *
 */

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	/**
	 * 查询所有用户，返回用于展现用户列表的list.html页面
	 * @param model
	 * @return
	 */
	@GetMapping
	public ModelAndView list(Model model) {
		//将用户仓库中的所有用户userRepository.listUsers()添加到model中，并且命名为"userList"
		model.addAttribute("userList", userRepository.listUsers());
		//该页面名为“用户管理”，将这个名字添加到model属性中去，用"title"引用这个名字
		model.addAttribute("title", "用户管理");
		//model名称为“userModel”，返回到页面“users/list”
		return new ModelAndView("users/list","userModel",model);
	}
	
	/**
	 * 根据id查询用户，返回哦用于展现某一用户的view.html页面
	 */
	@GetMapping("{id}")//url路径中输入的id
	public ModelAndView view(@PathVariable("id") Long id,Model model) {
		User user = userRepository.getUserById(id);
		//将查询到的用户传入/users/id对应的页面中
		model.addAttribute("user", user);
		model.addAttribute("title", "查看用户");
		//model名称为“userModel”，返回到页面“users/view”
		return new ModelAndView("users/view","userModel",model);
	}
	
	/**
	 * 返回用于新增或者修改用户的view.html页面
	 * @param model
	 * @return
	 */
	@GetMapping("/form")
	public ModelAndView createForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("title", "创建用户");
		//model名称为“userModel”，返回到页面“users/form”
		return new ModelAndView("users/form","userModel",model);
	}
	/**
	 * 新增或者修改用户，成功后重定向到list.html
	 */
	@PostMapping
	public ModelAndView saveOrUpdateUser(User user) {
		userRepository.savaOrUpdateUser(user);
		return new ModelAndView("redirect:/users");//重定向到list页面
	}
	
}
