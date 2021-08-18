
--Dropear las tablas
--Estas sentencias verifican que no existan las tablas previamente
--En caso de existir, las elimina en CASCADA, es decir,
--elimina todo el flujo asociado a la tabla

DROP TABLE IF EXISTS public.volunteer0 CASCADE;
DROP TABLE IF EXISTS public.volunteer1 CASCADE;
DROP TABLE IF EXISTS public.volunteer2 CASCADE;
DROP TABLE IF EXISTS public.skill CASCADE;
DROP TABLE IF EXISTS public.volunteer_skill0 CASCADE;
DROP TABLE IF EXISTS public.volunteer_skill1 CASCADE;
DROP TABLE IF EXISTS public.volunteer_skill2 CASCADE;


--Creacion de tablas

CREATE TABLE public.volunteer0 (
  "id" serial,
  "name" varchar(80),
  "email" varchar(80),
  "password" varchar(80),
  "availability" boolean,
  "delete" boolean default false,
  PRIMARY KEY ("id")
);
ALTER TABLE public.volunteer0 OWNER TO postgres;


CREATE TABLE public.volunteer1 (
  "id" serial,
  "name" varchar(80),
  "email" varchar(80),
  "password" varchar(80),
  "availability" boolean,
  "delete" boolean default false,
  PRIMARY KEY ("id")
);
ALTER TABLE public.volunteer1 OWNER TO postgres;


CREATE TABLE public.volunteer2 (
  "id" serial,
  "name" varchar(80),
  "email" varchar(80),
  "password" varchar(80),
  "availability" boolean,
  "delete" boolean default false,
  PRIMARY KEY ("id")
);
ALTER TABLE public.volunteer2 OWNER TO postgres;



CREATE TABLE public.skill (
  "id" serial,
  "name" varchar(80),
  "description" varchar(140),
  "delete" boolean default false,
  PRIMARY KEY ("id")
);
ALTER TABLE public.skill OWNER TO postgres;




CREATE TABLE public.volunteer_skill0 (
  "id" serial,
  "id_volunteer" integer, --foranea
  "id_skill" integer, --foranea
  "delete" boolean default false,
  PRIMARY KEY ("id")
);
ALTER TABLE public.volunteer_skill0 OWNER TO postgres;




CREATE TABLE public.volunteer_skill1 (
  "id" serial,
  "id_volunteer" integer, --foranea
  "id_skill" integer, --foranea
  "delete" boolean default false,
  PRIMARY KEY ("id")
);
ALTER TABLE public.volunteer_skill1 OWNER TO postgres;




CREATE TABLE public.volunteer_skill2 (
  "id" serial,
  "id_volunteer" integer, --foranea
  "id_skill" integer, --foranea
  "delete" boolean default false,
  PRIMARY KEY ("id")
);
ALTER TABLE public.volunteer_skill2 OWNER TO postgres;



-- Creación de llaves foráneas

ALTER TABLE ONLY public.volunteer_skill0
ADD CONSTRAINT id_volunteer_fk
FOREIGN KEY ("id_volunteer")
REFERENCES public.volunteer0("id")
ON DELETE CASCADE;

ALTER TABLE ONLY public.volunteer_skill0
ADD CONSTRAINT id_skill_fk
FOREIGN KEY ("id_skill")
REFERENCES public.skill("id")
ON DELETE CASCADE;


ALTER TABLE ONLY public.volunteer_skill1
ADD CONSTRAINT id_volunteer_fk
FOREIGN KEY ("id_volunteer")
REFERENCES public.volunteer1("id")
ON DELETE CASCADE;

ALTER TABLE ONLY public.volunteer_skill1
ADD CONSTRAINT id_skill_fk
FOREIGN KEY ("id_skill")
REFERENCES public.skill("id")
ON DELETE CASCADE;


ALTER TABLE ONLY public.volunteer_skill2
ADD CONSTRAINT id_volunteer_fk
FOREIGN KEY ("id_volunteer")
REFERENCES public.volunteer2("id")
ON DELETE CASCADE;

ALTER TABLE ONLY public.volunteer_skill2
ADD CONSTRAINT id_skill_fk
FOREIGN KEY ("id_skill")
REFERENCES public.skill("id")
ON DELETE CASCADE;