package be.condorcet.webservices;

import be.condorcet.entities.Classe;
import be.condorcet.entities.Cours;
import be.condorcet.services.InterfClasseService;
import be.condorcet.services.InterfCoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

        import be.condorcet.entities.Cours;
        import be.condorcet.services.InterfCoursService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.Pageable;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*",exposedHeaders = "*")
@RestController
@RequestMapping("/classe")
public class RestClasse
{
    @Autowired
    private InterfClasseService ics;

    // to retrieve a Classe with an ID send
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Classe> getClasse(@PathVariable(value = "id")int id) throws Exception
    {
        System.out.println("recherche du d'une Classe d' id " + id);
        Classe c = ics.read(id);
        return new ResponseEntity<Classe>(c, HttpStatus.OK);
    }
    //to retrieve the Classe with an sigle send
    @RequestMapping(value = "/sigle={sigle}", method = RequestMethod.GET)
    public ResponseEntity<List<Classe>> listClassesNom(@PathVariable(value="nom") String sigle) throws Exception{
        System.out.println("recherche de "+sigle);
        List<Classe> classes;
        classes = ics.read(sigle);
        return new ResponseEntity<>(classes, HttpStatus.OK);
    }
    /*////to retrieve the cours with an INTITULE,CODE send---------------------------------------------------
    @RequestMapping(value = "/{code}/{intitule}}", method = RequestMethod.GET)
    public ResponseEntity<Cours> getCoursUnique(@PathVariable(value = "CODE") String code,
                                                  @PathVariable(value = "INTITULE") String intitule)  throws Exception{
        System.out.println("recherche du Cours "+code+" "+intitule+" ");
        Cours c = ics.read(code,intitule);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }*/
    //create a Classe
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Classe> createClasse(@RequestBody Classe c) throws Exception {
        System.out.println("Création de Classe " + c.getSigle());
        ics.create(c);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    //update a Classe via ID
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Classe> majClasse(@PathVariable(value = "id") int id,@RequestBody Classe nouvc) throws Exception{
        System.out.println("maj de Classe id =  " + id);
        nouvc.setId(id);
        Classe c = ics.update(nouvc);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    //delete a Classe via ID
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteClasse(@PathVariable(value = "id") int id) throws Exception{
        System.out.println("effacement de Classe d'id " + id);
        Classe c = ics.read(id);
        ics.delete(c);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //return all classe
    @RequestMapping(value =  "/all",method = RequestMethod.GET)
    public ResponseEntity<List<Classe>> listClasse() throws Exception{
        System.out.println("recherche de tous les Classes");
        return new ResponseEntity<>(ics.all(), HttpStatus.OK);
    }

    //return all classe sorted
    @RequestMapping(value =  "/allp",method = RequestMethod.GET)
    public ResponseEntity<Page<Classe>> listClasse(Pageable pageable) throws Exception{
        System.out.println("recherche de tous les Classes");
        return new ResponseEntity<>(ics.allp(pageable), HttpStatus.OK);
    }
    //managing Exception
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Void>  handleIOException(Exception ex) {
        System.out.println("erreur : "+ex.getMessage());
        return ResponseEntity.notFound().header("error",ex.getMessage()).build();
    }
}
