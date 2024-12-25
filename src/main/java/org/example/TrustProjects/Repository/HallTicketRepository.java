package org.example.TrustProjects.Repository;

import org.example.TrustProjects.entity.HallTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallTicketRepository extends JpaRepository<HallTicket, Long> {
    HallTicket findByRollNo(String rollNo);
}
