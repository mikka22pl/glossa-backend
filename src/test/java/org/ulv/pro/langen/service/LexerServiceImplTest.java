package org.ulv.pro.langen.service;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.contains;
import static org.hamcrest.CoreMatchers.hasItems;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.ulv.pro.langen.dao.LexerDao;
import org.ulv.pro.langen.model.LexerItem;

@RunWith(MockitoJUnitRunner.class)
public class LexerServiceImplTest {

	@Mock
	private LexerDao lexerDao;
	
	@InjectMocks
	private LexerServiceImpl service;
	
	@Test
	public void should_get_list_id_of_lexer_and_its_children() throws Exception {
		// given
		LexerItem parent = new LexerItem(1, "singularis", "singularis opis", 19);
		
		List<LexerItem> children = new ArrayList<LexerItem>();
		children.add(new LexerItem(2, "1sg", "1 os. singularis", 1));
		children.add(new LexerItem(3, "2sg", "2 os. singularis", 1));
		children.add(new LexerItem(4, "3sg", "3 os. singularis", 1));
		
		parent.setChildren(children);

		given(lexerDao.getLexerAndChildren(anyInt())).willReturn(parent);
		
		// when
		List<Integer> list = service.getIdsParentAndChildren(1);
		
		// then
		Assert.assertThat(list, hasItems(1, 2, 3, 4));
	}
}
