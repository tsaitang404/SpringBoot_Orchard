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
 * 防病记录(DiseasePreventionRecord)表实体类
 *
 * @author xdz
 * @since 2024-06-20 15:58:44
 */
@SuppressWarnings("serial")
@TableName("disease_prevention_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DiseasePreventionRecord extends Model<DiseasePreventionRecord> {
    //防病记录ID    
    @TableId(type = IdType.AUTO)
    private Integer id;
    //地块ID
    private Integer plotId;
    //果树ID
    private Integer treeId;
    //防病日期
    private String preventionDate;
    //防病方法（如喷洒农药）
    private String method;
}
