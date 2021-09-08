package org.zerock.ex2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.EntityGraph;
import org.zerock.ex2.entity.Memo;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass(){
        System.out.println(memoRepository.getClass().getName());
    }

    @Test
    public void testInsertDummies(){
        IntStream.rangeClosed(1, 100).forEach(i -> {
            memoRepository.save(Memo.builder().memoText("Memo......" + i).build());
        });
    }


    @Test
    public void testSelect(){
        Long mno = 26L;

        Optional<Memo> result = memoRepository.findById(mno);
        System.out.println("-------------------------------");
        if(result.isPresent())
            System.out.println(result.get());
    }

    @Test
    @Transactional
    public void testSelect2(){
        Long mno = 80L;
        Memo memo = memoRepository.getById(mno);
        System.out.println("-------------------------------------------------------------");
        System.out.println(memo);
    }

    @Test
    public void testUpdate(){
        Memo memo = Memo.builder().mno(1L).memoText("Update.................").build();

        System.out.println("1------------------------------------------------------");
        memoRepository.save(memo);
        System.out.println("2------------------------------------------------------");
    }

    @Test
    public void testDelete(){
        Long mno = 100L;
        memoRepository.deleteById(100L);
    }



}
