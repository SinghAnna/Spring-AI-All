package edu.anant.ai;


import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AiService {


    private final ChatClient chatClient;


    public String generate(String userPrompt) {

        return chatClient
                .prompt()
                .user(userPrompt)
                .call()
                .content();

    }


    public String generateStuffData(String userPrompt){

        String systemPrompt = """
				If you're asked about abhishekvermaa10 YouTube channel, here is some information to help you with your response:
				[
				    {
				        "playlist_name": "Java Basics",
				        "pre-requiste playlist": [],
				        "next_playlist": [
				            "Java Advanced",
				            "Java Database Connectivity (JDBC)",
				            "Maven",
				            "Hibernate",
				            "Spring Basics with Spring Boot",
				            "Spring Data JPA with Spring Boot",
				            "Spring REST with Spring Boot",
				            "Spring AI with Spring Boot",
				            "Spring Microservices with Spring Boot"
				        ],
				        "playlist_link": null
				    },
				    {
				        "playlist_name": "Java Advanced",
				        "pre-requiste playlist": [
				            "Java Basics"
				        ],
				        "next_playlist": [
				            "Java Database Connectivity (JDBC)",
				            "Maven",
				            "Hibernate",
				            "Spring Basics with Spring Boot",
				            "Spring Data JPA with Spring Boot",
				            "Spring REST with Spring Boot",
				            "Spring AI with Spring Boot",
				            "Spring Microservices with Spring Boot"
				        ],
				        "playlist_link": "https://www.youtube.com/playlist?list=PLJDwhlqmpSfP5xBfI-41j3gNZ6GAsrxD-"
				    },
				    {
				        "playlist_name": "Java Database Connectivity (JDBC)",
				        "pre-requiste playlist": [
				            "Java Basics",
				            "Java Advanced"
				        ],
				        "next_playlist": [
				            "Maven",
				            "Hibernate",
				            "Spring Basics with Spring Boot",
				            "Spring Data JPA with Spring Boot",
				            "Spring REST with Spring Boot",
				            "Spring AI with Spring Boot",
				            "Spring Microservices with Spring Boot"
				        ],
				        "playlist_link": "https://www.youtube.com/playlist?list=PLJDwhlqmpSfP1FroiBGc7N3-r67VaEp0V"
				    },
				    {
				        "playlist_name": "Maven",
				        "pre-requiste playlist": [
				            "Java Basics",
				            "Java Advanced",
				            "Java Database Connectivity (JDBC)"
				        ],
				        "next_playlist": [
				            "Hibernate",
				            "Spring Basics with Spring Boot",
				            "Spring Data JPA with Spring Boot",
				            "Spring REST with Spring Boot",
				            "Spring AI with Spring Boot",
				            "Spring Microservices with Spring Boot"
				        ],
				        "playlist_link": "https://www.youtube.com/playlist?list=PLJDwhlqmpSfMNgiOg0xyg4hVsPcJUh4jE"
				    },
				    {
				        "playlist_name": "Hibernate",
				        "pre-requiste playlist": [
				            "Java Basics",
				            "Java Advanced",
				            "Java Database Connectivity (JDBC)",
				            "Maven"
				        ],
				        "next_playlist": [
				            "Spring Basics with Spring Boot",
				            "Spring Data JPA with Spring Boot",
				            "Spring REST with Spring Boot",
				            "Spring AI with Spring Boot",
				            "Spring Microservices with Spring Boot"
				        ],
				        "playlist_link": "https://www.youtube.com/playlist?list=PLJDwhlqmpSfNYPqMMqNj7DXl41fnTVJuY"
				    },
				    {
				        "playlist_name": "Spring Basics with Spring Boot",
				        "pre-requiste playlist": [
				            "Java Basics",
				            "Java Advanced",
				            "Java Database Connectivity (JDBC)",
				            "Maven",
				            "Hibernate"
				        ],
				        "next_playlist": [
				            "Spring Data JPA with Spring Boot",
				            "Spring REST with Spring Boot",
				            "Spring AI with Spring Boot",
				            "Spring Microservices with Spring Boot"
				        ],
				        "playlist_link": "https://www.youtube.com/playlist?list=PLJDwhlqmpSfO7BUlQk_di-86igrzgnsGo"
				    },
				    {
				        "playlist_name": "Spring Data JPA with Spring Boot",
				        "pre-requiste playlist": [
				            "Java Basics",
				            "Java Advanced",
				            "Java Database Connectivity (JDBC)",
				            "Maven",
				            "Hibernate",
				            "Spring Basics with Spring Boot"
				        ],
				        "next_playlist": [
				            "Spring REST with Spring Boot",
				            "Spring AI with Spring Boot",
				            "Spring Microservices with Spring Boot"
				        ],
				        "playlist_link": "https://www.youtube.com/playlist?list=PLJDwhlqmpSfPUg7_jffHmF_6MooTlH7rO"
				    },
				    {
				        "playlist_name": "Spring REST with Spring Boot",
				        "pre-requiste playlist": [
				            "Java Basics",
				            "Java Advanced",
				            "Java Database Connectivity (JDBC)",
				            "Maven",
				            "Hibernate",
				            "Spring Basics with Spring Boot",
				            "Spring Data JPA with Spring Boot"
				        ],
				        "next_playlist": [
				            "Spring AI with Spring Boot",
				            "Spring Microservices with Spring Boot"
				        ],
				        "playlist_link": "https://www.youtube.com/playlist?list=PLJDwhlqmpSfM7NmtpvG5tR5TyYctS6yCA"
				    },
				    ,
				    {
				        "playlist_name": "Spring AI with Spring Boot",
				        "pre-requiste playlist": [
				            "Java Basics",
				            "Java Advanced",
				            "Java Database Connectivity (JDBC)",
				            "Maven",
				            "Hibernate",
				            "Spring Basics with Spring Boot",
				            "Spring Data JPA with Spring Boot",
				            "Spring REST with Spring Boot"
				        ],
				        "next_playlist": [
				            "Spring Microservices with Spring Boot"
				        ],
				        "playlist_link": "https://www.youtube.com/playlist?list=PLJDwhlqmpSfOTU8G_KcVIDe1gJYHAB8nT"
				    },
				    {
				        "playlist_name": "Spring Microservices with Spring Boot",
				        "pre-requiste playlist": [
				            "Java Basics",
				            "Java Advanced",
				            "Java Database Connectivity (JDBC)",
				            "Maven",
				            "Hibernate",
				            "Spring Basics with Spring Boot",
				            "Spring Data JPA with Spring Boot",
				            "Spring REST with Spring Boot",
				            "Spring AI with Spring Boot"
				        ],
				        "next_playlist": [],
				        "playlist_link": null
				    },
				    {
				        "playlist_name": "Emailing by Java",
				        "pre-requiste playlist": [
				            "Java Basics",
				            "Java Advanced",
				            "Maven",
				            "Spring Basics with Spring Boot",
				            "Spring REST with Spring Boot"
				        ],
				        "next_playlist": [],
				        "playlist_link": "https://www.youtube.com/playlist?list=PLJDwhlqmpSfNPdTXdns60uAtJRoOtjgOs"
				    }
				],
				{
				"youtube": "https://www.youtube.com/@abhishekvermaa10",
				"linkedin": "https://www.linkedin.com/in/abhishekvermaa10",
				"instagram": "https://www.instagram.com/abhishekvermaa10",
				"github": "https://github.com/abhishekvermaa10",
				"x": "https://x.com/ytabhishekverma"
				"topmate": "https://topmate.io/abhishekvermaa10",
				"website": "https://abhishekvermaa10.github.io"
				}
				""";

            return chatClient.prompt()
                    .system(systemPrompt)
                    .user(userPrompt)
                    .call()
                    .content();

    }



	public String generateSupport(String userPrompt){
		String systemPrompt = """
				You are a customer service assistant for Abhishek Verma YouTube channel, viewers can find learning videos related to Java and Spring Boot on this channel for FREE.
								You can ONLY discuss:
								- About videos and playlists on channel
								- Java and Spring Boot topics
								- General career doubts
								If asked about anything else, respond: "I can only help with Abhishek Verma YouTube channel."
								{
								"youtube": "https://www.youtube.com/@abhishekvermaa10",
								"linkedin": "https://www.linkedin.com/in/abhishekvermaa10",
								"instagram": "https://www.instagram.com/abhishekvermaa10",
								"github": "https://github.com/abhishekvermaa10",
								"x": "https://x.com/ytabhishekverma"
								"topmate": "https://topmate.io/abhishekvermaa10",
								"website": "https://abhishekvermaa10.github.io"
								}
				""";

			return chatClient.prompt()
					.system(systemPrompt)
					.user(userPrompt)
					.call()
					.content();
	}
}
