package org.ibase4j.core.support.dubbo.spring;

import com.alibaba.dubbo.config.spring.ServiceBean;
import org.ibase4j.core.support.dubbo.spring.annotation.DubboService;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:19:19
 */
@SuppressWarnings("serial")
public class DubboServiceBean<T> extends ServiceBean<T> {
    public DubboServiceBean() {
        super();
    }

    public DubboServiceBean(DubboService service) {
        appendAnnotation(DubboService.class, service);
    }
}
