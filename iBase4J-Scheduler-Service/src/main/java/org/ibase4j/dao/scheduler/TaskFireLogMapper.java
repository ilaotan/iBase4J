package org.ibase4j.dao.scheduler;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.ibase4j.model.scheduler.TaskFireLog;

public interface TaskFireLogMapper extends BaseMapper<TaskFireLog, String> {
    List<String> selectIdByMap(RowBounds rowBounds, @Param("cm") Map<String, Object> params);
}
