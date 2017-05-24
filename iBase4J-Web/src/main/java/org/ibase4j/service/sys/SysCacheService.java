package org.ibase4j.service.sys;

import org.springframework.stereotype.Service;

import org.ibase4j.core.support.dubbo.spring.annotation.DubboReference;
import org.ibase4j.provider.sys.ISysCacheProvider;

@Service
public class SysCacheService {
    @DubboReference
    private ISysCacheProvider sysCacheProvider;

    public void flushCache() {
        sysCacheProvider.flush();
    }
}
