package com.marondal.springexample.jpa.service;

import com.marondal.springexample.jpa.domain.Student;
import com.marondal.springexample.jpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(
            String name
            , String phoneNumber
            , String email
            , String dreamJob) {

        Student student = Student.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .email(email)
                .dreamJob(dreamJob)
                .build();

        Student result = studentRepository.save(student);

        return result;

    }

    public Student updateStudent(int id, String dreamJob) {

        // 수정 행 조회
        // 조회 된 객체 얻어오기 
        // 객체 수정사항 적용
        // 수정된 객체를 저장

        // Optional
        // null일수도 있는 객체를 감싸 놓은 객체
        // null과 관련된 처리를 위한 기능
        // null인 객체 변수를 다루는 과정에서 NullPointerException의 위험을 줄이기 위한 용도
        // null을 리턴할 수도 있는 메서드에서 리턴 타입으로 활용
        // (내가 리턴할 객체가 널일 수 있으니 조심해서 다뤄라)
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if(optionalStudent.isPresent()) {
            // null 이 아니다
            Student student = optionalStudent.get();
            student = student.toBuilder().dreamJob(dreamJob).build();

            Student result = studentRepository.save(student);

            return result;
        } else {
            // null 이다
            return null;
        }

    }

    public void deleteStudent(int id) {
        // 삭제할 대상 행 조회
        // 조회된 객체로 삭제

        Optional<Student> optionalStudent = studentRepository.findById(id);

        if(optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            studentRepository.delete(student);
        }
    }

}
