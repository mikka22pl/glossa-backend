
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

CREATE TABLE lesson_structures (
    lesson_id integer NOT NULL,
    structure_id integer NOT NULL
);

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


CREATE TABLE sentence_builded (
    word_id integer NOT NULL,
    ordering smallint NOT NULL,
    slot_id integer NOT NULL,
    translation_id integer NOT NULL,
    word_form_id integer
);

CREATE TABLE template_slots (
    id integer NOT NULL,
    ordering smallint,
    group_id integer NOT NULL,
    type smallint NOT NULL,
    template_id integer NOT NULL,
    connected smallint
);
COMMENT ON COLUMN template_slots.connected IS '1 - podmiot
2 - czasownik; categoriesInclude ; potrzebuje podmiotu';
CREATE SEQUENCE sentence_structures_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    
ALTER SEQUENCE sentence_structures_id_seq OWNED BY template_slots.id;

CREATE TABLE sentence_translations (
    id integer NOT NULL,
    translation text NOT NULL
);
CREATE SEQUENCE sentence_translations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    
ALTER SEQUENCE sentence_translations_id_seq OWNED BY sentence_translations.id;

CREATE TABLE slot_fixed_words (
    slot_id integer NOT NULL,
    word_id integer NOT NULL
);

CREATE TABLE slot_specified (
    template_id integer NOT NULL,
    ordering smallint NOT NULL,
    specified_id integer NOT NULL
);

CREATE TABLE templates (
    id integer NOT NULL,
    template_name character varying(60) NOT NULL,
    language_id integer NOT NULL
);

CREATE SEQUENCE templates_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    
ALTER SEQUENCE templates_id_seq OWNED BY templates.id;


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

CREATE TABLE verb_forms (
    id integer NOT NULL,
    word_id integer NOT NULL,
    verb_form character varying(40) NOT NULL,
    form_type_id integer
);


CREATE SEQUENCE verb_forms_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    
ALTER SEQUENCE verb_forms_id_seq OWNED BY verb_forms.id;

CREATE TABLE word_categories (
    word_id integer NOT NULL,
    category_id integer NOT NULL,
    category_type character(1) NOT NULL
);
CREATE TABLE word_categories_include (
    word_id integer NOT NULL,
    category_id integer NOT NULL
);
COMMENT ON TABLE word_categories_include IS 'tabela opisuje jakie słowa z jakimi kategoriami się łączą np słowo smaczny łączy się z kategorią jedzenie. Nie mozna smaczny laczyc z np osobami.';
CREATE TABLE word_classes (
    word_id integer NOT NULL,
    type_id integer NOT NULL
);
CREATE TABLE word_dictionary (
    id integer NOT NULL,
    entry_word character varying(50) NOT NULL
);

CREATE SEQUENCE word_dictionary_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE word_dictionary_id_seq OWNED BY word_dictionary.id;

CREATE TABLE word_functions (
    word_id integer NOT NULL,
    function_id integer NOT NULL
);
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
    language_id integer NOT NULL,
    created_date timestamp with time zone DEFAULT now() NOT NULL
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


CREATE TABLE words_translations (
    id integer NOT NULL,
    word_id integer NOT NULL,
    translation_id integer NOT NULL
);
CREATE SEQUENCE words_translations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER SEQUENCE words_translations_id_seq OWNED BY words_translations.id;


ALTER TABLE ONLY courses ALTER COLUMN id SET DEFAULT nextval('courses_id_seq'::regclass);
ALTER TABLE ONLY languages ALTER COLUMN id SET DEFAULT nextval('languages_id_seq'::regclass);
ALTER TABLE ONLY lessons ALTER COLUMN id SET DEFAULT nextval('lessons_id_seq'::regclass);
ALTER TABLE ONLY lexers ALTER COLUMN id SET DEFAULT nextval('lexers_id_seq'::regclass);
ALTER TABLE ONLY sentence_translations ALTER COLUMN id SET DEFAULT nextval('sentence_translations_id_seq'::regclass);
ALTER TABLE ONLY template_slots ALTER COLUMN id SET DEFAULT nextval('sentence_structures_id_seq'::regclass);
ALTER TABLE ONLY templates ALTER COLUMN id SET DEFAULT nextval('templates_id_seq'::regclass);
ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);
ALTER TABLE ONLY verb_forms ALTER COLUMN id SET DEFAULT nextval('verb_forms_id_seq'::regclass);
ALTER TABLE ONLY word_dictionary ALTER COLUMN id SET DEFAULT nextval('word_dictionary_id_seq'::regclass);
ALTER TABLE ONLY word_groups ALTER COLUMN id SET DEFAULT nextval('word_groups_id_seq'::regclass);
ALTER TABLE ONLY words ALTER COLUMN id SET DEFAULT nextval('words_id_seq'::regclass);
ALTER TABLE ONLY words_translations ALTER COLUMN id SET DEFAULT nextval('words_translations_id_seq'::regclass);
