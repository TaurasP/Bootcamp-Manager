package com.bootcamp.bootcampmanager.admin;

import com.bootcamp.bootcampmanager.lecturer.Lecturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImp implements AdminService{

    @Autowired
    private AdminRepository adminRepository;


    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public void saveAdmin(Admin admin) {
        this.adminRepository.save(admin);
    }

    @Override
    public Admin getAdminById(long id) {
        Optional<Admin> optional = adminRepository.findById(id);
        Admin admin;
        if (optional.isPresent()) {
            admin = optional.get();
        } else {
            throw new RuntimeException("Not found admin: " + id);
        }
        return admin;
    }

    @Override
    public void deleteAdminById(long id) {
        this.adminRepository.deleteById(id);
    }
}
