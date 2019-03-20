package org.gIsid.xspeedIt.service.optimized;

import java.util.Arrays;

import org.gIsid.xspeedIt.util.RobotUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptimizedRobotServiceImpl implements OptimizedRobotService {

    @Autowired
    RobotUtils vUtilsXspeedit ;

    public String[] resolveCards(String chaineArticle) {

        int[] articlesaEmballer = vUtilsXspeedit.convertirChainEnIntegerArray(chaineArticle);
        int capaciteMaximalDeCarton = 10;

        //Maximum de cartons qu'on peut avoir est egale a la liste des article a emballer
        int maximumCarton = articlesaEmballer.length;
        int nombreExactDeCarton = 0;

        int[] cartonRestant = new int[maximumCarton];
        String[] arrayChaineResultat = new String[maximumCarton];

        for (int indexMaxCarton=0; indexMaxCarton<maximumCarton; indexMaxCarton++)
        {

            int indexCartonRestant;
            for (indexCartonRestant=0; indexCartonRestant<nombreExactDeCarton; indexCartonRestant++)
            {
                if (cartonRestant[indexCartonRestant] >= articlesaEmballer[indexMaxCarton])
                {
                    cartonRestant[indexCartonRestant] = cartonRestant[indexCartonRestant] - articlesaEmballer[indexMaxCarton];
                    construireArrayDeChaineArticleEmballe(articlesaEmballer, arrayChaineResultat, indexMaxCarton, indexCartonRestant);
                    break;
                }
            }

            if (indexCartonRestant==nombreExactDeCarton)
            {
                cartonRestant[nombreExactDeCarton] = capaciteMaximalDeCarton - articlesaEmballer[indexMaxCarton];
                construireArrayDeChaineArticleEmballe(articlesaEmballer, arrayChaineResultat, indexMaxCarton, nombreExactDeCarton);
                nombreExactDeCarton++;
            }
        }

        //Enlever les valeur Null de ce tableau
        arrayChaineResultat = Arrays.stream(arrayChaineResultat)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);

        return arrayChaineResultat;
    }

    /**
	 * construire l'array de chaine article emballee
	 * @param articlesaEmballer
	 * @param arrayChaineResultat
	 * @param indexMaxCarton
	 * @param index
	 */
    private void construireArrayDeChaineArticleEmballe(int[] articlesaEmballer, String[] arrayChaineResultat, int indexMaxCarton, int index) {
        final StringBuilder vReponse = new StringBuilder();
        if(arrayChaineResultat[index]!=null) {
            vReponse.append(arrayChaineResultat[index]);
            arrayChaineResultat[index] = vReponse.append(articlesaEmballer[indexMaxCarton]).toString();
        }else {
            arrayChaineResultat[index]= String.valueOf(articlesaEmballer[indexMaxCarton]);
        }
    }
}