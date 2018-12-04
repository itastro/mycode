package cn.shengrui.dto;

import cn.shengrui.system.entity.SysRole;
import cn.shengrui.system.entity.SysUser;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @ClassName SysUserDto
 * @Description TODO
 * @Date 2018/10/24 10:08
 * @Author itastro
 * @Version 1.0
 **/
@Getter
@Setter
@ToString
public class SysUserDto extends SysUser {

    private String token;

    private List<String> roleName;

    /**
     * 进行适配
     *
     * @param
     * @return
     */
    public static SysUserDto adapt(SysUser sysUser) {
        SysUserDto sysUserDto = new SysUserDto();
        BeanUtils.copyProperties(sysUser, sysUserDto);
        return sysUserDto;
    }

}
