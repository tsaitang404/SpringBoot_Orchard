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
 * 地块(Plot)表实体类
 *
 * @author xdz
 * @since 2024-06-20 15:37:57
 */
@SuppressWarnings("serial")
@TableName("plot")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Plot extends Model<Plot> {
    //地块ID    
    @TableId(type = IdType.AUTO)
    private Integer id;
    //地块位置
    private String location;
    //地块面积（平方米）
    private Float area;
    //日照时长（小时）
    private Integer sunlightDuration;
    //土壤特性（如酸碱度等）
    private String soilCharacteristics;
}
