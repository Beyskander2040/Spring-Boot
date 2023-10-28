package tn.esprit.tp1_benelbeyskander_4twin7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp1_benelbeyskander_4twin7.reposetries.IblocRepository;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Bloc;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BlocServicesImpl implements IBlocServices{
    final IblocRepository blocRepository;
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
    public Bloc getBloc(int idBloc) {

        return blocRepository.findById(idBloc).orElse(null);

    }

    @Override
    public void removeBloc(int idBloc) {
        blocRepository.deleteById(idBloc);

    }
}
