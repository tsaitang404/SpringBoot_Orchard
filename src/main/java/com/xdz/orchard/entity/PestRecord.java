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
 * 虫害记录(PestRecord)表实体类
 *
 * @author xdz
 * @since 2024-06-20 16:15:57
 */
@SuppressWarnings("serial")
@TableName("pest_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PestRecord extends Model<PestRecord> {
    //虫害记录ID    
    @TableId(type = IdType.AUTO)
    private Integer id;
    //地块ID，外键引用plot表
    private Integer plotId;
    //果树ID，外键引用tree表
    private Integer treeId;
    //发现虫害日期
    private String pestDate;
    //虫害类型
    private String pestType;
    //虫害严重程度
    private String severity;
}
