CREATE TABLE person
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    lastname character varying(255) COLLATE pg_catalog."default",
    firstname character varying(255) COLLATE pg_catalog."default",
    middlename character varying(255) COLLATE pg_catalog."default",
    suffix character varying COLLATE pg_catalog."default",
    title character varying COLLATE pg_catalog."default",
    streetnumber integer,
    barangay character varying COLLATE pg_catalog."default",
    municipalityorcity character varying COLLATE pg_catalog."default",
    zipcode integer,
    birthday character varying COLLATE pg_catalog."default",
    datehired character varying COLLATE pg_catalog."default",
    gwa double precision,
    currentlyemployed boolean,
    CONSTRAINT pk UNIQUE (id)
)