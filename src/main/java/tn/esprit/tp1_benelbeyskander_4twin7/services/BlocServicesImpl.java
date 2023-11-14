package tn.esprit.tp1_benelbeyskander_4twin7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Chambre;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Foyer;
import tn.esprit.tp1_benelbeyskander_4twin7.reposetries.IblocRepository;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Bloc;
import tn.esprit.tp1_benelbeyskander_4twin7.reposetries.IchambreRepository;
import tn.esprit.tp1_benelbeyskander_4twin7.reposetries.IfoyerRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BlocServicesImpl implements IBlocServices{
    final IblocRepository blocRepository;
    final IchambreRepository ichambreRepository ;
    final IfoyerRepository ifoyerRepository;
    @Override
    public List<Bloc> getAllBlocs() {
        return (List<Bloc>) blocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
            return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc getBloc(long idBloc) {

        return blocRepository.findById(idBloc).orElse(null);

    }

    @Override
    public void removeBloc(long  idBloc) {
        blocRepository.deleteById(idBloc);

    }
@Transactional
    @Override
    public Bloc affecterChambresABloc(List<Integer> numChambre, String nomBloc) {
        Bloc bloc = blocRepository.findByNomBloc(nomBloc);
        for(long id:numChambre){
            Chambre chambre = ichambreRepository.findById(id).orElse(null);
            chambre.setBloc(bloc);
        }


        return bloc;
    }

    @Override
    public Bloc affecterBlocafoyer(long idBloc, Long idFoyer) {
        Foyer optinalfoyer = ifoyerRepository.findById(idFoyer).orElse(null);
        Bloc  optionalbloc =blocRepository.findById(idBloc).orElse(null);


        optionalbloc.setFoyers(optinalfoyer);
//        blocRepository.save(optionalbloc);
            return optionalbloc ;


    }


    }


