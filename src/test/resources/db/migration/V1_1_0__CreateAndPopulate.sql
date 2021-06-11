create table zone (
   id INT auto_increment primary key, 
   title VARCHAR(50) NOT NULL, 
   description VARCHAR(100)
);

create table peak_hours (
   id INT auto_increment primary key, 
   day VARCHAR(50) NOT NULL, 
   start_time time,
   end_time time
);

create table off_peak_hours (
   id INT auto_increment primary key, 
   day VARCHAR(50) NOT NULL, 
   start_time time,
   end_time time,
   from_zone INT NOT NULL,
   to_zone INT NOT NULL
);

create table fare (
	id INT auto_increment primary key,
	from_zone INT NOT NULL,
	to_zone INT NOT NULL,
	peak_hours_charges INT NOT NULL,
	offpeak_hours_charges INT NOT NULL
);

create table capping_limits (
	id INT auto_increment primary key,
	from_zone INT NOT NULL,
	to_zone INT NOT NULL,
	daily_cap INT NOT NULL,
	weekly_cap INT NOT NULL
);
---This SQL file is used to insert data in respective tables

---Zone details

insert into zone(title, description) values
('Zone1','Central Area'),
('Zone2', 'Concentric Ring Over Zone1');

---Inserting data in peak hours

insert into peak_hours(day, start_time, end_time) values
('Monday',PARSEDATETIME('07:00', 'HH:MM'),PARSEDATETIME('10:30', 'HH:MM')),
('Monday',PARSEDATETIME('17:00', 'HH:MM'),PARSEDATETIME('20:00', 'HH:MM')), 
('Tuesday',PARSEDATETIME('07:00', 'HH:MM'),PARSEDATETIME('10:30', 'HH:MM')),
('Tuesday',PARSEDATETIME('17:00', 'HH:MM'),PARSEDATETIME('20:00', 'HH:MM')), 
('Wednesday',PARSEDATETIME('07:00', 'HH:MM'),PARSEDATETIME('10:30', 'HH:MM')),
('Wednesday',PARSEDATETIME('17:00', 'HH:MM'),PARSEDATETIME('20:00', 'HH:MM')), 
('Thursday',PARSEDATETIME('07:00', 'HH:MM'),PARSEDATETIME('10:30', 'HH:MM')),
('Thursday',PARSEDATETIME('17:00', 'HH:MM'),PARSEDATETIME('20:00', 'HH:MM')), 
('Friday',PARSEDATETIME('07:00', 'HH:MM'),PARSEDATETIME('10:30', 'HH:MM')),
('Friday',PARSEDATETIME('17:00', 'HH:MM'),PARSEDATETIME('20:00', 'HH:MM')),
('Saturday',PARSEDATETIME('09:00', 'HH:MM'),PARSEDATETIME('11:00', 'HH:MM')),
('Saturday',PARSEDATETIME('18:00', 'HH:MM'),PARSEDATETIME('22:00', 'HH:MM')),
('Sunday',PARSEDATETIME('09:00', 'HH:MM'),PARSEDATETIME('11:00', 'HH:MM')),
('Sunday',PARSEDATETIME('18:00', 'HH:MM'),PARSEDATETIME('22:00', 'HH:MM'));

---Inserting data for non peak hours

insert into off_peak_hours(day, start_time, end_time, from_zone, to_zone) values
('Monday',PARSEDATETIME('17:00', 'HH:MM'),PARSEDATETIME('20:00', 'HH:MM'),'2','1'), 
('Tuesday',PARSEDATETIME('17:00', 'HH:MM'),PARSEDATETIME('20:00', 'HH:MM'),'2','1'), 
('Wednesday',PARSEDATETIME('17:00', 'HH:MM'),PARSEDATETIME('20:00', 'HH:MM'),'2','1'), 
('Thursday',PARSEDATETIME('17:00', 'HH:MM'),PARSEDATETIME('20:00', 'HH:MM'),'2','1'), 
('Friday',PARSEDATETIME('17:00', 'HH:MM'),PARSEDATETIME('20:00', 'HH:MM'),'2','1'),
('Saturday',PARSEDATETIME('18:00', 'HH:MM'),PARSEDATETIME('22:00', 'HH:MM'),'2','1'),
('Sunday',PARSEDATETIME('18:00', 'HH:MM'),PARSEDATETIME('22:00', 'HH:MM'),'2','1');

--- Insert data for fare

insert into fare(from_zone, to_zone, peak_hours_charges, offpeak_hours_charges) values
('1','1','30','25'),
('1','2','35','30'),
('2','1','35','30'),
('2','2','25','20'); 

insert into capping_limits(from_zone, to_zone, daily_cap, weekly_cap) values
('1','1','100','500'),
('1','2','120','600'),
('2','1','120','600'),
('2','2','80','400'); 
