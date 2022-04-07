package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.ProspectRepository;
import com.example.managementbackend.model.Prospect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProspectService {
    @Autowired
    ProspectRepository prospectRepository;

    public Prospect findUser(String email, String code){

        return prospectRepository.findByEmailAndCode(email,code);
    }
    public Prospect saveNewUser( Prospect prospect){

        return prospectRepository.save(prospect);
    }
    public List<Prospect> getAllNewUsers(){
        return prospectRepository.findAll();

    }
    public Prospect findByEmail(String email)
    {
        return prospectRepository.findByEmail(email);
    }}
