package com.orctom.sample.springmvc.controller;

import com.google.common.collect.ImmutableList;
import com.orctom.sample.springmvc.model.SKU;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

  @RequestMapping(value = "/sample", method = RequestMethod.GET)
  public Iterable<String> test() {
    return ImmutableList.<String>builder().add("hello").add("would").add("spring-mvc").build();
  }

  @RequestMapping(value = "/sample2/{name}", method = RequestMethod.GET)
  public Iterable<String> test2(@PathVariable String name) {
    System.out.println(name);
    return ImmutableList.<String>builder().add("hello").add("would").add("spring-mvc").build();
  }

  @RequestMapping(value = "/sku", method = RequestMethod.GET, produces = "application/json")
  public @ResponseBody SKU sku() {
    return new SKU("315515", "folder", 123456, 100000);
  }
}
