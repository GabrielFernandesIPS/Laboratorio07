package MV;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import MV.model.BagOfWords;
import MV.view.BagOfWordsGUI;

/**
 *
 * @author Utilizador
 */
public class FactoryMVBagGUI {

    public static BagOfWordsGUI create(BagOfWords model) {

        BagOfWordsGUI viewG = new BagOfWordsGUI(model);


        return viewG;
    }
}
