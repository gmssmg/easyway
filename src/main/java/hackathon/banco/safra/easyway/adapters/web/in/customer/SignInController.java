package hackathon.banco.safra.easyway.adapters.web.in.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SignInController {
	
	@GetMapping("")
    public ModelAndView home(){

        ModelAndView mv = new ModelAndView("home");
        return mv;

    }
	
	@GetMapping("/microcredito")
    public ModelAndView microcredito(){

        ModelAndView mvabout = new ModelAndView("microcredito");
        return mvabout;

    }

}
