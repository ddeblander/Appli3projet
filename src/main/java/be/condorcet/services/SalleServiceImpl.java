package be.condorcet.services;

import be.condorcet.entities.Salle;

import be.condorcet.repositories.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional(rollbackOn = Exception.class)
public class SalleServiceImpl implements InterfSalleService
{
    @Autowired
    private SalleRepository SR;
    @Override
    public List<Salle> read(String sigle) {
        return SR.findBySigleLike(sigle+"%");
    }

    @Override
    public Salle read(int id, String sigle) {
        return SR.findByIdAndSigleLike(id,sigle);
    }

    @Override
    public Salle create(Salle salle) throws Exception {
        SR.save(salle);
        return salle;
    }
    @Override
    public Salle read(Integer id) throws Exception {
        Optional<Salle> oSalle= SR.findById(id);
        return oSalle.get();

    }
    @Override
    public Salle update(Salle salle) throws Exception {
        SR.save(salle);
        return salle;
    }
    @Override
    public void delete(Salle salle) throws Exception {
        SR.deleteById(salle.getId());
    }
    @Override
    public List<Salle> all() throws Exception {
        return SR.findAll();
    }

    @Override
    public Page<Salle> allp(Pageable pageable) throws Exception {
        return SR.findAll(pageable);
    }
}
