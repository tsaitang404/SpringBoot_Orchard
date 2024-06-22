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
 * 果树(Tree)表实体类
 *
 * @author xdz
 * @since 2024-06-20 15:45:33
 */
@SuppressWarnings("serial")
@TableName("tree")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tree extends Model<Tree> {
    //果树ID    
    @TableId(type = IdType.AUTO)
    private Integer id;
    //果树品种
    private String species;
    //种植日期
    private String plantingDate;
    //果树年龄（年）
    private Integer age;
    //果树数量（棵）
    private Integer count;
    //果树占地面积（平方米）
    private Float area;
    //地块ID
    private Integer plotId;
}
