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
 * 除草记录(WeedingRecord)表实体类
 *
 * @author xdz
 * @since 2024-06-20 16:35:20
 */
@SuppressWarnings("serial")
@TableName("weeding_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WeedingRecord extends Model<WeedingRecord> {
    //除草记录ID    
    @TableId(type = IdType.AUTO)
    private Integer id;
    //地块ID，外键引用plot表
    private Integer plotId;
    //果树ID，外键引用tree表
    private Integer treeId;
    //除草日期
    private String weedingDate;
    //除草方法（如人工、机械等）
    private String method;
}
