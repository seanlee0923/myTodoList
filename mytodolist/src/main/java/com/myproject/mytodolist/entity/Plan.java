package com.myproject.mytodolist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "plan")
public class Plan {
    @Id @GeneratedValue @Column(name = "plan_id")
    private Long id;

    @CreationTimestamp
    private Date planDay; // 게획을 만든 날

    private Date startDay;
    private Date endDay;

    @Column(name = "plan_name")
    private String name;
    @Column(name = "plan_info")
    private String info;

    private float percent; // plan이 가지고있는 todo 달성율

    // 이 plan을 가지고 있는 멤버
    @ManyToOne @JoinColumn(name = "member_id")
    private Member member;

    // 이 plan에 포함된 todolist들
    @OneToMany(mappedBy = "plan")
    List<Todo> todoList = new ArrayList<>();
}
