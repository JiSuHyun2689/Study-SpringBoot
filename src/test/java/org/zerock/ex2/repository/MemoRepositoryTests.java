package org.zerock.ex2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    /*
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

     */

    @Test
    public void testPageDefault(){

        //1페이지 10개

        Pageable pageable = PageRequest.of(0, 10);
        Page<Memo> result = memoRepository.findAll(pageable);
        System.out.println(result);
        System.out.println("-----------------------------------------------");
        System.out.println("Total Pages: " + result.getTotalPages()); // 총 페이지 수
        System.out.println("Total Count: " + result.getTotalElements() ); // 전체 데이터 개수
        System.out.println("Page Number: " + result.getNumber()); // 현재 페이지 번호 0부터 시작
        System.out.println("Page Size: " + result.getSize()); // 페이지당 데이터 개수
        System.out.println("has next page? " + result.hasNext()); // 다음 페이지 존재 여부
        System.out.println("first page? " + result.isFirst()); // 시작페이지(0) 여부
                
    }


    @Test
    public void testSort(){


        Sort sort1 = Sort.by("mno").descending();
        Pageable pageable = PageRequest.of(0, 10, sort1);
        Page<Memo> result = memoRepository.findAll(pageable);


        result.get().forEach(memo ->{
            System.out.println(memo);
        });

    }


}
