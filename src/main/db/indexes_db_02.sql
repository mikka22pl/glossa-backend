

SELECT pg_catalog.setval('courses_id_seq', 4, true);
SELECT pg_catalog.setval('languages_id_seq', 8, true);
SELECT pg_catalog.setval('lessons_id_seq', 6, true);
SELECT pg_catalog.setval('lexers_id_seq', 37, true);
SELECT pg_catalog.setval('sentence_structures_id_seq', 10, true);
SELECT pg_catalog.setval('sentence_translations_id_seq', 59, true);
SELECT pg_catalog.setval('templates_id_seq', 2, true);
SELECT pg_catalog.setval('verb_forms_id_seq', 4, true);
SELECT pg_catalog.setval('users_id_seq', 1, false);
SELECT pg_catalog.setval('words_id_seq', 50, true);
SELECT pg_catalog.setval('word_dictionary_id_seq', 95, true);
SELECT pg_catalog.setval('words_translations_id_seq', 96, true);



ALTER TABLE ONLY courses
    ADD CONSTRAINT courses_pkey PRIMARY KEY (id);

ALTER TABLE ONLY languages
    ADD CONSTRAINT languages_pkey PRIMARY KEY (id);

ALTER TABLE ONLY lesson_structures
    ADD CONSTRAINT lesson_structures_pkey PRIMARY KEY (lesson_id, structure_id);
    
ALTER TABLE ONLY lessons
    ADD CONSTRAINT lessons_pkey PRIMARY KEY (id);

ALTER TABLE ONLY lexers
    ADD CONSTRAINT lexers_pkey PRIMARY KEY (id);

ALTER TABLE ONLY sentence_builded
    ADD CONSTRAINT sentence_builded_pkey PRIMARY KEY (word_id, ordering, slot_id, translation_id);

ALTER TABLE ONLY template_slots
    ADD CONSTRAINT sentence_structures_pkey PRIMARY KEY (id);
    
ALTER TABLE ONLY sentence_translations
    ADD CONSTRAINT sentence_translations_pkey PRIMARY KEY (id);
    
ALTER TABLE ONLY slot_fixed_words
    ADD CONSTRAINT slot_fixed_words_pkey PRIMARY KEY (slot_id, word_id);
    
ALTER TABLE ONLY slot_specified
    ADD CONSTRAINT slot_specified_pkey PRIMARY KEY (template_id, ordering, specified_id);
    
ALTER TABLE ONLY templates
    ADD CONSTRAINT templates_pkey PRIMARY KEY (id);
    
ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);

ALTER TABLE ONLY verb_forms
    ADD CONSTRAINT verb_forms_pkey PRIMARY KEY (id);
    
ALTER TABLE ONLY word_categories_include
    ADD CONSTRAINT word_categories_include_pkey PRIMARY KEY (word_id, category_id);
    
ALTER TABLE ONLY word_categories
    ADD CONSTRAINT word_categories_pkey PRIMARY KEY (word_id, category_id);
    
ALTER TABLE ONLY words_learning
    ADD CONSTRAINT words_learning_pkey PRIMARY KEY (user_id, language_id, word_id);

    
ALTER TABLE ONLY word_dictionary
    ADD CONSTRAINT word_dictionary_pkey PRIMARY KEY (id);

ALTER TABLE ONLY word_classes
    ADD CONSTRAINT word_classes_pkey PRIMARY KEY (word_id, type_id);
    
ALTER TABLE ONLY word_functions
    ADD CONSTRAINT word_functions_pkey PRIMARY KEY (word_id, function_id);
    
ALTER TABLE ONLY words_learning
    ADD CONSTRAINT words_learning_pkey PRIMARY KEY (user_id, language_id, word_id);
    
ALTER TABLE ONLY words
    ADD CONSTRAINT words_pkey PRIMARY KEY (id);
    
ALTER TABLE ONLY words_translations
    ADD CONSTRAINT words_translations_pkey PRIMARY KEY (id);
    

ALTER TABLE ONLY courses
    ADD CONSTRAINT courses_language_id_fkey FOREIGN KEY (language_id) REFERENCES languages(id);

ALTER TABLE ONLY lesson_structures
    ADD CONSTRAINT lesson_structures_lesson_id_fkey FOREIGN KEY (lesson_id) REFERENCES lessons(id);
