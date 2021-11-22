package ru.netology.main;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Playbill;
import ru.netology.manager.PlaybillManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaybillManagerTest {

    // setRecentMovies

    @Test
    public void shouldSetRecentMovies() {
        PlaybillManager manager = new PlaybillManager();
        manager.setRecentMovies(4);
        int expected = 4;
        int actual = manager.getRecentMovies();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetRecentMoviesUnderMin() {
        PlaybillManager manager = new PlaybillManager();
        manager.setRecentMovies(-1);
        int expected = 10;
        int actual = manager.getRecentMovies();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSetRecentMoviesNull() {
        PlaybillManager manager = new PlaybillManager();
        manager.setRecentMovies(0);
        int expected = 10;
        int actual = manager.getRecentMovies();
        assertEquals(expected, actual);
    }

    // addMovie

    @Test
    public void shouldAddMovie() {
        PlaybillManager manager = new PlaybillManager();

        Playbill one = new Playbill("MovieOne");
        Playbill two = new Playbill("MovieTwo");
        Playbill three = new Playbill("MovieTree");

        manager.addMovie(one);
        manager.addMovie(three);
        manager.addMovie(two);

        assertArrayEquals(manager.getMovies(), new Playbill[]{one, three, two});
    }

    // listOfMovies

    @Test
    public void shouldListOfMovies() {
        PlaybillManager manager = new PlaybillManager();

        Playbill one = new Playbill("MovieOne");
        Playbill two = new Playbill("MovieTwo");
        Playbill three = new Playbill("MovieTree");

        manager.addMovie(one);
        manager.addMovie(two);
        manager.addMovie(three);

        assertArrayEquals(new Playbill[]{three, two, one}, manager.listOfMovies(3));
    }

    @Test
    public void shouldListOfMoviesTen() {
        PlaybillManager manager = new PlaybillManager();

        Playbill one = new Playbill("MovieOne");
        Playbill two = new Playbill("MovieTwo");
        Playbill three = new Playbill("MovieTree");
        Playbill four = new Playbill("MovieFour");
        Playbill five = new Playbill("MovieFive");
        Playbill six = new Playbill("MovieSix");
        Playbill seven = new Playbill("MovieSeven");
        Playbill eight = new Playbill("MovieEight");
        Playbill nine = new Playbill("MovieNine");
        Playbill ten = new Playbill("MovieTen");

        manager.addMovie(one);
        manager.addMovie(two);
        manager.addMovie(three);
        manager.addMovie(four);
        manager.addMovie(five);
        manager.addMovie(six);
        manager.addMovie(seven);
        manager.addMovie(eight);
        manager.addMovie(nine);
        manager.addMovie(ten);

        assertArrayEquals(new Playbill[]{ten, nine, eight, seven, six, five, four, three, two, one}, manager.listOfMovies(10));
    }

    @Test
    public void shouldListOfMoviesMoreTen() {
        PlaybillManager manager = new PlaybillManager();

        Playbill one = new Playbill("MovieOne");
        Playbill two = new Playbill("MovieTwo");
        Playbill three = new Playbill("MovieTree");
        Playbill four = new Playbill("MovieFour");
        Playbill five = new Playbill("MovieFive");
        Playbill six = new Playbill("MovieSix");
        Playbill seven = new Playbill("MovieSeven");
        Playbill eight = new Playbill("MovieEight");
        Playbill nine = new Playbill("MovieNine");
        Playbill ten = new Playbill("MovieTen");
        Playbill eleven = new Playbill("MovieEleven");
        Playbill twelve = new Playbill("MovieTwelve");

        manager.addMovie(one);
        manager.addMovie(two);
        manager.addMovie(three);
        manager.addMovie(four);
        manager.addMovie(five);
        manager.addMovie(six);
        manager.addMovie(seven);
        manager.addMovie(eight);
        manager.addMovie(nine);
        manager.addMovie(ten);
        manager.addMovie(eleven);
        manager.addMovie(twelve);

        assertArrayEquals(new Playbill[]{twelve, eleven, ten, nine, eight, seven, six, five, four, three}, manager.listOfMovies(10));
    }

    @Test
    public void shouldListOfMoviesWithArg() {
        PlaybillManager manager = new PlaybillManager(3);

        Playbill one = new Playbill("MovieOne");
        Playbill two = new Playbill("MovieTwo");
        Playbill three = new Playbill("MovieTree");
        Playbill four = new Playbill("MovieFour");
        Playbill five = new Playbill("MovieFive");
        Playbill six = new Playbill("MovieSix");
        Playbill seven = new Playbill("MovieSeven");
        Playbill eight = new Playbill("MovieEight");
        Playbill nine = new Playbill("MovieNine");
        Playbill ten = new Playbill("MovieTen");

        manager.addMovie(one);
        manager.addMovie(two);
        manager.addMovie(three);
        manager.addMovie(four);
        manager.addMovie(five);
        manager.addMovie(six);
        manager.addMovie(seven);
        manager.addMovie(eight);
        manager.addMovie(nine);
        manager.addMovie(ten);

        assertArrayEquals(new Playbill[]{ten, nine, eight}, manager.listOfMovies(3));
    }
}