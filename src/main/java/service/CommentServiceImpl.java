package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CommentVO;
import repository.CommentDAO;
import repository.CommentDAOImpl;

public class CommentServiceImpl implements CommentService {
	private static final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);
	private CommentDAO dao = new CommentDAOImpl();

	@Override
	public int register(CommentVO cvo) {

		return dao.insert(cvo);
	}

	@Override
	public List<CommentVO> getList() {

		return dao.selectList();
	}

	@Override
	public int modify(CommentVO cvo) {

		return dao.update(cvo);
	}

	@Override
	public int remove(long cvo) {

		return dao.delete(cvo);
	}
	
}
