package com.senla.intership.boot.api.repository;

import com.senla.intership.boot.entity.PostComment;
import com.senla.intership.boot.util.AbstractDao;
import com.senla.intership.boot.util.GenericDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment,Long> {
    PostComment findByText(String text);
}
