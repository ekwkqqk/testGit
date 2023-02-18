package com.example.springboottest.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicInsert;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="members", uniqueConstraints = {@UniqueConstraint(name = "UK_name_age", columnNames = {"name", "age"})})
@DynamicInsert
public class TestEntity {
 
  @Id
  private Long id;
 
  @Column(name="name", columnDefinition = "varchar(100) default 'USER'")
  private String username;
 
  private Integer age;
 
  @Enumerated(EnumType.STRING)
  private RoleType roleType;
 
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;
 
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastModifiedDate;
 
  @Lob
  private String description;
 
}
