package com.portal.extrafunc.service;

import com.javapms.basic.page.Pagination;
import com.portal.extrafunc.entity.Posts;
import com.portal.extrafunc.entity.Theme;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public abstract interface PostsService
{
  public abstract Pagination getPage(int paramInt1, int paramInt2);
  
  public abstract Pagination getPostsPageForTag(Integer paramInteger, int paramInt1, int paramInt2);
  
  public abstract Posts findById(Integer paramInteger);
  
  public abstract Posts saveTheme(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, String paramString1, String paramString2, String paramString3, List<MultipartFile> paramList, List<String> paramList1);
  
  public abstract Posts savePosts(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, String paramString1, String paramString2, String paramString3, List<MultipartFile> paramList, List<String> paramList1);
  
  public abstract Posts updatePosts(Integer paramInteger1, Integer paramInteger2, String paramString1, String paramString2, String paramString3, List<MultipartFile> paramList, List<String> paramList1);
  
  public abstract Theme shieldTheme(Integer paramInteger1, Integer paramInteger2, String paramString);
  
  public abstract Posts shieldPosts(Integer paramInteger1, Integer paramInteger2, String paramString);
  
  public abstract Theme deleteTheme(Integer paramInteger1, Integer paramInteger2, String paramString);
  
  public abstract Posts update(Posts paramPosts);
  
  public abstract Posts deleteById(Integer paramInteger);
  
  public abstract Posts[] deleteByIds(Integer[] paramArrayOfInteger);
}


/* Location:           F:\jsp源码\门户管理系统\javapms-1.2-beta\ROOT\WEB-INF\classes\
 * Qualified Name:     com.portal.extrafunc.service.PostsService
 * JD-Core Version:    0.7.0.1
 */