drop table if exists arbol cascade 
drop table if exists rama cascade 
drop sequence if exists arbol_seq
drop sequence if exists rama_seq

create sequence arbol_seq start with 1 increment by 50

create sequence rama_seq start with 1 increment by 50
 
    create table arbol (
        altura float(53) not null,
        anchura float(53) not null,
        id bigint not null,
        version bigint,
        nombre_comun varchar(255),
        tipo_tronco varchar(255),
        primary key (id)
    )
 
    create table rama (
        tipo_caduca boolean,
        tipo_perenne boolean,
        id bigint not null,
        version bigint,
        color_hoja varchar(255),
        forma_hoja varchar(255),
        primary key (id)
    )