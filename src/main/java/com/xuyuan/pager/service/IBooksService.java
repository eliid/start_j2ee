package com.xuyuan.pager.service;import java.util.List;import com.xuyuan.pager.entity.Books;import com.xuyuan.pager.model.PageBean;public interface IBooksService {	//-----------------------------------    public PageBean queryForPage(int pageSize,int currentPage);    //-----------------------------------    	List getAll();// 获得所有记录	List getBooks(int pageSize, int startRow);// 获得所有记录	int getRows();// 获得总行数	int getRows(String fieldname, String value);// 获得总行数	List queryBooks(String fieldname, String value);// 根据条件查询	List getBooks(String fieldname, String value, int pageSize, int startRow);// 根据条件查询	Books getBook(Integer bookId);// 根据ID获得记录	//Integer getMaxID();// 获得最大ID值	void addBook(Books pd);// 添加记录	void updateBook(Books pd);// 修改记录	void deleteBook(Integer bookId);// 删除记录}