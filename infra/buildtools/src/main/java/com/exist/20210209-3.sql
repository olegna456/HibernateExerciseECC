CREATE TABLE public.roles
(
    roleid integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    role character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT role_pk UNIQUE (roleid)
)
