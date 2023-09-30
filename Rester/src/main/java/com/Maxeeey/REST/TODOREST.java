package com.Maxeeey.REST;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TODOREST {
	
	@GetMapping(value = "/helloworld")
	public String printHelloWorld() {
		return "Was geht ab Freundin?!";
	}
	
	@GetMapping(value = "/uhrzeiger")
	public String printPatiMessage() {
		return "<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Cool Web Design</title>\r\n"
				+ "    <style>\r\n"
				+ "        body {\r\n"
				+ "            background-color: #f0f0f0;\r\n"
				+ "            font-family: Arial, sans-serif;\r\n"
				+ "            text-align: center;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        .container {\r\n"
				+ "            background-color: #fff;\r\n"
				+ "            border-radius: 10px;\r\n"
				+ "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);\r\n"
				+ "            max-width: 400px;\r\n"
				+ "            margin: 0 auto;\r\n"
				+ "            padding: 20px;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        h1 {\r\n"
				+ "            color: #333;\r\n"
				+ "        }\r\n"
				+ "\r\n"
				+ "        p {\r\n"
				+ "            color: #777;\r\n"
				+ "            font-style: italic;\r\n"
				+ "        }\r\n"
				+ "    </style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <div class=\"container\">\r\n"
				+ "        <h1>Lieber Maxi, wie geht's dir?!</h1>\r\n"
				+ "        <p>Eigentlich brauche ich keine Antwort. Ich weiß, wenn ich hier bin, geht's dir fantastisch! Hab ich Recht oder hab ich Recht? Ich hab immer Recht, merk dir das!</p>\r\n"
				+ "        <p>Jetzt muss ich noch was nettes sagen. Also: Was nettes!</p>\r\n"
				+ "    </div>\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ "";
	}
}
