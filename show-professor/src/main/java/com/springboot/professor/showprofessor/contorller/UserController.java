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
 * User������
 * @author Administrator
 *
 */

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	/**
	 * ��ѯ�����û�����������չ���û��б��list.htmlҳ��
	 * @param model
	 * @return
	 */
	@GetMapping
	public ModelAndView list(Model model) {
		//���û��ֿ��е������û�userRepository.listUsers()��ӵ�model�У���������Ϊ"userList"
		model.addAttribute("userList", userRepository.listUsers());
		//��ҳ����Ϊ���û������������������ӵ�model������ȥ����"title"�����������
		model.addAttribute("title", "�û�����");
		//model����Ϊ��userModel�������ص�ҳ�桰users/list��
		return new ModelAndView("users/list","userModel",model);
	}
	
	/**
	 * ����id��ѯ�û�������Ŷ����չ��ĳһ�û���view.htmlҳ��
	 */
	@GetMapping("{id}")//url·���������id
	public ModelAndView view(@PathVariable("id") Long id,Model model) {
		User user = userRepository.getUserById(id);
		//����ѯ�����û�����/users/id��Ӧ��ҳ����
		model.addAttribute("user", user);
		model.addAttribute("title", "�鿴�û�");
		//model����Ϊ��userModel�������ص�ҳ�桰users/view��
		return new ModelAndView("users/view","userModel",model);
	}
	
	/**
	 * �����������������޸��û���view.htmlҳ��
	 * @param model
	 * @return
	 */
	@GetMapping("/form")
	public ModelAndView createForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("title", "�����û�");
		//model����Ϊ��userModel�������ص�ҳ�桰users/form��
		return new ModelAndView("users/form","userModel",model);
	}
	/**
	 * ���������޸��û����ɹ����ض���list.html
	 */
	@PostMapping
	public ModelAndView saveOrUpdateUser(User user) {
		userRepository.savaOrUpdateUser(user);
		return new ModelAndView("redirect:/users");//�ض���listҳ��
	}
	
}
