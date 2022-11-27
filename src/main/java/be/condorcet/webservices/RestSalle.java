package be.condorcet.webservices;

import be.condorcet.entities.Salle;
import be.condorcet.services.InterfSalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*",exposedHeaders = "*")
@RestController
@RequestMapping("/salle")
public class RestSalle
{
    @Autowired
    private InterfSalleService ISS;

    // to retrieve a Salle with an ID send
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Salle> getClasse(@PathVariable(value = "id")int id) throws Exception
    {
        System.out.println("recherche du d'une Salle d' id " + id);
        Salle s = ISS.read(id);
        return new ResponseEntity<Salle>(s, HttpStatus.OK);
    }
    //to retrieve the Salle with an sigle send
    @RequestMapping(value = "/sigle={sigle}", method = RequestMethod.GET)
    public ResponseEntity<List<Salle>> listClassesNom(@PathVariable(value="nom") String sigle) throws Exception{
        System.out.println("recherche de "+sigle);
        List<Salle> Salles;
        Salles = ISS.read(sigle);
        return new ResponseEntity<>(Salles, HttpStatus.OK);
    }
    /*////to retrieve the cours with an INTITULE,CODE send---------------------------------------------------
    @RequestMapping(value = "/{code}/{intitule}}", method = RequestMethod.GET)
    public ResponseEntity<Cours> getCoursUnique(@PathVariable(value = "CODE") String code,
                                                  @PathVariable(value = "INTITULE") String intitule)  throws Exception{
        System.out.println("recherche du Cours "+code+" "+intitule+" ");
        Cours c = ics.read(code,intitule);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }*/
    //create a Salle
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Salle> createClasse(@RequestBody Salle s) throws Exception {
        System.out.println("Création de Classe " + s.getSigle());
        ISS.create(s);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    //update a Salle via ID
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Salle> majClasse(@PathVariable(value = "id") int id,@RequestBody Salle nouvs) throws Exception{
        System.out.println("maj de Classe id =  " + id);
        nouvs.setId(id);
        Salle s = ISS.update(nouvs);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    //delete a Salle via ID
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteClasse(@PathVariable(value = "id") int id) throws Exception{
        System.out.println("effacement de Classe d'id " + id);
        Salle s = ISS.read(id);
        ISS.delete(s);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //return all Salle
    @RequestMapping(value =  "/all",method = RequestMethod.GET)
    public ResponseEntity<List<Salle>> listClasse() throws Exception{
        System.out.println("recherche de tous les Salles");
        return new ResponseEntity<>(ISS.all(), HttpStatus.OK);
    }

    //return all Salle sorted
    @RequestMapping(value =  "/allp",method = RequestMethod.GET)
    public ResponseEntity<Page<Salle>> listClasse(Pageable pageable) throws Exception{
        System.out.println("recherche de tous les Salles");
        return new ResponseEntity<>(ISS.allp(pageable), HttpStatus.OK);
    }
    //managing Exception
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Void>  handleIOException(Exception ex) {
        System.out.println("erreur : "+ex.getMessage());
        return ResponseEntity.notFound().header("error",ex.getMessage()).build();
    }
}
