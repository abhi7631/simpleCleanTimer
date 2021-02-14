package com.simplyclean.TimerProject;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TimerController {

  private final TimerRepository repository;  

  @Autowired
  TimerController(TimerRepository repository) {
    this.repository = repository;
  }

  @PostMapping("/create/{start}/{step}")
  String newTimer(@PathVariable("start") int startVal, @PathVariable("step") int stepVal) {
	  TimerEntity timer = new TimerEntity(startVal,stepVal);
	  return repository.save(timer).getId().toString();
  }
  
  
  
  // Aggregate root
  @GetMapping("/check")
  Set<TimerResponse> all() {
	//TimerResponse response = new TimerResponse();
	Set<TimerResponse> timerResponseSet = new HashSet<TimerResponse>();
    List<TimerEntity> timers = repository.findAll();
    ListIterator<TimerEntity> iterator = timers.listIterator();
    while( iterator.hasNext())
    {
    	TimerResponse response = new TimerResponse(iterator.next().getStartVal(),
    			iterator.next().getStepVal(),iterator.next().getCreateDate());
    	timerResponseSet.add(response);
    }   

    return timerResponseSet;
  }

  
  // Single item
  
  @GetMapping("/check/{id}")
  TimerResponse one(@PathVariable String id) {
	  Long idLong = Long.parseLong(id);
	  TimerEntity timer = repository.findById(idLong) //
        .orElseThrow(() -> new TimerNotFoundExeption(idLong));
	  TimerResponse response = new TimerResponse(timer.getStartVal(),timer.getStepVal(),timer.getCreateDate());
	  
    return response;
  }

  @PutMapping("/pause/{id}")
  Timestamp pauseTimer( @PathVariable String id) {
    Long idLong = Long.parseLong(id);
    Optional<TimerEntity> timer = repository.findById(idLong);
    TimerEntity changeTimer = timer.get();
    if(changeTimer != null)
    {
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	changeTimer.setModifiedDate(timestamp);
    	changeTimer.setPauseInd(1);
    	repository.save(changeTimer);
    	return timestamp;
    }
    else
    {
    	throw new TimerNotFoundExeption(idLong);
    }
    	
  }

  @DeleteMapping("/clear/{id}")
  void deleteTimer(@PathVariable String id) {
	  Long idLong = Long.parseLong(id);
    repository.deleteById(idLong);
  }
}
