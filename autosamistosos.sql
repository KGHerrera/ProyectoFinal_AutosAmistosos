PGDMP         /        	    
    z            autosamistosos    14.5    14.5 0    I           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            J           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            K           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            L           1262    41038    autosamistosos    DATABASE     j   CREATE DATABASE autosamistosos WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
    DROP DATABASE autosamistosos;
                postgres    false                        3079    41089    pgcrypto 	   EXTENSION     <   CREATE EXTENSION IF NOT EXISTS pgcrypto WITH SCHEMA public;
    DROP EXTENSION pgcrypto;
                   false            M           0    0    EXTENSION pgcrypto    COMMENT     <   COMMENT ON EXTENSION pgcrypto IS 'cryptographic functions';
                        false    2                       1255    41427    before_auto_update_f()    FUNCTION     J  CREATE FUNCTION public.before_auto_update_f() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    INSERT INTO autos_respaldo values(OLD.idAutomoviles, OLD.idFabricantes, OLD.modelo, OLD.marca, OLD.precio, OLD.paisFabricacion, OLD.numeroPuertas, OLD.color, OLD.numeroAcientos, OLD.kilometraje, NOW());
    RETURN new;
END
$$;
 -   DROP FUNCTION public.before_auto_update_f();
       public          postgres    false                       1255    41433 T   update_fabricantes(character varying, character varying, character varying, integer) 	   PROCEDURE     R  CREATE PROCEDURE public.update_fabricantes(IN nombrep character varying, IN direccionp character varying, IN telefonop character varying, IN idfabricantesp integer)
    LANGUAGE plpgsql
    AS $$
    BEGIN
    UPDATE fabricantes SET nombre=nombrep, direccion=direccionp, telefono=telefonop WHERE idFabricantes=idFabricantesp;
    END
$$;
 ?   DROP PROCEDURE public.update_fabricantes(IN nombrep character varying, IN direccionp character varying, IN telefonop character varying, IN idfabricantesp integer);
       public          postgres    false                       1255    41200 "   verificar(character varying, text)    FUNCTION     G  CREATE FUNCTION public.verificar(usuariop character varying, passwordp text) RETURNS character varying
    LANGUAGE plpgsql
    AS $$
DECLARE
resultado VARCHAR(20);
BEGIN
SELECT usuario INTO resultado
FROM usuarios
WHERE usuario = usuarioP
AND PGP_SYM_DECRYPT(password::bytea, 'AES_KEY') = passwordP;
RETURN resultado;
END
$$;
 L   DROP FUNCTION public.verificar(usuariop character varying, passwordp text);
       public          postgres    false                       1255    41156 *   verificar_usuario(character varying, text)    FUNCTION     B  CREATE FUNCTION public.verificar_usuario(usuariop character varying, passwordp text) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE
