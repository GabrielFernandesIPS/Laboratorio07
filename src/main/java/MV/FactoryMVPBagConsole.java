package MV;

import MV.model.BagOfWords;
import MV.view.BagOfWordsConsoleView;

public class FactoryMVPBagConsole {

    public static BagOfWordsConsoleView create(BagOfWords model){
        BagOfWordsConsoleView viewC = new BagOfWordsConsoleView(model);
        model.addObservers(viewC);

        return viewC;
    }
}
