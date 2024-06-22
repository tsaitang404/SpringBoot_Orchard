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
 * 品级(Grade)表实体类
 *
 * @author xdz
 * @since 2024-06-20 16:15:54
 */
@SuppressWarnings("serial")
@TableName("grade")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Grade extends Model<Grade> {
    //品级ID    
    @TableId(type = IdType.AUTO)
    private Integer id;
    //品级名称（如A级、B级等）
    private String gradeName;
    //品级描述
    private String description;
}