ALTER TABLE ONLY lesson_structures
    ADD CONSTRAINT lesson_structures_structure_id_fkey FOREIGN KEY (structure_id) REFERENCES templates(id);

ALTER TABLE ONLY lessons
    ADD CONSTRAINT lessons_course_id_fkey FOREIGN KEY (course_id) REFERENCES courses(id);

ALTER TABLE ONLY sentence_builded
    ADD CONSTRAINT sentence_builded_slot_id_fkey FOREIGN KEY (slot_id) REFERENCES template_slots(id);
ALTER TABLE ONLY sentence_builded
    ADD CONSTRAINT sentence_builded_translation_id_fkey FOREIGN KEY (translation_id) REFERENCES sentence_translations(id);
ALTER TABLE ONLY sentence_builded
    ADD CONSTRAINT sentence_builded_word_id_fkey FOREIGN KEY (word_id) REFERENCES words(id);

ALTER TABLE ONLY template_slots
    ADD CONSTRAINT sentence_templates_template_id_fkey FOREIGN KEY (template_id) REFERENCES templates(id);
    
ALTER TABLE ONLY slot_fixed_words
    ADD CONSTRAINT slot_fixed_words_slot_id_fkey FOREIGN KEY (slot_id) REFERENCES template_slots(id);
    
ALTER TABLE ONLY slot_fixed_words
    ADD CONSTRAINT slot_fixed_words_word_id_fkey FOREIGN KEY (word_id) REFERENCES words(id);
    
ALTER TABLE ONLY slot_specified
    ADD CONSTRAINT slot_specified_specified_id_fkey FOREIGN KEY (specified_id) REFERENCES lexers(id);
    
ALTER TABLE ONLY slot_specified
    ADD CONSTRAINT slot_specified_template_id_fkey FOREIGN KEY (template_id) REFERENCES templates(id);
    
ALTER TABLE ONLY template_slots
    ADD CONSTRAINT template_slots_group_id_fkey FOREIGN KEY (group_id) REFERENCES lexers(id);

ALTER TABLE ONLY templates
    ADD CONSTRAINT templates_language_id_fkey FOREIGN KEY (language_id) REFERENCES languages(id);
ALTER TABLE ONLY verb_forms
    ADD CONSTRAINT verb_forms_form_type_id_fkey FOREIGN KEY (form_type_id) REFERENCES lexers(id);

ALTER TABLE ONLY verb_forms
    ADD CONSTRAINT verb_forms_word_id_fkey FOREIGN KEY (word_id) REFERENCES words(id);

ALTER TABLE ONLY word_categories
    ADD CONSTRAINT word_categories_category_id_fkey FOREIGN KEY (category_id) REFERENCES lexers(id);

ALTER TABLE ONLY word_categories_include
    ADD CONSTRAINT word_categories_include_category_id_fkey FOREIGN KEY (category_id) REFERENCES lexers(id);

ALTER TABLE ONLY word_categories_include
    ADD CONSTRAINT word_categories_include_word_id_fkey FOREIGN KEY (word_id) REFERENCES words(id);

ALTER TABLE ONLY word_categories
    ADD CONSTRAINT word_categories_word_id_fkey FOREIGN KEY (word_id) REFERENCES words(id);

ALTER TABLE ONLY word_classes
    ADD CONSTRAINT word_classes_type_id_fkey FOREIGN KEY (type_id) REFERENCES lexers(id);

ALTER TABLE ONLY word_classes
    ADD CONSTRAINT word_classes_word_id_fkey FOREIGN KEY (word_id) REFERENCES words(id);

ALTER TABLE ONLY word_functions
    ADD CONSTRAINT word_functions_function_id_fkey FOREIGN KEY (function_id) REFERENCES lexers(id);

ALTER TABLE ONLY word_functions
    ADD CONSTRAINT word_functions_word_id_fkey FOREIGN KEY (word_id) REFERENCES words(id);

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

ALTER TABLE ONLY words_translations
    ADD CONSTRAINT words_translations_translation_id_fkey FOREIGN KEY (translation_id) REFERENCES word_dictionary(id);

ALTER TABLE ONLY words_translations
    ADD CONSTRAINT words_translations_word_id_fkey FOREIGN KEY (word_id) REFERENCES words(id);
    
    