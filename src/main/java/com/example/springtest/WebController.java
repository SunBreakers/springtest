package com.example.springtest;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController implements WebMvcConfigurer {
	
	@GetMapping("/movies")
	public String movies(@RequestParam(name="liked", required=false)String movies, Model model) {
        Random random = new Random();
        int randomMovie = random.nextInt(812104) + 1;
        parseMovies m = new parseMovies();
        m.setMovie(randomMovie);

        model.addAttribute("poster_path", "https://www.themoviedb.org/t/p/w300_and_h450_bestv2" + m.getPosterPath());
        model.addAttribute("movieTitle", m.getTitle());
        model.addAttribute("movieOverview", m.getOverview());
        model.addAttribute("movieGenres", m.getGenres());
        model.addAttribute("movieRuntime", m.getRuntime());
        model.addAttribute("movieReleaseDate", m.getReleaseDate());
        model.addAttribute("movieVoteAverage", m.getVoteAverage());
        model.addAttribute("movieVoteCount", m.getVoteCount());
        model.addAttribute("imdb_id", "https://www.imdb.com/title/" + m.getIMDB_ID() + "/");
        // model.addAttribute("movieRecommendations", parseMovies.movieRecommendations);
        // model.addAttribute("movieVideo", parseMovies.movieVideo);
        System.out.println("Total movies tested: " + parseMovies.totalMoviesTested);
        System.out.println("Showing movie: (" + m.getID() + ") " + m.getTitle() + " on the /movies page\n");
		return "movies";
	}

    @RequestMapping("/AmazonCognito")
    public ModelAndView AmazonCognito () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logout.html");
        return modelAndView;
    }

    // @Override
    // public void addViewControllers(ViewControllerRegistry registry) {
    //     registry.addViewController("/").setViewName("home");
    // }
}