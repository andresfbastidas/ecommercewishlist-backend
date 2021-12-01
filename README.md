### SCRIPT BD

ALTER TABLE UserApp DROP CONSTRAINT FKUserApp447612;
ALTER TABLE WishList DROP CONSTRAINT FKWishList961070;
ALTER TABLE WishList DROP CONSTRAINT FKWishList598319;
ALTER TABLE WishListHistory DROP CONSTRAINT FKWishListHi361414;
DROP TABLE IF EXISTS Profile CASCADE;
DROP TABLE IF EXISTS UserApp CASCADE;
DROP TABLE IF EXISTS WishList CASCADE;
DROP TABLE IF EXISTS WishListHistory CASCADE;
DROP TABLE IF EXISTS Product CASCADE;
DROP SEQUENCE IF EXISTS PRODUCT_SEQ;
DROP SEQUENCE IF EXISTS USER_SEQ;
DROP SEQUENCE IF EXISTS WISHLISTHISTORY_SEQ;
DROP SEQUENCE IF EXISTS PROFILE_SEQ;
DROP SEQUENCE IF EXISTS WISHLIST_SEQ;
CREATE SEQUENCE PRODUCT_SEQ INCREMENT BY 1 NO MINVALUE NO MAXVALUE START WITH 1;
CREATE SEQUENCE USER_SEQ INCREMENT BY 1 NO MINVALUE NO MAXVALUE START WITH 1;
CREATE SEQUENCE WISHLISTHISTORY_SEQ INCREMENT BY 1 NO MINVALUE NO MAXVALUE START WITH 1;
CREATE SEQUENCE PROFILE_SEQ INCREMENT BY 1 NO MINVALUE NO MAXVALUE START WITH 1;
CREATE SEQUENCE WISHLIST_SEQ INCREMENT BY 1 NO MINVALUE NO MAXVALUE START WITH 1;
CREATE TABLE Profile (profile_id int8 NOT NULL, profile_name varchar(50) NOT NULL, PRIMARY KEY (profile_id));
CREATE TABLE UserApp (id_user_app int8 NOT NULL, user_name varchar(50) NOT NULL, email varchar(100) NOT NULL, firts_name varchar(100) NOT NULL, second_name varchar(100), surname varchar(100) NOT NULL, second_surname varchar(100), profile_id int8 NOT NULL, password varchar(255) NOT NULL, PRIMARY KEY (id_user_app));
CREATE TABLE WishList (id_wish_list int8 NOT NULL, name_wishlist varchar(100) NOT NULL, id_product int8 NOT NULL, id_user_app int8 NOT NULL, PRIMARY KEY (id_wish_list));
CREATE TABLE WishListHistory (id_wish_list_history int8 NOT NULL, name_wishlist varchar(100) NOT NULL, id_product int8 NOT NULL, id_user_app int8 NOT NULL, id_wish_list int8 NOT NULL, PRIMARY KEY (id_wish_list_history));
CREATE TABLE Product (id_product int8 NOT NULL, product_name varchar(100) NOT NULL, price int8 NOT NULL, product_quantity int8 NOT NULL, PRIMARY KEY (id_product));
ALTER TABLE UserApp ADD CONSTRAINT FKUserApp447612 FOREIGN KEY (profile_id) REFERENCES Profile (profile_id);
ALTER TABLE WishList ADD CONSTRAINT FKWishList961070 FOREIGN KEY (id_product) REFERENCES Product (id_product);
ALTER TABLE WishList ADD CONSTRAINT FKWishList598319 FOREIGN KEY (id_user_app) REFERENCES UserApp (id_user_app);
ALTER TABLE WishListHistory ADD CONSTRAINT FKWishListHi361414 FOREIGN KEY (id_wish_list) REFERENCES WishList (id_wish_list);

### INSERTS
insert into profile (profile_id,profile_name)
values (nextval('profile_seq'), 'ADMINISTRADOR');
insert into profile (profile_id,profile_name)
values (nextval('profile_seq'), 'CLIENTE');

insert into product (id_product,product_name, price, product_quantity)
values (nextval('product_seq'), 'MESA DE OFICINA', 300000, 5);
insert into product (id_product,product_name, price, product_quantity)
values (nextval('product_seq'), 'MESA DE ESCRITORIO', 220000, 7);
insert into product (id_product,product_name, price, product_quantity)
values (nextval('product_seq'), 'MESA DE REUNIONES', 500000, 2);
insert into product (id_product,product_name, price, product_quantity)
values (nextval('product_seq'), 'SILLA ERGONOMICA', 300000, 2);
insert into product (id_product,product_name, price, product_quantity)
values (nextval('product_seq'), 'SILLA CON RUEDAS GIRATORIA', 150000, 4);
insert into product (id_product,product_name, price, product_quantity)
values (nextval('product_seq'), 'LAMPARA PARA ESCRITORIO', 100000, 10);
insert into product (id_product,product_name, price, product_quantity)
values (nextval('product_seq'), 'LAMPARA DE PIE', 150000, 8);


### PASOS PARA EL DESPLIEGUE
###--Base de datos
##1.  Instalar postgres
##2. Crear la base de datos con nombre ecommercedb
##3. Ejecutar el scriptbd.sql
##4. Ejecutar el scriptinserts.sql
###--Frontend
##5. Instalar visual studio code
##6 Arrastrar la carpeta con nombre wish-list-manager-frontend al visual studio code
##7. Realizar un npm install para descargar dependencias
##8. Ejecutar comando ng-serve -o para levantar el servidor
###--Backend
##9. Si utiliza windows/mac ejecutar el comando java ‘ -jar c: pathtojarfile.jar’sin comillas simples y en el pathtojarfile colocar la ruta del jar
##9.1 El archivo application.properties se encuentra de manera externa por si desea modificar puerto o conexión a base de datos.

##Con esto quedaria el despliegue de manera local.

##Notas adicionales:
## Debido al tiempo de ejecución de la prueba, por parte del frontend no quedó implementado correctamente, igualmente quedó funcional la interfaz.
##Adicional, se envia el proyecto en postman.
