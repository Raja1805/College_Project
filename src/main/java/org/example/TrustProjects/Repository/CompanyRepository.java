package org.example.TrustProjects.Repository;

import org.example.TrustProjects.entity.Company;
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

public interface CompanyRepository extends JpaRepository<Company,String> {

    @Query(value = "Select c.company_code as companyCode,c.company_name as companyName,\n" +
            "c.status as status , c.created_date as createdDate from Company as c \n"+
            "where (:search is null or :search = '' or company_code Like %:search% or company_name Like %:search% \n" +
            "or c.status Like %:search% or c.created_date Like %:search%)",
            countQuery = "Select count(c.company_code) from Company as c "+
                    "where (:search is null or search = '' or company_code Like %:search% or company_name Like %:search% \n" +
                    "or c.status Like %:search% or c.created_date Like %:search%)",nativeQuery = true)
    Page<Map<String,Object>> getAllCompany(Pageable pageable, @Param("search") String search);
}
