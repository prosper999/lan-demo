package etg.lan.demo.core;

import org.apache.catalina.security.SecurityUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

public abstract class BaseController<T> {

    @Autowired
    private MessageSource messageSource;

    public String getMessage(String lan, String code) {
//        Locale locale = SecurityUtil.getCurrentUser(request).getCurrentLocale();
//        if(locale == null)
            Locale locale = Locale.forLanguageTag(lan);
        //默认是中文
//        Locale locale = new Locale(lan);
        return messageSource.getMessage(code, new Object[]{}, "Null", locale);
    }

}
