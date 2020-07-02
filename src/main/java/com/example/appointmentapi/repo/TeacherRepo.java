package com.example.appointmentapi.repo;

import com.example.appointmentapi.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
}
