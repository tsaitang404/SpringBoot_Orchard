package com.xdz.orchard.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 员工(Employee)表实体类
 *
 * @author xdz
 * @since 2024-06-20 16:15:53
 */
@SuppressWarnings("serial")
@TableName("employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee extends Model<Employee> {
    //员工ID    
    @TableId(type = IdType.AUTO)
    private Integer id;
    //员工姓名
    private String name;
    //联系方式
    private String phone;
    //入职日期
    private String hireDate;
}
