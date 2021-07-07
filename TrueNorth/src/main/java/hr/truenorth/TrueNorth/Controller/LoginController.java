package hr.truenorth.TrueNorth.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import hr.truenorth.TrueNorth.Model.User;
import hr.truenorth.TrueNorth.Service.UserService;

@Controller
public class LoginController {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoginController.class);
	
	@Autowired 
	private UserService userService;
	
	@Value("Mamba Forever")
	private String value;
	
	@GetMapping("/")
	public ModelAndView root(Model model) {
		System.out.println(value);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
		if(currentPrincipalName.equals("anonymousUser"))
			return new ModelAndView("homepage");
		
		User user = userService.getUserByUsername(currentPrincipalName);
		model.addAttribute("role", user.getRole().equals("ROLE_ADMIN") ? "admin" : "user");
		
		model.addAttribute("username", currentPrincipalName);
		log.info("GET Request for the profile page.");
		
		return new ModelAndView("profil");
	}
	
	@GetMapping("/homepage")
	public ModelAndView homepage(Model model) {
		log.info("GET request for the homepage.");
		return new ModelAndView("homepage");
	}
	
	@GetMapping("/homepage-error")
	public ModelAndView rootError(Model model) {
		log.info("ERROR while logging in.");
		
		model.addAttribute("error", "Login unsuccesful.");
		return new ModelAndView("homepage");
	}
}
