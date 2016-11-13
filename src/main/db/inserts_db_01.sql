
SET client_encoding = 'UTF8';

INSERT INTO courses (id, course_name, language_id) VALUES (1, 'Course 1', 1);
INSERT INTO courses (id, course_name, language_id) VALUES (2, 'Course 2', 1);
INSERT INTO courses (id, course_name, language_id) VALUES (3, 'Course 3', 1);
INSERT INTO courses (id, course_name, language_id) VALUES (4, 'sentence of the week', 5);



INSERT INTO languages (id, lang_name, code) VALUES (1, 'szwedzki', 'se');
INSERT INTO languages (id, lang_name, code) VALUES (2, 'angielski', 'uk');
INSERT INTO languages (id, lang_name, code) VALUES (3, 'fiński', 'fi');
INSERT INTO languages (id, lang_name, code) VALUES (4, 'niemiecki', 'de');
INSERT INTO languages (id, lang_name, code) VALUES (5, 'lakota', 'la');
INSERT INTO languages (id, lang_name, code) VALUES (6, 'grecki', 'gr');
INSERT INTO languages (id, lang_name, code) VALUES (7, 'norweski', 'no');
INSERT INTO languages (id, lang_name, code) VALUES (8, 'gruziński', 'ge');


INSERT INTO lessons (id, lesson_name, course_id) VALUES (1, 'lesson 1', 1);
INSERT INTO lessons (id, lesson_name, course_id) VALUES (2, 'lesson 2', 1);
INSERT INTO lessons (id, lesson_name, course_id) VALUES (3, 'lesson 3', 1);
INSERT INTO lessons (id, lesson_name, course_id) VALUES (4, 'dzierżawcze', 4);


INSERT INTO lexer (id, lex_name, descr, parent_id) VALUES (1, 'WORD_FUNCTION', 'Funkcje części mowy', NULL);
INSERT INTO lexer (id, lex_name, descr, parent_id) VALUES (2, 'FIXED', 'Niezmienna', 1);


INSERT INTO sentence_structures (id, language_id, lesson_id, ordering, group_id, type) VALUES (1, 5, 4, 1, 1, 1);
INSERT INTO sentence_structures (id, language_id, lesson_id, ordering, group_id, type) VALUES (2, 5, 4, 2, 5, 2);
INSERT INTO sentence_structures (id, language_id, lesson_id, ordering, group_id, type) VALUES (3, 5, 4, 3, 4, 1);
INSERT INTO sentence_structures (id, language_id, lesson_id, ordering, group_id, type) VALUES (4, 5, 4, 4, 3, 1);


INSERT INTO word_group_assign (word_id, group_id) VALUES (1, 1);
INSERT INTO word_group_assign (word_id, group_id) VALUES (1, 2);
INSERT INTO word_group_assign (word_id, group_id) VALUES (4, 3);
INSERT INTO word_group_assign (word_id, group_id) VALUES (2, 4);
INSERT INTO word_group_assign (word_id, group_id) VALUES (3, 4);
INSERT INTO word_group_assign (word_id, group_id) VALUES (7, 1);
INSERT INTO word_group_assign (word_id, group_id) VALUES (8, 3);
INSERT INTO word_group_assign (word_id, group_id) VALUES (4, 6);
INSERT INTO word_group_assign (word_id, group_id) VALUES (9, 1);
INSERT INTO word_group_assign (word_id, group_id) VALUES (9, 7);
INSERT INTO word_group_assign (word_id, group_id) VALUES (11, 1);
INSERT INTO word_group_assign (word_id, group_id) VALUES (13, 1);
INSERT INTO word_group_assign (word_id, group_id) VALUES (13, 8);
INSERT INTO word_group_assign (word_id, group_id) VALUES (14, 1);
INSERT INTO word_group_assign (word_id, group_id) VALUES (14, 9);
INSERT INTO word_group_assign (word_id, group_id) VALUES (15, 3);
INSERT INTO word_group_assign (word_id, group_id) VALUES (16, 3);
INSERT INTO word_group_assign (word_id, group_id) VALUES (16, 6);
INSERT INTO word_group_assign (word_id, group_id) VALUES (17, 3);
INSERT INTO word_group_assign (word_id, group_id) VALUES (18, 3);
INSERT INTO word_group_assign (word_id, group_id) VALUES (18, 6);
INSERT INTO word_group_assign (word_id, group_id) VALUES (19, 3);
INSERT INTO word_group_assign (word_id, group_id) VALUES (6, 5);
INSERT INTO word_group_assign (word_id, group_id) VALUES (20, 5);
INSERT INTO word_group_assign (word_id, group_id) VALUES (21, 1);
INSERT INTO word_group_assign (word_id, group_id) VALUES (22, 1);
INSERT INTO word_group_assign (word_id, group_id) VALUES (22, 2);
INSERT INTO word_group_assign (word_id, group_id) VALUES (23, 1);
INSERT INTO word_group_assign (word_id, group_id) VALUES (23, 10);
INSERT INTO word_group_assign (word_id, group_id) VALUES (24, 1);
INSERT INTO word_group_assign (word_id, group_id) VALUES (25, 1);
INSERT INTO word_group_assign (word_id, group_id) VALUES (26, 1);
INSERT INTO word_group_assign (word_id, group_id) VALUES (26, 10);
INSERT INTO word_group_assign (word_id, group_id) VALUES (27, 3);


