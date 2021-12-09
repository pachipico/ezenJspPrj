package repository;

import java.util.List;

import domain.CommentVO;


public interface CommentDAO {
	public int insert (CommentVO cvo);
	public List<CommentVO> selectList();
	public int update(CommentVO cvo);
	public int delete(long cno);
	public int delAll(long pno);
}
