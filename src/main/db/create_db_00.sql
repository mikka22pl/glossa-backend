
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

CREATE TABLE lessons (
    id integer NOT NULL,
    lesson_name character varying(25) NOT NULL,
    course_id integer NOT NULL
);
CREATE SEQUENCE lessons_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    
ALTER SEQUENCE lessons_id_seq OWNED BY lessons.id;


CREATE TABLE lexers (
    id integer NOT NULL,
    lex_name character varying(40) NOT NULL,
    descr character varying(80),
    parent_id integer
);
CREATE SEQUENCE lexers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE lexers_id_seq OWNED BY lexers.id;



CREATE TABLE sentence_structures (
    id integer NOT NULL,
    language_id integer,
    lesson_id integer NOT NULL,
    ordering smallint,
    group_id integer NOT NULL,
    type smallint NOT NULL
);
CREATE SEQUENCE sentence_structures_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE sentence_structures_id_seq OWNED BY sentence_structures.id;


CREATE TABLE users (
    id integer NOT NULL,
    login character varying(20) NOT NULL,
    passwd character varying(80)
);
CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE users_id_seq OWNED BY users.id;


CREATE TABLE word_group_assign (
    word_id integer NOT NULL,
    group_id integer NOT NULL
);

CREATE TABLE word_groups (
    id integer NOT NULL,
    group_name character varying(20) NOT NULL,
    language_id integer NOT NULL
);
CREATE SEQUENCE word_groups_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE word_groups_id_seq OWNED BY word_groups.id;

CREATE TABLE words (
    id integer NOT NULL,
    word character varying(30) NOT NULL,
    language_id integer NOT NULL
);
CREATE SEQUENCE words_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE words_id_seq OWNED BY words.id;


CREATE TABLE words_learning (
    user_id integer NOT NULL,
    language_id integer NOT NULL,
    word_id integer NOT NULL,
    last_used timestamp with time zone NOT NULL
);

ALTER TABLE ONLY courses ALTER COLUMN id SET DEFAULT nextval('courses_id_seq'::regclass);
ALTER TABLE ONLY languages ALTER COLUMN id SET DEFAULT nextval('languages_id_seq'::regclass);
ALTER TABLE ONLY lessons ALTER COLUMN id SET DEFAULT nextval('lessons_id_seq'::regclass);
ALTER TABLE ONLY lexers ALTER COLUMN id SET DEFAULT nextval('lexers_id_seq'::regclass);
ALTER TABLE ONLY sentence_structures ALTER COLUMN id SET DEFAULT nextval('sentence_structures_id_seq'::regclass);
ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);
ALTER TABLE ONLY word_groups ALTER COLUMN id SET DEFAULT nextval('word_groups_id_seq'::regclass);
ALTER TABLE ONLY words ALTER COLUMN id SET DEFAULT nextval('words_id_seq'::regclass);
    
