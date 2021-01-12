package br.com.zup.apirestloteria.rest.api.controller;
import br.com.zup.apirestloteria.rest.api.model.UsuarioModel;
import br.com.zup.apirestloteria.rest.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {

    @Autowired
    public final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/usuario/codigo={codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

//    @GetMapping("/api/usuario/login={login}")
//    public String consultaLogin(@PathVariable("login") String login) {
//
//        return repository;
//    }

    public static final String findUserByEmail = "SELECT login FROM usuario WHERE login = +login";


//    @Query
//    public List<Object>

    @GetMapping("/api/usuario")
    public Iterable<UsuarioModel> pesquisar() {
        return repository.findAll();
    }

    @PostMapping("/api/usuario/salvar")
    public UsuarioModel salvar(@RequestBody UsuarioModel usuario) {
        return repository.save(usuario);
    }
}
