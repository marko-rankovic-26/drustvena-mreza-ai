package com.forum.diplomski;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiplomskiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiplomskiApplication.class, args);
                // dodati controller za Diskusiju + Komentar!!!!!!!
                // Komentar = slozena struktura (cuva druge komentare)
                // metoda za dodavanje liste komentara u komentar (DEPH = 3)
                // lajkovan je 3 stanja => koristiti Boolean umesto boolean!!!!!!!!
	}

}
