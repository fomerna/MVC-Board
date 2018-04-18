package com.doubles.mvcboard.article.persistence;

import com.doubles.mvcboard.article.domain.ArticleVO;
import com.doubles.mvcboard.commons.paging.Criteria;

import java.util.List;

public interface ArticleDAO {

    void create(ArticleVO articleVO) throws Exception;

    ArticleVO read(Integer bno) throws Exception;

    void update(ArticleVO articleVO) throws Exception;

    void delete(Integer bno) throws Exception;

    List<ArticleVO> listAll() throws Exception;

    List<ArticleVO> listPaging(int page) throws Exception;

    List<ArticleVO> listCriteria(Criteria criteria) throws Exception;

}