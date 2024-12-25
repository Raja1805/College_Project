package org.example.TrustProjects.service;


import org.example.TrustProjects.DTO.ResponseDTO;
import org.example.TrustProjects.IService.IUserService;
import org.example.TrustProjects.Repository.RoleRepository;
import org.example.TrustProjects.Repository.UserRepository;
import org.example.TrustProjects.TrustProject;
import org.example.TrustProjects.entity.Role;
import org.example.TrustProjects.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userDao;

    @Autowired
    private RoleRepository roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    EmailService emailService;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role institutionRole = new Role();
        institutionRole.setRoleName("Institution");
        institutionRole.setRoleDescription("Institution role");
        roleDao.save(institutionRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("user role");
        roleDao.save(userRole);

//        Role managerRole = new Role();
//        managerRole.setRoleName("Manager");
//        managerRole.setRoleDescription("Default role for newly created record");
//        roleDao.save(managerRole);

        User adminUser = new User();
        adminUser.setUserName("Admin");
        adminUser.setUserId("NCVTE001");
        adminUser.setRoleCode("1");
        adminUser.setEmail("lakshinibose090@gmail.com");
        adminUser.setInstitutionName("Viskamix");
        adminUser.setPassword("Admin@123");
        adminUser.setNewPassword(adminUser.getNewPassword());
        adminUser.setActiveStatus(true);
        adminUser.setCreatedDate(new Date());
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

    }

//    public User registerNewUser(User user) {
//        Role role = roleDao.findById("User").get();
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(role);
//        user.setRole(userRoles);
//        user.setPassword((user.getPassword()));
//        User savedUser = userDao.save(user);
//
//        // Send confirmation email
//        String subject = "Welcome to ICVTE";
//        String body = "Dear " + user.getUserName() + ",\n\n"
//                + "Your account has been successfully created.\n"
//                + "Username: " + user.getUserName() + "\n"
//                + "Password: " + user.getPassword() + "\n\n"
//                + "Thank you for registering with us!";
//        emailService.sendSimpleEmail(user.getEmail(), subject, body);
//        return savedUser;
//    }


    public User registerNewUser(User user) throws MessagingException, IOException {
        Role role = roleDao.findById("User").get();
        String text = "<html>Greetings,<br><br>"
                + "We are pleased to inform you that your document verification has been successfully completed!\n\n"
                + "You can now access your account using the credentials provided below:\n\n"
                + "User ID: " + user.getUserName() + "<br>"
                + "Password: " + user.getPassword() + "<br><br>"
                + "Please follow these steps to log in:<br><br>"
                + "1. Visit www.icvte.com.<br>"
                + "2. Click 'Institute Login' on the right top corner.<br>"
                + "3. Enter your User ID and Password.<br><br>"
                + "If you encounter any issues or need assistance, feel free to reach out to us at "
                + "Info@icvte.com or +91 97898 32552. We are here to help!<br><br>"
                + "Welcome aboard, and we look forward to working with you.<br><br>"
                + "Warm regards<br><br>" + "<img width=80 height=80 src=\"cid:image\"></html>";

        DataSource source = new FileDataSource(new File(getClass().getClassLoader().getResource("logo.png").getFile()));


        MimeMultipart multipart = new MimeMultipart("related");

        // first part  (the html)
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(text, "text/html; charset=utf-8");

        // add it
        multipart.addBodyPart(messageBodyPart);
        //System.out.println("fds"+fds.getName());
        messageBodyPart = new MimeBodyPart();
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setHeader("Content-ID", "<image>");

        // add it
        multipart.addBodyPart(messageBodyPart);

        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setPassword((user.getPassword()));
        User savedUser = userDao.save(user);

        // Send confirmation email with updated content
        String subject = "Document Verification Completed - Your User ID & Password";
        emailService.sendSimpleMessage(user.getEmail(), subject, text, multipart);
        return savedUser;
    }


//    public String getEncodedPassword(String password) {
//        return passwordEncoder.encode(password);
//    }


//    @Override
//    public DataListDTO getAllUsers(int pageIndex, int pageSize, String search){
//        DataListDTO result = new DataListDTO();
//        Page<Map<String, Object>> rawResult = userDao.getAllUsers(PageRequest.of(pageIndex,pageSize), Optional.ofNullable(search).orElse(""));
//        if (rawResult != null){
//            result.setData(rawResult.getContent());
//            result.setLength((int)rawResult.getTotalElements());
//        }
//        result.setStatus(true);
//        return  result;
//    }

    @Override
    public ResponseDTO updateUser(User user) {
        ResponseDTO res = new ResponseDTO();
        User updateUser = userDao.getOne(user.getUserId());
        if (user.getRoleCode() != null) {
            updateUser.setRoleCode(user.getRoleCode());
        }

        if (user.getPassword() != null) {
            updateUser.setPassword(user.getPassword());
        }

        if (user.getEmail() != null) {
            updateUser.setEmail(user.getEmail());
        }

        userDao.saveAndFlush(updateUser);
        res.setStatus(true);
        res.setMessage("Update Success");
        return res;
    }


    public User saveUser(User user) {
        user.setActiveStatus(true); // Set the user as active when saved
        user.setCreatedDate(new Date());
        return userDao.save(user);
    }

}









