--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.7
-- Dumped by pg_dump version 9.5.7

-- Started on 2017-10-24 10:59:20

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2142 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 185 (class 1259 OID 18232)
-- Name: gecj; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE gecj (
    id bigint NOT NULL,
    ano integer,
    aprovado boolean NOT NULL,
    data_calculo date,
    de_acordo boolean,
    justificativa character varying(255),
    mes integer,
    parecer character varying(255),
    juiz_id bigint
);


ALTER TABLE gecj OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 18240)
-- Name: gecj_item; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE gecj_item (
    id bigint NOT NULL,
    auxilio character varying(255),
    de_acordo boolean,
    deferimento character varying(255),
    dia integer,
    em_vara_habilitada boolean,
    finalidade_evento character varying(255),
    gratificavel boolean,
    justificativa character varying(255),
    motivo character varying(255),
    parecer character varying(255),
    sub_tipo_evento character varying(255),
    tipo_evento character varying(255),
    util boolean,
    versao character varying(255),
    gecj_id bigint
);


ALTER TABLE gecj_item OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 18224)
-- Name: gecj_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE gecj_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE gecj_seq OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 18226)
-- Name: gecjitem_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE gecjitem_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE gecjitem_seq OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 18280)
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hibernate_sequence OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 18248)
-- Name: juiz; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE juiz (
    id bigint NOT NULL,
    cpf character varying(255),
    email character varying(255),
    nome character varying(255)
);


ALTER TABLE juiz OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 18228)
-- Name: juiz_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE juiz_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE juiz_seq OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 18272)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usuario (
    id bigint NOT NULL,
    email character varying(255) NOT NULL,
    perfil character varying(255) NOT NULL,
    senha character varying(255) NOT NULL
);


ALTER TABLE usuario OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 18256)
-- Name: vara; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE vara (
    id bigint NOT NULL,
    nome character varying(255)
);


ALTER TABLE vara OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 18230)
-- Name: vara_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE vara_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE vara_seq OWNER TO postgres;

--
-- TOC entry 2012 (class 2606 OID 18247)
-- Name: gecj_item_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gecj_item
    ADD CONSTRAINT gecj_item_pkey PRIMARY KEY (id);


--
-- TOC entry 2010 (class 2606 OID 18239)
-- Name: gecj_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gecj
    ADD CONSTRAINT gecj_pkey PRIMARY KEY (id);


--
-- TOC entry 2014 (class 2606 OID 18255)
-- Name: juiz_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY juiz
    ADD CONSTRAINT juiz_pkey PRIMARY KEY (id);


--
-- TOC entry 2018 (class 2606 OID 18279)
-- Name: usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- TOC entry 2016 (class 2606 OID 18260)
-- Name: vara_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vara
    ADD CONSTRAINT vara_pkey PRIMARY KEY (id);


--
-- TOC entry 2020 (class 2606 OID 18266)
-- Name: fk89k9xh95vteqs33k0f4951pi4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gecj_item
    ADD CONSTRAINT fk89k9xh95vteqs33k0f4951pi4 FOREIGN KEY (gecj_id) REFERENCES gecj(id);


--
-- TOC entry 2019 (class 2606 OID 18261)
-- Name: fk8iw7haojao036yoj41rqywuhl; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY gecj
    ADD CONSTRAINT fk8iw7haojao036yoj41rqywuhl FOREIGN KEY (juiz_id) REFERENCES juiz(id);


--
-- TOC entry 2141 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-10-24 10:59:21

--
-- PostgreSQL database dump complete
--

