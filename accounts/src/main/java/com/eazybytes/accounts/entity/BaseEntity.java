package com.eazybytes.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass // BaseEntity là một lớp cha (superclass) nhưng không được ánh xạ thành bảng trong cơ sở dữ liệu. Lớp này chỉ cung cấp các thuộc tính và logic chung cho các lớp con.
@ToString
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedDate // Thời gian tạo lần đầu
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate // Thời gian lần cuối cập nhật
//    @Column(insertable = false)
    private LocalDateTime updatedAt;

    @CreatedBy // Tạo bởi
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedBy // Người sửa cuối
//    @Column(insertable = false)
    private String updatedBy;
}
