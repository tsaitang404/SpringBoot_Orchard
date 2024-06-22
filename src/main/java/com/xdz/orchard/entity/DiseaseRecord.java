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
 * 病害记录(DiseaseRecord)表实体类
 *
 * @author xdz
 * @since 2024-06-20 16:15:21
 */
@SuppressWarnings("serial")
@TableName("disease_record")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DiseaseRecord extends Model<DiseaseRecord> {
    //病害记录ID    
    @TableId(type = IdType.AUTO)
    private Integer id;
    //地块ID
    private Integer plotId;
    //果树ID
    private Integer treeId;
    //发现病害日期
    private String diseaseDate;
    //病害类型
    private String diseaseType;
    //病害严重程度
    private String severity;
}
