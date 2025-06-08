package com.lions_internationals.service.impl;

import com.lions_internationals.repository.AdminRepository;
import com.lions_internationals.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }


}
