package be.condorcet.modele;

import be.condorcet.entities.Classe;
import be.condorcet.entities.Salle;
import be.condorcet.services.ClasseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping("/classe")
public class GestClasse
{
    @Autowired
    private ClasseServiceImpl classeServiceImpl;

    @RequestMapping("/tous")
    public String seeAll(Map<String, Object> model) {
        try {
            Classe c = new Classe();
            Collection<Classe> classes = classeServiceImpl.all();
            model.put("mesClasses", classes);
        } catch (Exception e) {
            System.out.println("error during the search " + e);
            model.put("error", e.getMessage());
            return "error";
        }
        return "affichageToutClasse";
    }
    @RequestMapping("/read")
    public String read(@RequestParam int idClasse, Map<String, Object> model){
        System.out.println("recherche d'une classe n° "+idClasse);
        try {
            Classe c = classeServiceImpl.read(idClasse);
            model.put("maClasse",c);
        }catch (Exception e) {
            System.out.println("error during the search" + e);
            model.put("error",e.getMessage());
            return "error";
        }
        return "affichageClasse";
    }

    @RequestMapping("/create")
    public String create(@RequestParam String sigle, @RequestParam int annee, @RequestParam String specialite, @RequestParam int nbEleves, @RequestParam Salle salle, Map<String, Object> model) {
        System.out.println("création de classe ");
        Classe c = new Classe(null,sigle,specialite,annee,nbEleves,salle);
        try
        {
            classeServiceImpl.create(c);
            System.out.println(c.getId());
            model.put("nouvClasse",c);
        }
        catch (Exception e)
        {
            System.out.println("error during classe creation " + e);
            model.put("error",e.getMessage());
            return"error";
        }
        return"nouveauClasse";

    }

    @RequestMapping("/delete")
    public String delete(@RequestParam int id,@RequestParam String sigle, @RequestParam String specialite, Map<String, Object> model) {
        System.out.println("suppression Classe n° "+id);

        try
        {
            Classe c = classeServiceImpl.read(id);
            classeServiceImpl.delete(c);
            System.out.println(c.getId());
            model.put("delCours",c);
        }
        catch (Exception e)
        {
            System.out.println("error  deleting cours " + e);
            model.put("error",e.getMessage());
            return"error";
        }
        return"suppCours";

    }
    @RequestMapping("/update")
    public String update(@RequestParam int id,@RequestParam String sigle, @RequestParam String specialite, @RequestParam int annee, @RequestParam int nbEleves,@RequestParam Salle salle, Map<String, Object> model) {
        System.out.println("recherche du classe n° "+id);
        Classe c = new Classe();
        try
        {
            c = classeServiceImpl.read(id);
            c.setSigle(sigle);
            c.setSpecialite(specialite);
            c.setNbEleves(nbEleves);
            c.setSalle(salle);
            classeServiceImpl.update(c);
        }
        catch (Exception e)
        {
            System.out.println("error updating classe  " + e);
            model.put("error",e.getMessage());
            return"error";
        }
        return"updateClasse";

    }
}
