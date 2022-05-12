package br.com.spring.study.springwebmvc.rest;

import br.com.spring.study.springwebmvc.model.Jedi;
import br.com.spring.study.springwebmvc.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class JediResource {

    @Autowired
    private JediService jediService;

    @GetMapping("/api/jedi")
    public List<Jedi> getAllJedi(){
        return jediService.findAll();
    }

    @GetMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<Jedi> getJediById(@PathVariable("id") Long id){
        final Jedi jedi = jediService.findById(id);

        return ResponseEntity.ok(jedi);
    }

    @PostMapping("/api/jedi")
    public Jedi createJedi(@Valid @RequestBody Jedi jedi){
        return jediService.save(jedi);
    }

    @PutMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> updateJedi(@PathVariable("id")Long id, @Valid @RequestBody Jedi jediDto){
        final Jedi jedi =  jediService.update(id, jediDto);

        return ResponseEntity.ok(jedi);
    }

    @DeleteMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteJedi(@PathVariable("id") Long id){
        jediService.delete(id);
    }
}
