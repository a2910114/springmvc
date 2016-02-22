package com.mykhaylenko.messenger.controller;

import com.mykhaylenko.messenger.model.User;
import com.mykhaylenko.messenger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * Created by pavlo.mykhaylenko on 8/14/2015.
 */
@Controller
@RequestMapping("/messenger")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String processRegistration(
            @RequestPart("profilePicture") MultipartFile profilePicture,
            @Valid User user, Errors errors, RedirectAttributes model) {

        if (errors.hasErrors()) {
            return "registerForm";
        }

        user.setPassword(passwordEncoder.encodePassword(user.getPassword(), null));
        userService.save(user);
        saveFile(profilePicture);
        model.addFlashAttribute("user", user);
        return "redirect:/messenger/" + user.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showMessengerProfile(@PathVariable String username, Model model) {
        //        User user = userService.findByUserName(username);
        //        model.addAttribute("user", user);
        return "profile";
    }

    private void saveFile(@RequestPart("profilePicture") MultipartFile profilePicture) {
        try {
            profilePicture.transferTo(
                    new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 8.0\\"
                            + "work\\Catalina\\localhost\\springmvc-1.0-SNAPSHOT\\" +
                            profilePicture.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
