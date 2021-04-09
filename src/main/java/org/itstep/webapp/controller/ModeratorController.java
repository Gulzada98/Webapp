package org.itstep.webapp.controller;

import javax.annotation.PreDestroy;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@PreAuthorize("hasRole('ROLE_MODERATOR')")
@Controller
public class ModeratorController {



  @PreDestroy
  public void init(){

  }

  public ModeratorController() {
  }
}
