package com.example.Demomongo.web.rest;
import com.example.Demomongo.entity.DocgiaEntity;
import com.example.Demomongo.repository.DocgiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/")
public class DocgiaResource {

    @Autowired
    DocgiaRepository docgiaRepository;
    @GetMapping("/docgia")
    public ResponseEntity<List<DocgiaEntity>> getalldocgia(){
        return new ResponseEntity<>(docgiaRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/docgia")
    public ResponseEntity<DocgiaEntity> saveDocgia(@Validated @RequestBody DocgiaEntity docgia){
        return ResponseEntity.ok(docgiaRepository.save(docgia));
    }
    @PutMapping("/docgia/{id}")
    public ResponseEntity<DocgiaEntity> updateDocgia(@PathVariable(value = "id") String docgiaId, @Validated @RequestBody DocgiaEntity docgia){
        Optional<DocgiaEntity> docgia1 = docgiaRepository.findById(docgiaId);

        if(!docgia1.isPresent()){
            return ResponseEntity.notFound().build();
        }
        docgia.setId(docgiaId);
        return ResponseEntity.ok(docgiaRepository.save(docgia));
    }
    @DeleteMapping("/docgia/{id}")
    public ResponseEntity<String> deleteDocgia(@PathVariable(value = "id") String docgiaId){
        Optional<DocgiaEntity> docgiadel = docgiaRepository.findById(docgiaId);
        if(!docgiadel.isPresent()){
            return ResponseEntity.notFound().build();
        }
        docgiaRepository.delete(docgiadel.get());
        return ResponseEntity.ok(docgiaId.toString());
    }

}
