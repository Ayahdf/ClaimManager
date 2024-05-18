package com.example.gestiondesreclamations.web;

import com.example.gestiondesreclamations.dao.entities.Document;
import com.example.gestiondesreclamations.service.implementation.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class DocumentController {

    @Autowired
    public DocumentService documentService;

}
