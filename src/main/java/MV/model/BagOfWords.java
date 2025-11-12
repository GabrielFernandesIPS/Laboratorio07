/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MV.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


import java.util.ArrayList;
import java.util.Collection;

import java.util.List;


/**
 * PARTICIPANTE ORIGINATOR DO PADRÃO MEMENTO
 *
 * @author brunomnsilva
 */
public class BagOfWords   {

    /**
     * Colecao que guarda as palavras
     */
    private final List<String> bag=new ArrayList<>();

    /**
     * Nome do bag of words
     */
    private String name;

    public BagOfWords(String name) {
        this.name = name;
    }
    public BagOfWords(String name, String word) {
        this.name = name;
        bag.add(word);
    }

    public void addWord(String s) throws BagOfWordsException {
        if (bag.contains(s)) {
            throw new BagOfWordsException(String.format("A palavra %s já existe!", s));
        }

        bag.add(s);


    }
    public void removeAll(){
        bag.clear();

    }

    public int getWordCount() {
        return bag.size();
    }

    @Override
    public String toString() {
        return "BagOfWords{" + "bag=" + bag + ", name=" + name + '}';
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */



    public Collection<String> getWords() {
        return new ArrayList(bag);
    }

    /**
     * Cria uma memória dos atributos atuais.
     *
     * @return a memória
     */




}
