package be.condorcet.services;

import be.condorcet.entities.Classe;
import be.condorcet.entities.Cours;
import be.condorcet.repositories.ClasseRepository;
import be.condorcet.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackOn = Exception.class)
public class ClasseServiceImpl implements InterfClasseService
{
    @Autowired
    private ClasseRepository classeRepository;
    @Override
    public List<Classe> read(String sigle) {
        return classeRepository.findBySigleLike(sigle+"%");
    }

    @Override
    public Classe read(int id, String sigle) {
        return classeRepository.findByIdAndSigleLike(id,sigle);
    }

    @Override
    public Classe create(Classe classe) throws Exception {
        classeRepository.save(classe);
        return classe;
    }
    @Override
    public Classe read(Integer id) throws Exception {
        Optional<Classe> oClasse= classeRepository.findById(id);
        return oClasse.get();

    }
    @Override
    public Classe update(Classe classe) throws Exception {
        classeRepository.save(classe);
        return classe;
    }
    @Override
    public void delete(Classe classe) throws Exception {
        classeRepository.deleteById(classe.getId());
    }
    @Override
    public List<Classe> all() throws Exception {
        return classeRepository.findAll();
    }

    @Override
    public Page<Classe> allp(Pageable pageable) throws Exception {
        return classeRepository.findAll(pageable);
    }
}
