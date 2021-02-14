package com.simplyclean.TimerProject;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class TimerModelAssembler implements RepresentationModelAssembler<TimerEntity, EntityModel<TimerEntity>> {
	@Override
	  public EntityModel<TimerEntity> toModel(TimerEntity timer) {

	    return EntityModel.of(timer, 
	        linkTo(methodOn(TimerController.class).one(timer.getId().toString())).withSelfRel(),
	        linkTo(methodOn(TimerController.class).all()).withRel("timers"));
	  }

}
