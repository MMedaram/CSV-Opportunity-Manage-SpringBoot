
CREATE TABLE public."CREATE_OPPORTUNITY"
(
	"ID" bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    "OPPORTUITY_NAME" character varying(50) COLLATE pg_catalog."default" NOT NULL,
    "ACCOUNT_NAME" character varying(50) COLLATE pg_catalog."default" NOT NULL,
    "EXP_BOOK_DATE" character varying(20) COLLATE pg_catalog."default" NOT NULL,
    "EXP_PRODUCT" character varying(20) COLLATE pg_catalog."default" NOT NULL,
    "EXP_SERVICE" character varying(20) COLLATE pg_catalog."default" NOT NULL,
    "EXIST_OPP_NAME" character varying(20) COLLATE pg_catalog."default" NOT NULL,
    "OPP_URL" character varying(100) COLLATE pg_catalog."default" NOT NULL,
        CONSTRAINT "CREATE_OPPORTUNITY_pkey" PRIMARY KEY ("ID")
    
)

/*
CREATE TABLE department
(
    id bigint NOT NULL,
    name character varying(100) NOT NULL,
    description character varying(2500) ,
    CONSTRAINT department_pkey PRIMARY KEY (id)
)

CREATE TABLE employee
(
    id bigint NOT NULL,
    name character varying(100) ,
    address character varying(100),
    designation character varying(100),
    salary double precision,
    department_id bigint NOT NULL,
    CONSTRAINT employee_pkey PRIMARY KEY (id),
    CONSTRAINT department_id FOREIGN KEY (department_id)
        REFERENCES public.department (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)
*/


