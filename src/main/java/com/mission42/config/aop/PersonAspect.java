package com.mission42.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class PersonAspect {
    public static final Logger LOGGER = LoggerFactory.getLogger(PersonAspect.class);

    @Before(value = "execution(* com.mission42.controller.PersonController.*(*))")
    public void logBeforeCallingPersonController(JoinPoint joinPoint) {
        LOGGER.info(" " + joinPoint.getSignature() + " started at -> " + LocalDate.now());
    }


    @After(value = "execution(* com.mission42.controller.PersonController.*(*))")
    public void logAfterCallingPersonController(JoinPoint joinPoint) {
        LOGGER.info(" " + joinPoint.getSignature() + " ended  at -> " + LocalDate.now());
    }

    /*
    @Around(value = "* com.mission42.service.FeeEntryService.*(..)")
    public void logArroundPersonController(JoinPoint joinPoint){
        Object obj = joinPoint.getTarget();
        // tryinng to identifying the target object
        if(obj instanceof FeeEntryService){
            FeeEntryService feeEntryService = (FeeEntryService) obj;
            LOGGER.debug("* "+feeEntryService);
        }
    }*/
}
