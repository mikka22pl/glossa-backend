
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


INSERT INTO lexers (id, lex_name, descr, parent_id) VALUES (1, 'WORD_FUNCTION', 'Funkcje części mowy', NULL);
INSERT INTO lexers (id, lex_name, descr, parent_id) VALUES (3, 'WORD_CATEGORY', 'Kategorie słów', NULL);
INSERT INTO lexers (id, lex_name, descr, parent_id) VALUES (5, 'noun', 'rzeczownik', 1);
INSERT INTO lexers (id, lex_name, descr, parent_id) VALUES (7, 'static verb', 'czasownik stanu', 1);
INSERT INTO lexers (id, lex_name, descr, parent_id) VALUES (2, 'verb', 'czasownik', 1);
INSERT INTO lexers (id, lex_name, descr, parent_id) VALUES (4, 'clothes', 'ubrania', 3);
INSERT INTO lexers (id, lex_name, descr, parent_id) VALUES (6, 'food', 'jedzenie', 3);
INSERT INTO lexers (id, lex_name, descr, parent_id) VALUES (8, 'adjective', 'przymiotnik', 1);
INSERT INTO lexers (id, lex_name, descr, parent_id) VALUES (9, 'article', 'rodzajnik', 1);
INSERT INTO lexers (id, lex_name, descr, parent_id) VALUES (10, 'possessive', 'zaimek dzierżawczy', 1);
INSERT INTO lexers (id, lex_name, descr, parent_id) VALUES (11, 'animals', 'zwierzęta', 3);
INSERT INTO lexers (id, lex_name, descr, parent_id) VALUES (12, 'colors', 'Colors', 3);
INSERT INTO lexers (id, lex_name, descr, parent_id) VALUES (13, 'look & feel', 'look & feel', 3);
INSERT INTO lexers (id, lex_name, descr, parent_id) VALUES (14, 'tools', 'tools', 3);


INSERT INTO sentence_structures (id, language_id, lesson_id, ordering, group_id, type) VALUES (1, 5, 4, 1, 5, 1);
INSERT INTO sentence_structures (id, language_id, lesson_id, ordering, group_id, type) VALUES (2, 5, 4, 2, 10, 2);
INSERT INTO sentence_structures (id, language_id, lesson_id, ordering, group_id, type) VALUES (3, 5, 4, 3, 9, 1);
INSERT INTO sentence_structures (id, language_id, lesson_id, ordering, group_id, type) VALUES (4, 5, 4, 4, 7, 1);


INSERT INTO word_categories (word_id, category_id, category_type) VALUES (18, 8, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (22, 4, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (22, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (14, 4, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (14, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (23, 11, 'C');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (1, 4, 'C');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (40, 8, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (31, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (8, 8, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (23, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (33, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (6, 10, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (1, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (4, 8, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (45, 8, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (3, 9, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (13, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (2, 10, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (21, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (46, 7, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (15, 7, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (25, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (29, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (16, 8, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (24, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (27, 8, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (41, 7, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (47, 8, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (35, 7, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (26, 11, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (26, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (7, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (17, 7, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (28, 6, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (28, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (9, 6, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (9, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (19, 7, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (11, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (36, 6, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (36, 7, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (32, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (43, 7, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (39, 8, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (31, 6, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (42, 7, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (39, 12, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (34, 4, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (34, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (44, 7, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (30, 5, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (38, 7, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (48, 7, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (37, 7, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (40, 12, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (35, 4, 'F');
INSERT INTO word_categories (word_id, category_id, category_type) VALUES (20, 10, 'F');


INSERT INTO words (id, word, language_id, created_date) VALUES (1, 'nitéhepi', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (2, 'nitȟáwa', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (3, 'kiŋ', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (4, 'šá', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (6, 'mitȟáwa', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (7, 'thípi', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (8, 'číkʼala', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (9, 'wakȟályapi', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (11, 'wičhítowapi', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (13, 'mas’íyapȟe', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (14, 'šiyútakaŋ', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (15, 'húŋkešni', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (16, 'sáŋ', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (17, 'tké', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (19, 'waštémna', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (21, 'oyúŋke', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (22, 'šiná', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (23, 'igmú', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (24, 'ožáŋžaŋglepi', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (25, 'iyápi', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (26, 'šúŋka', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (27, 'pȟáŋžela', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (28, 'waháŋpi', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (29, 'owóte', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (30, 'omás’apȟela', 5, '2016-11-13 20:13:58.783+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (31, 'bló', 5, '2016-11-13 20:14:57.855+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (32, 'wóayupte', 5, '2016-11-13 20:15:14.231+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (33, 'míla', 5, '2016-11-13 20:17:36.022+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (35, 'šóke', 5, '2016-11-13 20:39:02.798+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (36, 'wíphi', 5, '2016-11-13 20:39:09.17+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (37, 'šápA', 5, '2016-11-13 20:39:43.155+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (38, 'oškíškA', 5, '2016-11-13 20:39:54.348+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (41, 'škéhaŋ', 5, '2016-11-13 20:40:16.186+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (42, 'čhó', 5, '2016-11-13 20:40:21.342+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (43, 'wókȟokipȟekA', 5, '2016-11-13 20:40:34.436+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (44, 'očhíŋwašte', 5, '2016-11-13 20:40:42.28+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (45, 'kȟátA', 5, '2016-11-13 20:40:51.876+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (46, 'héčhetu šni', 5, '2016-11-13 20:40:58.912+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (47, 'pȟé', 5, '2016-11-13 20:41:17.854+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (48, 'ot’íŋzA', 5, '2016-11-13 20:41:31.251+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (20, 'tȟáwa', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (39, 'ǧí', 5, '2016-11-13 20:40:01.311+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (18, 'sápA', 5, '2016-11-13 19:36:41.74+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (34, 'iphíyakA', 5, '2016-11-13 20:17:59.183+01');
INSERT INTO words (id, word, language_id, created_date) VALUES (40, 'ská', 5, '2016-11-13 20:40:07.43+01');

