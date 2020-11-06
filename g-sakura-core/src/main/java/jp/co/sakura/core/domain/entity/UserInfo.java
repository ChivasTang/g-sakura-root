package jp.co.sakura.core.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.sakura.core.constant.CoreConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@TableName(CoreConstant.TABLE_NAME_T_USER_INFO)
public class UserInfo extends BaseEntity implements Serializable {
    @TableId
    private Long userId;

    private String username;

    @JsonIgnore
    private String salt;

    private String token;

    private String email;

    private Long managerId;

    private String firstName;

    private String lastName;

    private LocalDateTime accountExpire;

    private LocalDateTime passwordExpire;

    private static final long serialVersionUID = 1L;

}