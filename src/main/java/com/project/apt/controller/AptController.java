package com.project.apt.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.apt.dto.AptDtoComment;
import com.project.apt.dto.AptQueryDto;
import com.project.apt.dto.CommentQueryDto;
import com.project.apt.entity.Apt;
import com.project.apt.entity.Comments;
import com.project.apt.repository.AptRepository;
import com.querydsl.core.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequiredArgsConstructor
public class AptController {

    private final AptRepository aptRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/api/apt")
    public Page<AptQueryDto> searchApt(Pageable pageable, Apt apt){

        if (!"".equals(apt.getCityL())){

            return aptRepository.searchApt(apt, pageable);
        }

        return aptRepository.searchPage(pageable);
    }
    @PostMapping("/api/apt")
    public Page<AptQueryDto> gekk(@RequestBody(required = false) String member2,Pageable pageable) throws JsonProcessingException {

        Apt apt = objectMapper.readValue(member2, Apt.class);

        Page<AptQueryDto> apts = aptRepository.searchApt(apt, pageable);
        System.out.println(apts);
        return apts;

    }
    @GetMapping("/api/apt/detail")
    public ResponseEntity<Map<String,Object>> detailApt(@RequestParam("id") Long id,@RequestParam("aptName") String aptNAme){
        Map<String,Object> resultMap= new HashMap<>();
        List<String> apiAptdate=new ArrayList<>();
        List<String> apiAptPrice=new ArrayList<>();

        String aptName = aptRepository.aptFindById(id);
        List<CommentQueryDto> apts = aptRepository.aptFindByName(aptName);
        List<AptDtoComment> comments=null;
        for (int i=0; i<apts.size();i++){
            apiAptdate.add(apts.get(i).getContractDate());
            apiAptPrice.add(apts.get(i).getPrice().trim().replace(",",""));
            if (apts.get(i).getComments()!=null){
                comments = apts.get(i).getComments();}
        }
        resultMap.put("comments",comments);
        resultMap.put("aptDate",apiAptdate);
        resultMap.put("aptPrice",apiAptPrice);
        //resultMap.put("aptName",apt.getAptName());
        HttpStatus status= HttpStatus.OK;

        return new ResponseEntity<Map<String,Object>>(resultMap,status);
        //aptRepository.aptFindById(id);
    }


    public AptRepository getAptRepository() {
        return aptRepository;
    }
}
