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
 * 防虫记录(PestPreventionRecord)表实体类
 *
 * @author xdz
 * @since 2024-06-20 16:15:57
 */
@SuppressWarnings("serial")
@TableName("pest_prevention_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PestPreventionRecord extends Model<PestPreventionRecord> {
    //防虫记录ID    
    @TableId(type = IdType.AUTO)
    private Integer id;
    //地块ID
    private Integer plotId;
    //果树ID
    private Integer treeId;
    //防虫日期
    private String preventionDate;
    //防虫方法（如喷洒农药）
    private String method;
}
