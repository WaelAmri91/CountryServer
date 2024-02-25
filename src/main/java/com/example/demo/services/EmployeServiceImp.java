package com.example.demo.services;

import com.example.demo.Dto.AddEmployeRequest;
import com.example.demo.entities.Employe;
import com.example.demo.repositories.DepartementRepository;
import com.example.demo.repositories.EmployeRepository;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class EmployeServiceImp implements EmployeService {
    @Autowired
    EmployeRepository employeRepository;
    private static final String UPLOADED_FOLDER = "uploads/";
    @Autowired
    DepartementRepository departementRepository;

    @Override
    public List<Employe> GetEmployes(){return (List<Employe>) employeRepository.findAll();}
    @Override
    public Employe GetEmploye(long employeId){return employeRepository.findById(employeId).orElse(null);}


    @Override
        public Employe AddEmploye (AddEmployeRequest request) {
             Employe employe=new Employe();
                    employe.setTitle(request.getTitle());
             employe.setEmpNum(request.getEmpNum());

            if(request.getDepartementId() != null)
                employe.setDepartement(departementRepository.findById(request.getDepartementId()).orElse(null));
            return employeRepository.save(employe);
       }
         @Override
        public Employe EditEmploye(long employeId, AddEmployeRequest request) {
            Employe employe=employeRepository.findById(employeId).orElse(null);
                   if(employe != null){
                      employe.setTitle(request.getTitle());
                       employe.setEmpNum(request.getEmpNum());
                        employe.setDepartement(departementRepository.findById(request.getDepartementId()).orElse(null));
                        if(request.getDepartementId() != null)
                            employe.setDepartement(departementRepository.findById(request.getDepartementId()).orElse(null));
                        return employeRepository.save(employe);
                   }
                   return null;
        }
    @Override
    public void DeleteEmploye(long employeId) {
        employeRepository.deleteById(employeId);
    }

    @Override
    public Employe addFile(MultipartFile multipartFile, Long employeId) {

        if(multipartFile!= null) {
            Employe employe = employeRepository.findById(employeId).get();


            try {
                Path uploadPath = Paths.get(UPLOADED_FOLDER).toAbsolutePath().normalize();
                Files.createDirectories(uploadPath);

                String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
                String fileExtension = FilenameUtils.getExtension(fileName);
                UUID randomUUID = UUID.randomUUID();
                fileName = randomUUID + "." + fileExtension;
                Path filePath = uploadPath.resolve(fileName);

                Files.write(filePath, multipartFile.getBytes(), StandardOpenOption.CREATE);

                employe.setFileName(fileName);

              return   employeRepository.save(employe);


            } catch (IOException e) {
                throw new RuntimeException(e);
            }



        }


        return null;

    }

    @Override
    public ResponseEntity<byte[]> retrieveFile(Long employeId) throws IOException {

        Employe employe= employeRepository.findById(employeId).get();
        String fileName = employe.getFileName();
        File file = new File(UPLOADED_FOLDER + fileName);
        byte[] fileBytes = FileUtils.readFileToByteArray(file);
        if (fileBytes == null) {
            return ResponseEntity.notFound().build();
        }
        String extension = FilenameUtils.getExtension(fileName);
        MediaType mediaType = null;

        switch (extension.toLowerCase()) {
            case "pdf":
                mediaType = MediaType.APPLICATION_PDF;
                break;
            case "doc":
            case "docx":
                mediaType = MediaType.valueOf("application/msword");
                break;
            case "xls":
            case "xlsx":
                mediaType = MediaType.valueOf("application/vnd.ms-excel");
                break;
            case "ppt":
            case "pptx":
                mediaType = MediaType.valueOf("application/vnd.ms-powerpoint");
                break;
            case "jpg":
            case "jpeg":
                mediaType = MediaType.IMAGE_JPEG;
                break;
            case "png":
                mediaType = MediaType.IMAGE_PNG;
                break;
            case "gif":
                mediaType = MediaType.IMAGE_GIF;
                break;
            case "mp4":
                mediaType = MediaType.valueOf("video/mp4");
                break;
            case "txt":
                mediaType = MediaType.TEXT_PLAIN;
                break;
            default:
                mediaType = MediaType.APPLICATION_OCTET_STREAM;
                break;
        }

        return ResponseEntity.ok()
                .contentType(mediaType)
                .body(fileBytes);
    }



}
