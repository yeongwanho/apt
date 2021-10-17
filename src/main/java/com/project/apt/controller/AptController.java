package com.project.apt.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.apt.entity.Apt;
import com.project.apt.entity.Member;
import com.project.apt.repository.AptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Decoder;
import java.net.URLDecoder;
import java.util.*;

@RestController
@RequiredArgsConstructor
public class AptController {

    private final AptRepository aptRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/api/apt")
    public Page<Apt> searchApt(Pageable pageable,Apt apt,HttpServletRequest request){

        if (!"".equals(apt.getCityL())){
            Page<Apt> apts = aptRepository.searchApt(apt, pageable);
            return aptRepository.searchApt(apt, pageable);
        }

        return aptRepository.searchPage(pageable);
    }
    @PostMapping("/api/apt")
    public Page<Apt> gekk(@RequestBody(required = false) String member2,Pageable pageable) throws JsonProcessingException {

        Apt apt = objectMapper.readValue(member2, Apt.class);

        Page<Apt> apts = aptRepository.searchApt(apt, pageable);
        System.out.println(apts);
        return apts;

    }
    @GetMapping("/api/apt/detail")
    public ResponseEntity<Map<String,Object>> detailApt(@RequestParam("id") Long id,@RequestParam("aptName") String aptNAme){
        Map<String,Object> resultMap= new HashMap<>();
        List<String> apiAptdate=new ArrayList<>();
        List<String> apiAptPrice=new ArrayList<>();
        Apt apt = aptRepository.aptFindById(id);
        List<Apt> apts = aptRepository.aptFindByName(apt.getAptName());
        for (int i=0; i<apts.size();i++){
            apiAptdate.add(apts.get(i).getContractDate());
            apiAptPrice.add(apts.get(i).getPrice().trim().replace(",",""));

        }
        resultMap.put("aptDate",apiAptdate);
        resultMap.put("aptPrice",apiAptPrice);
        resultMap.put("aptName",apt.getAptName());
        HttpStatus status= HttpStatus.OK;

        return new ResponseEntity<Map<String,Object>>(resultMap,status);
        //aptRepository.aptFindById(id);
    }

    public AptRepository getAptRepository() {
        return aptRepository;
    }
}
