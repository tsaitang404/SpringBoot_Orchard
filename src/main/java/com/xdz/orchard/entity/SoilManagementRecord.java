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
 * 土壤管理记录(SoilManagementRecord)表实体类
 *
 * @author xdz
 * @since 2024-06-20 16:35:18
 */
@SuppressWarnings("serial")
@TableName("soil_management_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SoilManagementRecord extends Model<SoilManagementRecord> {
    //土壤管理记录ID    
    @TableId(type = IdType.AUTO)
    private Integer id;
    //地块ID，外键引用plot表
    private Integer plotId;
    //土壤管理日期
    private String managementDate;
    //管理方法（如深翻、改良等）
    private String method;
    //详细信息
    private String details;
}
