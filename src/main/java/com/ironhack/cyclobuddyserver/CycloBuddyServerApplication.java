package com.ironhack.cyclobuddyserver;

import com.ironhack.cyclobuddyserver.DTO.RideDTO;
import com.ironhack.cyclobuddyserver.model.Route;
import com.ironhack.cyclobuddyserver.model.User;
import com.ironhack.cyclobuddyserver.service.impl.RideService;
import com.ironhack.cyclobuddyserver.service.impl.RouteService;
import com.ironhack.cyclobuddyserver.service.impl.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

//swagger is being used for better back-end documentation
@SpringBootApplication
@EnableSwagger2
public class CycloBuddyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CycloBuddyServerApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebMvcConfigurer crossConfigure() {
        return new WebMvcConfigurer() {
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods(new String[]{"*"}).allowedOrigins(new String[]{"http://localhost:3000"});
            }
        };
    }

    //pre-set data for the presentation
    @Bean
    CommandLineRunner run(UserService userService, RideService rideService, RouteService routeService) {
        return args -> {

            //creating users
            //String city, String bicycleType, Integer averageSpeed, Integer averageKmPerMonth
            userService.saveUser(new User("Laura", "laura@gmail.com", "P@sw0rd"));
            userService.saveUser(new User("Edita", "edita@gmail.com", "P@sw0rd"));
            userService.saveUser(new User("Lina", "lina@gmail.com", "P@sw0rd"));
            userService.saveUser(new User("Germantas", "germantas@gmail.com", "P@sw0rd"));
            userService.saveUser(new User("Lukas", "lukas@gmail.com", "P@sw0rd"));


            //Laura´s rides
            rideService.saveRide(new RideDTO(LocalDateTime.of(2022, 7, 1, 18, 30), "Barruera Plaza Mayor", "Barruera", "Good option if you are used to steep cycling climbs.", 1, "https://images.pexels.com/photos/7099142/pexels-photo-7099142.png?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", new Route(50, 1300, 160, "Barruera Camping", "MonCafe", "gravel", 1)));
            rideService.saveRide(new RideDTO(LocalDateTime.of(2022, 6, 28, 19, 15), "Barruera Church", "Barruera", "Nice scenery with some physical effort needed", 1, "https://images.pexels.com/photos/6929302/pexels-photo-6929302.png?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", new Route(18, 500, 60, "Barruera", "Barruera", "gravel", 3)));

            //Edita´s rides
            rideService.saveRide(new RideDTO(LocalDateTime.of(2022, 8, 1, 9, 00), "Mitchigan Lake Cafe", "Chicago", "A nice ride on the lake shore is waiting for you.", 2, "https://images.pexels.com/photos/5851028/pexels-photo-5851028.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", new Route(70, 120, 240, "Cafe Parking", "Cafe Parking", "MTB", 4)));

            //Lina´s rides
            rideService.saveRide(new RideDTO(LocalDateTime.of(2022, 6, 29, 10, 00), "Klaipeda Port Parking", "Klaipeda", "Easy going ride with sea views and no rush", 3,"https://images.pexels.com/photos/5851016/pexels-photo-5851016.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", new Route(30, 100, 180, "Ferry terminal", "Klaipeda Port Parking", "gravel", 5)));
            rideService.saveRide(new RideDTO(LocalDateTime.of(2022, 7, 13, 16, 15), "Ferry terminal", "Klaipeda", "it's gonna be a nice slow city ride.", 3, "https://images.pexels.com/photos/6929301/pexels-photo-6929301.png?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", new Route(15, 20, 60, "Klaipeda Port", "Klaipeda Train Station", "city", 6)));
            rideService.saveRide(new RideDTO(LocalDateTime.of(2022, 6, 18, 12, 00), "Parking de Valle Perdido", "Murcia", "Ride in the forest with nice mountain views, that´s gonna be fun!", 3, "https://images.pexels.com/photos/5851035/pexels-photo-5851035.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", new Route(20, 300, 150, "Parking", "Parking", "MTB", 7)));
            //Germantas rides
            rideService.saveRide(new RideDTO(LocalDateTime.of(2022, 7, 1, 19, 00), "Gedminu School", "Klaipeda", "A workout, be ready to go fast, minimum 25km/h", 4, "https://images.pexels.com/photos/5851018/pexels-photo-5851018.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1", new Route(50, 100, 120, "Klaipeda City center", "Siauliai", "road", 8)));
            rideService.saveRide(new RideDTO(LocalDateTime.of(2022, 8, 12, 13, 15), "Pumptrack", "Klaipeda", "Short but intensive ride", 4, "https://images.pexels.com/photos/7099170/pexels-photo-7099170.png?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" ,new Route(25, 200, 45, "Klaipeda City center", "Klaipeda City center", "road", 9)));
            //Lucas rides
            rideService.saveRide(new RideDTO(LocalDateTime.of(2022, 2, 15, 15, 00), "Vilnius Train Station", "Vilnius", "Long distance, no rush.", 5, "https://images.pexels.com/photos/7099145/pexels-photo-7099145.png?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" ,new Route(120, 450, 60, "Vilnius", "Trakai", "road", 10)));

        };
    }

}
