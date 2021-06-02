package com.example.firstSpringBootApp.data.services;

import com.example.firstSpringBootApp.data.Tag;
import com.example.firstSpringBootApp.data.repo.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TagService {

    private TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag getTagById(Integer id)
    {
        return tagRepository.findById(id).get();
    }


    public Map<Tag, String> getTagsMap() {
        Map<Tag, Integer> map= tagRepository.findAll().stream().filter(tag -> tag.getBooksSize()>0).collect(Collectors.toMap(t->t,Tag::getBooksSize));
        Integer max = map.values().stream().max(Integer::compare).get();
        Integer min = map.values().stream().min(Integer::compare).get();
        Map<Integer,String> tagClasses = new HashMap<>();
        tagClasses.put(1,"Tag Tag_xs");
        tagClasses.put(2,"Tag Tag_sm");
        tagClasses.put(3,"Tag");
        tagClasses.put(4,"Tag Tag_md");
        tagClasses.put(5,"Tag Tag_lg");
        Map<Tag, String> map2=map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,t->
        {
            Integer value=1+(t.getValue()-min)*4/(max-min);
            return tagClasses.getOrDefault(value,"Tag");

        }));

        return map2;
    }

}
