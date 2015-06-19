-- create table admin(id serial primary key, nome varchar, senha varchar);
-- insert into admin(nome, senha) values('admin',md5('123'))
-- create table filme(id serial primary key, genero varchar, trailer varchar, faixa_etaria varchar, diretor varchar, duracao varchar, sinopse varchar)
-- create table elenco(id serial primary key, id_filme integer references filme, nome_ator varchar, nome_ator_filme varchar)
-- create table tipo(id serial primary key, nome varchar);
-- insert into tipo(nome) values('Legendado');
-- insert into tipo(nome) values('Dublado');
-- create table sessao(id serial primary key, hora_inicio timestamp, hora_fim timestamp, id_filme integer references filme, id_tipo integer references tipo, preco_adulto money, preco_estudante money, preco_idoso money, sala integer);

	 -- CREATE OR REPLACE FUNCTION emp_stamp() RETURNS trigger AS $emp_stamp$
-- 	    DECLARE
-- 		r record;
-- 	    BEGIN
-- 		for r in select * from sessao where sala = NEW.sala loop
-- 			IF (r.hora_inicio, r.hora_fim) OVERLAPS
-- 				(NEW.hora_inicio, NEW.hora_fim) THEN
-- 				return null;
-- 			END IF;
-- 		end loop;
-- 		return NEW;
-- 	    END;
-- 	$emp_stamp$ LANGUAGE plpgsql;

-- 	CREATE TRIGGER sala_reservada BEFORE INSERT OR UPDATE ON sessao
-- 	    FOR EACH ROW EXECUTE PROCEDURE emp_stamp();

