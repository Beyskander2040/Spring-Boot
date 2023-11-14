package tn.esprit.tp1_benelbeyskander_4twin7.services;
import java.util.List;
import tn.esprit.tp1_benelbeyskander_4twin7.entities.Bloc;

public interface IBlocServices {
    List<Bloc> getAllBlocs();
    Bloc updateBloc(Bloc bloc);
    Bloc addBloc (Bloc bloc );
    Bloc getBloc (long idBloc);
    void removeBloc (long idBloc);
    public Bloc affecterChambresABloc(List<Integer> numChambre, String nomBloc) ;
    public Bloc affecterBlocafoyer(long idBloc , Long idFoyer );




}
