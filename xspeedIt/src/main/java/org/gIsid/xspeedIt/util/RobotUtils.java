package org.gIsid.xspeedIt.util;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class RobotUtils {
    public Boolean isValidIntegerSequence(String string) {
        if (string != null && !string.isEmpty()) {
            for (char vItem : string.toCharArray()) {
                if (!Character.isDigit(vItem)) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }


    public int[] convertirChainEnIntegerArray(String chaineArticleEmballerRobotActuel) {

        int[] vResopnse = null;
        int vIndex = 0;
        vResopnse = new int[chaineArticleEmballerRobotActuel.length()];

        for (char vItem : chaineArticleEmballerRobotActuel.toCharArray()) {
            vResopnse[vIndex] = vItem - '0';
            vIndex++;
        }
        return vResopnse;
    }


    public int getNombreCarton(String chaineArticleEmballerRobotActuel) {

        String[] seperated = chaineArticleEmballerRobotActuel.split("\\/");

        return seperated.length;
    }


    public String convertArrayIntEnChaine(String[] arrayInt) {

        return Arrays.stream(arrayInt).collect(Collectors.joining("/"));
    }

}
