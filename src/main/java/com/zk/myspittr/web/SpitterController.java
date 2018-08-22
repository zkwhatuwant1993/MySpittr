package com.zk.myspittr.web;

import com.zk.myspittr.Spitter;
import com.zk.myspittr.data.SpitterRepository;
import com.zk.myspittr.model.SpitterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(
            @Valid SpitterForm form, Errors errors,Model model) throws IOException {
        if (errors.hasErrors()) {
            return "registerForm";
        }

        MultipartFile profilePicture = form.getProfilePicture();
        Spitter spitter = form.toSpitter();
        profilePicture.transferTo(new File(spitter.getUsername() + ".jpg"));
        spitterRepository.save(spitter);
        model.addAttribute("username", spitter.getUsername());
        return "redirect:/spitter/{username}";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showUserProfile(
            @PathVariable("username") String username, Model model) {
        if (!model.containsAttribute("spitter")) {
            model.addAttribute(spitterRepository.findByUsername(username));
        }
        return "profile";
    }
}
