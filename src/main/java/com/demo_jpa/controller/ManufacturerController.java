package com.demo_jpa.controller;

import com.demo_jpa.entity.Manufacturer;
import com.demo_jpa.entity.Product;
import com.demo_jpa.entity.TelenorFailed;
import com.demo_jpa.entity.TelenorSuccess;
import com.demo_jpa.response.EmptyJsonBody;
import com.demo_jpa.response.ResponseHandler;
import com.demo_jpa.service.ManufactureService;
import com.demo_jpa.service.ProductService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RestController
public class ManufacturerController {
    @Autowired
    private ManufactureService manufactureService;

    @GetMapping("getmanu")
    public ResponseEntity<Object> getManu() {
        List<Manufacturer> products = manufactureService.getManu();
        return ResponseHandler.generateResponse("Success", HttpStatus.OK, products);
    }
    @PostMapping("savemanu")
    public ResponseEntity<Object> saveManu(@RequestBody Manufacturer p) {

        return ResponseHandler.generateResponse("Success", HttpStatus.OK,   manufactureService.addManu(p));
    }

}
