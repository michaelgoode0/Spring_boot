create table roles
(
    id         bigserial not null
        constraint roles_pkey
            primary key,
    permission varchar(255)
);
create table users
(
    id       bigserial not null
        constraint users_pkey
            primary key,
    username varchar(255)
        constraint users_username_key
            unique,
    password varchar(255)
);

create table users_profiles
(
    id          bigserial not null
        constraint users_profiles_pkey
            primary key,
    firstname   varchar(255),
    surname     varchar(255),
    town        varchar(255),
    phonenumber bigint
);

create table posts
(
    id             bigserial not null
        constraint posts_pkey
            primary key,
    comments_count bigint,
    likes_count    bigint,
    text           varchar(255)
);

create table post_comments
(
    id   bigserial not null
        constraint post_comments_pkey
            primary key,
    text varchar(255)
);

create table friends
(
    to_user_id   bigserial not null
        constraint friends_to_user_id_fkey
            references users_profiles,
    from_user_id bigserial not null
        constraint friends_from_user_id_fkey
            references users_profiles,
    constraint friends_pkey
        primary key (to_user_id, from_user_id)
);

create table users_roles
(
    user_id bigserial not null
        constraint users_roles_user_id_fkey
            references users,
    role_id bigserial not null
        constraint users_roles_role_id_fkey
            references roles,
    constraint users_roles_pkey
        primary key (user_id, role_id)
);

create table reactions
(
    id       bigserial not null
        constraint reactions_pkey
            primary key,
    reaction boolean
);

create table hashtags
(
    id    bigserial not null
        constraint hashtags_pkey
            primary key,
    value varchar(255)
        constraint hashtags_value_key
            unique
);

create table profiles_users
(
    user_profile_id bigserial not null
        constraint profiles_users_user_profile_id_fkey
            references users_profiles,
    user_id         bigserial not null
        constraint profiles_users_user_id_fkey
            references users,
    constraint profiles_users_pkey
        primary key (user_profile_id, user_id)
);

create table reactions_profiles
(
    reaction_id bigserial not null
        constraint reactions_profiles_reaction_id_fkey
            references reactions,
    profile_id  bigserial not null
        constraint reactions_profiles_profile_id_fkey
            references users_profiles,
    constraint reactions_profiles_pkey
        primary key (reaction_id, profile_id)
);

create table reactions_posts
(
    reaction_id bigserial not null
        constraint reactions_posts_reaction_id_fkey
            references reactions,
    post_id     bigserial not null
        constraint reactions_posts_post_id_fkey
            references posts,
    constraint reactions_posts_pkey
        primary key (reaction_id, post_id)
);

create table posts_profiles
(
    post_id    bigserial not null
        constraint posts_profiles_post_id_fkey
            references posts,
    profile_id bigserial not null
        constraint posts_profiles_profile_id_fkey
            references users_profiles,
    constraint posts_profiles_pkey
        primary key (post_id, profile_id)
);

create table posts_hashtags
(
    post_id    bigserial not null
        constraint posts_hashtags_post_id_fkey
            references posts,
    hashtag_id bigserial not null
        constraint posts_hashtags_hashtag_id_fkey
            references hashtags,
    constraint posts_hashtags_pkey
        primary key (post_id, hashtag_id)
);

create table comments_profiles
(
    comment_id bigserial not null
        constraint comments_profiles_comment_id_fkey
            references post_comments,
    profile_id bigserial not null
        constraint comments_profiles_profile_id_fkey
            references users_profiles,
    constraint comments_profiles_pkey
        primary key (comment_id, profile_id)
);

create table comments_posts
(
    comment_id bigserial not null
        constraint comments_posts_comment_id_fkey
            references post_comments,
    post_id    bigserial not null
        constraint comments_posts_post_id_fkey
            references posts,
    constraint comments_posts_pkey
        primary key (comment_id, post_id)
);

create table invites
(
    id             bigserial not null
        constraint invites_pkey
            primary key,
    date_of_invite date,
    status         varchar(255)
);

create table invites_from_user
(
    invites_id   bigserial not null
        constraint invites_from_user_invites_id_fkey
            references invites,
    from_user_id bigserial not null
        constraint invites_from_user_from_user_id_fkey
            references users_profiles,
    constraint invites_from_user_pkey
        primary key (invites_id, from_user_id)
);

create table invites_to_user
(
    invites_id bigserial not null
        constraint invites_to_user_invites_id_fkey
            references invites,
    to_user_id bigserial not null
        constraint invites_to_user_to_user_id_fkey
            references users_profiles,
    constraint invites_to_user_pkey
        primary key (invites_id, to_user_id)
);
