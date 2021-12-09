package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import orm.DataBaseBuilder;

public class CommentDAOImpl implements CommentDAO {
	private static final Logger log = LoggerFactory.getLogger(CommentDAOImpl.class);
	private final String ns = "CommentMapper.";
	private SqlSession sql;

	public CommentDAOImpl() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(CommentVO cvo) {
		int isUp = sql.insert(ns + "reg", cvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<CommentVO> selectList() {

		return sql.selectList(ns + "list");
	}

	@Override
	public int update(CommentVO cvo) {
		int isUp = sql.update(ns + "mod", cvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int delete(long cno) {
		int isUp = sql.delete(ns + "del", cno);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}
	
	@Override
	public int delAll(long pno) {
		int isUp = sql.delete(ns + "delAll", pno);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

}
