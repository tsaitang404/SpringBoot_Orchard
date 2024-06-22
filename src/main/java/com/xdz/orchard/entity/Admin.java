package com.xdz.orchard.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 管理员(Admin)表实体类
 *
 * @author xdz
 * @since 2023-04-29 19:47:07
 */
@SuppressWarnings("serial")
@TableName("admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin extends Model<Admin> {
    //管理员ID    
    @TableId(type = IdType.AUTO)
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //token
    private String token;
    //头像
    private String headImage;
    //性别
    private String sex;
    //联系方式
    private String phone;
}
