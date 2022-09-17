insert into role(role) values('ROLE_ADMIN');

 insert into users(firstname,lastname,username,password,role_id) values ('farzad','afshar','farzadAfi','afi',1);

 insert into url(url) values ('/dynamicRole/test');

 insert into role_urls(role_id, urls_id) values (1,1);