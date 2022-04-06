package com.bootcamp.bootcampmanager.admin;

import java.util.List;

public interface AdminService {

    public List<Admin> getAllAdmins();
    public void saveAdmin(Admin admin);
    public Admin getAdminById(long id);
    public void deleteAdminById(long id);
}
