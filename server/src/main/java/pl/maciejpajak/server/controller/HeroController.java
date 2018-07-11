package pl.maciejpajak.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.maciejpajak.server.model.Hero;
import pl.maciejpajak.server.repository.HeroRepository;

import java.util.List;

/*
    temporary solution to bypass spring rest data hyperlinks
 */
@RestController
@RequestMapping("/api/heroes")
@CrossOrigin(origins = "http://localhost:4200")
public class HeroController {

    @Autowired
    private HeroRepository heroRepository;

    @GetMapping
    public List<Hero> getAllHeroes(@RequestParam(required = false) String name) {
        if (name != null) {
            return heroRepository.findByNameContainingIgnoreCase(name);
        } else {
            return heroRepository.findAll();
        }
    }

    @GetMapping("/{id}")
    public Hero getHeroById(@PathVariable Long id) {
        return heroRepository.findById(id).orElseThrow(() -> new RuntimeException("data not found"));
    }

    @PostMapping
    public Hero createHero(@RequestBody Hero hero) {
        return heroRepository.save(hero);
    }

    @PutMapping
    public Hero updateHero(@RequestBody Hero hero) {
        return heroRepository.save(hero);
    }

    @DeleteMapping("/{id}")
    public void deleteHero(@PathVariable("id") Long id) {
        heroRepository.deleteById(id);
    }


}
