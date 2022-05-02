package ru.fedorov.exam.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fedorov.exam.model.CaptchaCode;

@Repository
public interface CaptchaRepository extends JpaRepository<CaptchaCode, Integer> {
}
