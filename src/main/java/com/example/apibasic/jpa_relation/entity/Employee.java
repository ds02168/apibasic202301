package com.example.apibasic.jpa_relation.entity;


import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "empId")
@Builder
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId; // 사원 번호

    private String empName; // 사원명

    /*
    * EAGER : 필요없는 정보들도 항상 조인을 하도록 설정
    * LAZY : 부서정보가 필요할때만 조인(실무에서는 ManyToOne시 무조건 LAZY)
    * */

    @ManyToOne(fetch = LAZY) //연관관계 매핑
    @JoinColumn(name = "dept_id") //FK 컬럼 이름 지정
    private Department department;
}
