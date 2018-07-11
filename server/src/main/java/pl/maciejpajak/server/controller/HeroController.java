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
    public List<Hero> getAllHeroes() {
        return heroRepository.findAll();
    }

    @PostMapping
    public Hero createHero(Hero hero) {
        return heroRepository.save(hero);
    }

    @PutMapping
    public Hero updateHero(Hero hero) {
        return heroRepository.save(hero);
    }

    @DeleteMapping
    public void deleteHero(Hero hero) {
        heroRepository.delete(hero);
    }


}
