package pl.maciejpajak.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.maciejpajak.server.model.Hero;
import pl.maciejpajak.server.repository.HeroRepository;

import java.util.stream.Stream;

@Slf4j
@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
    ApplicationRunner initData(HeroRepository heroRepository) {
        return args -> {
            Stream.of("Superman", "Batman", "Wolverine").forEach(name -> {
                heroRepository.save(new Hero(name));
            });
            heroRepository.findAll().forEach(m -> log.info(m.toString()));
        };
    }
}
