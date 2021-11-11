package ru.netology.manager;

import ru.netology.domain.Playbill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlaybillManager {
    private int recentMovies = 10;
    private Playbill[] movies = new Playbill[0];

    public PlaybillManager(int recentMovies) {
        this.recentMovies = recentMovies;
    }

    public void addMovie(Playbill movie) {
        Playbill[] tmp = new Playbill[movies.length + 1];

        System.arraycopy(movies, 0, tmp, 0, movies.length);
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public void setRecentMovies(int recentMovies) {
        if (recentMovies <= 0) {
            return;
        }
        this.recentMovies = recentMovies;
    }

    public Playbill[] listOfMovies(int recentMovies) {
        int resultLength = 0;
        if (recentMovies < 10) {
            resultLength = recentMovies;
        } else {
            resultLength = 10;
        }

        Playbill[] result = new Playbill[resultLength];
        Playbill[] movies = getMovies();

        for (int i = 0; i < resultLength; i++) {
            int j = movies.length - i - 1;
            result[i] = movies[j];
        }
        return result;
    }
}
