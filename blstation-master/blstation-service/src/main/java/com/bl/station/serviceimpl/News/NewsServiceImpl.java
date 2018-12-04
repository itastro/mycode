package com.bl.station.serviceimpl.News;

import com.bl.station.service.News.NewService;
import com.bl.station.Bean.BeanValidator;
import com.bl.station.entity.News;
import com.bl.station.mapper.NewsMapper;
import com.bl.station.page.PageInfo;
import com.bl.station.page.PageParam;
import com.bl.station.param.NewsParam;
import com.bl.station.param.NewsSearch;
import com.bl.station.service.picture.PictrueService;
import com.bl.station.utils.JsonMapper;
import com.bl.station.utils.StationResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author itastro
 */
@Slf4j
@Service
public class NewsServiceImpl implements NewService {


    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private PictrueService pictrueService;


    @Override
    public StationResult add(NewsParam news) throws Exception {
        log.info("news:{}", JsonMapper.obj2String(news));
        BeanValidator.check(news);

        String url = "";

        News news1 = new News();

        BeanUtils.copyProperties(news, news1);
        if (news.getPic() != null) {
            url = pictrueService.upload(news.getPic());
        }
        news1.setPicurl(url);
        news1.setCreatetime(new Date());
        newsMapper.insert(news1);
        return StationResult.success("新闻添加成功");
    }

    @Override
    public StationResult update(NewsParam newsParam) throws Exception {

        if (newsParam.getId() == null) {
            return StationResult.fail("请你传入更新的id");
        }

        if (newsParam.getPic() == null) {
            News news = newsMapper.selectByPrimaryKey(newsParam.getId());
            news.setCreatetime(new Date());
            news.setAuthor(newsParam.getAuthor());
            news.setTitle(newsParam.getTitle());
            news.setStarttime(newsParam.getStarttime());
            news.setEndtime(newsParam.getEndtime());
            news.setSummary(newsParam.getSummary());
            news.setExpired(newsParam.getExpired());
            news.setContent(newsParam.getContent());
        }

        SaveAndUpdate saveAndUpdate = new SaveAndUpdate(newsParam).invoke();
        News news1 = saveAndUpdate.getNews1();
        String url = saveAndUpdate.getUrl();
        news1.setPicurl(url);
        newsMapper.updateByPrimaryKeyWithBLOBs(news1);
        return StationResult.success("更新成功");
    }

    @Override
    public StationResult delete(String ids) {

        log.info("ids:{}", ids);
        if (StringUtils.isBlank(ids)) {
            return StationResult.fail("请选择需要删除的新闻");
        }
        String[] idss = ids.split(",");
        for (String id : idss) {
            newsMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
        return StationResult.success("删除新闻成功");
    }

    @Override
    public PageInfo<News> pageQuery(PageParam pageParam, NewsSearch newsSearch) {
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        Page<News> list = newsMapper.pageQuery(newsSearch);
        PageInfo<News> result = new PageInfo<News>(list);
        return result;
    }


    @Override
    public PageInfo<News> findAll(PageParam pageParam) {

        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());

        List<News> list = newsMapper.findAll();
        PageInfo<News> result = new PageInfo<News>(list);
        return result;
    }

    @Override
    public News findOne(Integer id) {

        News news = newsMapper.selectByPrimaryKey(id);
        return news;
    }

    private class SaveAndUpdate {
        private NewsParam newsParam;
        private String url;
        private News news1;

        public SaveAndUpdate(NewsParam newsParam) {
            this.newsParam = newsParam;
        }

        public String getUrl() {
            return url;
        }

        public News getNews1() {
            return news1;
        }

        public SaveAndUpdate invoke() throws Exception {
            url = "";

            news1 = new News();
            news1.setCreatetime(new Date());
            BeanUtils.copyProperties(newsParam, news1);
            if (newsParam.getPic() != null) {
                url = pictrueService.upload(newsParam.getPic());
            }
            return this;
        }
    }
}
