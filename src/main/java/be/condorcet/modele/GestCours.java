package be.condorcet.modele;


import be.condorcet.entities.Cours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import be.condorcet.services.CoursServiceImpl;

import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping("/cours")
public class GestCours {
    @Autowired
    private CoursServiceImpl coursServiceImpl;

    @RequestMapping("/tous")
    public String seeAll(Map<String, Object> model) {
        try {
            Collection<Cours> cours = coursServiceImpl.all();
            model.put("mesCours", cours);
        } catch (Exception e) {
            System.out.println("error during the search " + e);
            model.put("error", e.getMessage());
            return "error";
        }
        return "affichertousCours";
    }
    @RequestMapping("/read")
    public String read(@RequestParam int idCours, Map<String, Object> model){
        System.out.println("recherche du cours n° "+idCours);
        try {
            Cours c = coursServiceImpl.read(idCours);
            model.put("monCours",c);
        }catch (Exception e) {
            System.out.println("error during the search" + e);
            model.put("error",e.getMessage());
            return "error";
        }
        return "affEmploye";
    }

    @RequestMapping("/create")
    public String create(@RequestParam String code, @RequestParam String intitule, Map<String, Object> model) {
        System.out.println("création de cours ");
        Cours c = new Cours(null,code, intitule);
        try
        {
            coursServiceImpl.create(c);
            System.out.println(c.getIdcours());
            model.put("nouvcours",c);
        }
        catch (Exception e)
        {
            System.out.println("error during cours creation " + e);
            model.put("error",e.getMessage());
            return"error";
        }
        return"nouveauCours";

    }

    @RequestMapping("/delete")
    public String delete(@RequestParam int idCours,@RequestParam String code, @RequestParam String intitule, Map<String, Object> model) {
        System.out.println("suppression Cours n° "+idCours);

        try
        {
            Cours c = coursServiceImpl.read(idCours);
            coursServiceImpl.delete(c);
            System.out.println(c.getIdcours());
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
    public String update(@RequestParam int idCours,@RequestParam String code, @RequestParam String intitule, Map<String, Object> model) {
        System.out.println("recherche du cours n° "+idCours);
        Cours c = new Cours(code, intitule);
        try
        {
            c = coursServiceImpl.read(idCours);
            c.setCode(code);
            c.setIntitule(intitule);
            coursServiceImpl.update(c);
        }
        catch (Exception e)
        {
            System.out.println("error updating cours  " + e);
            model.put("error",e.getMessage());
            return"error";
        }
        return"updateCours";

    }

}
