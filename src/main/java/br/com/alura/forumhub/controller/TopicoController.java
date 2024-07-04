package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.model.Topico;
import br.com.alura.forumhub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public ResponseEntity<Topico> criar(@RequestBody @Valid Topico topico) {
        repository.save(topico);
        URI uri = URI.create("/topicos/" + topico.getId());
        return ResponseEntity.created(uri).body(topico);
    }

    @GetMapping
    public List<Topico> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> detalhar(@PathVariable Long id) {
        return repository.findById(id)
                .map(topico -> ResponseEntity.ok(topico))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> atualizar(@PathVariable Long id, @RequestBody @Valid Topico topico) {
        return repository.findById(id)
                .map(existingTopico -> {
                    existingTopico.setTitulo(topico.getTitulo());
                    existingTopico.setMensagem(topico.getMensagem());
                    repository.save(existingTopico);
                    return ResponseEntity.ok(existingTopico);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