resultado INTEGER;
BEGIN
SELECT count(*) INTO resultado
FROM usuarios
WHERE usuario = usuarioP
AND PGP_SYM_DECRYPT(password::bytea, 'AES_KEY') = passwordP;
RETURN resultado;
END
$$;
 T   DROP FUNCTION public.verificar_usuario(usuariop character varying, passwordp text);
       public          postgres    false            ?            1259    41047    automoviles    TABLE     ?  CREATE TABLE public.automoviles (
    idautomoviles integer NOT NULL,
    idfabricantes integer NOT NULL,
    modelo character varying(20) NOT NULL,
    marca character varying(20) NOT NULL,
    precio numeric(9,2) NOT NULL,
    paisfabricacion character varying(20) NOT NULL,
    numeropuertas smallint NOT NULL,
    color character varying(20),
    numeroacientos smallint NOT NULL,
    kilometraje integer NOT NULL
);
    DROP TABLE public.automoviles;
       public         heap    postgres    false            ?            1259    41046    automoviles_idautomoviles_seq    SEQUENCE     ?   CREATE SEQUENCE public.automoviles_idautomoviles_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.automoviles_idautomoviles_seq;
       public          postgres    false    213            N           0    0    automoviles_idautomoviles_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.automoviles_idautomoviles_seq OWNED BY public.automoviles.idautomoviles;
          public          postgres    false    212            ?            1259    41040    fabricantes    TABLE     ?   CREATE TABLE public.fabricantes (
    idfabricantes integer NOT NULL,
    nombre character varying(20) NOT NULL,
    direccion character varying(40) NOT NULL,
    telefono character varying(12) NOT NULL
);
    DROP TABLE public.fabricantes;
       public         heap    postgres    false            ?            1259    41078    autos_fabricantes    VIEW     w  CREATE VIEW public.autos_fabricantes AS
 SELECT a.idautomoviles,
    a.modelo,
    a.marca,
    a.precio,
    a.paisfabricacion,
    a.numeropuertas,
    a.color,
    a.numeroacientos,
    a.kilometraje,
    a.idfabricantes,
    f.nombre,
    f.direccion,
    f.telefono
   FROM (public.automoviles a
     JOIN public.fabricantes f ON ((a.idfabricantes = f.idfabricantes)));
 $   DROP VIEW public.autos_fabricantes;
       public          postgres    false    213    213    213    213    213    213    213    213    213    213    211    211    211    211            ?            1259    41419    autos_respaldo    TABLE     ?  CREATE TABLE public.autos_respaldo (
    idautomoviles integer NOT NULL,
    idfabricantes integer NOT NULL,
    modelo character varying(20) NOT NULL,
    marca character varying(20) NOT NULL,
    precio numeric(9,2) NOT NULL,
    paisfabricacion character varying(20) NOT NULL,
    numeropuertas smallint NOT NULL,
    color character varying(20),
    numeroacientos smallint NOT NULL,
    kilometraje integer NOT NULL,
    fecha_modificacion timestamp without time zone NOT NULL
);
 "   DROP TABLE public.autos_respaldo;
       public         heap    postgres    false            ?            1259    41059    clientes    TABLE     /  CREATE TABLE public.clientes (
    idclientes integer NOT NULL,
    nombre character varying(20) NOT NULL,
    primerapellido character varying(20) NOT NULL,
    segundoapellido character varying(20) NOT NULL,
    direccion character varying(40) NOT NULL,
    telefono character varying(12) NOT NULL
);
    DROP TABLE public.clientes;
       public         heap    postgres    false            ?            1259    41058    clientes_idclientes_seq    SEQUENCE     ?   CREATE SEQUENCE public.clientes_idclientes_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.clientes_idclientes_seq;
       public          postgres    false    215            O           0    0    clientes_idclientes_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.clientes_idclientes_seq OWNED BY public.clientes.idclientes;
          public          postgres    false    214            ?            1259    41039    fabricantes_idfabricantes_seq    SEQUENCE     ?   CREATE SEQUENCE public.fabricantes_idfabricantes_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.fabricantes_idfabricantes_seq;
       public          postgres    false    211            P           0    0    fabricantes_idfabricantes_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.fabricantes_idfabricantes_seq OWNED BY public.fabricantes.idfabricantes;
          public          postgres    false    210            ?            1259    41141    usuarios    TABLE     ?   CREATE TABLE public.usuarios (
    idusuarios integer NOT NULL,
    usuario character varying(20) NOT NULL,
    password text NOT NULL
);
    DROP TABLE public.usuarios;
       public         heap    postgres    false            ?            1259    41140    usuarios_idusuarios_seq    SEQUENCE     ?   CREATE SEQUENCE public.usuarios_idusuarios_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.usuarios_idusuarios_seq;
       public          postgres    false    219            Q           0    0    usuarios_idusuarios_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.usuarios_idusuarios_seq OWNED BY public.usuarios.idusuarios;
          public          postgres    false    218            ?            1259    41065    ventas    TABLE     ?   CREATE TABLE public.ventas (
    idautomoviles integer NOT NULL,
    idclientes integer NOT NULL,
    fechaventa date NOT NULL,
    precioauto numeric(9,2) NOT NULL,
    costototal numeric(9,2) NOT NULL,
    impuestos numeric(9,2) NOT NULL
);
    DROP TABLE public.ventas;
       public         heap    postgres    false            ?           2604    41050    automoviles idautomoviles    DEFAULT     ?   ALTER TABLE ONLY public.automoviles ALTER COLUMN idautomoviles SET DEFAULT nextval('public.automoviles_idautomoviles_seq'::regclass);
 H   ALTER TABLE public.automoviles ALTER COLUMN idautomoviles DROP DEFAULT;
       public          postgres    false    212    213    213            ?           2604    41062    clientes idclientes    DEFAULT     z   ALTER TABLE ONLY public.clientes ALTER COLUMN idclientes SET DEFAULT nextval('public.clientes_idclientes_seq'::regclass);
 B   ALTER TABLE public.clientes ALTER COLUMN idclientes DROP DEFAULT;
       public          postgres    false    215    214    215            ?           2604    41043    fabricantes idfabricantes    DEFAULT     ?   ALTER TABLE ONLY public.fabricantes ALTER COLUMN idfabricantes SET DEFAULT nextval('public.fabricantes_idfabricantes_seq'::regclass);
 H   ALTER TABLE public.fabricantes ALTER COLUMN idfabricantes DROP DEFAULT;
       public          postgres    false    210    211    211            ?           2604    41144    usuarios idusuarios    DEFAULT     z   ALTER TABLE ONLY public.usuarios ALTER COLUMN idusuarios SET DEFAULT nextval('public.usuarios_idusuarios_seq'::regclass);
 B   ALTER TABLE public.usuarios ALTER COLUMN idusuarios DROP DEFAULT;
       public          postgres    false    218    219    219            @          0    41047    automoviles 
   TABLE DATA           ?   COPY public.automoviles (idautomoviles, idfabricantes, modelo, marca, precio, paisfabricacion, numeropuertas, color, numeroacientos, kilometraje) FROM stdin;
    public          postgres    false    213   gA       F          0    41419    autos_respaldo 
   TABLE DATA           ?   COPY public.autos_respaldo (idautomoviles, idfabricantes, modelo, marca, precio, paisfabricacion, numeropuertas, color, numeroacientos, kilometraje, fecha_modificacion) FROM stdin;
    public          postgres    false    220   ?B       B          0    41059    clientes 
   TABLE DATA           l   COPY public.clientes (idclientes, nombre, primerapellido, segundoapellido, direccion, telefono) FROM stdin;
    public          postgres    false    215   uC       >          0    41040    fabricantes 
   TABLE DATA           Q   COPY public.fabricantes (idfabricantes, nombre, direccion, telefono) FROM stdin;
    public          postgres    false    211   ?C       E          0    41141    usuarios 
   TABLE DATA           A   COPY public.usuarios (idusuarios, usuario, password) FROM stdin;
    public          postgres    false    219   ;D       C          0    41065    ventas 
   TABLE DATA           j   COPY public.ventas (idautomoviles, idclientes, fechaventa, precioauto, costototal, impuestos) FROM stdin;
    public          postgres    false    216   "E       R           0    0    automoviles_idautomoviles_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.automoviles_idautomoviles_seq', 67, true);
          public          postgres    false    212            S           0    0    clientes_idclientes_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.clientes_idclientes_seq', 1, false);
          public          postgres    false    214            T           0    0    fabricantes_idfabricantes_seq    SEQUENCE SET     K   SELECT pg_catalog.setval('public.fabricantes_idfabricantes_seq', 6, true);
          public          postgres    false    210            U           0    0    usuarios_idusuarios_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.usuarios_idusuarios_seq', 2, true);
          public          postgres    false    218            ?           2606    41052    automoviles automoviles_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.automoviles
    ADD CONSTRAINT automoviles_pkey PRIMARY KEY (idautomoviles);
 F   ALTER TABLE ONLY public.automoviles DROP CONSTRAINT automoviles_pkey;
       public            postgres    false    213            ?           2606    41064    clientes clientes_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (idclientes);
 @   ALTER TABLE ONLY public.clientes DROP CONSTRAINT clientes_pkey;
       public            postgres    false    215            ?           2606    41045    fabricantes fabricantes_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY public.fabricantes
    ADD CONSTRAINT fabricantes_pkey PRIMARY KEY (idfabricantes);
 F   ALTER TABLE ONLY public.fabricantes DROP CONSTRAINT fabricantes_pkey;
       public            postgres    false    211            ?           2606    41148    usuarios usuarios_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (idusuarios);
 @   ALTER TABLE ONLY public.usuarios DROP CONSTRAINT usuarios_pkey;
       public            postgres    false    219            ?           2620    41428    automoviles before_auto_update    TRIGGER     ?   CREATE TRIGGER before_auto_update BEFORE UPDATE ON public.automoviles FOR EACH ROW EXECUTE FUNCTION public.before_auto_update_f();
 7   DROP TRIGGER before_auto_update ON public.automoviles;
       public          postgres    false    270    213            ?           2606    41053 *   automoviles automoviles_idfabricantes_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.automoviles
    ADD CONSTRAINT automoviles_idfabricantes_fkey FOREIGN KEY (idfabricantes) REFERENCES public.fabricantes(idfabricantes);
 T   ALTER TABLE ONLY public.automoviles DROP CONSTRAINT automoviles_idfabricantes_fkey;
       public          postgres    false    211    213    3237            ?           2606    41422 0   autos_respaldo autos_respaldo_idfabricantes_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.autos_respaldo
    ADD CONSTRAINT autos_respaldo_idfabricantes_fkey FOREIGN KEY (idfabricantes) REFERENCES public.fabricantes(idfabricantes);
 Z   ALTER TABLE ONLY public.autos_respaldo DROP CONSTRAINT autos_respaldo_idfabricantes_fkey;
       public          postgres    false    220    211    3237            ?           2606    41068     ventas ventas_idautomoviles_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ventas
    ADD CONSTRAINT ventas_idautomoviles_fkey FOREIGN KEY (idautomoviles) REFERENCES public.automoviles(idautomoviles);
 J   ALTER TABLE ONLY public.ventas DROP CONSTRAINT ventas_idautomoviles_fkey;
       public          postgres    false    3239    216    213            ?           2606    41073    ventas ventas_idclientes_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.ventas
    ADD CONSTRAINT ventas_idclientes_fkey FOREIGN KEY (idclientes) REFERENCES public.clientes(idclientes);
 G   ALTER TABLE ONLY public.ventas DROP CONSTRAINT ventas_idclientes_fkey;
       public          postgres    false    215    3241    216            @   t  x???Mn?0???)?@?x??d?Ct??!??FN ???T?E%?]d??7o^&?a?????????B? P/?z?'P?.P	
	Ph??lbj?UK-?H?????'?,?J?????;w?(?IYM???O?{????P?W?t?I1??O???vg!-L???b????i??"o??6????u??:Qx??_-?D?????t?? ??,???	?C???02 ?Y?????pm??;|w?GZ7????????H??F'%s$?=0??
(??1,?6???%??]???%?+?OP?$?5???YamY?K??*????c C?H??n?:??nX?kX??2????aY??n-???!?o???m?.a?M??*?{????(???W      F   z   x?}?1?0D?z|?\ ??*?^????P??Eq|?h???k?*?u?B??y??????K?
iQ?????N??|K????K????>????n???y?????????!3w???/?.$?      B      x?????? ? ?      >   ?   x??A?  ????????_zY?j?R	6??p??L;?? ??"&????1??:?Y??@????CV>8?UH?:???7?Oh?????5?-d;??Sr???-I.`???[????E,??d??q6????%C?{7?? [???v'|????8      E   ?   x?]?KN?1??q?? ?q??K'~$??T	vO??????????|???????0??54???&?i ??EI?
?0#?\??????# Cb?????$Q?Z??a?v?Z??=cT\4??|?3_t??????????>?Pv?a?<? :l?j+?????Fv????? ?N{??eLO?@??`tpN?;?ZsW???d?0^;??5v%???o?u?7X      C      x?????? ? ?     