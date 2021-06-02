package com.example.firstSpringBootApp.data.services;


import com.example.firstSpringBootApp.data.Genre;
import com.example.firstSpringBootApp.data.repo.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
public class GenreService {
    private GenreRepository genreRepository;
    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getParentGenres(Integer id)
    {
        return  genreRepository.findAllByParentId(id);
    }
    public List<Genre> getGenreMap()
    {
        List<Genre> genreList=genreRepository.findAllByParentId(null);
        return genreList;
    }

    public Genre getBookById(Integer id) {
        return genreRepository.findById(id).get();
    }

    public List<Genre> getBreadCrumbs(Genre genre) {
        List<Genre> list =new ArrayList<>();
        list.add(genre);
        while (genre.getParentId()!=null)
        {
            genre=genreRepository.findById(genre.getParentId()).get();
            list.add(genre);
        }
        Collections.reverse(list);
        return list ;
    }

}
