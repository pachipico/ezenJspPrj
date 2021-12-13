package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ProductVO;
import repository.ProductDAO;
import repository.ProductDAOImpl;

public class ProductServiceImpl implements ProductService {
	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	private ProductDAO dao = new ProductDAOImpl();

	@Override
	public int register(ProductVO pvo) {

		return dao.insert(pvo);
	}

	@Override
	public List<ProductVO> getList() {

		return dao.selectList();
	}

	@Override
	public ProductVO getOne(long pno) {

		return dao.selectOne(pno);
	}

	@Override
	public int modify(ProductVO pvo) {

		return dao.update(pvo);
	}

	@Override
	public int remove(long pno) {

		return dao.delete(pno);
	}

	@Override
	public ProductVO getOneAndUp(Long pno) {
		ProductVO pvo =  dao.selectOne(pno);
		int isUp = dao.addReadCount(pno);
		pvo.setReadCount(pvo.getReadCount() + isUp);
		return pvo;
	}

}
