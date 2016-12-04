

SELECT pg_catalog.setval('courses_id_seq', 4, true);
SELECT pg_catalog.setval('languages_id_seq', 8, true);
SELECT pg_catalog.setval('lessons_id_seq', 4, true);
SELECT pg_catalog.setval('lexers_id_seq', 14, true);
SELECT pg_catalog.setval('sentence_structures_id_seq', 4, true);
SELECT pg_catalog.setval('users_id_seq', 1, false);
SELECT pg_catalog.setval('words_id_seq', 48, true);
SELECT pg_catalog.setval('word_dictionary_id_seq', 1, false);
SELECT pg_catalog.setval('words_translations_id_seq', 1, false);



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

ALTER TABLE ONLY words_learning
    ADD CONSTRAINT words_learning_pkey PRIMARY KEY (user_id, language_id, word_id);

ALTER TABLE ONLY words
    ADD CONSTRAINT words_pkey PRIMARY KEY (id);

ALTER TABLE ONLY word_categories
    ADD CONSTRAINT word_categories_pkey PRIMARY KEY (word_id, category_id);
    
ALTER TABLE ONLY word_dictionary
    ADD CONSTRAINT word_dictionary_pkey PRIMARY KEY (id);
    
ALTER TABLE ONLY words_translations
    ADD CONSTRAINT words_translations_pkey PRIMARY KEY (id);

    
ALTER TABLE ONLY courses
    ADD CONSTRAINT courses_language_id_fkey FOREIGN KEY (language_id) REFERENCES languages(id);

ALTER TABLE ONLY lessons
    ADD CONSTRAINT lessons_course_id_fkey FOREIGN KEY (course_id) REFERENCES courses(id);

ALTER TABLE ONLY sentence_structures
    ADD CONSTRAINT sentence_structures_language_id_fkey FOREIGN KEY (language_id) REFERENCES languages(id);

ALTER TABLE ONLY sentence_structures
    ADD CONSTRAINT sentence_structures_lesson_id_fkey FOREIGN KEY (lesson_id) REFERENCES lessons(id);

ALTER TABLE ONLY words
    ADD CONSTRAINT words_language_id_fkey FOREIGN KEY (language_id) REFERENCES languages(id);

ALTER TABLE ONLY words_learning
    ADD CONSTRAINT words_learning_language_id_fkey FOREIGN KEY (language_id) REFERENCES languages(id);

ALTER TABLE ONLY words_learning
    ADD CONSTRAINT words_learning_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);

ALTER TABLE ONLY words_learning
    ADD CONSTRAINT words_learning_word_id_fkey FOREIGN KEY (word_id) REFERENCES words(id);

ALTER TABLE ONLY word_categories
    ADD CONSTRAINT word_categories_word_id_fkey FOREIGN KEY (word_id) REFERENCES words(id);
    
ALTER TABLE ONLY word_categories
    ADD CONSTRAINT word_categories_category_id_fkey FOREIGN KEY (category_id) REFERENCES lexers

ALTER TABLE ONLY words_translations
    ADD CONSTRAINT words_translations_translation_id_fkey FOREIGN KEY (translation_id) REFERENCES word_dictionary(id);

ALTER TABLE ONLY words_translations
    ADD CONSTRAINT words_translations_word_id_fkey FOREIGN KEY (word_id) REFERENCES words(id);
    
    