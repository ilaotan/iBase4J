package org.ibase4j.provider.sys;

import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import org.ibase4j.model.sys.SysDic;
import org.ibase4j.model.sys.SysDicIndex;

public interface ISysDicProvider {
    public Map<String, Map<String, String>> getAllDic();

    public void updateDicIndex(SysDicIndex record);

    public void updateDic(SysDic record);

    public void deleteDic(String id);

    public SysDicIndex queryDicIndexById(String id);

    public SysDic queryDicById(String id);

    public Page<SysDicIndex> queryDicIndex(Map<String, Object> params);

    public Page<SysDic> queryDic(Map<String, Object> params);

    public void deleteDicIndex(String id);

    public Map<String, String> queryDicByDicIndexKey(String key);
}
