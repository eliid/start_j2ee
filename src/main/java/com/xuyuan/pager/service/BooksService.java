package com.xuyuan.pager.service;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import com.xuyuan.pager.dao.IBooksDao;import com.xuyuan.pager.entity.Books;import com.xuyuan.pager.model.PageBean;//@Servicepublic class BooksService implements IBooksService {		//@Autowired	private IBooksDao booksDao;		//将持久层的分页实现封装成PageBean对象.以便在视图层直接使用分页模型对象.	//Dao层分页传递HQL参数,实际上已经包括了带查询条件的和不带查询条件的了.	//如果要带上查询条件的分页查询,可以重载该方法,带上查询条件和查询值即可(可以从视图层传递进来).	//如果还不明白,请看BooksDao其他部分的实现,实际上是对这两种情况的分离.	//----------------------------------------------------	public PageBean queryForPage(int pageSize,int pageNo){        final String hql = "from Books";        						//查询语句        int allRow = booksDao.getAllRowCount(hql);   					//总记录数                int offset = PageBean.countOffset(pageSize, pageNo);    		//当前页开始记录        List<Books> list = booksDao.queryForPage(hql,offset, pageSize); //当前页的记录                //把分页信息保存到Bean中        PageBean pageBean = new PageBean();        pageBean.setAllRow(allRow);        pageBean.setList(list);        pageBean.setPageSize(pageSize);                  int totalPage = PageBean.countTotalPage(pageSize, allRow);    	//总页数        int currentPage = PageBean.countCurrentPage(pageNo);			//当前页                pageBean.setCurrentPage(currentPage);        pageBean.setTotalPage(totalPage);                pageBean.init();                return pageBean;    }	//----------------------------------------------------	//不带查询条件的查询全部数据和分页查询	public List getAll() {		return booksDao.getAll();	}	public List getBooks(int pageSize, int startRow) {		return booksDao.getBooks(pageSize, startRow);	}	public int getRows() {		return booksDao.getRows();	}	//带查询条件的查询全部数据和分页查询	public List queryBooks(String fieldname, String value) {		return booksDao.queryBooks(fieldname, value);	}	public List getBooks(String fieldname, String value, int pageSize, int startRow) {		return booksDao.getBooks(fieldname, value, pageSize, startRow);	}	public int getRows(String fieldname, String value) {		return booksDao.getRows(fieldname, value);	}		public void addBook(Books book) {		booksDao.addBook(book);	}	public void updateBook(Books book) {		booksDao.updateBook(book);	}	public void deleteBook(Integer bookId) {		Books book = booksDao.getBook(bookId);		booksDao.deleteBook(book);	}	public Books getBook(Integer bookId) {		return booksDao.getBook(bookId);	}//	public Integer getMaxID() {//		return booksDao.getMaxID();//	}		public IBooksDao getBooksDao() {		return booksDao;	}	public void setBooksDao(IBooksDao booksDao) {		this.booksDao = booksDao;	}}