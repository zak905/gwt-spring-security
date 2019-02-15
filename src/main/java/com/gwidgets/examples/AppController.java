package com.gwidgets.examples;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AppController {
	@RequestMapping("/user")
	  public ResponseEntity<String> user(@AuthenticationPrincipal User user) {
	    return new ResponseEntity<String>(user.getUsername(), HttpStatus.OK);
	  }

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "redirect:/GwtSpringSecurity.html";
	}
}