package org.example.TrustProjects.service;

import org.example.TrustProjects.entity.HallTicket;
import org.example.TrustProjects.Repository.HallTicketRepository; // Ensure correct casing for 'repository'
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class HallTicketService {

    @Autowired
    private HallTicketRepository hallTicketRepository;

    public HallTicket createHallTicket(String rollNo, MultipartFile hallTicketFile) {
        HallTicket hallTicket = new HallTicket();
        hallTicket.setRollNo(rollNo);

        try {
            hallTicket.setHallTicket(hallTicketFile.getBytes()); // Save file bytes
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception as needed
        }

        return hallTicketRepository.save(hallTicket);
    }

    public HallTicket getHallTicketByRollNo(String rollNo) {
        return hallTicketRepository.findByRollNo(rollNo);
    }

    public List<HallTicket> getAllHallTickets() {
        return hallTicketRepository.findAll();
    }
}
