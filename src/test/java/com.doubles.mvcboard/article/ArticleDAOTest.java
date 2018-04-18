package com.doubles.mvcboard.article;

import com.doubles.mvcboard.article.domain.ArticleVO;
import com.doubles.mvcboard.article.persistence.ArticleDAO;
import com.doubles.mvcboard.commons.paging.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class ArticleDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(ArticleDAOTest.class);

    @Inject
    private ArticleDAO articleDAO;

    @Test
    public void testCreate() throws Exception {

        for (int i = 1; i <= 1000; i++) {
            ArticleVO articleVO = new ArticleVO();
            articleVO.setTitle(i+ "번째 글 제목입니다...");
            articleVO.setContent(i+ "번재 글 내용입니다...");
            articleVO.setWriter("user0"+(i%10));

            articleDAO.create(articleVO);
        }

    }

    @Test
    public void testRead() throws Exception {
        logger.info(articleDAO.read(7).toString());
    }

    @Test
    public void testUpdate() throws Exception {
        ArticleVO article = new ArticleVO();
        article.setBno(11);
        article.setTitle("글 수정 테스트 제목");
        article.setContent("글 수정 테스트 내용");
        articleDAO.update(article);
    }

    @Test
    public void testDelete() throws Exception {
        articleDAO.delete(6);
    }

    @Test
    public void testListPaging() throws Exception {

        int page = 3;

        List<ArticleVO> articles = articleDAO.listPaging(page);

        for (ArticleVO article : articles) {
            logger.info(article.getBno() + ":" + article.getTitle());
        }

    }

    @Test
    public void testListCriteria() throws Exception {
        Criteria criteria = new Criteria();
        criteria.setPage(3);
        criteria.setPerPageNum(20);

        List<ArticleVO> articles = articleDAO.listCriteria(criteria);

        for (ArticleVO article : articles) {
            logger.info(article.getBno() + " : " + article.getTitle());
        }
    }
}