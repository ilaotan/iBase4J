package org.ibase4j.core.support.dubbo.spring;

import com.alibaba.dubbo.config.spring.ReferenceBean;
import org.ibase4j.core.support.dubbo.spring.annotation.DubboReference;

@SuppressWarnings("serial")
public class DubboReferenceBean<T> extends ReferenceBean<T> {

    public DubboReferenceBean() {
        super();
    }

    public DubboReferenceBean(DubboReference reference) {
        appendAnnotation(DubboReference.class, reference);
    }
}
