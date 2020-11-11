package jp.co.sakura.core.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jp.co.sakura.core.constant.CoreConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName(CoreConstant.TABLE_NAME_M_ROLE)
public class Role extends BaseEntity implements Serializable {
    @TableId
    private Long roleId;

    private String roleName;

    private String description;

    private static final long serialVersionUID = 1L;

}