package org.example.TrustProjects.Repository;

import org.example.TrustProjects.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ResultRepository extends JpaRepository<Result,Long> {
    Optional<Result> findByEnrollmentNumber(String enrollmentNumber);
}