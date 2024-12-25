package org.example.TrustProjects.IService;

import org.example.TrustProjects.DTO.DataListDTO;
import org.example.TrustProjects.DTO.ResponseDTO;
import org.example.TrustProjects.entity.Affiliation;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IAffiliationService {
//    DataListDTO getAllAffiliationUsers(int pageIndex, int pageSize, String search);

    List<Affiliation> getAllAffiliationUsers();

    ResponseDTO updateUser(Affiliation affiliation);

    Affiliation saveAffiliationUser(Affiliation user);

    Optional<Affiliation> getUserById(int affiliationId);

//    void setUserIdManually(String userId, String newUserId);

    void uploadDocument(int affiliationId, MultipartFile file, String documentType) throws IOException;
}
