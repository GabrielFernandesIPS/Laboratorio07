package MV.view;

import MV.model.BagOfWords;
import observer.Observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BagOfWordsConsoleView implements Observer {

    private BagOfWords model;

    public BagOfWordsConsoleView(BagOfWords model){
        this.model = model;
    }

    @Override
    public void update(Object obj) {
        BagOfWords.UpdateKeyWord kw = (BagOfWords.UpdateKeyWord) obj;
        List<String> l = new ArrayList<>();
        int li = 0;
        if(kw == BagOfWords.UpdateKeyWord.ADDED){
            l = (List<String>) model.getWords();
            li = l.size() - 1;
            System.out.printf("[CLI] %s: %s, size(%d)", kw, l.get(li) , model.getWordCount());
        }

        if(kw == BagOfWords.UpdateKeyWord.REMOVEDALL){
            System.out.println("[CLI] Removed all Content");
        }
        System.out.print("\n");
        System.out.println("Current Content: " + model.getWords());
    }


}
