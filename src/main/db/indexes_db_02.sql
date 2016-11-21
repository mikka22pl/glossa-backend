

SELECT pg_catalog.setval('courses_id_seq', 4, true);
SELECT pg_catalog.setval('languages_id_seq', 8, true);
SELECT pg_catalog.setval('lessons_id_seq', 4, true);
SELECT pg_catalog.setval('lexers_id_seq', 2, true);
SELECT pg_catalog.setval('sentence_structures_id_seq', 4, true);
SELECT pg_catalog.setval('users_id_seq', 1, false);
SELECT pg_catalog.setval('word_groups_id_seq', 10, true);
SELECT pg_catalog.setval('words_id_seq', 27, true);



ALTER TABLE ONLY courses
    ADD CONSTRAINT courses_pkey PRIMARY KEY (id);

ALTER TABLE ONLY languages
    ADD CONSTRAINT languages_pkey PRIMARY KEY (id);

ALTER TABLE ONLY lessons
    ADD CONSTRAINT lessons_pkey PRIMARY KEY (id);

ALTER TABLE ONLY lexers
    ADD CONSTRAINT lexers_pkey PRIMARY KEY (id);

ALTER TABLE ONLY sentence_structures
    ADD CONSTRAINT sentence_structures_pkey PRIMARY KEY (id);

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);

ALTER TABLE ONLY word_group_assign
    ADD CONSTRAINT word_group_assign_pkey PRIMARY KEY (word_id, group_id);

ALTER TABLE ONLY word_groups
    ADD CONSTRAINT word_groups_pkey PRIMARY KEY (id);

ALTER TABLE ONLY words_learning
    ADD CONSTRAINT words_learning_pkey PRIMARY KEY (user_id, language_id, word_id);

ALTER TABLE ONLY words
    ADD CONSTRAINT words_pkey PRIMARY KEY (id);

ALTER TABLE ONLY courses
    ADD CONSTRAINT courses_language_id_fkey FOREIGN KEY (language_id) REFERENCES languages(id);

ALTER TABLE ONLY lessons
    ADD CONSTRAINT lessons_course_id_fkey FOREIGN KEY (course_id) REFERENCES courses(id);

ALTER TABLE ONLY sentence_structures
    ADD CONSTRAINT sentence_structures_group_id_fkey FOREIGN KEY (group_id) REFERENCES word_groups(id);

ALTER TABLE ONLY sentence_structures
    ADD CONSTRAINT sentence_structures_language_id_fkey FOREIGN KEY (language_id) REFERENCES languages(id);

ALTER TABLE ONLY sentence_structures
    ADD CONSTRAINT sentence_structures_lesson_id_fkey FOREIGN KEY (lesson_id) REFERENCES lessons(id);

ALTER TABLE ONLY word_group_assign
    ADD CONSTRAINT word_group_assign_group_id_fkey FOREIGN KEY (group_id) REFERENCES word_groups(id);

ALTER TABLE ONLY word_group_assign
    ADD CONSTRAINT word_group_assign_word_id_fkey FOREIGN KEY (word_id) REFERENCES words(id);

ALTER TABLE ONLY word_groups
    ADD CONSTRAINT word_groups_language_id_fkey FOREIGN KEY (language_id) REFERENCES languages(id);

ALTER TABLE ONLY words
    ADD CONSTRAINT words_language_id_fkey FOREIGN KEY (language_id) REFERENCES languages(id);

ALTER TABLE ONLY words_learning
    ADD CONSTRAINT words_learning_language_id_fkey FOREIGN KEY (language_id) REFERENCES languages(id);

ALTER TABLE ONLY words_learning
    ADD CONSTRAINT words_learning_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE ONLY words_learning
    ADD CONSTRAINT words_learning_word_id_fkey FOREIGN KEY (word_id) REFERENCES words(id);

