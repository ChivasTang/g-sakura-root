package jp.co.sakura.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString(callSuper = true)
public class BaseEntity {

    @JsonIgnore
    private Integer version;

    @JsonIgnore
    private Integer deleted;

    @JsonIgnore
    private Long createUserId;

    @JsonIgnore
    private Long updateUserId;

    @JsonIgnore
    private LocalDateTime createTime;

    @JsonIgnore
    private LocalDateTime updateTime;
}
