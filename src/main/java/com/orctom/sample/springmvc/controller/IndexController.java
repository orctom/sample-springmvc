package com.orctom.sample.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.collect.ImmutableList;

/**
 * Created by CH on 4/23/14.
 */
@Controller
public class IndexController {

	@RequestMapping(value = "/sample", method = RequestMethod.GET)
	public Iterable<String> test() {
		return ImmutableList.<String> builder().add("hello").add("would").add("spring-mvc").build();
	}
}
