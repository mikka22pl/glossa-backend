package org.ulv.pro.langen.utils;

import java.util.List;

import org.ulv.pro.langen.conjugatio.ConjTypeEnum;
import org.ulv.pro.langen.model.word.WordSet;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class ConjugatedWordUtils {

	public static String findSingularis1(final List<WordSet> words) {
		return findForm(words, ConjTypeEnum.SINGULARIS_1);
	}

	public static String findSingularis2(final List<WordSet> words) {
		return findForm(words, ConjTypeEnum.SINGULARIS_2);
	}

	public static String findSingularis3(final List<WordSet> words) {
		return findForm(words, ConjTypeEnum.SINGULARIS_3);
	}

	public static String findDualis(final List<WordSet> words) {
		return findForm(words, ConjTypeEnum.DUALIS);
	}

	private static String findForm(final List<WordSet> words,
			final ConjTypeEnum type) {
		return Iterables.find(words, new Predicate<WordSet>() {
			@Override
			public boolean apply(WordSet item) {
				return type.equals(item.getType());
			}
		}).getWord();
	}
}
