PGDMP     5                     w            demo    11.4    11.4 	               0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    24576    demo    DATABASE     �   CREATE DATABASE demo WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE demo;
             postgres    false            �            1259    24585    tbl_patient    TABLE     >  CREATE TABLE public.tbl_patient (
    id uuid NOT NULL,
    age integer,
    diagnosis character varying(255),
    gender character varying(255),
    medicine character varying(255),
    name character varying(255),
    next_visit_date timestamp without time zone,
    prescription_date timestamp without time zone
);
    DROP TABLE public.tbl_patient;
       public         postgres    false            �            1259    24593    report_view    VIEW     �   CREATE VIEW public.report_view AS
 SELECT date_trunc('day'::text, t.prescription_date) AS day,
    count(t.id) AS visits
   FROM public.tbl_patient t
  GROUP BY (date_trunc('day'::text, t.prescription_date));
    DROP VIEW public.report_view;
       public       postgres    false    197    197            �            1259    24577    tbl_employee    TABLE     �   CREATE TABLE public.tbl_employee (
    id uuid NOT NULL,
    designation character varying(255),
    name character varying(255)
);
     DROP TABLE public.tbl_employee;
       public         postgres    false            �
           2606    24584    tbl_employee tbl_employee_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.tbl_employee
    ADD CONSTRAINT tbl_employee_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.tbl_employee DROP CONSTRAINT tbl_employee_pkey;
       public         postgres    false    196            �
           2606    24592    tbl_patient tbl_patient_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.tbl_patient
    ADD CONSTRAINT tbl_patient_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.tbl_patient DROP CONSTRAINT tbl_patient_pkey;
       public         postgres    false    197           