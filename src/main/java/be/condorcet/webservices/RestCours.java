package be.condorcet.webservices;

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
@RequestMapping("/cours")
public class RestCours
{
    @Autowired
    private InterfCoursService ics;

    // to retrieve a cour with an ID send
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cours> getCour(@PathVariable(value = "id")int id) throws Exception
    {
        System.out.println("recherche du d'un cours d' id " + id);
        Cours c = ics.read(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    //to retrieve the cours with an INTITULE send
    @RequestMapping(value = "/intitule={intitule}", method = RequestMethod.GET)
    public ResponseEntity<List<Cours>> listCourssNom(@PathVariable(value="nom") String nom) throws Exception{
        System.out.println("recherche de "+nom);
        List<Cours> cours;
        cours = ics.read(nom);
        return new ResponseEntity<>(cours, HttpStatus.OK);
    }
    /*////to retrieve the cours with an INTITULE,CODE send---------------------------------------------------
    @RequestMapping(value = "/{code}/{intitule}}", method = RequestMethod.GET)
    public ResponseEntity<Cours> getCoursUnique(@PathVariable(value = "CODE") String code,
                                                  @PathVariable(value = "INTITULE") String intitule)  throws Exception{
        System.out.println("recherche du Cours "+code+" "+intitule+" ");
        Cours c = ics.read(code,intitule);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }*/
    //create a cours
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Cours> createCours(@RequestBody Cours c) throws Exception {
        System.out.println("Création du cours " + c.getIntitule());
        ics.create(c);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    //update a cours via ID
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cours> majCours(@PathVariable(value = "id") int id,@RequestBody Cours nouvc) throws Exception{
        System.out.println("maj du cours id =  " + id);
        nouvc.setIdcours(id);
        Cours c = ics.update(nouvc);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    //delete a cours via ID
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCours(@PathVariable(value = "id") int id) throws Exception{
        System.out.println("effacement du cours d'id " + id);
        Cours c = ics.read(id);
        ics.delete(c);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //-------------------Retrouver tous les clients --------------------------------------------------------
    @RequestMapping(value =  "/all",method = RequestMethod.GET)
    public ResponseEntity<List<Cours>> listCours() throws Exception{
        System.out.println("recherche de tous les Cours");
        return new ResponseEntity<>(ics.all(), HttpStatus.OK);
    }

    //-------------------Retrouver tous les clients triés et par page--------------------------------------------------------
    @RequestMapping(value =  "/allp",method = RequestMethod.GET)
    public ResponseEntity<Page<Cours>> listCours(Pageable pageable) throws Exception{
        System.out.println("recherche de tous les Cours");
        return new ResponseEntity<>(ics.allp(pageable), HttpStatus.OK);
    }
    //-------------------Gérer les erreurs--------------------------------------------------------
    @ExceptionHandler({Exception.class})
    public ResponseEntity<Void>  handleIOException(Exception ex) {
        System.out.println("erreur : "+ex.getMessage());
        return ResponseEntity.notFound().header("error",ex.getMessage()).build();
    }
}
