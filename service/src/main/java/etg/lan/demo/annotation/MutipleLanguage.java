package etg.lan.demo.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MutipleLanguage {

//    public enum ReturnType{Object,List}
//
//    ReturnType returnType() default ReturnType.List;

//    Class<?> Clazz();

    String lanParameterName() default "lan";

}
