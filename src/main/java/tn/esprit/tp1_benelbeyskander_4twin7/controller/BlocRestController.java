package tn.esprit.tp1_benelbeyskander_4twin7.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Bloc;
import tn.esprit.tp1_benelbeyskander_4twin7.services.IBlocServices;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("Bloc")
@Slf4j
public class BlocRestController {
    private  final IBlocServices blocServices ;

    @GetMapping("allblocs")
    public List<Bloc> getallblocs(){
        return blocServices.getAllBlocs();

    }
    @PostMapping("add")
    public Bloc addbloc( @RequestBody Bloc b){
        return  blocServices.addBloc(b);

    }
    @PutMapping("updatebloc/{idBloc}")
    public Bloc updatebloc (@PathVariable int idBloc , @RequestBody Bloc  updatedBloc ) {
        Bloc existingBloc = blocServices.getBloc(idBloc);
        if (existingBloc != null) {

            existingBloc.setNomBloc(updatedBloc.getNomBloc());
            existingBloc.setCapaciteBloc(updatedBloc.getCapaciteBloc());
            return blocServices.updateBloc(existingBloc);
        } else {
            return null;
        }
    }
    @DeleteMapping("deletebloc/{idBloc}")
    public void deletebloc(@PathVariable int idBloc){
        Bloc existingBloc = blocServices.getBloc(idBloc);
        if (existingBloc != null){
            blocServices.removeBloc(idBloc);
        }else {
            log.warn("N'existe pas");
        }

    }
}
