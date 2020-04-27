package com.example.ritesh.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.example.ritesh.demo.dao.UserDaoService;
import com.example.ritesh.demo.exception.UserNotFoundException;
import com.example.ritesh.demo.model.User;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
public class RestResuorce {
	@Autowired
	private UserDaoService service;
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> retriveAllUsers() {
		return service.findAll();

	}
//hateoas
	/*
	 * @RequestMapping(value = "/users/{id}", method = RequestMethod.GET) public
	 * User retriveUserById(@PathVariable int id) { User user = service.findOne(id);
	 * if (user == null) throw new UserNotFoundException("id-" + id); return user;
	 * 
	 * }
	 */

	// Using Hateoas
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public Resource<User> retriveUserById(@PathVariable int id) {
		User user = service.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkto = linkTo(methodOn(this.getClass()).retriveAllUsers());
		resource.add(linkto.withRel("all-ussers"));
		return resource;
		// return user;

	}

//Getting proper SatausCose
	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User use = service.save(user);
		URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(use.getId()).toUri();
		return ResponseEntity.created(url).build();

	}
	/*
	 * @RequestMapping(value = "/users", method = RequestMethod.POST, consumes =
	 * MediaType.APPLICATION_JSON) public ResponseEntity<Object>
	 * createUser(@RequestBody User user) { User use = service.save(user); URI url =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (use.getId()).toUri(); return ResponseEntity.created(url).build();
	 * 
	 * }
	 */

	@RequestMapping(value = "/users/name/{name}", method = RequestMethod.GET)
	public User retriveUserByName(@PathVariable String name) {
		return service.findUserByName(name);

	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public void deleteUserById(@PathVariable int id) {
		User user = service.deleteById(id);
		if (user == null)
			throw new UserNotFoundException("id-" + id);

	}

	@GetMapping(path = "hellow-word")
	public String hellWordInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());

	}
}
