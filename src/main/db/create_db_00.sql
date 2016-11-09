
CREATE DATABASE glossa WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Polish_Poland.1250' LC_CTYPE = 'Polish_Poland.1250';

SET client_encoding = 'UTF8';


CREATE TABLE courses (
    id integer NOT NULL,
    course_name character varying(30) NOT NULL,
    language_id integer NOT NULL
);

CREATE SEQUENCE courses_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE courses_id_seq OWNED BY courses.id;
    
CREATE TABLE languages (
    id integer NOT NULL,
    lang_name character varying(20) NOT NULL,
    code character(2)
);

CREATE SEQUENCE languages_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE languages_id_seq OWNED BY languages.id;

ALTER TABLE ONLY courses ALTER COLUMN id SET DEFAULT nextval('courses_id_seq'::regclass);
ALTER TABLE ONLY languages ALTER COLUMN id SET DEFAULT nextval('languages_id_seq'::regclass);



INSERT INTO courses (id, course_name, language_id) VALUES (1, 'Course 1', 1);
INSERT INTO courses (id, course_name, language_id) VALUES (2, 'Course 2', 1);
INSERT INTO courses (id, course_name, language_id) VALUES (3, 'Course 3', 1);


SELECT pg_catalog.setval('courses_id_seq', 3, true);


INSERT INTO languages (id, lang_name, code) VALUES (1, 'szwedzki', 'se');
INSERT INTO languages (id, lang_name, code) VALUES (2, 'angielski', 'uk');
INSERT INTO languages (id, lang_name, code) VALUES (3, 'fiński', 'fi');
INSERT INTO languages (id, lang_name, code) VALUES (4, 'niemiecki', 'de');
INSERT INTO languages (id, lang_name, code) VALUES (5, 'lakota', 'la');
INSERT INTO languages (id, lang_name, code) VALUES (6, 'grecki', 'gr');
INSERT INTO languages (id, lang_name, code) VALUES (7, 'norweski', 'no');
INSERT INTO languages (id, lang_name, code) VALUES (8, 'gruziński', 'ge');


SELECT pg_catalog.setval('languages_id_seq', 8, true);



ALTER TABLE ONLY courses
    ADD CONSTRAINT courses_pkey PRIMARY KEY (id);

ALTER TABLE ONLY languages
    ADD CONSTRAINT languages_pkey PRIMARY KEY (id);

ALTER TABLE ONLY courses
    ADD CONSTRAINT courses_language_id_fkey FOREIGN KEY (language_id) REFERENCES languages(id);
    
