package com.thoughtworks.restfulapi.restfulapi.exp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class Myexception extends RuntimeException {

}
