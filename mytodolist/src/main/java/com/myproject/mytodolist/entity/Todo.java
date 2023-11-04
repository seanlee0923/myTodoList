package com.myproject.mytodolist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "todo")
public class Todo {
    @Id @GeneratedValue
    @Column(name = "todo_id")
    private Long id;

    @Column(name = "todo_name")
    private String name;

    @Column(name = "todo_info")
    private String todoInfo;

    private boolean achieve; // 달성 여부

    @ManyToOne @JoinColumn(name = "plan_id")
    private Plan plan;
    
}
