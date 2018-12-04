package cn.shengrui.dto;

import cn.shengrui.system.entity.SysAcl;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AclDto
 * @Description 用户绑定的权限
 * @Date 2018/10/24 15:55
 * @Author itastro
 * @Version 1.0
 **/
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AclDto {

    private List<SysAcl> noBind=new ArrayList<>();

    private List<SysAcl> inBind=new ArrayList<>();


    String


}
