package com.simplyclean.TimerProject;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

public interface TimerRepository extends JpaRepository<TimerEntity, Long> {
	@Bean(name="entityManagerFactory")
	public default LocalSessionFactoryBean sessionFactory() {
	    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

	    return sessionFactory;
	} 

}
