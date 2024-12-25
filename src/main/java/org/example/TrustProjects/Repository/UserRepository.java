package org.example.TrustProjects.Repository;


import org.example.TrustProjects.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Map;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, String> {


    User findByEmail(String email);

    Optional<User> findByUserName(String username);

    @Query(value = "select * from User where user_name = :userName " , nativeQuery = true)
    User findByUsername(@Param("userName") String userName);



//    @Query(value = "SELECT u.user_id AS userId, u.user_name AS userName, u.role_code AS roleCode, u.email AS email, " +
//            "u.applicant_name AS applicantName, u.mobile_number AS mobileNumber, u.alternative_number AS alternativeNumber, " +
//            "u.password AS password, u.otp AS otp, u.new_password AS newPassword, u.permanent_address AS permanentAddress, " +
//            "u.city AS city, u.state AS state, u.postal_code AS postalCode, u.website AS website, u.postal_address AS postalAddress, " +
//            "u.sector AS sector, u.active_status AS activeStatus, u.created_date AS createdDate, u.updated_date AS updatedDate,u.courses AS courses " +
//            "FROM user AS u " +
//            "WHERE (:search IS NULL OR :search = '' OR u.user_id LIKE %:search% OR u.user_name LIKE %:search% " +
//            "OR u.role_code LIKE %:search% OR u.email LIKE %:search% OR u.applicant_name LIKE %:search% " +
//            "OR u.mobile_number LIKE %:search% OR u.alternative_number LIKE %:search% OR u.password LIKE %:search% " +
//            "OR u.otp LIKE %:search% OR u.new_password LIKE %:search% OR u.permanent_address LIKE %:search% " +
//            "OR u.city LIKE %:search% OR u.state LIKE %:search% OR u.postal_code LIKE %:search% OR u.website LIKE %:search% " +
//            "OR u.postal_address LIKE %:search% OR u.sector LIKE %:search% OR u.active_status LIKE %:search% " +
//            "OR u.created_date LIKE %:search% OR u.updated_date LIKE %:search% OR u.courses LIKE %:search%)",
//            countQuery = "SELECT COUNT(u.user_id) FROM user AS u " +
//                    "WHERE (:search IS NULL OR :search = '' OR u.user_id LIKE %:search% OR u.user_name LIKE %:search% " +
//                    "OR u.role_code LIKE %:search% OR u.email LIKE %:search% OR u.applicant_name LIKE %:search% " +
//                    "OR u.mobile_number LIKE %:search% OR u.alternative_number LIKE %:search% OR u.password LIKE %:search% " +
//                    "OR u.otp LIKE %:search% OR u.new_password LIKE %:search% OR u.permanent_address LIKE %:search% " +
//                    "OR u.city LIKE %:search% OR u.state LIKE %:search% OR u.postal_code LIKE %:search% OR u.website LIKE %:search% " +
//                    "OR u.postal_address LIKE %:search% OR u.sector LIKE %:search% OR u.active_status LIKE %:search% " +
//                    "OR u.created_date LIKE %:search% OR u.updated_date LIKE %:search% OR u.courses LIKE %:search%)",
//            nativeQuery = true)
//    Page<Map<String, Object>> getAllUsers(Pageable pageable, @Param("search") String search);



}
