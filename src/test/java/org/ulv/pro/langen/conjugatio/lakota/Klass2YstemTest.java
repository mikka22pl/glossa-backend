package org.ulv.pro.langen.conjugatio.lakota;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.ulv.pro.langen.model.LexerItem;
import org.ulv.pro.langen.model.Word;
import org.ulv.pro.langen.model.template.FormedWord;
import org.ulv.pro.langen.service.LexerItemBuilder;

@RunWith(MockitoJUnitRunner.class)
public class Klass2YstemTest {

	@Test
	public void should_build_2_singularis() throws Exception {
		// given
		String expected = "luhá";
		
		Word baseWord = new Word(1, "yuhá");
		baseWord.setConjugatioType(new LexerItemBuilder(11, "CLASS_II", "klasa II", 9).build());

		LexerItem templateLexer = new LexerItemBuilder(31, "template", "template", 14).build();
		FormedWord template = new FormedWord();
		template.setId(4);
		template.setName("x-yuhá-pl");
		template.setVerbForm(templateLexer);
		
		Conjugatio conj = new Klass2YstemConjugatio();
		
		// when
		String word = conj.build2sg(baseWord, template);
		
		// then
		Assert.assertThat(word, notNullValue());
		Assert.assertThat(word, is(expected));
	}
	
	@Test
	public void should_build_dualis() throws Exception {
		// given
		String expected = "uŋyúha";
		
		Word baseWord = new Word(1, "yuhá");
		baseWord.setConjugatioType(new LexerItemBuilder(11, "CLASS_II", "klasa II", 9).build());

		LexerItem templateLexer = new LexerItemBuilder(31, "template", "template", 14).build();
		FormedWord template = new FormedWord();
		template.setId(4);
		template.setName("x-yuhá-pl");
		template.setVerbForm(templateLexer);
		
		Conjugatio conj = new Klass2YstemConjugatio();
		
		// when
		String word = conj.buildDualis(baseWord, template);
		
		// then
		Assert.assertThat(word, notNullValue());
		Assert.assertThat(word, is(expected));
	}
}
