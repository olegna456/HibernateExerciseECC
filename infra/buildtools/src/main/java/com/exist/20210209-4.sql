CREATE TABLE public.person_role
(
    roleid integer,
    person_id integer,
    CONSTRAINT personfk FOREIGN KEY (person_id)
        REFERENCES public.person (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT role_fk FOREIGN KEY (roleid)
        REFERENCES public.roles (roleid) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)