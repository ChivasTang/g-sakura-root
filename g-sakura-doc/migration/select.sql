select * from role;
select * from user;
select * from user_info;
select * from user_role;


select user.username,
       user.password,
       userInfo.id,
       role.id,
       role.name,
       role.description
from user
         inner join user_info userInfo on user.username = userInfo.username
         inner join user_role userRole on userInfo.id = userRole.user_id
         inner join role on userRole.role_id = role.id
where user.username = 'boss';