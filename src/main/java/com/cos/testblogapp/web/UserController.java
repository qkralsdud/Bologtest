package com.cos.testblogapp.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.testblogapp.domain.user.User;
import com.cos.testblogapp.domain.user.UserRepository;
import com.cos.testblogapp.web.dto.JoinReqtDto;
import com.cos.testblogapp.web.dto.LoginReqDto;

@Controller
public class UserController {
	
	private UserRepository userRepository;	
	private HttpSession session;
	public UserController(UserRepository userRepository, HttpSession session) {
		this.userRepository = userRepository;
		this.session = session;
	}
	
//	@RequestMapping(value="/some/path", method = RequestMethod.POST)
//	public void ResponseEntity<?> someMethod(HttpServletResponse response) {
//	   Cookie myCookie = new Cookie("cookieName", cookieValue);
//	   myCookie.setMaxAge(쿠키 expiration 타임 (int));
//	   myCookie.setPath("/"); // 모든 경로에서 접근 가능 하도록 설정
//	   response.addCookie(myCookie);
//	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
	@PostMapping("/login")
	public String login(LoginReqDto dto) {
		
		User userEntity = userRepository.mLogin(dto.getUsername(), dto.getPassword());
		
		if(userEntity == null) {
			return "redirect:/loginForm";
		} else {
			session.setAttribute("user", userEntity);
			return "redirect:/home";
		}
	}
	
	@PostMapping("/join")
	public String join(JoinReqtDto dto) {		
		userRepository.save(dto.toEntity());
		
		return "redirect:/loginForm"; 
	}
		
}








