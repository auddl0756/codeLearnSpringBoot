package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Table(name="tbl_memo")
@Entity
public class Memo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(length = 200,nullable = false)
    private String memoText;

}
