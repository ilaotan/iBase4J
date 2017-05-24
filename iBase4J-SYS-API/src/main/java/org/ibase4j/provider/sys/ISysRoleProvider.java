package org.ibase4j.provider.sys;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import org.ibase4j.core.base.BaseProvider;
import org.ibase4j.model.sys.SysRole;
import org.ibase4j.model.sys.ext.SysRoleBean;

public interface ISysRoleProvider extends BaseProvider<SysRole> {
    public Page<SysRoleBean> queryBean(Map<String, Object> params);

    /**
     * 根据角色Id获取权限选项value
     */
    public List<String> getPermissions(String id);
}
