package modele;


import com.example.exercice1_1.repositories.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("")
public class GestCours
{
    @Autowired
    private CoursRepository coursRepository;
    @RequestMapping("/tous")
}
