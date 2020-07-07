package com.hzm.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author hzm
 * @version 1.0
 * @date 2020/7/6 23:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    private static final long serialVersionUID = 8277890565143743043L;
    private Long id;
    private String serial;
}
