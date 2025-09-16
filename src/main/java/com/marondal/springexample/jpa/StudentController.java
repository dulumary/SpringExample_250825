package com.marondal.springexample.jpa;

import com.marondal.springexample.jpa.domain.Student;
import com.marondal.springexample.jpa.repository.StudentRepository;
import com.marondal.springexample.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 경고!!!!
    // 절대 컨트롤러에서는 Repository 객체 사용 금지!!!
    // JPA 수업 편의를 위해서 임시로 사용
    @Autowired
    private StudentRepository studentRepository;

    @ResponseBody
    @GetMapping("/add")
    public Student addStudent() {
        // 김인규, 010-1234-5678, lecture@hagulu.com, 개발자
        Student student = studentService.createStudent("김인규", "010-1234-5678", "lecture@hagulu.com", "개발자");

        return student;
    }

    @ResponseBody
    @GetMapping("/modify")
    public Student modifyStudent() {
        // id가 3인 학생 장래희망 강사로 변경
        Student student = studentService.updateStudent(3, "강사");

        return student;
    }


    @ResponseBody
    @GetMapping("/remove")
    public String  removeStudent() {
        // id가 3인 행 삭제
        studentService.deleteStudent(3);

        return "삭제!!";
    }

    @ResponseBody
    @GetMapping("/find")
    public List<Student> findStudent() {

        List<Student> studentList = null;
        // 모든 행 조회
//        List<Student> studentList = studentRepository.findAll();

//        studentList = studentRepository.findByName("김인규");

//        studentList = studentRepository.findByOrderByIdDesc();
//        studentList = studentRepository.findTop2ByNameOrderByIdDesc("김인규");

//        List<String> nameList = new ArrayList<>();
//        nameList.add("유재석");
//        nameList.add("조세호");
//
//        studentList = studentRepository.findByNameIn(nameList);
//        studentList = studentRepository.findByEmailContaining("gmail.com");
        studentList = studentRepository.selectByDreamJob("개발자");

        return studentList;
    }




    @ResponseBody
    @GetMapping("/lombok")
    public Student lombokTest() {

//        Student student = new Student(3, "김인규", "010-1111-2222", "lecture@hagulu.com", "개발자", null, null);

        // builder 패턴
        Student student = Student.builder()
                .name("김인규")
                .email("lecture@hagulu.com")
                .phoneNumber("010-1111-2222")
                .build();

        return student;
    }
}
