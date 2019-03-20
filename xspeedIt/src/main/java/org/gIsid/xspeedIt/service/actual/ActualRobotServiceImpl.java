package org.gIsid.xspeedIt.service.actual;

import org.gIsid.xspeedIt.util.RobotUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author AminaCh
 * next fit algorithme
 */
@Service
public class ActualRobotServiceImpl implements ActualRobotService {

    @Autowired
    RobotUtils vUtilsXspeedit;
    
    /**
	 * Elle va mettre les articles dans les cartons
	 * @return
	 */

    public String[] resolveCards(String chaineArticle) {

        final StringBuilder vReponse = new StringBuilder();

        int[] vChaineArticleInt = vUtilsXspeedit.convertirChainEnIntegerArray(chaineArticle);

        int vCartonCapacite = 10;
        for (int vTailleArticle : vChaineArticleInt) {
        	
        	//Vérifier si on peut l'ajouter dans le carton

            if (vCartonCapacite - vTailleArticle < 0) {
                vReponse.append("/");
                vCartonCapacite = 10;
            }

          //Ajouter dans le carton
            vReponse.append(vTailleArticle);

          //Capacité restons dans le carton
            vCartonCapacite -= vTailleArticle;
        }

        return vReponse.toString().split("/");

    }

}
