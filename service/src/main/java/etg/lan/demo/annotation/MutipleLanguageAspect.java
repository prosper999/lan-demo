package etg.lan.demo.annotation;

import etg.lan.demo.decorator.LanDecorator;
import etg.lan.demo.entity.SysOrg;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class MutipleLanguageAspect {

    @Autowired
    LanDecorator lanDecorator;

    @Pointcut("@annotation(etg.lan.demo.annotation.MutipleLanguage)")
    private void pointcut(){
//        System.out.println("point cut");
    }

//    @Before("pointcut()")
//    public void before(JoinPoint jp){
//        System.out.println("before point cut");
//    }

//    @After("pointcut()")
//    public void after(JoinPoint joinPoint, MutipleLanguage mutipleLanguage){
//        System.out.println("after point cut");
//        //获取两个参数值，
////        Object[] objects = joinPoint.getArgs();
////        if(objects != null){
////            for(Object o:objects){
////                System.out.println(o);
////            }
////        }
//
//        Object[] args = joinPoint.getArgs(); // 参数值
//        String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames(); // 参数名
//
//        System.out.println(joinPoint.getSignature().getName());
//
////        joinPoint.getThis()
//
//        //list
//        //lan
//        lanDecorator.filter(null,null);
//    }

    private int checkLan(MethodSignature signature,String lanName) {
        int index = -1;
        boolean hadLan = false;
        String[] argNames = signature.getParameterNames();
        if (argNames != null && argNames.length > 0) {
            for (int i = 0; i < argNames.length; i++) {
                if (argNames[i].equals(lanName)) {
                    hadLan = true;
                    index = i;
                    break;
                }
            }
        }
        if (!hadLan) return -1;
        Class[] classes = signature.getParameterTypes();
        if (classes[index].getSimpleName().equals("String")) {
            return index;
        }
        return -1;
    }

    @Around("pointcut()&&@annotation(mutipleLanguage)")
    public Object around(ProceedingJoinPoint joinPoint, MutipleLanguage mutipleLanguage) throws Throwable {

        System.out.println("around point cut");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        int index = checkLan(signature,mutipleLanguage.lanParameterName());
        if (index < 0)
            throw new Exception("Cannot find lanParameterName of MutipleLanguage, should be as (String lan)");

//        if(index == null || index < 0)
//            throw new Exception("Incorrect lanParameterName of MutipleLanguage.");

        String lan = (String)joinPoint.getArgs()[index];

        //之前要检验是否有语言参数
        //检验有返回对象
        Object object = joinPoint.proceed();
        if(object instanceof java.util.List){
            List list = (List) object;
            lanDecorator.filter(list, lan);
            return list;
        }else{
            lanDecorator.filter(object, lan);
            return object;
        }
    }

    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void afterException(JoinPoint joinPoint, Exception e) {
        System.out.print("-----------afterException:" + e.getMessage());
    }

}
