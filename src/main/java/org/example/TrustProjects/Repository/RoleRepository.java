package org.example.TrustProjects.Repository;


import org.example.TrustProjects.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Map;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, String> {

    @Query(value = "Select r.role_code as roleCode,r.role_name as roleName,\n" +
            " r.role_description as roleDescription from role as r \n"+
            "where (:search is null or :search = '' or role_code Like %:search% or role_name Like %:search% \n" +
            "or r.role_description Like %:search%)",
            countQuery = "Select count(r.role_code) from Role as r "+
                    "where (:search is null or :search = '' or role_code Like %:search% or role_name Like %:search% \n" +
                    "or r.role_description Like %:search%)",nativeQuery = true)
    Page<Map<String,Object>> getAllRole(Pageable pageable, @Param("search") String search);



}