INSERT INTO word_groups (id, group_name, language_id) VALUES (1, 'noun', 5);
INSERT INTO word_groups (id, group_name, language_id) VALUES (2, 'noun clothes', 5);
INSERT INTO word_groups (id, group_name, language_id) VALUES (3, 'adjective', 5);
INSERT INTO word_groups (id, group_name, language_id) VALUES (4, 'determine', 5);
INSERT INTO word_groups (id, group_name, language_id) VALUES (5, 'possessive', 5);
INSERT INTO word_groups (id, group_name, language_id) VALUES (6, 'adjective color', 5);
INSERT INTO word_groups (id, group_name, language_id) VALUES (7, 'noun food', 5);
INSERT INTO word_groups (id, group_name, language_id) VALUES (8, 'noun tools', 5);
INSERT INTO word_groups (id, group_name, language_id) VALUES (9, 'noun modern', 5);
INSERT INTO word_groups (id, group_name, language_id) VALUES (10, 'noun animals', 5);


INSERT INTO words (id, word, language_id) VALUES (1, 'nitéhepi', 5);
INSERT INTO words (id, word, language_id) VALUES (2, 'nitȟáwa', 5);
INSERT INTO words (id, word, language_id) VALUES (3, 'kiŋ', 5);
INSERT INTO words (id, word, language_id) VALUES (4, 'šá', 5);
INSERT INTO words (id, word, language_id) VALUES (6, 'mitȟáwa', 5);
INSERT INTO words (id, word, language_id) VALUES (7, 'thípi', 5);
INSERT INTO words (id, word, language_id) VALUES (8, 'číkʼala', 5);
INSERT INTO words (id, word, language_id) VALUES (9, 'wakȟályapi', 5);
INSERT INTO words (id, word, language_id) VALUES (11, 'wičhítowapi', 5);
INSERT INTO words (id, word, language_id) VALUES (13, 'mas’íyapȟe', 5);
INSERT INTO words (id, word, language_id) VALUES (14, 'šiyútakaŋ', 5);
INSERT INTO words (id, word, language_id) VALUES (15, 'húŋkešni', 5);
INSERT INTO words (id, word, language_id) VALUES (16, 'sáŋ', 5);
INSERT INTO words (id, word, language_id) VALUES (17, 'tké', 5);
INSERT INTO words (id, word, language_id) VALUES (18, 'sápe', 5);
INSERT INTO words (id, word, language_id) VALUES (19, 'waštémna', 5);
INSERT INTO words (id, word, language_id) VALUES (20, 'nitȟáwa', 5);
INSERT INTO words (id, word, language_id) VALUES (21, 'oyúŋke', 5);
INSERT INTO words (id, word, language_id) VALUES (22, 'šiná', 5);
INSERT INTO words (id, word, language_id) VALUES (23, 'igmú', 5);
INSERT INTO words (id, word, language_id) VALUES (24, 'ožáŋžaŋglepi', 5);
INSERT INTO words (id, word, language_id) VALUES (25, 'iyápi', 5);
INSERT INTO words (id, word, language_id) VALUES (26, 'šúŋka', 5);
INSERT INTO words (id, word, language_id) VALUES (27, 'pȟáŋžela', 5);

