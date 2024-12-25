package org.example.TrustProjects.controller;

import org.example.TrustProjects.entity.HallTicket;
import org.example.TrustProjects.service.HallTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/halltickets")
public class HallTicketController {

    @Autowired
    private HallTicketService hallTicketService;

    // POST API to create a HallTicket with file upload
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<HallTicket> createHallTicket(
            @RequestParam("rollNo") String rollNo,
            @RequestParam("hallTicket") MultipartFile hallTicketFile) {
        HallTicket createdHallTicket = hallTicketService.createHallTicket(rollNo, hallTicketFile);
        return ResponseEntity.ok(createdHallTicket);
    }

    // GET API to fetch HallTicket by RollNo
    @GetMapping("/{rollNo}")
    public ResponseEntity<HallTicket> getHallTicketByRollNo(@PathVariable String rollNo) {
        HallTicket hallTicket = hallTicketService.getHallTicketByRollNo(rollNo);
        if (hallTicket != null) {
            return ResponseEntity.ok(hallTicket);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // GET API to fetch all HallTickets
    @GetMapping
    public ResponseEntity<List<HallTicket>> getAllHallTickets() {
        List<HallTicket> hallTickets = hallTicketService.getAllHallTickets();
        return ResponseEntity.ok(hallTickets);
    }
}
