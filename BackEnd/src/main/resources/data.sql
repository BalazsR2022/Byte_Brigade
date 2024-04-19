CREATE DATABASE IF NOT EXISTS bookdb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE bookdb;

CREATE TABLE IF NOT EXISTS books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(50),
    publisher VARCHAR(50),
    category VARCHAR(30),
    county VARCHAR(50),
    quality VARCHAR(50),
    picture VARCHAR(10),
    year INT(6),
    reserved BOOLEAN,
    owner_id INT,
    FOREIGN KEY (owner_id) REFERENCES bookusers(id)
);

CREATE TABLE IF NOT EXISTS bookusers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(100),
    email VARCHAR(100),
    role ENUM('ADMIN_ROLE', 'USER_ROLE') NOT NULL,
    is_admin BOOLEAN
);

CREATE TABLE IF NOT EXISTS user_roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    role ENUM('ADMIN_ROLE', 'USER_ROLE') NOT NULL,
    FOREIGN KEY (user_id) REFERENCES bookusers(id)
);

INSERT INTO `books` (`owner_id`, `year`, `category`, `author`, `county`, `publisher`, `quality`, `title`, `reserved`, `picture`) VALUES
(6, 1955, 'fantasy', 'J.R.R. Tolkien', 'Heves ', 'Allen & Unwin', 'használt', 'A gyűrűk ura', NULL, '1.png'),
(9, 1997, 'ifúsági', 'J.K. Rowling', 'Vas', 'Bloomsbury', 'használt', 'Harry Potter és a bölcsk köve', NULL, '1.png'),
(1, 1988, 'ismeretterjesztő', 'Stephen Hawking', 'Pest', 'Bantam Books', 'újszerű', 'Az idő rövid története', NULL, '1.png'),
(8, 2005, 'fantasy', 'Rick Riordan', 'Somogy', 'Könyvmolyképző', 'használt', 'Percy Jackson - Az olimposz hőse', NULL,'1.png'),
(3, 1955, 'tudományos-fantasztikus', 'Isaac Asimov', 'Veszprém', 'GABO', 'használt', 'Az idő urai', NULL, '1.png'),
(3, 1991, 'tudományos-fantasztikus', 'Isaac Asimov', 'Veszprém', 'Móra', 'használt', 'Én, a robot', NULL, '1.png'),
(1, 1998, 'informatika', 'Dirk Louis - Peter Müller', 'Pest', 'Panem', 'újszerű', 'JAVA - Belépés az Internet-programozás világába', NULL, '1.png'),
(2, 2020, 'pszichológia', 'Vekerdy Tamás', 'Pest', 'Kulcslyuk', 'újszerű', 'Kamaszkor körül', NULL, '1.png'),
(2, 1996, 'pszichológia', 'Rita L. Atkinson', 'Pest', 'Osiris', 'használt', 'Pszichológia', NULL, '1.png'),
(3, 1998, 'tankönyv', 'Yaesko Nakanishi', 'Veszprém', 'Gakken', 'használt', 'Japanese for Everyone', NULL,  '1.png'),
(11, 2010, 'gasztronómia', 'Bereznay Tamás', 'Heves', 'Boook', 'újszerű', 'Süteményeskönyv', NULL,  '1.png'),
(11, 2011, 'gasztronómia', 'Bereznay Tamás', 'Heves', 'Boook', 'újszerű', 'Főzni gyerekjáték', NULL, '1.png'),
(20, 2008, 'szépirodalom', 'Viktor Pelevin', 'Pest', 'Európa', 'újszerű', 'Empire \'V\' - elbeszélés a valódi felsőbbrendű emberről', NULL, '1.png'),
(10, 1987, 'szépirodalom', 'William Shakespeare', 'Fejér', 'Európa', 'használt', ' Sok hűhó semmiért', NULL, '1.png'),
(10, 1986, 'szépirodalom', 'William Shakespeare', 'Fejér', 'Európa', 'használt', 'János király', NULL, '1.png'),
(10, 1987, 'szépirodalom', 'William Shakespeare', 'Fejér', 'Európa', 'használt', 'A két veronai nemes', NULL, '1.png'),
(2, 1983, 'szépirodalom', 'Jack Keroac', 'Pest', 'Európa', 'használt', 'Úton', NULL, '1.png'),
(4, 2001, 'vallás és filozófia', 'Vekerdi József', 'Somogy', 'Farkas Lőrinc Imre Kiadó', 'használt', 'Buddha beszédei', NULL, '1.png'),
(2, 1998, 'pszichológia', 'G.W. Allport', 'Pest', 'Kairosz Kiadó', 'használt', 'A személyiség alakulás', NULL, '1.png'),
(5, 1998, 'sport', 'Ueshiba - Stevens', 'Nógrád', 'Szenzár', 'használt', 'Az Aikido esszenciája', NULL, '1.png'),
(5, 1877, 'művészet', 'Tóth Ervin', 'Nógrád', 'Officina', 'antik', 'A japán fametszet', NULL, '1.png'),
(5, 2001, 'sport', 'Kassai Lajos', 'Nógrád', 'Dee-sign', 'használt', 'Lovasíjászat', NULL, '1.png'),
(9, 2002, 'szépirodalom', 'Christopher Moore ', 'Tolna', 'Agave', 'újszerű', 'Biff Evangéliuma', NULL, '1.png');

INSERT INTO `bookusers` (`username`, `password`, `email`, `is_admin`, `role`) VALUES
('Csajbók-Reményi László', 'password', 'Laci@gmail.com', b'1', 'ADMIN_ROLE'),
('Balázs Réka', 'password', 'Reka@gmail.com', b'1', 'ADMIN_ROLE'),
('Gerecs Diána', 'password', 'gerecsdiana@gmail.com', b'1', 'ADMIN_ROLE'),
('Kovács Ádám', '', NULL, b'0', 'USER_ROLE'),
('Nagy Petra', '', NULL, b'0', 'USER_ROLE'),
('Szabó Gábor', '', NULL, b'0', 'USER_ROLE'),
('Horváth Anna', '', NULL, b'0', 'USER_ROLE'),
('Tóth Péter', '', NULL, b'0', 'USER_ROLE'),
('Kiss Katalin', '', NULL, b'0', 'USER_ROLE'),
('Molnár Márk', '', NULL, b'0', 'USER_ROLE'),
('Kovács Zsófia', '', NULL, b'0', 'USER_ROLE'),
('Papp Bence', '', NULL, b'0', 'USER_ROLE'),
('Varga Eszter', '', NULL, b'0', 'USER_ROLE'),
('Lakatos Levente', '', NULL, b'0', 'USER_ROLE'),
('Balogh Dóra', '', NULL, b'0', 'USER_ROLE'),
('Takács Balázs', '', NULL, b'0', 'USER_ROLE'),
('Fekete Viktória', '', NULL, b'0', 'USER_ROLE'),
('Szűcs Máté', '', NULL, b'0', 'USER_ROLE'),
('Varga Kíra', '', NULL, b'0', 'USER_ROLE'),
('Bálint Richárd', '', NULL, b'0', 'USER_ROLE');
