package be.condorcet.services;

import be.condorcet.repositories.CoursRepository;
import be.condorcet.entities.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackOn = Exception.class)
public class CoursServiceImpl implements InterfCoursService{
    @Autowired
    private CoursRepository coursRepository;
    @Override
    public List<Cours> read(String intitule) {
        return coursRepository.findByIntituleLike(intitule+"%");
    }
    public Cours read(String code,String intitule) {
        return coursRepository.findCoursByCodeAndIntitule(code,intitule);
    }
    @Override
    public Cours create(Cours cours) throws Exception {
        coursRepository.save(cours);
        return cours;
    }
    @Override
    public Cours read(Integer id) throws Exception {
        Optional<Cours> oCours= coursRepository.findById(id);
        return oCours.get();

    }
    @Override
    public Cours update(Cours cours) throws Exception {
        coursRepository.save(cours);
        return cours;
    }
    @Override
    public void delete(Cours cours) throws Exception {
        coursRepository.deleteById(cours.getIdcours());
    }
    @Override
    public List<Cours> all() throws Exception {
        return coursRepository.findAll();
    }

    @Override
    public Page<Cours> allp(Pageable pageable) throws Exception {
        return coursRepository.findAll(pageable);
    }
}