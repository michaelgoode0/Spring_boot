select * from users_profiles_t upt 
            join users_t ut on upt.users_id=ut.id;

select * from users_t ut 
            left join permissions_t pt on ut.id=pt.id;

select * from post_comments_t pct 
            join posts_t pt on pct.posts_id=pt.id;

select * from posts_t pt 
            join users_profiles_t upt on pt.users_profiles_id = upt.id;

select upt2.id,upt.id from users_profiles_t upt 
            join users_profiles_t upt2  on upt.id =upt2.id;
