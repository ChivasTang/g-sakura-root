package jp.co.sakura.core.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import jp.co.sakura.core.constant.CoreConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName(CoreConstant.TABLE_NAME_R_USER_ROLE)
public class UserRole extends BaseEntity implements Serializable {
    private Long userId;
    private Long roleId;
}