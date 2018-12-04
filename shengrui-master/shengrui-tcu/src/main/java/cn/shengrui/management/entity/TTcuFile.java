package cn.shengrui.management.entity;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TTcuFile {
    private Integer id;

    private Integer fileId;

    private Integer tcuId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getTcuId() {
        return tcuId;
    }

    public void setTcuId(Integer tcuId) {
        this.tcuId = tcuId;
    }
}