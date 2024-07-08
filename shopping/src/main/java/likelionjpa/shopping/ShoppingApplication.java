package likelionjpa.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class ShoppingApplication {
	public static void main(String[] args) {
		Lombok yaaan = new Lombok();
		yaaan.setData("string");
		String data = yaaan.getData();
		System.out.println("hello = "+data);
		SpringApplication.run(ShoppingApplication.class, args);
	}

}