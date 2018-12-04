package cn.shengrui.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
/**
 * @author itwang
 */
public class TProjectTcu {
    private Integer id;

    private Integer projectId;

    private Integer tcuId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getTcuId() {
        return tcuId;
    }

    public void setTcuId(Integer tcuId) {
        this.tcuId = tcuId;
    }
}