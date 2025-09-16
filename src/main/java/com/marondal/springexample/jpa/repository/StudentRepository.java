package com.marondal.springexample.jpa.repository;

import com.marondal.springexample.jpa.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // 전달 받은 이름과 일치하는 행 조회
    // WHERE `name` = #{name}
    public List<Student> findByName(String name);


    // id를 기반으로 내림차순 정렬
    // ORDER BY `id` DESC
    public List<Student> findByOrderByIdDesc();

    // 전달 받은 이름과 일치하는 행 들을 id 기준으로 내림차순 정렬해서 2개만 조회
    // WHERE `name` = #{name} ORDER BY `id` DESC LIMTI 2;
    public List<Student> findTop2ByNameOrderByIdDesc(String name);

    // 전달받은 이름들과 일치하는 행 조회
    // WHERE `name` IN (#{}, #{})
    public List<Student> findByNameIn(List<String> nameList);

    // 전달 받은 키워드가 포함된 email 컬럼을 가진 행 조회
    // WHERE `email` LIKE '%#{}%'
    public List<Student> findByEmailContaining(String keyword);

    // 쿼리 직접 작성
    // dreamJob이 전달한 값과 일치하는 행조회
    @Query(value="SELECT * FROM `new_student` WHERE `dream_job` = :dreamJob", nativeQuery=true)
    public List<Student> selectByDreamJob(@Param("dreamJob") String dreamJob);

}
