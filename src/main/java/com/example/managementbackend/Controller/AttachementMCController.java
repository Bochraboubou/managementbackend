package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.AttachementMCRepository;
import com.example.managementbackend.Service.AttachementMCService;
import com.example.managementbackend.Service.AttachemntService;
import com.example.managementbackend.model.Attachement;
import com.example.managementbackend.model.AttachementMC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admin")
@RestController
public class AttachementMCController {
    @Autowired
    private AttachementMCService attachementMCService;


    @GetMapping("/getAllMCAttachement")
    public List<AttachementMC> getAllAttachemntMC(){
      return  attachementMCService.getAll();
    }
    @GetMapping("/getBYCode/{code}")
    public AttachementMC getAttachementMCBucode(@PathVariable String code ){
        return  attachementMCService.getByCode(code);
    }

    @PostMapping("/ordreTraveaux/{ordreTraveauxId}/attachementMC")
    public AttachementMC createAttachementMC(@PathVariable(value = "ordreTraveauxId") Long ordreTraveauxId,
                                             @Valid @RequestBody AttachementMC attachementMC) {
        return attachementMCService.create(ordreTraveauxId,attachementMC);
    }
}
