package com.bl.station.Bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @ClassName Ftp
 * @Description TODO
 * @Date 2018/9/24 22:28
 * @Author itastro
 * @Version 1.0
 **/

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ftp {

    private String name;

    private String url;

    private String path;

    private Integer port;


}
