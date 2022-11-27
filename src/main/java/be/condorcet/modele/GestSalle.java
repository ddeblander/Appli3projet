package be.condorcet.modele;

import be.condorcet.entities.Classe;
import be.condorcet.entities.Salle;
import be.condorcet.services.SalleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping("/salle")
public class GestSalle
{
    @Autowired
    private SalleServiceImpl SSI;

    @RequestMapping("/tous")
    public String seeAll(Map<String, Object> model) {
        try {
            Salle c = new Salle();
            Collection<Salle> classes = SSI.all();
            model.put("mesSalle", classes);
        } catch (Exception e) {
            System.out.println("error during the search " + e);
            model.put("error", e.getMessage());
            return "error";
        }
        return "affichageToutSalle";
    }
    @RequestMapping("/read")
    public String read(@RequestParam int idSalle, Map<String, Object> model){
        System.out.println("recherche d'une classe n° "+idSalle);
        try {
            Salle c = SSI.read(idSalle);
            model.put("maSalle",c);
        }catch (Exception e) {
            System.out.println("error during the search" + e);
            model.put("error",e.getMessage());
            return "error";
        }
        return "affichageSalle";
    }

    @RequestMapping("/create")
    public String create(@RequestParam String sigle,@RequestParam int capacite, Map<String, Object> model) {
        System.out.println("création de classe ");
        Salle c = new Salle(null,sigle,capacite);
        try
        {
            SSI.create(c);
            System.out.println(c.getId());
            model.put("nouvSalle",c);
        }
        catch (Exception e)
        {
            System.out.println("error during Salle creation " + e);
            model.put("error",e.getMessage());
            return"error";
        }
        return"nouveauSalle";

    }

    @RequestMapping("/delete")
    public String delete(@RequestParam int id,@RequestParam String sigle, @RequestParam String specialite, Map<String, Object> model) {
        System.out.println("suppression Classe n° "+id);

        try
        {
            Salle c = SSI.read(id);
            SSI.delete(c);
            System.out.println(c.getId());
            model.put("delSalle",c);
        }
        catch (Exception e)
        {
            System.out.println("error  deleting Salle " + e);
            model.put("error",e.getMessage());
            return"error";
        }
        return"suppSalle";

    }
    @RequestMapping("/update")
    public String update(@RequestParam int id,@RequestParam String sigle,@RequestParam int capacite, Map<String, Object> model) {
        System.out.println("recherche du Salle n° "+id);
        Salle s = new Salle();
        try
        {
            s = SSI.read(id);
            s.setSigle(sigle);
            s.setCapacite(capacite);
            s.setId(id);
            SSI.update(s);
        }
        catch (Exception e)
        {
            System.out.println("error updating Salle  " + e);
            model.put("error",e.getMessage());
            return"error";
        }
        return"updateSalle";

    }
}
