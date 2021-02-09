CREATE TABLE public.contactinformation
(
    contact_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    person_id integer,
    landline character varying(255) COLLATE pg_catalog."default",
    mobilenumber character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT contactinformation_pkey PRIMARY KEY (contact_id),
    CONSTRAINT person_fk FOREIGN KEY (person_id)
        REFERENCES public.person (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)