package jp.co.sakura.core.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.sakura.core.constant.CoreConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName(CoreConstant.TABLE_NAME_M_USER)
public class User extends BaseEntity implements Serializable {
    @TableId
    private String username;

    @JsonIgnore
    private String password;

    private static final long serialVersionUID = 1L;

}