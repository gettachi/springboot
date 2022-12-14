package com.example.springboot.web;

import com.example.springboot.persistence.model.ExtractDTO;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@CrossOrigin
@RequestMapping("/extractdata")
public class ReadDataImageController {

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
    @GetMapping("")
    public String homePage(Model model) {

        return "/jsp/index";
    }


    @PostMapping(value = "/prosess")
    @ResponseBody
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile files) throws IOException {

      // ClassLoader classLoader = new ReadFile().getClass().getClassLoader();

      ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        StringBuilder fileNames = new StringBuilder();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, files.getOriginalFilename());
        fileNames.append(files.getOriginalFilename());
        Files.write(fileNameAndPath, files.getBytes());


      File file = new File(String.valueOf(fileNameAndPath));
        files.transferTo(file);
      ITesseract instance = new Tesseract();  // JNA Interface Mapping
      // ITesseract instance = new Tesseract1(); // JNA Direct Mapping
      instance.setDatapath("tessdata"); // path to tessdata directory
      String result ="";
      try {
           result = instance.doOCR(file);
           System.out.println(result);
      } catch (TesseractException e) {
          System.out.println(e.getMessage());
      }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
