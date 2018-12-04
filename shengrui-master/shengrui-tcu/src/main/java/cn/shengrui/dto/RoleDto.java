package cn.shengrui.dto;

import cn.shengrui.system.entity.SysRole;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName RoleDto
 * @Description TODO
 * @Date 2018/10/24 14:41
 * @Author itastro
 * @Version 1.0
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RoleDto {

    private List<SysRole> noBind=new ArrayList<>();

    private List<SysRole> inBind=new ArrayList<>();


}
