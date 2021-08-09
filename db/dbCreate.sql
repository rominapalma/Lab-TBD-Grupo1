
--Dropear las tablas
--Estas sentencias verifican que no existan las tablas previamente
--En caso de existir, las elimina en CASCADA, es decir,
--elimina todo el flujo asociado a la tabla

DROP TABLE IF EXISTS public.volunteer CASCADE;
DROP TABLE IF EXISTS public.institution CASCADE;
DROP TABLE IF EXISTS public.ranking CASCADE;
DROP TABLE IF EXISTS public.status_task CASCADE;
DROP TABLE IF EXISTS public.skill CASCADE;
DROP TABLE IF EXISTS public.volunteer_skill CASCADE;
DROP TABLE IF EXISTS public.coordinator CASCADE;
DROP TABLE IF EXISTS public.task CASCADE;
DROP TABLE IF EXISTS public.urgency CASCADE;
DROP TABLE IF EXISTS public.urgency_skill CASCADE;
DROP TABLE IF EXISTS public.task_skill CASCADE;

--Creacion de tablas

CREATE TABLE public.volunteer (
  "id" serial,
  "name" varchar(80),
  "email" varchar(80),
  "birthday" date,
  "password" varchar(80),
  "availability" boolean,
  "location" geometry(Point,4326),
  "delete" boolean default false,
  PRIMARY KEY ("id")
);

ALTER TABLE public.volunteer OWNER TO postgres;

CREATE TABLE public.institution (
  "id" serial,
  "name" varchar(80),
  "location" geometry(Point,4326),
  "delete" boolean default false,
  PRIMARY KEY ("id")
);

ALTER TABLE public.institution OWNER TO postgres;

CREATE TABLE public.ranking (
  "id" serial,
  "score" integer,
  "flag_guest" integer,
  "flag_participate" integer,
  "id_volunteer" integer, --foranea
  "id_task" integer, --foranea
  "delete" boolean default false,
  PRIMARY KEY ("id")
);

ALTER TABLE public.ranking OWNER TO postgres;

COMMENT ON TABLE public.ranking IS 'flag_guest y flag_participate es 1 si la respuesta es si, 2 si la respuesta es no';

CREATE TABLE public.status_task (
  "id" serial,
  "description" varchar(140),
  "delete" boolean default false,
  PRIMARY KEY ("id")
);

ALTER TABLE public.status_task OWNER TO postgres;

CREATE TABLE public.skill (
  "id" serial,
  "name" varchar(80),
  "description" varchar(140),
  "delete" boolean default false,
  PRIMARY KEY ("id")
);

ALTER TABLE public.skill OWNER TO postgres;

CREATE TABLE public.volunteer_skill (
  "id" serial,
  "id_volunteer" integer, --foranea
  "id_skill" integer, --foranea
  "delete" boolean default false,
  PRIMARY KEY ("id")
);

ALTER TABLE public.volunteer_skill OWNER TO postgres;

CREATE TABLE public.coordinator (
  "id" serial,
  "name" varchar(80),
  "id_institution" serial, --foranea
  "location" geometry(Point,4326),
  "delete" boolean default false,
  PRIMARY KEY ("id")
);

ALTER TABLE public.coordinator OWNER TO postgres;

CREATE TABLE public.task (
  "id" serial,
  "name" varchar(80),
  "description" varchar(140),
  "num_vol_req" integer,
  "num_vol_signin" integer,
  "start_date" date,
  "end_date" date,
  "id_status_task" integer, --foranea
  "id_urgency" integer, --foranea
  "delete" boolean default false,
  PRIMARY KEY ("id")
);

ALTER TABLE public.task OWNER TO postgres;

CREATE TABLE public.urgency (
  "id" serial,
  "name" varchar(80),
  "description" varchar(140),
  "start_date" date,
  "end_date" date,
  "id_coordinator" integer, --foranea
  "location" geometry(Point,4326),
  "delete" boolean default false,
  PRIMARY KEY ("id")
);

ALTER TABLE public.urgency OWNER TO postgres;

CREATE TABLE public.urgency_skill (
  "id" serial,
  "id_urgency" integer, --foranea
  "id_skill" integer, --foranea
  "delete" boolean default false,
  PRIMARY KEY ("id")
);

ALTER TABLE public.urgency_skill OWNER TO postgres;

CREATE TABLE public.task_skill (
  "id" serial,
  "id_task" integer, --foranea
  "id_urgency_skill" integer, --foranea
  "delete" boolean default false,

  PRIMARY KEY ("id")
);

ALTER TABLE public.task_skill OWNER TO postgres;

-- Creación de llaves foráneas

ALTER TABLE ONLY public.volunteer_skill
ADD CONSTRAINT id_volunteer_fk
FOREIGN KEY ("id_volunteer")
REFERENCES public.volunteer("id")
ON DELETE CASCADE;

ALTER TABLE ONLY public.volunteer_skill
ADD CONSTRAINT id_skill_fk
FOREIGN KEY ("id_skill")
REFERENCES public.skill("id")
ON DELETE CASCADE;

ALTER TABLE ONLY public.ranking
ADD CONSTRAINT id_volunteer_fk
FOREIGN KEY ("id_volunteer")
REFERENCES public.volunteer("id")
ON DELETE CASCADE;

ALTER TABLE ONLY public.ranking
ADD CONSTRAINT id_task_fk
FOREIGN KEY ("id_task")
REFERENCES public.task("id")
ON DELETE CASCADE;

ALTER TABLE ONLY public.coordinator
ADD CONSTRAINT id_institution_fk
FOREIGN KEY ("id_institution")
REFERENCES public.institution("id")
ON DELETE CASCADE;

ALTER TABLE ONLY public.task
ADD CONSTRAINT id_status_task_fk
FOREIGN KEY ("id_status_task")
REFERENCES public.status_task("id")
ON DELETE CASCADE;

ALTER TABLE ONLY public.task
ADD CONSTRAINT id_urgency_fk
FOREIGN KEY ("id_urgency")
REFERENCES public.urgency("id")
ON DELETE CASCADE;

ALTER TABLE ONLY public.urgency
ADD CONSTRAINT id_coordinator_fk
FOREIGN KEY ("id_coordinator")
REFERENCES public.coordinator("id")
ON DELETE CASCADE;

ALTER TABLE ONLY public.urgency_skill
ADD CONSTRAINT id_urgency_fk
FOREIGN KEY ("id_urgency")
REFERENCES public.urgency("id")
ON DELETE CASCADE;

ALTER TABLE ONLY public.urgency_skill
ADD CONSTRAINT id_skill_fk
FOREIGN KEY ("id_skill")
REFERENCES public.skill("id")
ON DELETE CASCADE;

ALTER TABLE ONLY public.task_skill
ADD CONSTRAINT id_task_fk
FOREIGN KEY ("id_task")
REFERENCES public.task("id")
ON DELETE CASCADE;

ALTER TABLE ONLY public.task_skill
ADD CONSTRAINT id_urgency_skill_fk
FOREIGN KEY ("id_urgency_skill")
REFERENCES public.urgency_skill("id")
ON DELETE CASCADE;
