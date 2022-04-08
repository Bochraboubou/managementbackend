package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.AttachementRepository;
import com.example.managementbackend.Repository.BondeCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachemntService {
    @Autowired
    private AttachementRepository attachementRepo;
}
