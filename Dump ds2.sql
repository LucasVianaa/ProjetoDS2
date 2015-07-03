--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.2
-- Dumped by pg_dump version 9.4.2
-- Started on 2015-07-03 00:09:16

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 2040 (class 1262 OID 12135)
-- Dependencies: 2039
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- TOC entry 181 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2043 (class 0 OID 0)
-- Dependencies: 181
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- TOC entry 180 (class 3079 OID 16384)
-- Name: adminpack; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;


--
-- TOC entry 2044 (class 0 OID 0)
-- Dependencies: 180
-- Name: EXTENSION adminpack; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 172 (class 1259 OID 16917)
-- Name: admin; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE admin (
    id integer NOT NULL,
    nome character varying,
    senha character varying
);


ALTER TABLE admin OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16923)
-- Name: admin_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE admin_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE admin_id_seq OWNER TO postgres;

--
-- TOC entry 2045 (class 0 OID 0)
-- Dependencies: 173
-- Name: admin_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE admin_id_seq OWNED BY admin.id;


--
-- TOC entry 177 (class 1259 OID 17024)
-- Name: elenco; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE elenco (
    id integer NOT NULL,
    id_filme integer,
    nome_ator character varying
);


ALTER TABLE elenco OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 17022)
-- Name: elenco_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE elenco_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE elenco_id_seq OWNER TO postgres;

--
-- TOC entry 2046 (class 0 OID 0)
-- Dependencies: 176
-- Name: elenco_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE elenco_id_seq OWNED BY elenco.id;


--
-- TOC entry 174 (class 1259 OID 16933)
-- Name: filme; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE filme (
    id integer NOT NULL,
    genero character varying,
    trailer character varying,
    faixa_etaria character varying,
    diretor character varying,
    duracao character varying,
    sinopse character varying,
    titulo character varying
);


ALTER TABLE filme OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 16939)
-- Name: filme_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE filme_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE filme_id_seq OWNER TO postgres;

--
-- TOC entry 2047 (class 0 OID 0)
-- Dependencies: 175
-- Name: filme_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE filme_id_seq OWNED BY filme.id;


--
-- TOC entry 179 (class 1259 OID 17040)
-- Name: sessao; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sessao (
    id integer NOT NULL,
    hora_inicio timestamp without time zone,
    hora_fim timestamp without time zone,
    id_filme integer,
    preco_adulto numeric,
    preco_estudante numeric,
    preco_idoso numeric,
    sala integer,
    its3d boolean,
    itslegendado boolean
);


ALTER TABLE sessao OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 17038)
-- Name: sessao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sessao_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sessao_id_seq OWNER TO postgres;

--
-- TOC entry 2048 (class 0 OID 0)
-- Dependencies: 178
-- Name: sessao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sessao_id_seq OWNED BY sessao.id;


--
-- TOC entry 1904 (class 2604 OID 16962)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY admin ALTER COLUMN id SET DEFAULT nextval('admin_id_seq'::regclass);


--
-- TOC entry 1906 (class 2604 OID 17027)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY elenco ALTER COLUMN id SET DEFAULT nextval('elenco_id_seq'::regclass);


--
-- TOC entry 1905 (class 2604 OID 16964)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY filme ALTER COLUMN id SET DEFAULT nextval('filme_id_seq'::regclass);


--
-- TOC entry 1907 (class 2604 OID 17043)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sessao ALTER COLUMN id SET DEFAULT nextval('sessao_id_seq'::regclass);


--
-- TOC entry 2027 (class 0 OID 16917)
-- Dependencies: 172
-- Data for Name: admin; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO admin (id, nome, senha) VALUES (1, 'admin', '202cb962ac59075b964b07152d234b70');


--
-- TOC entry 2049 (class 0 OID 0)
-- Dependencies: 173
-- Name: admin_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('admin_id_seq', 1, true);


--
-- TOC entry 2032 (class 0 OID 17024)
-- Dependencies: 177
-- Data for Name: elenco; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO elenco (id, id_filme, nome_ator) VALUES (12, 17, 'Paul Walker');
INSERT INTO elenco (id, id_filme, nome_ator) VALUES (13, 17, 'Vin Diesel');


--
-- TOC entry 2050 (class 0 OID 0)
-- Dependencies: 176
-- Name: elenco_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('elenco_id_seq', 13, true);


--
-- TOC entry 2029 (class 0 OID 16933)
-- Dependencies: 174
-- Data for Name: filme; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO filme (id, genero, trailer, faixa_etaria, diretor, duracao, sinopse, titulo) VALUES (17, 'velocidade', 'youtubiu', '135', 'Steven ', '130', 'Era uma vez', 'velozes e alguma co');


--
-- TOC entry 2051 (class 0 OID 0)
-- Dependencies: 175
-- Name: filme_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('filme_id_seq', 17, true);


--
-- TOC entry 2034 (class 0 OID 17040)
-- Dependencies: 179
-- Data for Name: sessao; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO sessao (id, hora_inicio, hora_fim, id_filme, preco_adulto, preco_estudante, preco_idoso, sala, its3d, itslegendado) VALUES (11, '2015-07-15 23:00:00', '2015-07-16 01:10:00', 17, 6, 5, 5, 1, true, true);


--
-- TOC entry 2052 (class 0 OID 0)
-- Dependencies: 178
-- Name: sessao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sessao_id_seq', 11, true);


--
-- TOC entry 1909 (class 2606 OID 16969)
-- Name: admin_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (id);


--
-- TOC entry 1913 (class 2606 OID 17032)
-- Name: elenco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY elenco
    ADD CONSTRAINT elenco_pkey PRIMARY KEY (id);


--
-- TOC entry 1911 (class 2606 OID 16973)
-- Name: filme_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY filme
    ADD CONSTRAINT filme_pkey PRIMARY KEY (id);


--
-- TOC entry 1915 (class 2606 OID 17048)
-- Name: sessao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sessao
    ADD CONSTRAINT sessao_pkey PRIMARY KEY (id);


--
-- TOC entry 1916 (class 2606 OID 17033)
-- Name: elenco_id_filme_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY elenco
    ADD CONSTRAINT elenco_id_filme_fkey FOREIGN KEY (id_filme) REFERENCES filme(id) ON DELETE CASCADE;


--
-- TOC entry 1917 (class 2606 OID 17049)
-- Name: sessao_id_filme_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sessao
    ADD CONSTRAINT sessao_id_filme_fkey FOREIGN KEY (id_filme) REFERENCES filme(id) ON DELETE CASCADE;


--
-- TOC entry 2042 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2015-07-03 00:09:16

--
-- PostgreSQL database dump complete
--

