/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  attuku
 * Created: 27 janv. 2021
 */

drop database if exists deliveryDB;

create database if not exists deliveryDB;

use deliveryDB;

create table deliveries (
    id int not null auto_increment primary key,
    buyer int not null,
    idArticle int not null,
    nameArticle varchar(255) not null,
    date datetime not null,
    address varchar(255)
);