package org.ulv.pro.langen.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.ulv.pro.langen.model.word.WordSet;

public class SentenceWord implements Serializable, Comparable<SentenceWord> {

	private static final long serialVersionUID = 7273526834733081593L;
	private final Word word;
	private List<WordSet> conjugationList;
	private WordSet choosen;

	private int ordering;

	public SentenceWord(Word word) {
		this.word = word;
		this.conjugationList = new ArrayList<WordSet>();
		this.choosen = new WordSet();
	}

	public Word getWord() {
		return word;
	}

	public int getOrdering() {
		return ordering;
	}

	public void setOrdering(int ordering) {
		this.ordering = ordering;
	}

	public List<WordSet> getConjugationList() {
		return conjugationList;
	}

	public void setConjugationList(List<WordSet> conjugationList) {
		this.conjugationList = conjugationList;
	}

	public void addConjugation(WordSet wordSet) {
		this.conjugationList.add(wordSet);
	}

	public WordSet getChoosen() {
		return choosen;
	}

	public void setChoosen(WordSet choosen) {
		this.choosen = choosen;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SentenceWord [word=");
		builder.append(word);
		builder.append(", ordering=");
		builder.append(ordering);
		builder.append(", choosen=");
		builder.append(choosen);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(SentenceWord o) {
		return this.ordering == o.getOrdering() ? 0 : this.ordering < o.getOrdering() ? -1 : 1;
	}
}
