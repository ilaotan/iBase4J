package org.ibase4j.service.sys;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import org.ibase4j.core.config.Resources;
import org.ibase4j.core.support.Assert;
import org.ibase4j.core.support.dubbo.spring.annotation.DubboReference;
import org.ibase4j.core.util.WebUtil;
import org.ibase4j.model.sys.SysDic;
import org.ibase4j.model.sys.SysDicIndex;
import org.ibase4j.provider.sys.ISysDicProvider;

@Service
public class SysDicService {
    @DubboReference
    private ISysDicProvider provider;

    public Page<SysDicIndex> queryDicIndex(Map<String, Object> params) {
        return provider.queryDicIndex(params);
    }

    public Page<SysDic> queryDic(Map<String, Object> params) {
        return provider.queryDic(params);
    }

    public void addDicIndex(SysDicIndex record) {
        record.setCreateBy(WebUtil.getCurrentUser());
        provider.updateDicIndex(record);
    }

    public void updateDicIndex(SysDicIndex record) {
        Assert.isNotBlank(record.getId(), Resources.getMessage("ID_IS_NULL"));
        record.setUpdateBy(WebUtil.getCurrentUser());
        provider.updateDicIndex(record);
    }

    public void deleteDicIndex(String id) {
        Assert.isNotBlank(id, Resources.getMessage("ID_IS_NULL"));
        provider.deleteDicIndex(id);
    }

    public void addDic(SysDic record) {
        record.setCreateBy(WebUtil.getCurrentUser());
        provider.updateDic(record);
    }

    public void updateDic(SysDic record) {
        Assert.isNotBlank(record.getId(), Resources.getMessage("ID_IS_NULL"));
        record.setUpdateBy(WebUtil.getCurrentUser());
        provider.updateDic(record);
    }

    public void deleteDic(String id) {
        Assert.isNotBlank(id, Resources.getMessage("ID_IS_NULL"));
        provider.deleteDic(id);
    }

    public SysDicIndex queryDicIndexById(String id) {
        return provider.queryDicIndexById(id);
    }

    public SysDic queryDicById(String id) {
        return provider.queryDicById(id);
    }

    public Map<String, String> queryDicByDicIndexKey(String key) {
        Assert.notNull(key, Resources.getMessage("KEY_IS_NULL"));
        return provider.queryDicByDicIndexKey(key);
    }

}
