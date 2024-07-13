package com.challenger.alura.FinalChallenger;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinalChallengerApplication {

	public static void main(String[] args) {
//		Flyway flyway = Flyway.configure()
//				.dataSource("jdbc:mysql://localhost/game_api", "root", "1234").load();
//		flyway.repair();

		SpringApplication.run(FinalChallengerApplication.class, args);
	}

}
