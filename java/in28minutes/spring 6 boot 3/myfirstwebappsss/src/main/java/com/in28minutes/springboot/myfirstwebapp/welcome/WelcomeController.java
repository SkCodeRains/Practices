package com.in28minutes.springboot.myfirstwebapp.welcome;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

	// @Autowired
	// private AuthenticationService authenticationService;

	@GetMapping("/")
	private String gotWelcomePage(ModelMap model) {
		model.put("name", getLogedinUser());
		return "welcome";
	}

	private String getLogedinUser() {
		// return SecurityContextHolder.getContext().getAuthentication().getName();
		return "superadmin";
	}

	// @PostMapping({ "/", "/login" })
	// private String gotoWelcomePage(@RequestParam String name, @RequestParam
	// String password, ModelMap model) {
	// var is = authenticationService.authenticate(name, password);
	// if (is) {
	// model.put("name", name);
	// return "sayHello";
	// } else {
	// model.put("error", "Invalid credention");
	// return "login2";
	// }
	// }

	// @GetMapping("/login")
	// private String gotoLoginPage(@RequestParam String name, ModelMap model) {
	// model.put("name", name);
	// return "login2";
	// }
}
