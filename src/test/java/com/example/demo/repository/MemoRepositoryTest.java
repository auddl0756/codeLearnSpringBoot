package com.example.demo.repository;

import com.example.demo.entity.Memo;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

//스프링부트 2.2 이하 정도? junit4 에서는 @RunWith(SpringRunner.class) 붙여줘야 스프링 환경과 함께 테스트 진행 가능
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemoRepositoryTest {
    @Autowired
    MemoRepository memoRepository;


    @After
    public void clean(){
        memoRepository.deleteAll();
    }

    @Test
    public void 메모레포지토리test(){
        System.out.println(memoRepository.getClass().getName());
    }

    @Test
    public void  저장후가져오기(){
        IntStream.rangeClosed(1,100)
                .forEach(
                        i->{
                            Memo memo = Memo.builder()
                                    .memoText("Sample..."+i).build();
                            memoRepository.save(memo);
                        }
                );


        for(long i=1;i<=100;i++){
            assertThat(i).isEqualTo(memoRepository.getByMno(i).getMno());
        }
    }

    @Test
    public void 수정(){
        String changedText = "changed text";

        memoRepository.save(
                Memo.builder()
                    .memoText("before text")
                    .build()
        );

        memoRepository.save(
                Memo.builder()
                    .mno(1L)
                    .memoText(changedText)
                    .build()
        );

        memoRepository.findAll().stream()
                                .forEach(System.out::println);

        Memo latestSaved = memoRepository.findAll().get(0);
        assertThat(latestSaved.getMemoText()).isEqualTo(changedText);

    }


    @Test
    public void 삭제(){

        memoRepository.save(
                Memo.builder()
                        .memoText("sample text")
                        .build()
        );

        memoRepository.deleteById(1L);

        assertThat(memoRepository.findAll().size()).isEqualTo(0);

    }
}