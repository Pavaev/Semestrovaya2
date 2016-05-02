package project.aspectJ;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import project.model.User;
import project.model.UserLog;
import project.service.AspectService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
public class AspectJ {

    UserLog log;

    @Autowired
    AspectService aspectServ;

    @Around("@annotation(Log)")
    public void logAnnotatedMethods(ProceedingJoinPoint pjp) throws Throwable {
        log = new UserLog();
        //get date-time
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String dt = dateFormat.format(date);

        //get method name
        String name = pjp.getSignature().getName();

        //get current user
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        log.setDate(dt);
        log.setName(name);
        log.setUser(user);
        pjp.proceed();
    }

    @AfterReturning(pointcut = "@annotation(Log)", returning = "returnValue")
    public void getReturned(JoinPoint joinPoint, String returnValue) {
        if (returnValue == null || "".equals(returnValue)) {
            returnValue = "void";
        }
        log.setReturned(returnValue);

        System.out.println(log.getDate() + " " + log.getName() + " " + log.getReturned() + " " + log.getUser().getUsername());

        aspectServ.add(log);
    }

}