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
 * 游客(Visitor)表实体类
 *
 * @author xdz
 * @since 2024-06-20 16:35:19
 */
@SuppressWarnings("serial")
@TableName("visitor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Visitor extends Model<Visitor> {
    //游客ID    
    @TableId(type = IdType.AUTO)
    private Integer id;
    //游客姓名
    private String name;
    //访问日期
    private String visitDate;
    //访问目的（如采摘、参观等）
    private String purpose;
}
