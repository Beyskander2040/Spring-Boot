package tn.esprit.tp1_benelbeyskander_4twin7.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Bloc;
import tn.esprit.tp1_benelbeyskander_4twin7.services.IBlocServices;

import java.util.List;
@Tag(name = "Bloc Management")
@RestController
@RequiredArgsConstructor
@RequestMapping("Bloc")
@Slf4j
public class BlocRestController {
    private  final IBlocServices blocServices ;


    @Operation(description = "Get all blocs")
    @GetMapping("allblocs")
    public List<Bloc> getallblocs(){
        return blocServices.getAllBlocs();

    }
    @Operation(description = "Retrieve bloc")
    @PostMapping("add")
    public Bloc addbloc( @RequestBody Bloc b){
        return  blocServices.addBloc(b);

    }
    @Operation(description = "Update bloc")
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
    @Operation(description = "Delete bloc")
    @DeleteMapping("deletebloc/{idBloc}")
    public void deletebloc(@PathVariable long idBloc){
        Bloc existingBloc = blocServices.getBloc(idBloc);
        if (existingBloc != null){
            blocServices.removeBloc(idBloc);
        }else {
            log.warn("N'existe pas");
        }

    }
    @Operation(description = "affecterchambrebloc")
    @PutMapping("/affecterchambrebloc/{nomBloc}")
    public  Bloc affecterchambrebloc(@RequestBody List<Integer> numeroChambre,@PathVariable String nomBloc){
        return blocServices.affecterChambresABloc(numeroChambre,nomBloc);
    }
    @PostMapping("/affecterBlocFoyer/{idBloc}/{idFoyer}")
    public Bloc affecterBlocFoyer(@PathVariable long idBloc, @PathVariable long idFoyer) {
        return blocServices.affecterBlocafoyer(idBloc, idFoyer);
    }
}
