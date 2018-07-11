package pl.maciejpajak.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.maciejpajak.server.model.Manufacturer;
import pl.maciejpajak.server.repository.ManufacturerRepository;

import java.util.stream.Stream;

@Slf4j
@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
    ApplicationRunner initData(ManufacturerRepository manufacturerRepository) {
        return args -> {
            Stream.of("Avon", "Palmer's", "Nivea").forEach(name -> {
                Manufacturer manufacturer = new Manufacturer(name);
                manufacturerRepository.save(manufacturer);
            });
            manufacturerRepository.findAll().forEach(m -> log.info(m.toString()));
        };
    }
}
