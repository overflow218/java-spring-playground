package com.overflow218.my_first_spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Component
@Aspect // aop로 쓰려면 aspect를 달아줘야함
/**
 * 보통 실무에서는 aop는 조금 특별한 존재라서 따로 명시적으로 config에
 * 넣어주는게 좋음. 여기서는 일단 그냥 component 어노테이션써서 넣어볼게
 */
public class TimeTraceAop {

    // 영향을 미치는 범위가 어디인지 여기에 적어주어야함
    @Around("execution(* com.overflow218.my_first_spring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{

        long start = System.currentTimeMillis();

        System.out.println("START: " + joinPoint.toString());
        System.out.println("object"+ this.toString());
        try {
            return joinPoint.proceed(); // joinPoint 거쳐서 실제 서비스로 들어가는거임
        } finally {
            // 실제 서비스 호출끝나고 나갈때 다시 들어와서 시간체크
            long finish = System.currentTimeMillis();
            long timeMs = start - finish;

            System.out.println("END: "+ joinPoint.toString() + " "+ timeMs + "ms");

        }
    }
}
