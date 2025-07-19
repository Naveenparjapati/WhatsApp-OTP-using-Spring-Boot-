package naveen97.example.WatsOTPTemplates.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import naveen97.example.WatsOTPTemplates.Model.User;
import naveen97.example.WatsOTPTemplates.Service.UserService;


@Controller
public class UserController {
    
	
	@Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("userObj", new User());
        return "index";
    }

    @PostMapping("/user")
    public String save(User user, Model model){
       boolean isSaved = userService.saveUser(user);
       user.setOtp(null);
       model.addAttribute("userObj", user);
       return "success";
    }

    @PostMapping("/validate")
    public String validateOTP(@ModelAttribute("userObj") User userObj, Model model){
        User u = userService.validateOtp(userObj.getEmail(), userObj.getOtp());
        if(u!=null){
            model.addAttribute("smsg", "Congratulations, Your Account Activated..!!");
        }else{
            model.addAttribute("emsg", "Invalid OTP, Enter Correct OTP..!!");
        }
        return "success";
    }
}
