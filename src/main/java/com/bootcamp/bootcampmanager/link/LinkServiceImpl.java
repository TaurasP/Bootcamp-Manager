package com.bootcamp.bootcampmanager.link;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinkServiceImpl implements LinkService{

    @Autowired
    private LinkRepository linkRepository;

    @Override
    public List<Link> getAllLinks() {
        return linkRepository.findAll();
    }

    @Override
    public void saveLink(Link link) {
        this.linkRepository.save(link);
    }

    @Override
    public Link getLinkById(long id) {
        Optional<Link> optional = linkRepository.findById(id);
        Link link;
        if (optional.isPresent()) {
            link = optional.get();
        } else {
            throw new RuntimeException("Not found link: " + id);
        }
        return link;
    }

    @Override
    public void deleteLinkById(long id) {
        this.linkRepository.deleteById(id);
    }
}
